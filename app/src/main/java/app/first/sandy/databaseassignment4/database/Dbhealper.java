package app.first.sandy.databaseassignment4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import app.first.sandy.databaseassignment4.beans.Beans;

/**
 * Created by manjula on 09-02-2017.
 */

public class Dbhealper extends SQLiteOpenHelper {

    private static final String DB_NAME = "assignment4.db";
    private static final int DB_VER = 1;
    private static final String TABLE_NAME = "data";
    private static final String ID = "_id";
    private static final String FIRST_NAME = " first_name ";
    private static final String LAST_NAME = " last_name ";
    private Context ctx;
    private SQLiteDatabase database;


    public Dbhealper(Context context) {
        super(context,DB_NAME,null,DB_VER);
        ctx= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table = " CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FIRST_NAME + "TEXT," +
                LAST_NAME + "TEXT )";

        db.execSQL(table);
        Log.i("create table","Creating table...........");
        Toast.makeText(ctx,"Database created",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String upgrade = "Drop Table if exists " + TABLE_NAME;
        db.execSQL(upgrade);

    }

    public void open(){

        Log.i("opendb","Checking weather database is null..........");
        if (this.database==null){
            Log.i("Database null","getting Writable database......");
            this.database = this.getWritableDatabase();
            Toast.makeText(ctx,"DATABASE is open now",Toast.LENGTH_SHORT).show();
        }

    }
    public void close(){

        if (this.database.isOpen()){
            this.database.close();
            Log.i("Close db","Database closed..........");
        }

    }

    public long insertData(Beans beans){

        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, beans.getFirst_name());
        values.put(LAST_NAME, beans.getLast_name());

        return this.database.insert(TABLE_NAME,null,values);

    }


//    public Beans getAll_products()
//    {
//        Cursor curser = this.database.query(TABLE_NAME,new String[]{FIRST_NAME,LAST_NAME},null,null,null,null,null);
//
//            while (curser.moveToNext())
//            {
//                String firstname = curser.getString(1);
//                String lastname = curser.getString(2);
//                curser.close();
//                return new Beans() ;
//            }
//        return null;
//        }






    }


