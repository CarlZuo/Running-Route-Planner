package com.example.runningrouteplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Preference extends AppCompatActivity {
    private EditText dis;
    private RadioGroup loop;
    private RadioGroup dir_group;
    private boolean loop_choice;
    private int direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        dis = findViewById(R.id.input);
        loop = findViewById(R.id.rg2);
        dir_group = findViewById(R.id.rg1);
    }

    public void onStartClick(View view){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            Context context = getApplicationContext();
            CharSequence text = "Location permission denied!\nPlease open it in setting!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            Intent intent = new Intent(Preference.this, MapsActivity.class);
            Bundle a = new Bundle();
            a.putInt("source",1);
            a.putDouble("distance",Double.valueOf(dis.getText().toString()));
            int id = loop.getCheckedRadioButtonId();
            if (id==R.id.loop_y) loop_choice=true;
            else loop_choice=false;
            int dir = dir_group.getCheckedRadioButtonId();
            switch (dir){
                case R.id.north_west: direction=1; break;
                case R.id.north_east: direction=2; break;
                case R.id.south_west: direction=3; break;
                case R.id.south_east: direction=4; break;
                default: direction = 0; break;
            }
            a.putBoolean("loop",loop_choice);
            a.putInt("direction",direction);
            intent.putExtras(a);
            startActivity(intent);
            Context context = getApplicationContext();
            CharSequence text = "Open the Map!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
