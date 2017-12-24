package com.gautam.listg;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bAddMainactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        TextView textView = (TextView)findViewById(R.id.txtDisplay);
        SQLiteDatabase database = openOrCreateDatabase("gautamdb.db",MODE_PRIVATE, null);
        //database.execSQL("create table if not exists sampletable (name text, location text)");
        database.execSQL("insert into sampletable values ('gautam',' Hyderabad') ");
        Cursor cursor =  database.rawQuery("select * from sampletable",null);
        cursor.moveToFirst();

        System.out.print("Column count : " + cursor.getColumnCount()+"\n");
        String strName = cursor.getString(0);
        String strLocation = cursor.getString(1);

        textView.setText(strName + "\t" + strLocation);
        database.close();

    }


    // Initialising buttons :
    private void init() {
        bAddMainactivity = (Button)findViewById(R.id.btnAddMainActivity);   // Compose button.
        bAddMainactivity.setOnClickListener(this);
    }

    //Click on button.
    @Override
    public void onClick (View view) {
        System.out.println("Starting new intent");
        startActivity(new Intent(this, dialogBox.class ));
    }
}
