package com.example.runningrouteplanner;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.FileNotFoundException;

public class MyProvider extends ContentProvider {

    private DBHelper dbHelper = null;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(MyProviderContract.AUTHORITY, "runningrouteplanner", 1);
    }

    // initialise DBHelper
    @Override
    public boolean onCreate() {

        Log.d("g53mdp", "content provider created");
        this.dbHelper = new DBHelper(this.getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {

        String contentType;

        if (uri.getLastPathSegment()==null) {
            contentType = MyProviderContract.CONTENT_TYPE_MULTIPLE;
        } else {
            contentType = MyProviderContract.CONTENT_TYPE_SINGLE;
        }

        return contentType;
    }

    // insert data to database
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long id = db.insert("runningrouteplanner", null, values);
        db.close();
        Uri nu = ContentUris.withAppendedId(uri, id);

        Log.d("g53mdp", nu.toString());

        getContext().getContentResolver().notifyChange(nu, null);

        return nu;
    }

    // query items from database
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Log.d("g53mdp", uri.toString() + " " + uriMatcher.match(uri));

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch(uriMatcher.match(uri)) {
            case 2:
                selection = "_ID = " + uri.getLastPathSegment();
            case 1:
                return db.query("runningrouteplanner", projection, selection, selectionArgs, null, null, sortOrder);
            default:
                return null;
        }
    }

    // update information for selected log
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int affectRow = db.update("runningrouteplanner", values, selection,selectionArgs);
        db.close();

        return affectRow;
    }

    // delete data
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int affectRow = db.delete("runningrouteplanner", selection, selectionArgs);
        db.close();

        return affectRow;
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        throw new UnsupportedOperationException("not implemented");
    }
}
