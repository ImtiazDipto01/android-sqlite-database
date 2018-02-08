package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

/**
 * Created by Dipto on 2/7/2018.
 */

class CustomerListModel {

    private String customer_name = null;
    private String customer_address = null;
    private String customer_city = null ;
    private String customer_country = null ;

    public CustomerListModel(String customer_name, String customer_address, String customer_city,
                             String customer_country){

        this.customer_name = customer_name;
        this.customer_address = customer_address ;
        this.customer_city = customer_city ;
        this.customer_country = customer_country ;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_city() {
        return customer_city;
    }

    public void setCustomer_city(String customer_city) {
        this.customer_city = customer_city;
    }

    public String getCustomer_country() {
        return customer_country;
    }

    public void setCustomer_country(String customer_country) {
        this.customer_country = customer_country;
    }

}
