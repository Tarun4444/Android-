package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class spinnerfromjava extends AppCompatActivity {
Spinner sp;
    String []ar={"SELECT COUNTRY","INDIA","CHINA","RUSSIA","INDONASIA"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnerfromjava);
        sp=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (position == 0)
                {
                }
                else
                {
                    Toast.makeText(spinnerfromjava.this, "you have selected"+sp.getSelectedItem(),Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            };
    });
}}
