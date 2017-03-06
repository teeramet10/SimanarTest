package com.example.barbie.simanartest.database;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.barbie.simanartest.R;

public class FormDatabaseActivity extends AppCompatActivity {

    TextView tvId;
    EditText edtName;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_database);
        tvId = (TextView) findViewById(R.id.id);
        edtName = (EditText) findViewById(R.id.name);
        btnEdit = (Button) findViewById(R.id.btnedit);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            String id=bundle.getString(DatabaseHelper.ID);
            String name =bundle.getString(DatabaseHelper.NAME);
            tvId.setText(id);
            edtName.setText(name);

        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtName.equals("")){
                    DatabaseHelper databaseHelper=new DatabaseHelper(FormDatabaseActivity.this);
                    databaseHelper.updateDatabase(tvId.getText().toString(),edtName.getText().toString());
                    finish();
                }
            }
        });
    }
}
