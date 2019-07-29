package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContextTest extends AppCompatActivity {

    String Name[]={"Ashish","Shubham","Rishi","Kshitij"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_test);
        lv=(ListView)findViewById(R.id.lv);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Name);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select Option");
        menu.add(0,v.getId(),0,"call");
        menu.add(0,v.getId(),0,"SMS");
    }
}
