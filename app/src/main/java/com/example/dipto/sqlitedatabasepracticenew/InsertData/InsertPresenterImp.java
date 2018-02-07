package com.example.dipto.sqlitedatabasepracticenew.InsertData;

/**
 * Created by Dipto on 2/7/2018.
 */

public class InsertPresenterImp implements InsertPresenter, InsertDataInteractor.OnRequestListener {

    InsertDataView view ;
    InsertDataInteractor insertDataInteractor ;

    public InsertPresenterImp(InsertDataView insertDataView, InsertDataInteractorImp interactorImp){
        this.view = insertDataView ;
        this.insertDataInteractor = interactorImp ;
    }

    @Override
    public void callInsertData(String customer_name, String contact_name, String address_str, String city_str, String postal_code, String country_str) {

        if(view != null){
            view.startLoading();
        }
        insertDataInteractor.insertData(view.getAppContext(), customer_name, contact_name, address_str, city_str,
                postal_code, country_str, this);
    }

    @Override
    public void onDestroy() {
        view = null ;
    }

    @Override
    public void onSuccess(String msg) {
        view.showMessage(msg);
    }

    @Override
    public void onFailure(String msg) {
        view.showMessage(msg);
    }
}
