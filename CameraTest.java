package com.example.shubhamupadhyay.batapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraTest extends AppCompatActivity {

    Button b;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_test);
        b=(Button)findViewById(R.id.b);
        iv=(ImageView)findViewById(R.id.i);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(intent,10);//10 is the result code like for every complaint in a shop
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle=data.getExtras();
        if(requestCode==10 && resultCode==RESULT_OK)
        {
            Bitmap bmp=(Bitmap) bundle.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}
