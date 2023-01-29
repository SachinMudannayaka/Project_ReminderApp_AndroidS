package com.pmadcode15.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private ListView listView;
    private TextView count;
    private Context context;

    private DBHandler dbHandler;

    private List<ReminderModel>Reminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=findViewById(R.id.reminderAddbutton);
        listView=findViewById(R.id.reminderList);
        count=findViewById(R.id.todocount);
        context=this;
        dbHandler=new DBHandler(this);
        Reminders=new ArrayList<>();

        Reminders=dbHandler.getAllReminders();

        ReminderAdapter adapter=new ReminderAdapter(context,R.layout.single_reminder,Reminders);
        listView.setAdapter(adapter);


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