package com.example.bryan.studybuddies;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class place extends AppCompatActivity {
    int state = 0; //0 checked out, 1 checked in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
    }
    public void openCheck(View V){
        LinearLayout list = findViewById(R.id.checkInBox);
        Button but = findViewById(R.id.checkInOut);
        if(state == 1){;
            state = 0;
            but.setText("Check In");
            but.setBackgroundColor(Color.parseColor("#83C80E"));
        }else{
            list.setVisibility(View.VISIBLE);
        }
    }

    public void checkOut(View V){
        LinearLayout list = findViewById(R.id.checkInBox);
        list.setVisibility(View.VISIBLE);

    }

    public void closeCheckYes(View V){
        state = 1;
        LinearLayout x = findViewById(R.id.checkInBox);
        x.setVisibility(View.GONE);
        Button but = findViewById(R.id.checkInOut);
        but.setBackgroundColor(Color.parseColor("#F44436"));
        but.setText("Check Out");

    }

    public void closeCheckNo(View V){
        LinearLayout x = findViewById(R.id.checkInBox);
        x.setVisibility(View.GONE);
    }
}
