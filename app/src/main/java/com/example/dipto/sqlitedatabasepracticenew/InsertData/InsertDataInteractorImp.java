package com.example.dipto.sqlitedatabasepracticenew.InsertData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.dipto.sqlitedatabasepracticenew.Utils.DatabaseHelper;

/**
 * Created by Dipto on 2/7/2018.
 */

public class InsertDataInteractorImp implements InsertDataInteractor{


    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public void insertData(Context context, String customer_name, String contact_name,
                           String address_str, String city_str, String postal_code,
                           String country_str, OnRequestListener requestListener) {

        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase() ;
        String msg = databaseHelper.addCustomerInfo(customer_name, contact_name, address_str, city_str,
                postal_code, country_str, sqLiteDatabase);
        databaseHelper.close();

        if(msg.equals("0")){
            requestListener.onFailure("failed to add a new row");
        }
        if(msg.equals("1")){
            requestListener.onSuccess("a new row added");
        }
    }

}
