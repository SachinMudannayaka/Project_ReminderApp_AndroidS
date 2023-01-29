package com.pmadcode15.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditReminder extends AppCompatActivity {

    private EditText editTitle,editDescription;
    private Button editConButton;
    private Context context;
    private Long updatedDate;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reminder);

       context=this;
        dbHandler=new DBHandler(context);

        editConButton=findViewById(R.id.editConfirmbtn);
        editTitle=findViewById(R.id.editTitle);
        editDescription=findViewById(R.id.editDescription);

        final String id=getIntent().getStringExtra("id");
        ReminderModel reminderModel=dbHandler.getSingleReminder(Integer.parseInt(id));
        editTitle.setText(reminderModel.getTitle());
        editDescription.setText(reminderModel.getDescription());

        editConButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editedtitle=editTitle.getText().toString();
                String editeddescription=editDescription.getText().toString();
                updatedDate=System.currentTimeMillis();
                ReminderModel reminderModel=new ReminderModel(Integer.parseInt(id),editedtitle,editeddescription,updatedDate,0);
                int State= dbHandler.updateSingleReminder(reminderModel);
                System.out.println(State);
                startActivity(new Intent(context,MainActivity.class));
            }
        });


    }
}