package com.apps.nicholaspark.bluelineapp.data.db;

import android.provider.BaseColumns;

/**
 * Created by nicholaspark on 10/21/16.
 */

public final class DataPersistenceContract {

    private DataPersistenceContract(){}

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String[] COLUMNS = new String[]{
                _ID,
                COLUMN_NAME_NAME,
                COLUMN_NAME_EMAIL,
                COLUMN_NAME_PASSWORD
        };
        public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
                + _ID + " integer primary key,"
                + COLUMN_NAME_NAME + " text,"
                + COLUMN_NAME_EMAIL + " text)";
        public static final String DROP_TABLE = "DROP TABLE IF NOT EXISTS "+TABLE_NAME;
    }

    public static abstract class RepoEntry implements BaseColumns{
        public static final String TABLE_NAME = "repos";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_FULL_NAME = "full_name";
        public static final String COLUMN_NAME_PRIVATE = "private";
        public static final String COLUMN_NAME_HTML_URL = "html_url";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_URL = "url";
        public static final String[] COLUMNS = new String[]{
                _ID,
                COLUMN_NAME_NAME,
                COLUMN_NAME_FULL_NAME,
                COLUMN_NAME_PRIVATE,
                COLUMN_NAME_HTML_URL,
                COLUMN_NAME_DESCRIPTION,
                COLUMN_NAME_URL
        };
        public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
                + _ID + " integer primary key,"
                + COLUMN_NAME_NAME + " text,"
                + COLUMN_NAME_FULL_NAME + "full_name"
                + COLUMN_NAME_PRIVATE + " integer,"
                + COLUMN_NAME_HTML_URL + " text,"
                + COLUMN_NAME_DESCRIPTION + " text"
                + COLUMN_NAME_URL + " text)";
        public static final String DROP_TABLE = "DROP TABLE IF NOT EXISTS "+TABLE_NAME;
    }
}
