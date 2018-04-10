package com.example.elrojo.testapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elrojo.testapplication.Data;
import com.example.elrojo.testapplication.POJOs.User;
import com.example.elrojo.testapplication.R;

public class InsertActivity extends AppCompatActivity {

    EditText id, name, age, email;
    Button insert;
    Data data;

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
                User usuario = new User(
                        id.getText().toString(),
                        name.getText().toString(),
                        Integer.valueOf(age.getText().toString()),
                        email.getText().toString()
                );

                data = new Data(getApplicationContext());
                data.open();
                data.insertUser(usuario);
                Toast.makeText(getApplicationContext(),
                        "El usuario se guardo correctamente",
                        Toast.LENGTH_LONG).show();
                data.close();
            }
        });
    }
}
