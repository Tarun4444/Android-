package com.example.shubhamupadhyay.batapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by SHUBHAM UPADHYAY on 05-07-2016.
 */

public class MyService extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.wiggle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        stopSelf();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
      mp.stop();
        stopSelf();
    }
}
