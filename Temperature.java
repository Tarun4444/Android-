package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Temperature extends AppCompatActivity
{

    RadioButton r1, r2;
    RadioGroup rg;
    Button convert;
    TextView tv1;
    EditText n;
    float s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        rg = (RadioGroup) findViewById(R.id.rg);
        tv1 = (TextView) findViewById(R.id.tv);
        n = (EditText) findViewById(R.id.ed);

        convert = (Button) findViewById(R.id.b);

        convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                s = Integer.parseInt(n.getText().toString());
            if(r1.isChecked())
            {
                tv1.setText(+(5 * (s - 32) / 9) + "Degree Fahrenheit");
            }
            else if(r2.isChecked())
            {
                tv1.setText(((s * 9 / 5) + 32) + "Degree Celcius");
            }
            else
            tv1.setText("Select one");
                rg.clearCheck();
            };
        });

        View.OnClickListener listner = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {



            }
        };
        r1.setOnClickListener(listner);
        r2.setOnClickListener(listner);

    }
}

