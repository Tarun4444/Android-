package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bat1 extends AppCompatActivity implements View.OnClickListener {
    Button inc,dec,reset;
    TextView t;
    static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat1);

        inc=(Button)findViewById(R.id.button);
        dec=(Button)findViewById(R.id.button2);
        reset=(Button)findViewById(R.id.button3);
        t=(TextView)findViewById(R.id.b);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button:
                count--;
                t.setText("BATRANG  :  "+count);
                break;

            case R.id.button2:
                count++;
                t.setText("BATRANG  :  "+count);
                break;

            case R.id.button3:
                count=0;
                t.setText("BATRANG  :  "+count);
                break;

        }
    }
}
