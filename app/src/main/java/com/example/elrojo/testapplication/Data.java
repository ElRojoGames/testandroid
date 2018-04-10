package com.example.elrojo.testapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elrojo.testapplication.Helpers.DBHelper;
import com.example.elrojo.testapplication.POJOs.User;

public class Data {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context){
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public void insertUser(User user){
        ContentValues values = user.toValues();
        sqLiteDatabase.insert(SQLConstants.tableUsers, null, values);
    }

}
