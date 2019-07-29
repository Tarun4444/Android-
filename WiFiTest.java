package com.example.shubhamupadhyay.batapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class WiFiTest extends AppCompatActivity
{

    WifiManager wm;
    WifiInfo wifiInfo;
    List<ScanResult> s;
    BroadcastReceiver br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_test);

        wm=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        if(wm!=null)
        {
            if(!wm.isWifiEnabled())
            {
                wm.setWifiEnabled(true);
                wm.startScan();
            }
            else
            {
                wm.startScan();
            }

        }
        else
        {
            Toast.makeText(WiFiTest.this, "old phone", Toast.LENGTH_SHORT).show();
        }
         br=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action=intent.getAction();
                if(action.equals(action))
                {
                    wm.getScanResults();
                }
                for(ScanResult s1:s)
                Toast.makeText(WiFiTest.this,s1.BSSID+"||"+s1.SSID+"||"+s1.level, Toast.LENGTH_SHORT).show();
            }
        };

        IntentFilter ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(br,ifr);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}
