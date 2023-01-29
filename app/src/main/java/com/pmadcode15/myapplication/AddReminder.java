package com.pmadcode15.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddReminder extends AppCompatActivity {
    private EditText title,description;
    private Button add;
    private Context context;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        add=findViewById(R.id.addConBtn);
        title=findViewById(R.id.addTitle);
        description=findViewById(R.id.addDescription);
        context=this;
        dbHandler=new DBHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usertitle=title.getText().toString();
                String userdescription=description.getText().toString();
                long started=System.currentTimeMillis();

                ReminderModel remMode=new ReminderModel(usertitle,userdescription,started,0);
                dbHandler.AddReminder(remMode);

                startActivity(new Intent(context,MainActivity.class));
            }
        });




    }
}