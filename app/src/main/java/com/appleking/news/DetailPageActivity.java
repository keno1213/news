package com.appleking.news;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.appleking.news.widget.NoLoadWebView;

import java.io.RandomAccessFile;

/**
 * Created by appleking on 2017/3/15.
 */

public class DetailPageActivity extends AppCompatActivity {

    private NoLoadWebView web;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        web = (NoLoadWebView) findViewById(R.id.mWeb);
        String url = getIntent().getStringExtra("url");
        web.loadUrl(url);
        ProgressDialog dialog = new ProgressDialog(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        DatabaseHelper database = new DatabaseHelper(this);

        db = database.getReadableDatabase();



    }



}

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mydata.db";
    private static final int db_version = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(username varchar(20) not null , age varchar(20) not null );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
