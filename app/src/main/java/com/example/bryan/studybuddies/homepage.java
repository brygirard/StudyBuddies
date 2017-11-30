package com.example.bryan.studybuddies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }
    public void buttonClickFunction(View v)
    {
        Intent myIntent = new Intent(v.getContext(), classpage.class);
        startActivity(myIntent);
    }

    public void buttonClickSearchFunction(View v)
    {
        Intent myIntent = new Intent(v.getContext(), classes_search.class);
        startActivity(myIntent);
    }

    public void buttonClickContactFunction(View v)
    {
        Intent myIntent = new Intent(v.getContext(), contact_search.class);
        startActivity(myIntent);
    }

}