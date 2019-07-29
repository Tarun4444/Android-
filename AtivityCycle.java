package com.example.shubhamupadhyay.batapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AtivityCycle extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativity_cycle);
        b1=(Button)findViewById(R.id.stas);
        b2=(Button)findViewById(R.id.sts);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Intent i=new Intent(this,MyService.class);
        switch(v.getId())
        {
            case R.id.stas:
                startService(i);
                break;
            case R.id.sts:
                stopService(i);
                break;
        }
    }
}
