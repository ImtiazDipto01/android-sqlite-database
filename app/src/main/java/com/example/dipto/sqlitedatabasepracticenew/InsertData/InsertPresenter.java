package com.example.dipto.sqlitedatabasepracticenew.InsertData;

/**
 * Created by Dipto on 2/7/2018.
 */

public interface InsertPresenter {

    public void callInsertData(String customer_name, String contact_name,
                               String address_str, String city_str, String postal_code,
                               String country_str);

    public void onDestroy();
}
