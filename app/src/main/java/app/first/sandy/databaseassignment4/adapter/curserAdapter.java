package app.first.sandy.databaseassignment4.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.os.Bundle;
import android.widget.TextView;

import app.first.sandy.databaseassignment4.R;

/**
 * Created by manjula on 09-02-2017.

 */



public class curserAdapter extends CursorAdapter {
    public curserAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.customlist,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView firstname =(TextView)view.findViewById(R.id.setfirstname);
        TextView lastname =(TextView)view.findViewById(R.id.setlastname);
        TextView setid =(TextView)view.findViewById(R.id.setid);

        int id = cursor.getInt(0);
        String first_name = cursor.getString(1);
        String last_name =cursor.getString(2);

        setid.setText(String.valueOf(id));
        firstname.setText(first_name);
        lastname.setText(last_name);



//
        //


    }
}
