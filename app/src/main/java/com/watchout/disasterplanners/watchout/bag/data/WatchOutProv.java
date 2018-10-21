package com.watchout.disasterplanners.watchout.bag.data;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;



public class WatchOutProv extends ContentProvider {
    public static final String LOG_TAG = WatchOutProv.class.getSimpleName();
    private static final int ITEMS = 100;
    private static final int ITEM_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(WatchOutContract.CONTENT_AUTHORITY, WatchOutContract.PATH_WATCHOUT, ITEMS);
        sUriMatcher.addURI(WatchOutContract.CONTENT_AUTHORITY, WatchOutContract.PATH_WATCHOUT + "/#", ITEM_ID);
    }
        private WatchOutDbHelper mDbHelper;
        @Override
        public boolean onCreate() {
            mDbHelper = new WatchOutDbHelper(getContext());
            return true;
        }
        @Override
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                            String sortOrder){
            SQLiteDatabase database = mDbHelper.getReadableDatabase();
            Cursor cursor;
            int match = sUriMatcher.match(uri);
            switch (match){
                case ITEMS:
                    cursor = database.query(WatchOutContract.ItemEntry.TABLE_NAME, projection,selection,selectionArgs,null,null,sortOrder);
                    break;
                case ITEM_ID:
                    selection= WatchOutContract.ItemEntry._ID +"=?";
                    selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                    cursor = database.query(WatchOutContract.ItemEntry.TABLE_NAME, projection,selection,selectionArgs,null,null,sortOrder);
                    break;
                    default:
                        throw new IllegalArgumentException("Cannot query unknown URI" + uri);
            }
            cursor.setNotificationUri(getContext().getContentResolver(),uri);
            return cursor;
        }
        @Override
    public Uri insert(Uri uri, ContentValues contentValues){
            final int match = sUriMatcher.match(uri);
            switch (match){
                case ITEMS:
                    return insertItem(uri, contentValues);
                    default:
                        throw new IllegalArgumentException("Insertion is not supported for" + uri);
            }
        }
        private Uri insertItem(Uri uri, ContentValues values){
            String name = values.getAsString(WatchOutContract.ItemEntry.COLUMN_ITEM_NAME);
            if (name == null){
                throw new IllegalArgumentException("Item requires a name");
            }
            float weight = values.getAsFloat(WatchOutContract.ItemEntry.COLUMN_ITEM_WEIGHT);
            if (weight < 0){
                throw new IllegalArgumentException("Item requires valid weight");
            }
       SQLiteDatabase database = mDbHelper.getWritableDatabase();
            long id = database.insert(WatchOutContract.ItemEntry.TABLE_NAME,null,values);
            if (id == -1){
                Log.e(LOG_TAG,"Failed to insert row for" + uri);
                return null;
            }
            getContext().getContentResolver().notifyChange(uri,null);
            return ContentUris.withAppendedId(uri, id);
        }
        @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[] selectionArgs){
            final int match = sUriMatcher.match(uri);
            switch (match){
                case ITEMS:
                    return updateItem(uri, contentValues, selection, selectionArgs);
                case ITEM_ID:
                    selection = WatchOutContract.ItemEntry._ID + "=?";
                    selectionArgs = new String[] {
                            String.valueOf((ContentUris.parseId(uri)))};
                    return updateItem(uri, contentValues, selection,selectionArgs);
                    default:
                        throw new IllegalArgumentException("Update is not supported for" + uri);

                    }
            }
            private int updateItem(Uri uri, ContentValues values, String selection, String[] selectionArgs){
            if (values.containsKey(WatchOutContract.ItemEntry.COLUMN_ITEM_NAME)){
                String name = values.getAsString(WatchOutContract.ItemEntry.COLUMN_ITEM_NAME);
                if (name == null){
                    throw new IllegalArgumentException("Item requires a name");
                }
            }
            if (values.containsKey(WatchOutContract.ItemEntry.COLUMN_ITEM_WEIGHT)){
                float weight = values.getAsFloat(WatchOutContract.ItemEntry.COLUMN_ITEM_WEIGHT);
                if (weight<0){
                    throw new IllegalArgumentException("Item requires valid weight");
                }
            }
            if (values.size()==0){
                return 0;
            }
            SQLiteDatabase database = mDbHelper.getWritableDatabase();
                int rowsUpdated = database.update(WatchOutContract.ItemEntry.TABLE_NAME, values, selection, selectionArgs);
                if (rowsUpdated != 0) {
                    getContext().getContentResolver().notifyChange(uri, null);
                }

                // Return the number of rows updated
                return rowsUpdated;
            }
            @Override
    public int delete(Uri uri, String selection, String[] selectionArgs){
            SQLiteDatabase database = mDbHelper.getWritableDatabase();
            int rowsDeleted;
            final int match = sUriMatcher.match(uri);
            switch (match){
                case ITEMS:
                    rowsDeleted = database.delete(WatchOutContract.ItemEntry.TABLE_NAME, selection, selectionArgs);
                    break;
                case ITEM_ID:
                    selection = WatchOutContract.ItemEntry._ID + "=?";
                    selectionArgs = new String[]{
                            String.valueOf(ContentUris.parseId(uri))
                    };
                    rowsDeleted = database.delete(WatchOutContract.ItemEntry.TABLE_NAME, selection, selectionArgs);
                    break;
                    default: throw new IllegalArgumentException("Deletion is not supported for" + uri);
            }
            if (rowsDeleted != 0){
                getContext().getContentResolver().notifyChange(uri, null);
            }
            return rowsDeleted;
            }
            @Override
    public String getType(Uri uri){
            final int match = sUriMatcher.match(uri);
            switch (match){
                case ITEMS:
                    return WatchOutContract.ItemEntry.CONTENT_LIST_TYPE;
                case ITEM_ID:
                    return WatchOutContract.ItemEntry.CONTENT_ITEM_TYPE;
                    default:
                        throw new IllegalArgumentException("Unknown URI" + uri + "with match" + match);
            }
        }

    }