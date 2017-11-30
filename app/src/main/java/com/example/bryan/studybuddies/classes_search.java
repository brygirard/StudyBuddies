package com.example.bryan.studybuddies;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class classes_search extends AppCompatActivity {


    //add class data
    String[] classes = {"CS 100","CS 125", "CS 126", "CS 173", "CS 233", "CS 241", "CS 374", "CS465", "CS 498"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView lv;
        SearchView sv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_search);
        lv = (ListView) findViewById(R.id.contactListView);
        sv = (SearchView) findViewById(R.id.contactSearchView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {

                adapter.getFilter().filter(text);
                return false;
            }
        });

        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.class_search_menu, menu);

    }
}