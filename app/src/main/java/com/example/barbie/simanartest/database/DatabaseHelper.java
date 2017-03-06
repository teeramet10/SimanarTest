package com.example.barbie.simanartest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.barbie.simanartest.classstudent.Student;

import java.util.ArrayList;

/**
 * Created by barbie on 3/5/2017.
 */

public class DatabaseHelper {
    public  static final String ID="ID";
    public  static final String NAME="NAME";

    Context context;
    SQLiteDatabase myDatabase;
    SQLiteHelper myHelper;


    public DatabaseHelper(Context context) {
        this.context=context;
    }

    public ArrayList<Student> readDatabase(){

        ArrayList<Student> strudentArrayList=new ArrayList<>();

        myHelper=new SQLiteHelper(context);
        myDatabase=myHelper.getReadableDatabase();

        Cursor cursor1=myDatabase.query(SQLiteHelper.STUDENT_DB,null,null,null,null,null,null);
        Cursor cursor=myDatabase.rawQuery("SELECT * FROM "+ SQLiteHelper.STUDENT_DB,null);
        while(cursor.moveToNext()){

            String id =cursor.getString(cursor.getColumnIndex(SQLiteHelper.STUDENT_ID));
            String name =cursor.getString(cursor.getColumnIndex(SQLiteHelper.STUDENT_NAME));

            Student student=new Student();
            student.setId(id);
            student.setName(name);
            strudentArrayList.add(student);
        }


        cursor.close();
        myDatabase.close();
        return strudentArrayList;

    }

    public long insertDatabase(String id,String name){
        myHelper=new SQLiteHelper(context);
        myDatabase=myHelper.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(SQLiteHelper.STUDENT_ID,id);
        cv.put(SQLiteHelper.STUDENT_NAME,name);
        long i =myDatabase.insert(SQLiteHelper.STUDENT_DB,null,cv);

        myDatabase.close();
        return i;
    }

    public void updateDatabase(String id,String name){
        myHelper=new SQLiteHelper(context);
        myDatabase=myHelper.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(SQLiteHelper.STUDENT_NAME,name);

        myDatabase.update(SQLiteHelper.STUDENT_DB,cv
                ,SQLiteHelper.STUDENT_ID+"=?",new String[]{id});
        myDatabase.close();
    }

    public void deleteDatabase(String  id){
        myHelper=new SQLiteHelper(context);
        myDatabase=myHelper.getWritableDatabase();
        myDatabase.delete(SQLiteHelper.STUDENT_DB,
                SQLiteHelper.STUDENT_ID+"=?",new String[]{id});
        myDatabase.close();
    }

}
