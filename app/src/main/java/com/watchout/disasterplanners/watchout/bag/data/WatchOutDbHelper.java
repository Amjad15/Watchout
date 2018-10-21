package com.watchout.disasterplanners.watchout.bag.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.watchout.disasterplanners.watchout.bag.data.WatchOutContract.ItemEntry;


public class WatchOutDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = WatchOutDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "watchout.db";
    private static final int DATABASE_VERSION = 1;
    public WatchOutDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String SQL_CREATE_ITEMS_TABLE = "CREATE TABLE" + ItemEntry.TABLE_NAME + "("
                + ItemEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ItemEntry.COLUMN_ITEM_NAME + "TEXT NOT NULL"
                + ItemEntry.COLUMN_ITEM_WEIGHT + " FLOAT NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_ITEMS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}