package com.example.elrojo.testapplication.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.elrojo.testapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button insert, search, delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = (Button) findViewById(R.id.btnActivityInsert);
        search = (Button) findViewById(R.id.btnActivitySearch);
        delete = (Button) findViewById(R.id.btnActivityDelete);

        insert.setOnClickListener(this);
        search.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btnActivityInsert:
                intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActivitySearch:
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.btnActivityDelete:
                intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
                break;

        }
    }
}
