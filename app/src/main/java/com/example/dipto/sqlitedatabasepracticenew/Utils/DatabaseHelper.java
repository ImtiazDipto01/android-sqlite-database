package com.example.dipto.sqlitedatabasepracticenew.Utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dipto on 1/25/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "customerinfo";
    private static int DATABASE_VERSION = 1;
    private static String create_customer_table =
            "CREATE TABLE "+ColumnName.CustomerInfo.TABLE_NAME+"("
                    +ColumnName.CustomerInfo.CUSTOMER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +ColumnName.CustomerInfo.CUSTOMER_NAME+" TEXT"
                    +ColumnName.CustomerInfo.CONTACT_NAME+" TEXT"
                    +ColumnName.CustomerInfo.CITY+" TEXT"
                    +ColumnName.CustomerInfo.POSTAL_CODE+" TEXT"
                    +ColumnName.CustomerInfo.COUNTRY+" TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("++++Database Create++++", "database created");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_customer_table);
        Log.d("++++TABLE Create++++", "customer table created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
