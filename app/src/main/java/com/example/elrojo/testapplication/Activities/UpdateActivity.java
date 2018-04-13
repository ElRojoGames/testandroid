package com.example.elrojo.testapplication.Activities;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elrojo.testapplication.Data;
import com.example.elrojo.testapplication.POJOs.User;
import com.example.elrojo.testapplication.R;
import com.example.elrojo.testapplication.SQLConstants;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    EditText idUpdate, nameUpdate, ageUpdate, emailUpdate;
    Button btnSearchUpdate, btnUpdate;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        idUpdate = (EditText) findViewById(R.id.idUpdate);
        nameUpdate = (EditText) findViewById(R.id.nameUpdate);
        ageUpdate = (EditText) findViewById(R.id.ageUpdate);
        emailUpdate = (EditText) findViewById(R.id.emailUpdate);

        btnSearchUpdate = (Button) findViewById(R.id.btnSearchUpdate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnSearchUpdate.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() )
        {
            case R.id.btnSearchUpdate:
                User user = new User();
                String stringSearchId = idUpdate.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                user = data.getUser(stringSearchId);

                nameUpdate.setText(user.getName());
                ageUpdate.setText(String.valueOf(user.getAge()));
                emailUpdate.setText(user.getEmail());
                break;

            case R.id.btnUpdate:
                data = new Data(getApplicationContext());
                data.open();

                String id = idUpdate.getText().toString();
                ContentValues contentValues = new ContentValues(3);

                contentValues.put(SQLConstants.COLUMN_NAME, nameUpdate.getText().toString());
                contentValues.put(SQLConstants.COLUMN_AGE, Integer.valueOf(ageUpdate.getText().toString()));
                contentValues.put(SQLConstants.COLUMN_EMAIL, emailUpdate.getText().toString());

                data.updateUser(id, contentValues);
                Toast.makeText(getApplicationContext(), "El usuario se actualizo correctamente",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
