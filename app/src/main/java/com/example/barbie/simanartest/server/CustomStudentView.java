package com.example.barbie.simanartest.server;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;

import java.util.ArrayList;

/**
 * Created by barbie on 2/8/2017.
 */

public class CustomStudentView extends BaseAdapter {
    Context context;
    ArrayList<Student> studentArrayList;
    LayoutInflater layoutInflater;
    ViewHolder viewHolder;

    public CustomStudentView(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.viewstudent,parent,false);
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.id);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        if(studentArrayList.size()>0){
            Student student=studentArrayList.get(position);
            viewHolder.tvId.setText(student.getId());
            viewHolder.tvName.setText(student.getName());
        }
        return convertView;
    }

    class  ViewHolder{
        TextView tvId;
        TextView tvName;
    }
}
