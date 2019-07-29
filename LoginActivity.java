package com.example.shubhamupadhyay.batapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity
{

    Button login;
    EditText uid,pass;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button)findViewById(R.id.b);
        uid=(EditText)findViewById(R.id.uid);
        pass=(EditText)findViewById(R.id.uid);
        tv=(TextView)findViewById(R.id.tv);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String pass1=uid.getText().toString();
                String p=pass.getText().toString();
                String u=uid.getText().toString();
                if(u.isEmpty()||p.isEmpty())
                {
                    tv.setText("provide value");
                    tv.setTextSize(30);
                    tv.setTextColor(Color.RED);
                }
                else
                {
                    if(u.equals(p))
                    {
                        Intent i=new Intent(LoginActivity.this,MainActivity.class);
                        i.putExtra("uid",u);
                        startActivity(i);
                    }
                    else
                    {
                        tv.setTextSize(30);
                        tv.setTextColor(Color.RED);
                        tv.setText("Login failed");
                    }
                }
            }
        });
    }
}
