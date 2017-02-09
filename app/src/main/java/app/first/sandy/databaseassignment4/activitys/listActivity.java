package app.first.sandy.databaseassignment4.activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import app.first.sandy.databaseassignment4.R;
import app.first.sandy.databaseassignment4.adapter.curserAdapter;
import app.first.sandy.databaseassignment4.database.Dbhealper;

public class listActivity extends AppCompatActivity {
    ListView listView;
//List<Beans> model = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);
        listView = (ListView)findViewById(R.id.list);

        Dbhealper handler = new Dbhealper(this);

        SQLiteDatabase database=handler.getWritableDatabase();

        Cursor cursor= database.rawQuery("SELECT  * FROM data ",null);

        curserAdapter curserAdapter = new curserAdapter(this,cursor);

//        adapters adapter = new adapters(model,this);
        listView.setAdapter(curserAdapter);

    }

}
