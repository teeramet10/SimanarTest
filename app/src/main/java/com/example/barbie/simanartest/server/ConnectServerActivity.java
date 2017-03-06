package com.example.barbie.simanartest.server;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ConnectServerActivity extends AppCompatActivity {
    static int COMPLETE =1;
    static int Failed =2;
    int status=0;

    Context context = this;
    EditText edtId;
    EditText edtName;
    ListView listView;
    Button btnSend;
    ArrayList<Student> studentArrayList;
    CustomStudentView customStudentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_server);
        edtId = (EditText) findViewById(R.id.id);
        edtName = (EditText) findViewById(R.id.name);
        btnSend = (Button) findViewById(R.id.btnsend);
        listView = (ListView) findViewById(R.id.liststudent);

        readDataFromServer();


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtId.getText().toString().equals("")&&!edtName.getText().toString().equals("")) {
                    insertDatabaseToServer();
                    edtId.setText("");
                    edtName.setText("");
                }
            }
        });


    }


    private void insertDatabaseToServer() {
        final Student student = new Student();
        student.setId(edtId.getText().toString());
        student.setName(edtName.getText().toString());

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("id", student.getId())
                .add("name", student.getName())
                .build();

        Request request = new Request.Builder()
                .url("http://192.168.1.38/student/addstudent.php")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("FAILURE", e.getMessage());
                status=Failed;
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String message =response.body().string();
                    if(message.equals(String.valueOf(COMPLETE))) {
                        status = COMPLETE;
                    }else {
                        status=Failed;
                    }
                    Log.i("SUCCESS1",message );
                }
            }

        });

        if(status==COMPLETE){
            studentArrayList.add(student);
            customStudentView.notifyDataSetChanged();
        }else {
            Toast.makeText(this,"add data failed",Toast.LENGTH_SHORT);
        }
    }

    public void readDataFromServer() {

        new JsonParse().execute();
    }


    public class JsonParse extends AsyncTask<String,Void,JSONArray> {


        @Override
        protected JSONArray doInBackground(String... params) {
            JSONArray jsonArray=null;
            String json = "";
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://192.168.1.38/student/readstudent.php")
                        .build();

                Response response=okHttpClient.newCall(request).execute();
                json=response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                jsonArray=new JSONArray(json);
            }catch (Exception e){
                e.printStackTrace();
            }
            return jsonArray;

        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            super.onPostExecute(jsonArray);
            studentArrayList=new ArrayList<>();
            try {

                for (int i = 0; i < jsonArray.length(); i++) {
                    Student student = new Student();

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");

                    student.setId(id);
                    student.setName(name);
                    studentArrayList.add(student);
                }
            } catch (Exception e) {
                e.getMessage();
            }

            customStudentView = new CustomStudentView(context, studentArrayList);
            listView.setAdapter(customStudentView);

        }

    }

}