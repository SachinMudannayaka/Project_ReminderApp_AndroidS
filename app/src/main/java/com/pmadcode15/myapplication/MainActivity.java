package com.pmadcode15.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private ListView listView;
    private TextView count;
    private Context context;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.reminderAddbutton);
        listView=findViewById(R.id.reminderList);
        count=findViewById(R.id.todocount);
        context=this;
        dbHandler=new DBHandler(this);

        int countReminder= dbHandler.countReminder();
        count.setText("YOU HAVE "+countReminder+" REMINDERS");

      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(context,AddReminder.class));
          }
      });


    }
}