package com.example.runningrouteplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "db", null, 1);
        Log.d("g54mdp", "DBHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("g54mdp", "onCreateDBHelper");

        // create a recipe table
        db.execSQL("CREATE TABLE runningrouteplanner (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "date DATE NOT NULL," +
                "startPoint VARCHAR NOT NULL," +
                "endPoint VARCHAR NOT NULL," +
                "distance FLOAT(10,2) NOT NULL" +
                ");");

        // insert two original data
        db.execSQL("INSERT INTO runningrouteplanner (date, startPoint, endPoint, distance) VALUES ('2019-11-08', '09,89', '10', 5000);");
        db.execSQL("INSERT INTO runningrouteplanner (date, startPoint, endPoint, distance) VALUES ('2019-11-09', '08', '09', 3000);");
        db.execSQL("INSERT INTO runningrouteplanner (date, startPoint, endPoint, distance) VALUES ('2019-11-10', '06', '07', 1000);");
        db.execSQL("INSERT INTO runningrouteplanner (date, startPoint, endPoint, distance) VALUES ('2019-11-11', '07', '08', 500);");
        db.execSQL("INSERT INTO runningrouteplanner (date, startPoint, endPoint, distance) VALUES ('2019-11-12', '09', '10', 5000);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS runningrouteplanner");
        onCreate(db);
    }
}