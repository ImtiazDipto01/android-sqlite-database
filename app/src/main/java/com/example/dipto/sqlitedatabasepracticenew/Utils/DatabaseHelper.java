package com.example.dipto.sqlitedatabasepracticenew.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Dipto on 1/25/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context ;
    private static String DATABASE_NAME = "customerinfo";
    private static int DATABASE_VERSION = 1;
    private static String create_customer_table =
            "CREATE TABLE "+ColumnName.CustomerInfo.TABLE_NAME+"("
                    +ColumnName.CustomerInfo.CUSTOMER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +ColumnName.CustomerInfo.CUSTOMER_NAME+" TEXT"
                    +ColumnName.CustomerInfo.CONTACT_NAME+" TEXT"
                    +ColumnName.CustomerInfo.ADDRESS+" TEXT"
                    +ColumnName.CustomerInfo.CITY+" TEXT"
                    +ColumnName.CustomerInfo.POSTAL_CODE+" TEXT"
                    +ColumnName.CustomerInfo.COUNTRY+" TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context ;
        Log.d("++++Database Create++++", "database created");
        Toast.makeText(context, "database created", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(create_customer_table);
            Log.d("++++TABLE Create++++", "customer table created !");
            Toast.makeText(context, "customer table created !", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e){
            Log.d("++++TABLE Create++++", String.valueOf(e));
            Toast.makeText(context, "customer table not created", Toast.LENGTH_SHORT).show();
        }
    }


    public String addCustomerInfo(String customer_name, String contact_name, String address,
                                String city, String postal_code, String country, SQLiteDatabase db){

        String msg = "" ;

        try {

            ContentValues contentValues = new ContentValues() ;
            contentValues.put(ColumnName.CustomerInfo.CUSTOMER_NAME, customer_name);
            contentValues.put(ColumnName.CustomerInfo.CONTACT_NAME, contact_name);
            contentValues.put(ColumnName.CustomerInfo.ADDRESS, address);
            contentValues.put(ColumnName.CustomerInfo.CITY, city);
            contentValues.put(ColumnName.CustomerInfo.POSTAL_CODE, postal_code);
            contentValues.put(ColumnName.CustomerInfo.COUNTRY, country);

            String[] nullColumnHack = {ColumnName.CustomerInfo.ADDRESS, ColumnName.CustomerInfo.CITY, ColumnName.CustomerInfo.POSTAL_CODE};

            db.insert(ColumnName.CustomerInfo.TABLE_NAME, String.valueOf(nullColumnHack), contentValues);
            Log.d("+++++CUSTOMER INFO++++", "a new row added");
            msg = "1" ;
            //Toast.makeText(context, "a new row added", Toast.LENGTH_SHORT).show();

        }

        catch (SQLiteException e){
            Log.d("++++SQLiteException++++", String.valueOf(e));
            //Toast.makeText(context, "failed to add a new row", Toast.LENGTH_SHORT).show();
            msg = "0" ;
        }
        return msg ;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
