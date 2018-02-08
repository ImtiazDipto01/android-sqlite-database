package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import android.content.Context;

import java.util.List;

/**
 * Created by Dipto on 2/8/2018.
 */

public interface CustomerListView {

    public void getCustomerList(List<CustomerListModel> list) ;

    public void startLoading() ;

    public void stopLoading() ;

    public void showMessage(String msg) ;

    Context getAppContext() ;
}
