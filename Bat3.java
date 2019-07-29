package com.example.shubhamupadhyay.batapp;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bat3 extends AppCompatActivity
{

    Button add,sub,mul;
    TextView t1;
    EditText n,m;
    int s,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat3);

        n=(EditText)findViewById(R.id.eT);
        m=(EditText)findViewById(R.id.eT2);
        add=(Button)findViewById(R.id.b4);
        sub=(Button)findViewById(R.id.b1);
        mul=(Button)findViewById(R.id.b2);
        t1=(TextView)findViewById(R.id.tV);



        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                s=Integer.parseInt(n.getText().toString());
                s2=Integer.parseInt(m.getText().toString());
                t1.setText("Result  :  "+(s+s2));

            }
        });

        sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                s=Integer.parseInt(n.getText().toString());
                s2=Integer.parseInt(m.getText().toString());
                t1.setText("Result  :  "+(s-s2));

            }
        });

        mul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                s=Integer.parseInt(n.getText().toString());
                s2=Integer.parseInt(m.getText().toString());
                t1.setText("Result  :  "+(s*s2));

            }
        });

    }


}
