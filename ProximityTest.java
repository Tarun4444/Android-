package com.example.shubhamupadhyay.batapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ProximityTest extends AppCompatActivity {

    ImageView iv;
    SensorManager sm;
    Sensor s;
    SensorEventListener se1=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            if(x==5)
            {
                iv.setImageResource(R.drawable.shubham);
            }
            else
            {
                iv.setImageResource(R.drawable.ff);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_test);
        iv=(ImageView)findViewById(R.id.imageView);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(se1,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
