package com.example.shubhamupadhyay.batapp;


/*we need sensor manager to use a sensor*/


import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.widget.TextView;

public class SensorTest extends AppCompatActivity {
    TextView tv;
    SensorManager sm;
    Sensor s;
    SensorEventListener se1=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];
            tv.setTextSize(30);
            tv.setTextColor(Color.RED);
            tv.setText("Azimuth: "+x+"  Pitch: "+y+"  roll: "+z);




        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv=(TextView)findViewById(R.id.tv);
        sm.registerListener(se1,s,SensorManager.SENSOR_DELAY_NORMAL);//if this is not there then sensor will work only once
    }
}
