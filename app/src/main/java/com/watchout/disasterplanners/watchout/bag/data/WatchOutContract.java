package com.watchout.disasterplanners.watchout.bag.data;
import android.net.Uri;
import android.content.ContentResolver;
import android.provider.BaseColumns;

public final class WatchOutContract {
    private WatchOutContract() {}
    public static final String CONTENT_AUTHORITY = "com.watchout.disasterplanners.watchout.bag";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
  public static final String PATH_WATCHOUT = "bag";

  public static final class ItemEntry implements BaseColumns {
      public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WATCHOUT);
      public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE+ "/" + CONTENT_AUTHORITY + "/" + PATH_WATCHOUT;
      public static final String CONTENT_ITEM_TYPE =
              ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WATCHOUT;
      public final static String TABLE_NAME = "items";
      public final static String _ID = BaseColumns._ID;
      public final static String COLUMN_ITEM_NAME = "item";
      public final static String COLUMN_ITEM_WEIGHT = "weight";
  }
}