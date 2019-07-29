package com.example.shubhamupadhyay.batapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


public class ButtonOptionTest extends AppCompatActivity {

    PopupMenu p;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_option_test);

        b=(Button)findViewById(R.id.button4);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               p=new PopupMenu(ButtonOptionTest.this,b);
               p.getMenuInflater().inflate(R.menu.menu,p.getMenu());
               p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       Toast.makeText(ButtonOptionTest.this,item.getTitle(), Toast.LENGTH_SHORT).show();
                       return true;
                   }
               });
                    p.show();
           }
       });

    }


}
