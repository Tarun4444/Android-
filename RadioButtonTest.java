package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonTest extends AppCompatActivity
{

    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button clear;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        r3=(RadioButton)findViewById(R.id.rb3);
        r4=(RadioButton)findViewById(R.id.rb4);
        rg=(RadioGroup) findViewById(R.id.rg);
        tv1= (TextView)findViewById(R.id.tv);
        clear=(Button) findViewById(R.id.b);

        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rg.clearCheck();
                tv1.setText("");

            }
        });
        View.OnClickListener listner=new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
             RadioButton r=(RadioButton)v;
                tv1.setText("You have selected  "+r.getText().toString());
            }


        };
        r1.setOnClickListener(listner);
        r2.setOnClickListener(listner);
        r3.setOnClickListener(listner);
        r4.setOnClickListener(listner);
    }
}
