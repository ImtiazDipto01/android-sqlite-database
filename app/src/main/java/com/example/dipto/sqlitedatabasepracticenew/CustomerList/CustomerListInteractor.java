package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import android.content.Context;

import java.util.List;

/**
 * Created by Dipto on 2/8/2018.
 */

public interface CustomerListInteractor {

    interface OnRequestListener{
        public void onSuccess(List<CustomerListModel> list) ;
        public void onFailure(String msg) ;
    }

    public void getCustomerList(Context context, OnRequestListener onRequestListener);
}
