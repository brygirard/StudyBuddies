package com.example.bryan.studybuddies;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class contact_search extends AppCompatActivity {
    ListView lv;
    SearchView sv;
    String[] names={"Andrew","Ashley","Bryan","Bryant","Mike","Sabrina","Xueming"};
    int[] images={R.drawable.contacticon,R.drawable.contacticon,R.drawable.contacticon,R.drawable.contacticon,R.drawable.contacticon,R.drawable.contacticon,R.drawable.contacticon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView) findViewById(R.id.listView1);
        sv=(SearchView) findViewById(R.id.searchView1);
        //ADASPTER
        final contactAdapter adapter=new contactAdapter(this, getContacts());
        lv.setAdapter(adapter);
        sv.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                // TODO Auto-generated method stub
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
    private ArrayList<contact> getContacts()
    {
        ArrayList<contact> players=new ArrayList<contact>();
        contact p;
        for(int i=0;i<names.length;i++)
        {
            p=new contact(names[i], images[i]);
            players.add(p);
        }
        return players;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_search_menu, menu);

    }
}
