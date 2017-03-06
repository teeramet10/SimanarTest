package com.example.barbie.simanartest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
;import com.example.barbie.simanartest.customlistview.CustomListViewActivity;
import com.example.barbie.simanartest.database.MySQLiteActivity;
import com.example.barbie.simanartest.sendandreceive.SendDataActivity;
import com.example.barbie.simanartest.server.ConnectServerActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    Context context = this;
    String[] menu = new String[]{"TextView & Button", "EditText", "Spinner","CheckBox"
            , "AlertDialog", "Toast", "Date & Time", "ListView", "CustomListView", "RecycleView"
            , "Send & Recieve Data", "Image", "MySqLite", "Connect Server"};

    Class[] menuclass = new Class[]{TextViewButtonActivity.class, EditTextActivity.class
            , SpinnerActivity.class,CheckBoxActivity.class, AlertDialogActivity.class, ToastActivity.class, DateTimeActivity.class
            , ListViewActivity.class, CustomListViewActivity.class, RecycleViewActivity.class, SendDataActivity.class
            , ImageActivity.class, MySQLiteActivity.class
            , ConnectServerActivity.class};
    ArrayList<Menu> menuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindWidget();

        menuArrayList = new ArrayList<>();
        for (int i = 0; i < menu.length; i++) {
            Menu menuobj = new Menu(menu[i], menuclass[i]);
            menuArrayList.add(menuobj);
        }

        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, menuArrayList.get(position).getClassmenu());
                startActivity(intent);
            }
        });

    }

    public void bindWidget() {
        listView = (ListView) findViewById(R.id.listview);
    }
}
