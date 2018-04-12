package com.example.elrojo.testapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.elrojo.testapplication.Data;
import com.example.elrojo.testapplication.POJOs.User;
import com.example.elrojo.testapplication.R;

public class SearchActivity extends AppCompatActivity {

    EditText searchId, txtAreaResult;
    Button btnSearch;
    Data data;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        user = new User();
        searchId = (EditText) findViewById(R.id.searchId);
        txtAreaResult = (EditText)findViewById(R.id.txtAreaResult);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringSearchId = searchId.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                user = data.getUser(stringSearchId);

                String result = "RESULTADOS:\n"+"Id: "+user.getId()+"\nName: "+user.getName()
                        +"\nAge: "+user.getAge()+"\nEmail:"+user.getEmail();
                txtAreaResult.setText(result);
            }
        });
    }
}
