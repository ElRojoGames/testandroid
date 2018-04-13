package com.example.elrojo.testapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elrojo.testapplication.Data;
import com.example.elrojo.testapplication.R;

public class DeleteActivity extends AppCompatActivity {

    EditText idDelete;
    Button btnDelete;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        idDelete = (EditText) findViewById(R.id.idDelete);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idDelete.getText().toString();
                data = new Data(getApplicationContext());
                data.deleteUser(id);
                Toast.makeText(getApplicationContext(), "El elemento de ha eliminado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
