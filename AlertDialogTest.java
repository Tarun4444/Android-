package com.example.shubhamupadhyay.batapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class AlertDialogTest extends AppCompatActivity {

    AlertDialog.Builder adb;
    AlertDialog a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);
    }

    public void alert(View v)       //view object is necessary and alert was defined in XML file
    {
        adb=new AlertDialog.Builder(this);
        adb.setMessage("Are you Sure");
        adb.setTitle("Are You Sure");

        adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogTest.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogTest.this, "No", Toast.LENGTH_SHORT).show();
            }
        });

        a=adb.create();
        a.show();
    }


}
