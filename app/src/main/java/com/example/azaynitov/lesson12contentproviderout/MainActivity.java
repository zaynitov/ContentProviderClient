package com.example.azaynitov.lesson12contentproviderout;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Cursor cursor;

    private static final String AUTHORITY = "com.example.admin.lesson9";
    private static final String NOTE_TABLE = "notifications";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + NOTE_TABLE);
    public static final Uri CONTENT_URI_FORDELETE =
            Uri.parse("content://" + AUTHORITY + "/" + NOTE_TABLE+"/1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver contentResolver = getContentResolver();
        getContentResolver().insert(CONTENT_URI, getContentValues(3, "HelloFromHeaven", "It's perfect here"));
        Log.d("outter", "inserted");
        getContentResolver().delete(CONTENT_URI_FORDELETE, null, null);
        Log.d("outter", "deleted" + CONTENT_URI.toString());

    }

    public ContentValues getContentValues(Integer id, String name, String content) {
        ContentValues contentValues = new ContentValues();
        if (id != null) {
            contentValues.put("id", id);
        }
        contentValues.put("name", name);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        contentValues.put("date", dateFormat.format(date));
        contentValues.put("content", content);
        return contentValues;

    }


}
