package com.example.barbie.simanartest.customlistview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    String[] studentname = {"Lucy", "Elsa", "Gundum", "Loki", "Lufy", "Nami", "Sanji", "Solo"};
    String[] studentid = {"02564-1", "02565-2", "02566-3", "02567-4"
            , "02568-5", "02569-6", "02570-7", "02571-8"};
    int[] image = {R.drawable.lucy, R.drawable.elsa, R.drawable.gundam, R.drawable.loki, R.drawable.lufy
            , R.drawable.nami, R.drawable.sanji, R.drawable.solo};

    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<Student> studentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        studentArrayList = new ArrayList<>();
        for (int i = 0; i < studentname.length; i++) {
            Student student = new Student();
            student.setName(studentname[i]);
            student.setId(studentid[i]);
            student.setImage(image[i]);
            studentArrayList.add(student);
        }

        listView = (ListView) findViewById(R.id.listview);
        customAdapter = new CustomAdapter(this, studentArrayList);
        listView.setAdapter(customAdapter);
    }
}
