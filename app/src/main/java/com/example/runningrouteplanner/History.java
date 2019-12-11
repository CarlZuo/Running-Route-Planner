package com.example.runningrouteplanner;

import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class History extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SimpleCursorAdapter dataAdapter;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        // default sort order is id
        queryTrack("date");

        // register observer
        getContentResolver().registerContentObserver(MyProviderContract.ALL_URI, true, new ChangeObserver(h));

        ArrayList<String> items = new ArrayList<String>();
        items.add("date");
        items.add("startTime");
        items.add("endTime");
        items.add("distance");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, items);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    // changeObserver to check any change on database
    class ChangeObserver extends ContentObserver {

        public ChangeObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            this.onChange(selfChange, null);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            queryTrack("_id");
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        String item = parent.getItemAtPosition(pos).toString();
        switch (item){
            case "date":
                queryTrack("date");
                break;
            case "startPoint":
                queryTrack("startPoint");
                break;
            case "endPoint":
                queryTrack("endPoint");
                break;
            case "distance":
                queryTrack("distance");
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    // query and display all the recipes
    public void queryTrack(String order) {

        String[] projection = new String[] {
                MyProviderContract._ID,
                MyProviderContract.DATE,
                MyProviderContract.DISTANCE,
        };

        String colsToDisplay [] = new String[] {
                MyProviderContract._ID,
                MyProviderContract.DATE,
                MyProviderContract.DISTANCE,
        };

        int[] colResIds = new int[] {
                R.id.ID,
                R.id.Date,
                R.id.StartPoint,
                R.id.EndPoint,
                R.id.Distance,
        };

        Cursor cursor = getContentResolver().query(MyProviderContract.TRACKER_URI, projection, null, null, order);

        // put each item to item layout, and then put each layout inside listView
        dataAdapter = new SimpleCursorAdapter(
                this,
                R.layout.item_layout,
                cursor,
                colsToDisplay,
                colResIds,
                0);

        // put each item to each child inside listView
        final ListView listView = (ListView) findViewById(R.id.historyList);
        listView.setAdapter(dataAdapter);
        // set a listener for each item detail clicking
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                View v = listView.getChildAt(myItemInt);

                TextView myId = (TextView)v.findViewById(R.id.ID);
                String s = myId.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("myId", s);

                TextView myDate = (TextView)v.findViewById(R.id.Date);
                String s1 = myDate.getText().toString();
                Bundle bundle1 = new Bundle();
                bundle1.putString("myDate", s1);

                TextView myStart = (TextView)v.findViewById(R.id.StartPoint);
                String s2 = myStart.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("myStart", s2);

                TextView myEnd = (TextView)v.findViewById(R.id.EndPoint);
                String s3 = myEnd.getText().toString();
                Bundle bundle3 = new Bundle();
                bundle3.putString("myEnd", s3);

                TextView myDistance = (TextView)v.findViewById(R.id.Distance);
                String s4 = myDistance.getText().toString();
                Bundle bundle4 = new Bundle();
                bundle4.putString("myDistance", s4);

                TextView mySpeed = (TextView)v.findViewById(R.id.Speed);
                String s5 = mySpeed.getText().toString();
                Bundle bundle5 = new Bundle();
                bundle5.putString("mySpeed", s5);

                // send details to LogDetail activity
                Intent intent = new Intent(History.this, LogDetails.class);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                intent.putExtras(bundle2);
                intent.putExtras(bundle3);
                intent.putExtras(bundle4);
                intent.putExtras(bundle5);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // resume the activity, and refresh the database to display
        queryTrack("date");
    }
}
