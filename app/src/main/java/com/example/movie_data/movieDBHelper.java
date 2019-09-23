package com.example.movie_data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.movie_data.*;

import androidx.annotation.Nullable;

public class movieDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "moviedetail.db";
    public static final int DATABASE_VERSION = 1;


    public movieDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public movieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       /* CREATE TABLE <TABLE_NAME> (<ID> INTEGER PRIMARY KEY AUTOINCREMENT, <COLUMN_NAME> TEXT NOT NULL, <COLUMN_NAME> TEXT NOT NULL, <COLUMN_TIMESTAMP> TIMESTAMP DEFAULT CURRENT_TIMESTAMP);*/

        final String SQL_CREATE_MOVIEDETAIL_TABLE = "CREATE TABLE " +
                MovieContract.MovieEntry.TABLE_NAME + " (" +
                MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MovieContract.MovieEntry.COLUMN_MOVIE_NAME + " TEXT NOT NULL, " +
                MovieContract.MovieEntry.COLUMN_MOVIE_LANGUAGE + " TEXT NOT NULL, " +
                MovieContract.MovieEntry.COLUMN_MOVIE_GENRE + " TEXT NOT NULL, " +
                MovieContract.MovieEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_MOVIEDETAIL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieContract.MovieEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
