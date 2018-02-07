package com.example.dipto.sqlitedatabasepracticenew.InsertData;

import android.content.Context;

/**
 * Created by Dipto on 2/7/2018.
 */

public interface InsertDataView {

    public void startLoading() ;

    public void stopLoading() ;

    public void showMessage(String msg) ;

    Context getAppContext() ;
}
