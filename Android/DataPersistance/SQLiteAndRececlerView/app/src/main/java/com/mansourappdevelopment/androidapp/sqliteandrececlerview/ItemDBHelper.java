package com.mansourappdevelopment.androidapp.sqliteandrececlerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_AMOUNT;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_NAME;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_TIMESTAMP;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.TABLE_NAME;

public class ItemDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "itemsList.db";
    public static final int DATABASE_VERSION = 1;

    public ItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_ITEMSLIST_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_ITEMSLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
