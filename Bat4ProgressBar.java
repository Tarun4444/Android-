package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Bat4ProgressBar extends AppCompatActivity
{

    ProgressBar pb;
    Button start;
    Thread th;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat4_progress_bar);

        pb=(ProgressBar)findViewById(R.id.pb);
        start=(Button)findViewById(R.id.pbp);
        t1=(TextView)findViewById(R.id.tv);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {t1.setText("INSTALLING BAT VIRUS....");

              th=new Thread()
              {
                  public void run()
                  {
                      try
                      {
                      for(int i=0;i<25;i++)
                      {
                          pb.setProgress(i*4);
                          sleep(500);
                      }
                      }
                      catch(Exception e)
                      {}
                  }
              };
                th.start();
            }
        });
    }
}
