package com.example.dipto.sqlitedatabasepracticenew.InsertData;

import android.content.Context;

/**
 * Created by Dipto on 2/7/2018.
 */

public interface InsertDataInteractor {

    interface OnRequestListener{

        public void onSuccess(String msg) ;
        public void onFailure(String msg) ;
    }

    public void insertData(final Context context, String customer_name, String contact_name,
                           String address_str, String city_str, String postal_code,
                           String country_str, OnRequestListener requestListener) ;

}
