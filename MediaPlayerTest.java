package com.example.shubhamupadhyay.batapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MediaPlayerTest extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    ImageButton play;
    SeekBar sb;
    TextView tv;
    Thread progress;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_test);

        sb = (SeekBar) findViewById(R.id.sb);
        tv = (TextView) findViewById(R.id.tv);
        play = (ImageButton) findViewById(R.id.play);
        mp = MediaPlayer.create(this, R.raw.wiggle);

        tv.setText(convertToDuration(mp.getDuration()));

        sb.setMax(mp.getDuration());


        play.setOnClickListener(this);

        sb.setOnSeekBarChangeListener(this);
        progress=new Thread(){
            public void run()
            {

                while(mp.getDuration()!=mp.getCurrentPosition())
                {
                    sb.setProgress(mp.getCurrentPosition());
                }

            }
        };
        progress.start();

    }

    String convertToDuration(long l)
    {
        String duration="";
        long l1=l/1000;
        duration+=l1/60+":"+l1%60;
        return duration;

    }

    @Override
    public void onClick(View v) {

        if (!mp.isPlaying()) {
            mp.start();

            play.setImageResource(android.R.drawable.ic_media_pause);
        } else {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        }

    }


        @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(fromUser)
        {
            mp.seekTo(progress);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }





    public void onCompletion(MediaPlayer mp)
    {
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.wiggle);
    }
}
