package com.example.runningrouteplanner;

import android.net.Uri;

public class MyProviderContract {
    public static final String AUTHORITY = "com.example.runningrouteplanner.MyProvider";

    public static final Uri TRACKER_URI = Uri.parse("content://"+AUTHORITY+"/runningrouteplanner");
    public static final Uri ALL_URI = Uri.parse("content://"+AUTHORITY+"/");

    public static final String _ID = "_id";

    public static final String DATE = "date";
    public static final String DISTANCE = "distance";

    public static final String CONTENT_TYPE_SINGLE = "vnd.android.cursor.item/MyProvider.data.text";
    public static final String CONTENT_TYPE_MULTIPLE = "vnd.android.cursor.dir/MyProvider.data.text";
}
