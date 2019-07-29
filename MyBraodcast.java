package com.example.shubhamupadhyay.batapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.TaskStackBuilder;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;


public class MyBraodcast extends BroadcastReceiver
{
    Notification.Builder nb;
    NotificationManager nm;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        {
            String status=bundle.getString(TelephonyManager.EXTRA_STATE);
            if(status.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                nb=new Notification.Builder(context);
                nb.setContentTitle(("call")).setContentText("you have").setSmallIcon(android.R.drawable.sym_call_incoming).
                setContentInfo("tyou have call from"+bundle.getString(
                        TelephonyManager.EXTRA_INCOMING_NUMBER));
                TaskStackBuilder tsb=TaskStackBuilder.create(context);
                Intent i=new Intent(context,Bat2.class);
                tsb.addNextIntent(i);
                PendingIntent pi=tsb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                nm.notify(0,nb.build());

                Toast.makeText(context, "Have Incoming call"+bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
