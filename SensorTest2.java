/*package com.example.shubhamupadhyay.batapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorTest2 extends AppCompatActivity {
    SensorManager sm;
    Sensor s;
    List<Sensor> l;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test2);
        sm=(SensorManager)getSystemService(Context.SEARCH_SERVICE);
        l=sm.getSensorList(Sensor.TYPE_ALL);
        tv=(TextView)findViewById(R.id.tv);
        for(Sensor s1:l)
        {
            data+=s1.getName()+"||"+s1.getType()+"||"+s1.getVendor()+"\n";
        }
        tv.setText(data);
    }
}
*/