package com.apps.nicholaspark.bluelineapp.data.db;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by nicholaspark on 10/21/16.
 */

public class DbHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "bellaccounts.db";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataPersistenceContract.UserEntry.CREATE_TABLE);
        db.execSQL(DataPersistenceContract.RepoEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DataPersistenceContract.UserEntry.DROP_TABLE);
        db.execSQL(DataPersistenceContract.RepoEntry.DROP_TABLE);
        onCreate(db);
    }
}
