package com.example.shubhamupadhyay.batapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DBTest extends AppCompatActivity {

    Cursor c;
    EditText sid,sname,sage,sadd;
    SQLiteDatabase sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
        sid=(EditText)findViewById(R.id.sid);
        sname=(EditText)findViewById(R.id.sname);
        sadd=(EditText)findViewById(R.id.saddress);
        sname=(EditText)findViewById(R.id.sname);
        sage=(EditText)findViewById(R.id.sage);

        sd=openOrCreateDatabase("delhidb",MODE_PRIVATE,null);

        sd.execSQL("create table if not exists student (sid int primary key, sname varchar not null,sage int not null, saddress varchar not null)");//table in sql is created
        c=sd.rawQuery("select * from student",null);
    }

    public void add(View v)
    {
        try
        {
            int id=Integer.parseInt(sid.getText().toString().trim());
            int age=Integer.parseInt(sage.getText().toString().trim());

            String name=sname.getText().toString();
            String add=sadd.getText().toString();
            sd.execSQL("insert into student values("+id+",'"+name+"',"+age+",'"+add+"')");
            Toast.makeText(DBTest.this, "DATA INSERTED....", Toast.LENGTH_SHORT).show();
            c=sd.rawQuery("select * from student",null);

        }
        catch(Exception e)
        {
            Toast.makeText(DBTest.this,e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }
    public void previous(View v) {
        if (c.moveToPrevious()) {
            sid.setText("" + c.getInt(0));
            sname.setText("" + c.getString(1));
            sage.setText("" + c.getInt(2));
            sadd.setText("" + c.getString(3));


        }
    }
    public void next(View v)
    {
        if (c.moveToNext()) {
            sid.setText("" + c.getInt(0));
            sname.setText("" + c.getString(1));
            sage.setText("" + c.getInt(2));
            sadd.setText("" + c.getString(3));


        }

    }
    public void search(View v)
    {
        try{
            int id=Integer.parseInt(sid.getText().toString());
            Cursor c1=sd.rawQuery("select * from student where sid="+id,null);
            if (c.moveToNext()) {
                sid.setText("" + c.getInt(0));
                sname.setText("" + c.getString(1));
                sage.setText("" + c.getInt(2));
                sadd.setText("" + c.getString(3));
           }
            else
            {
                Toast.makeText(DBTest.this, "no regard found", Toast.LENGTH_SHORT).show();
                sid.setText("");
                sname.setText("");
                sage.setText("");
                sadd.setText("");
            }
        }
        catch(Exception e)
        {
            Toast.makeText(DBTest.this,e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }
}
/*
public void first(View v)
{
if (c.moveToNext()) {
            sid.setText("");
            sname.setText("");
            sage.setText("");
            sadd.setText(""));


        }
        }
public void delete(View v)
{
int id=Integer.parseInt(sid.getText(0.toString());
try{

Cursor c=sd.rawQuery("delete from student where sid="+id,null);
}
catch(Exception e)
{
Toast........"DATA NOT DELETED"
}

}

*/
