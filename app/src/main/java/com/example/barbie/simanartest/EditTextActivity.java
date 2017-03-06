package com.example.barbie.simanartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    EditText edtgetMessage;
    EditText edtsetMessage;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        bindWidget();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message =edtgetMessage.getText().toString();
                edtsetMessage.setText(message);
            }
        });

    }

    public void bindWidget(){
        btnClick =(Button) findViewById(R.id.btn_click);
        edtgetMessage=(EditText)findViewById(R.id.edtgetmessage);
        edtsetMessage=(EditText) findViewById(R.id.edtsetmessage);
    }
}
