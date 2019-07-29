package com.example.shubhamupadhyay.batapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest extends AppCompatActivity
{
    File f;
    FileInputStream fis;
    FileOutputStream fos;
    EditText fname, fdata;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]
                        {
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},1002);
                        }
            }
        else
        {

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
        fname = (EditText) findViewById(R.id.ed1);
        fdata = (EditText) findViewById(R.id.ed2);
        File f1 = Environment.getExternalStorageDirectory();     //this will give the external storage
        f = new File(f1, "stpdelhi");                              //a file named stpdelhi created in directory environment
        if (!f.exists())
        {
            f.mkdir();                                         //make a directory if does not exists
            Toast.makeText(FileTest.this, "Folder Created", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(FileTest.this, "Folder Already Exists", Toast.LENGTH_SHORT).show();
        }
    }
        public void cdata(View v)
    {
        String f2=fname.getText().toString().trim();
        try
        {
            File f3=new File(f,f2+".txt");
            if(!f3.exists())
            {
                f3.createNewFile();
                Toast.makeText(FileTest.this, "File Created...", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(FileTest.this, "File Exists...", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)
        {
            Toast.makeText(FileTest.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void adata(View v)
    {
        try
        {
           String name =fname.getText().toString().trim();
            String data=fdata.getText().toString().trim();
            fos=new FileOutputStream(f.getAbsolutePath()+File.separator+name+".txt",true);//getAbsolutePath gives the full path i.e. with forward slash, other is relative path that we dont need
            fos.write(data.getBytes());
            Toast.makeText(FileTest.this, "DATA INSERTED...", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(FileTest.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
        public void sdata(View v)
        {
            try
            {
                String name=fname.getText().toString();
                fdata.setText("");
                fis=new FileInputStream(f.getAbsolutePath()+File.separator+name+".txt");//the forward slash and the back slash in the path are put by java itself
                String filedata="";
                int i;
                while((i=fis.read())>-1)
                {
                    filedata+=(char)i;
                }
                fdata.setText(filedata);
            }
            catch(Exception e)
            {
                Toast.makeText(FileTest.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode)
        {
            case 1002:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {

                }
                else
                {

                }
                return;
        }
    }
}
