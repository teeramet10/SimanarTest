package com.example.barbie.simanartest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by barbie on 2/5/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    Context context;
    public static final String STUDENT_DB = "student";
    public static final String STUDENT_ID = "id";
    public static final String STUDENT_NAME = "name";
    public static final int db_version = 1;

    public static final String CREATE_TABLE = "CREATE TABLE " + STUDENT_DB + "("
            + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + STUDENT_NAME + " TEXT NOT NULL);";


    public SQLiteHelper(Context context) {
        super(context, STUDENT_DB, null, db_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if(db.getVersion()==1){
//
//        }
    }
}
