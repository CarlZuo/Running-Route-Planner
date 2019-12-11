package com.example.runningrouteplanner;

import android.content.Context;
import android.content.Intent;
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
        String myDistance = "   " +bundle4.getString("myDistance") + " km";

        TextView s1 = (TextView) findViewById(R.id.ID);
        s1.setText(myId);

        TextView s2 = (TextView) findViewById(R.id.Date);
        s2.setText(myDate);

        TextView s3 = (TextView) findViewById(R.id.StartPoint);
        s3.setText(myStart);

        TextView s4 = (TextView) findViewById(R.id.EndPoint);
        s4.setText(myEnd);

        TextView s5 = (TextView) findViewById(R.id.Distance);
        s5.setText(myDistance);

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

    public void onReLoadClick(View view){
        Intent intent = new Intent(LogDetails.this, MapsActivity.class);
        Bundle a = new Bundle();
        a.putInt("source",2);
        TextView s1 = (TextView) findViewById(R.id.StartPoint);
        a.putString("start", s1.getText().toString());
        TextView s2 = (TextView) findViewById(R.id.EndPoint);
        a.putString("end", s2.getText().toString());
        intent.putExtras(a);
        startActivity(intent);
    }
}
