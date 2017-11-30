package com.example.bryan.studybuddies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class classpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classpage);
    }
    public void buttonClickMapFunction(View v)
    {
        Intent myIntent = new Intent(v.getContext(), MapsActivity.class);
        startActivity(myIntent);
    }
    public void buttonClickPlaceFunction(View v)
    {
        Intent myIntent = new Intent(v.getContext(), place.class);
        startActivity(myIntent);
    }
}
