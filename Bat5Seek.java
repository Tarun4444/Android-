package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class Bat5Seek extends AppCompatActivity {

    SeekBar sb;
    TextView tv;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat5_seek);

        sb=(SeekBar)findViewById(R.id.sb);
        tv=(TextView)findViewById(R.id.tv);
        pb=(ProgressBar)findViewById(R.id.pb);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress, boolean fromUser)
            {

                tv.setText("tuning  "+progress+"%..");
                pb.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
