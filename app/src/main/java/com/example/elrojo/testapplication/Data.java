package com.example.elrojo.testapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public User getUser(String id){
        User usuario = new User();
        String[] whereArgs = new String[]{id};
        Cursor cursor = sqLiteDatabase.query(
                SQLConstants.tableUsers,
                SQLConstants.ALL_COLUMNS,
                SQLConstants.SEARCH_BY_ID,
                whereArgs,
                null,
                null,
                null);

        cursor.moveToFirst();
        while(cursor.moveToNext()){
            usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            usuario.setName(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NAME)));
            usuario.setAge(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_AGE)));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_EMAIL)));
        }

        if(cursor.getCount()==0){
            String N_A = "N/A";

            usuario.setId(N_A);
            usuario.setName(N_A);
            usuario.setAge(0);
            usuario.setEmail(N_A);
        }

        return usuario;
    }

    public void deleteUser(String id){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.delete(SQLConstants.tableUsers, SQLConstants.WHERE_ID_CLAUSE, whereArgs);
    }

    public void updateUser(String id, ContentValues contentValues){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.update(SQLConstants.tableUsers, contentValues, SQLConstants.SEARCH_BY_ID,
                whereArgs);
    }

}
