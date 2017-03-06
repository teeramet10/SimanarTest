package com.example.barbie.simanartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView lvName;
    private String[] name={"Lucy","Elsa","Gundum","Loki","Lufy","Nami","Sunji","Solo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lvName =(ListView)findViewById(R.id.listview);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,name);
        lvName.setAdapter(adapter);
        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,name[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
