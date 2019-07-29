package com.example.shubhamupadhyay.batapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Bat2 extends ListActivity
{
    String menu[]={"MyBraodcast","MapsActivity","AtivityCycle","OptionMenuTest","WiFiTest","ContentProviderTest","BluetoohTest2","BluetoothTest","MediaPlayerTest"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat2);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menu);
        setListAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Toast.makeText(Bat2.this, "On Create...", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Bat2.this, "On Start...", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Bat2.this, "On Resume...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Bat2.this, "On Pause...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Bat2.this, "On Stop...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Bat2.this, "On-Destroy...", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try
        {
            String s="com.example.shubhamupadhyay.batapp."+menu[position];
            Class c=Class.forName(s);
            Intent i=new Intent(this,c);
            startActivity(i);

        }

        catch(Exception e)
        {
            Toast.makeText(Bat2.this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}

