package com.example.barbie.simanartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {
    String[] name= {"Lucy", "Elsa", "Gundum", "Loki", "Lufy", "Nami", "Sunji", "Solo"};
    Spinner spinner;
    TextView tvName;
    ArrayAdapter spnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner =(Spinner) findViewById(R.id.spinner);
        tvName=(TextView) findViewById(R.id.tvname);

        spnAdapter =new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,name);
        spinner.setAdapter(spnAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvName.setText(spnAdapter.getItem(position).toString());
                spinner.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
