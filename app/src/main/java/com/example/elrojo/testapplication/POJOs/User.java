package com.example.elrojo.testapplication.POJOs;

import android.content.ContentValues;

import com.example.elrojo.testapplication.SQLConstants;

public class User {
    private String id;
    private String name;
    private int age;
    private String email;

    public User(){

    }

    public User(String id, String name, int age, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put(SQLConstants.COLUMN_ID, id);
        contentValues.put(SQLConstants.COLUMN_NAME, name);
        contentValues.put(SQLConstants.COLUMN_AGE, age);
        contentValues.put(SQLConstants.COLUMN_EMAIL, email);

        return  contentValues;
    }


}
