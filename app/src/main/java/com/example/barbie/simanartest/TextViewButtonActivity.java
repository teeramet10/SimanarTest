package com.example.barbie.simanartest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewButtonActivity extends AppCompatActivity {

    private TextView tvText;
    private Button btnClick;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        bindWidget();

        tvText=(TextView) findViewById(R.id.txt);
        btnClick=(Button) findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvText.setText("Count : "+count);
            }
        });
    }

    public void bindWidget(){
        tvText=(TextView) findViewById(R.id.txt);
        btnClick=(Button) findViewById(R.id.btn_click);

    }
}
