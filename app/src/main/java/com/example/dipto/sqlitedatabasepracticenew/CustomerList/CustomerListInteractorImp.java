package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dipto.sqlitedatabasepracticenew.Utils.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipto on 2/8/2018.
 */

public class CustomerListInteractorImp implements CustomerListInteractor {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;
    private CustomerListModel customerListModel;
    private List<CustomerListModel> list ;

    @Override
    public void getCustomerList(Context context, OnRequestListener onRequestListener) {

        list = new ArrayList<>() ;
        databaseHelper = new DatabaseHelper(context) ;
        sqLiteDatabase = databaseHelper.getReadableDatabase() ;
        cursor = databaseHelper.getCustomerList(sqLiteDatabase) ;

        if(cursor != null){
            while(cursor.moveToNext()){
                String name = cursor.getString(0) ;
                String address = cursor.getString(1) ;
                String city = cursor.getString(2);
                String country = cursor.getString(3);
                customerListModel = new CustomerListModel(name, address, city, country);
                list.add(customerListModel);
            }
            onRequestListener.onSuccess(list);
        }
        else{
            onRequestListener.onFailure("No Customer Available !");
        }
    }
}
