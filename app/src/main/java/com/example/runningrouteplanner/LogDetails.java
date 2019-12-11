package com.example.runningrouteplanner;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogDetails extends AppCompatActivity {

    SimpleCursorAdapter dataAdapter;
    private String myId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_details);

        // receive details of the log, and display them
        Bundle bundle = getIntent().getExtras();
        myId = "   " +bundle.getString("myId");

        Bundle bundle1 = getIntent().getExtras();
        String myDate = "   " + bundle1.getString("myDate");

        Bundle bundle2 = getIntent().getExtras();
        String myStart = "   " +bundle2.getString("myStart");

        Bundle bundle3 = getIntent().getExtras();
        String myEnd = "   " +bundle3.getString("myEnd");

        Bundle bundle4 = getIntent().getExtras();
        String myDistance = "   " +bundle4.getString("myDistance") + " m";

        Bundle bundle5 = getIntent().getExtras();
        String mySpeed = "   " +bundle5.getString("mySpeed") + " m/s";

        TextView s1 = (TextView) findViewById(R.id.ID);
        s1.setText(myId);

        TextView s2 = (TextView) findViewById(R.id.Date);
        s2.setText(myDate);

        TextView s3 = (TextView) findViewById(R.id.StartTime);
        s3.setText(myStart);

        TextView s4 = (TextView) findViewById(R.id.EndTime);
        s4.setText(myEnd);

        TextView s5 = (TextView) findViewById(R.id.Distance);
        s5.setText(myDistance);

        TextView s6 = (TextView) findViewById(R.id.Speed);
        s6.setText(mySpeed);

    }

    public void onDeleteClick(View view) {

        // delete data and toast information
        getContentResolver().delete(MyProviderContract.TRACKER_URI,"_id=?", new String[]{myId});
        Context context = getApplicationContext();
        CharSequence text = "Log has been deleted!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();
    }
}
