package com.example.barbie.simanartest.sendandreceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;

public class SendDataActivity extends AppCompatActivity {
    public static final int REQUEST_CODE =100;
    public static final String NAME= "name";
    public static final String ID="id";

    TextView tvId;
    TextView tvName;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        tvId =(TextView)findViewById(R.id.tvid);
        tvName=(TextView)findViewById(R.id.tvname);
        btnEdit=(Button) findViewById(R.id.editbtn);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setId(tvId.getText().toString());
                student.setName(tvName.getText().toString());

                Intent intent=new Intent(SendDataActivity.this,FormActivity.class);
                intent.putExtra(NAME,student.getName());
                intent.putExtra(ID,student.getId());
                startActivityForResult(intent,REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==REQUEST_CODE &&resultCode==RESULT_OK&& data!=null){
            String name =data.getStringExtra(NAME);
            String id =data.getStringExtra(ID);

            tvId.setText(id);
            tvName.setText(name);

        }
    }
}
