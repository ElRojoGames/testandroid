package com.example.elrojo.testapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.elrojo.testapplication.R;

public class InsertActivity extends AppCompatActivity {

    EditText id, name, age, email;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        insert = (Button) findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
