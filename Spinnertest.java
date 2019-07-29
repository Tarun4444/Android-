package com.example.shubhamupadhyay.batapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Spinnertest extends AppCompatActivity
{

    Spinner sp;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinnertest);

        sp=(Spinner)findViewById(R.id.sp);
        rl=(RelativeLayout)findViewById(R.id.rl);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(sp.getSelectedItem().toString().equals("Select color"))
                {

                }

                else if(sp.getSelectedItem().toString().equals("red"))
                {
                    rl.setBackgroundColor(Color.RED);
                }
                else if(sp.getSelectedItem().toString().equals("yellow"))
                {
                    rl.setBackgroundColor(Color.YELLOW);
                }
                else if(sp.getSelectedItem().toString().equals("green")) {
                    rl.setBackgroundColor(Color.GREEN);
                }


                else if(sp.getSelectedItem().toString().equals("blue"))
                {
                    rl.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
