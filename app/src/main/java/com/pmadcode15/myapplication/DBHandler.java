package com.pmadcode15.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
//Database variables
    private static final int VERSION=1;
    private static final String DB_NAME="reminder";
    private static final String TABLE_NAME="reminder";

    //column names
    private static final String ID="id";
    private static final String TITLE="title";
    private static final String DESCRIPTION="description";
    private static final String STARTED="started";
    private static final String FINISHED="finished";



    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE_QUERY="CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TITLE +" TEXT,"
                +DESCRIPTION +" TEXT,"
                +STARTED+" TEXT,"
                +FINISHED+" TEXT" +
                ");";
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+ TABLE_NAME;
        //execute query to delete if existed
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        //create again
        onCreate(sqLiteDatabase);

    }

    public void AddReminder(ReminderModel remMode){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(TITLE,remMode.getTitle());
        contentValues.put(DESCRIPTION,remMode.getDescription());
        contentValues.put(STARTED,remMode.getStarted());
        contentValues.put(FINISHED,remMode.getFinished());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public int countReminder(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }
    //to get all reminders
public List<ReminderModel>getAllReminders()

    {
        List<ReminderModel> reminderModels = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                ReminderModel reminderModel = new ReminderModel();
                reminderModel.setId(cursor.getInt(0));
                reminderModel.setTitle(cursor.getString(1));
                reminderModel.setDescription(cursor.getString(2));
                reminderModel.setStarted(cursor.getLong(3));
                reminderModel.setFinished(cursor.getLong(4));

                reminderModels.add(reminderModel);
            }
            while (cursor.moveToNext());

        }
        return reminderModels;
    }
}
