package com.example.shubhamupadhyay.batapp;

import android.content.SharedPreferences;
import android.graphics.AvoidXfermode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class PreferenceTest extends AppCompatActivity {

    SharedPreferences sp;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_test);
        ed1=(EditText)findViewById(R.id.editText);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);//a mypref named file is created where the temporary data is stored

        ed1.setText(sp.getString("str",""));          //the already written text is there
    }
    @Override
    protected void onStop()                           //this function used to use activity's info before the activity is destroyed
    {

        super.onStop();
        String st=ed1.getText().toString();
        SharedPreferences.Editor se=sp.edit();
        se.putString("str",st);                     //the earlier written text is still there
        se.commit();                                //changes in the file are reflected

    }
}
