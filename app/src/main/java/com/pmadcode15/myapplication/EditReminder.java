package com.pmadcode15.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditReminder extends AppCompatActivity {

    private EditText editTitle,editDescription;
    private Button editConButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reminder);


        editConButton=findViewById(R.id.editConfirmbtn);
        editTitle=findViewById(R.id.editDescription);
        editDescription=findViewById(R.id.editTitle);
    }
}