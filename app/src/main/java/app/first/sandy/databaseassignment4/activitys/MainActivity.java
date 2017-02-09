package app.first.sandy.databaseassignment4.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import app.first.sandy.databaseassignment4.R;
import app.first.sandy.databaseassignment4.activitys.listActivity;
import app.first.sandy.databaseassignment4.beans.Beans;
import app.first.sandy.databaseassignment4.database.Dbhealper;

public class MainActivity extends AppCompatActivity {

    EditText firstname;
    EditText lastname;
    Dbhealper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Dbhealper(this);
    }

    public void showall(View view) {

        Intent intent = new Intent(this, listActivity.class);
        startActivity(intent);
    }

    public void save(View view) {
        firstname=(EditText)findViewById(R.id.etname);
        lastname=(EditText)findViewById(R.id.etlstname);

        Beans person_1 = new Beans();
       person_1.setFirst_name(firstname.getText().toString());
        person_1.setLast_name(lastname.getText().toString());
        db.open();
        db.insertData(person_1);
        Toast.makeText(this,"DATA SAVED IN UR DB",Toast.LENGTH_SHORT).show();


    }
}
