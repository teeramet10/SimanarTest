package com.example.barbie.simanartest.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;
import com.example.barbie.simanartest.server.CustomStudentView;

import java.util.ArrayList;

public class MySQLiteActivity extends AppCompatActivity {
    Context context = this;

    EditText edtId;
    EditText edtName;
    ListView listView;
    Button btnSend;
    View vEmpty;
    LayoutInflater layoutInflater;

    CustomStudentView customStudentView;
    ArrayList<Student> studentArrayList;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sqlite);
        edtId = (EditText) findViewById(R.id.id);
        edtName = (EditText) findViewById(R.id.name);
        btnSend = (Button) findViewById(R.id.btnsend);
        listView = (ListView) findViewById(R.id.liststudent);

        layoutInflater = LayoutInflater.from(context);
        vEmpty = layoutInflater.inflate(R.layout.empty_state,((ViewGroup) listView.getParent()),false);
        ((ViewGroup) listView.getParent()).addView(vEmpty);
        listView.setEmptyView(vEmpty);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, FormDatabaseActivity.class);
                intent.putExtra(DatabaseHelper.ID, studentArrayList.get(position).getId());
                intent.putExtra(DatabaseHelper.NAME, studentArrayList.get(position).getName());
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Delete");
                alertDialog.setMessage("Do you  want delete?");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHelper databaseHelper = new DatabaseHelper(context);
                        databaseHelper.deleteDatabase(studentArrayList.get(position).getId());

                        studentArrayList.remove(position);
                        customStudentView.notifyDataSetChanged();
                    }
                });

                alertDialog.setNegativeButton("CANCEL", null);
                alertDialog.create().show();
                return true;
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtId.getText().toString().equals("") && !edtName.getText().toString().equals("")) {
                    Student student = new Student();
                    student.setId(edtId.getText().toString());
                    student.setName(edtName.getText().toString());

                    DatabaseHelper databaseHelper = new DatabaseHelper(context);
                    long i = databaseHelper.insertDatabase(student.getId(), student.getName());

                    if (i!=-1) {
                        studentArrayList.add(student);
                        customStudentView.notifyDataSetChanged();
                        edtId.setText("");
                        edtName.setText("");
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        databaseHelper = new DatabaseHelper(context);
        studentArrayList = databaseHelper.readDatabase();
        customStudentView = new CustomStudentView(context, studentArrayList);
        listView.setAdapter(customStudentView);
    }
}
