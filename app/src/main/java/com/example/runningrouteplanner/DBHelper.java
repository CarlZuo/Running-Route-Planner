package com.example.runningrouteplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "db", null, 1);
        Log.d("routePlanner", "DBHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("routePlanner", "onCreateDBHelper");

        // create a recipe table
        db.execSQL("CREATE TABLE routePlanner (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "date DATE NOT NULL," +
                "startPoint VARCHAR NOT NULL," +
                "endPoint VARCHAR NOT NULL," +
                "distance FLOAT(10,2) NOT NULL" +
                ");");

        // insert two original data
        db.execSQL("INSERT INTO routePlanner (date, startPoint, endPoint, distance) VALUES ('2019-11-08', '42.350, -71.106', '42.342, -71.147', 2.0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS routePlanner");
        onCreate(db);
    }
}