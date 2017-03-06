package com.example.barbie.simanartest.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barbie.simanartest.R;
import com.example.barbie.simanartest.classstudent.Student;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by barbie on 2/3/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> studentArrayList;
    LayoutInflater inflater;
    ViewHolder viewHolder;
    public CustomAdapter(Context context, ArrayList<Student> studentArrayList) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.studentArrayList = studentArrayList;
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
            convertView=inflater.inflate(R.layout.viewlistview,parent,false);
            viewHolder.imgProfile=(ImageView) convertView.findViewById(R.id.img);
            viewHolder.tvName=(TextView)convertView.findViewById(R.id.name);
            viewHolder.tvId=(TextView) convertView.findViewById(R.id.id);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        Student student=studentArrayList.get(position);
        if(student!=null) {
            Picasso.with(context).load(student.getImage()).fit().into(viewHolder.imgProfile);
            viewHolder.tvName.setText(student.getName());
            viewHolder.tvId.setText(student.getId());
        }
        return convertView;
    }

    class ViewHolder{
        ImageView imgProfile;
        TextView tvName;
        TextView tvId;
    }
}
