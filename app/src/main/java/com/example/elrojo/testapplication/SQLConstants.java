package com.example.elrojo.testapplication;

public class SQLConstants {

    public static  final String DB_NAME = "usersdb.db";

    public static final String tableUsers = "users";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_EMAIL = "email";

    public static final String SQL_CREATE_TABLE_USERS =
            "CREATE TABLE " + tableUsers + " (" +
            COLUMN_ID + " TEXT PRIMARY_KEY, " +
            COLUMN_NAME + " TEXT, " +
            COLUMN_AGE + " INT, " +
            COLUMN_EMAIL + " TEXT " + ");";

    public static final String SEARCH_BY_ID ="id=?";

    public static final String SQL_DELETE =
            "DROP TABLE " + tableUsers;

    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_AGE, COLUMN_EMAIL};

}
