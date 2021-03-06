package com.example.study.wk10cc2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by study on 28/11/17.
 */

public class SpendingDbHelper extends SQLiteOpenHelper {


    private final Context context;
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    SpendingDbHelper(Context context) {
        super(context, SpendingContract.SpendingEntry.TABLE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

//TODO 2.1 Build the SQLite command string to create the table
        final String SQL_CREATE_TABLE = "CREATE TABLE "
                + SpendingContract.SpendingEntry.TABLE_NAME
                + "("
                + SpendingContract.SpendingEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SpendingContract.SpendingEntry.COL_AMOUNT + " TEXT NOT NULL, "
                + SpendingContract.SpendingEntry.COL_REMARKS + " TEXT NOT NULL"
                + ");";

//Execute the SQL command
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS "
                + SpendingContract.SpendingEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
//TO DO 2.2 Build the SQLite command string to delete the table
//TO DO 2.3 execute this SQLite command
//TO DO 2.4 Create the table

    }
}
