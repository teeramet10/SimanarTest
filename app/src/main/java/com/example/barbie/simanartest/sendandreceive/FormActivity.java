package com.example.barbie.simanartest.sendandreceive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.barbie.simanartest.R;

public class FormActivity extends AppCompatActivity {
    TextView tvId;
    EditText edtName;
    Button btnSave;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        tvId =(TextView)findViewById(R.id.tvid);
        edtName=(EditText) findViewById(R.id.edtname);
        btnSave =(Button) findViewById(R.id.btnsave);

        intent=getIntent();
        Bundle bundle =intent.getExtras();
        if(bundle!=null) {
            tvId.setText(bundle.getString(SendDataActivity.ID));
            edtName.setText(bundle.getString(SendDataActivity.NAME));
        }else{
            finish();
        }



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra(SendDataActivity.ID,tvId.getText().toString());
                intent.putExtra(SendDataActivity.NAME,edtName.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
