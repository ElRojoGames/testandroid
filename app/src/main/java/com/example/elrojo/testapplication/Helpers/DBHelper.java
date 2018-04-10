package com.example.elrojo.testapplication.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elrojo.testapplication.SQLConstants;

public class DBHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;

    public DBHelper(Context context){
        super(context, SQLConstants.DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstants.SQL_CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstants.SQL_DELETE);
        onCreate(db);
    }
}
