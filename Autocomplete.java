package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class Autocomplete extends AppCompatActivity {

    AutoCompleteTextView act;
    MultiAutoCompleteTextView mct;

    String country[]={"INDIA","IRAN","IRAQ","USA","UK"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);

        act=(AutoCompleteTextView)findViewById(R.id.actv);
        mct=(MultiAutoCompleteTextView)findViewById(R.id.mactv);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,country);

        act.setAdapter(adapter);
        mct.setAdapter(adapter);
        mct.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
