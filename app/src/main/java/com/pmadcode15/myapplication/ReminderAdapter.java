package com.pmadcode15.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<ReminderModel> {

    private Context context;
    private int resources;
    List<ReminderModel> reminderModels;

    ReminderAdapter(Context context, int resource, List<ReminderModel> reminderModels) {
        super(context, resource, reminderModels);
        this.context = context;
        this.resources = resource;
        this.reminderModels = reminderModels;
    }

        public View getView(int position,View convertView, ViewGroup parent){
            LayoutInflater inflater=LayoutInflater.from(context);
            View row=inflater.inflate(resources,parent,false);
            TextView title=row.findViewById(R.id.title);
            TextView description=row.findViewById(R.id.descreiption);
            ImageView imageView=row.findViewById(R.id.imageView);

            ReminderModel reminderModel=reminderModels.get(position);
            title.setText(reminderModel.getTitle());
            description.setText(reminderModel.getDescription());
            imageView.setVisibility(row.INVISIBLE);
            if(reminderModel.getFinished()>0) {
                imageView.setVisibility(View.VISIBLE);

            }
        return row;

    }

}
