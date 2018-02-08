package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import java.util.List;

/**
 * Created by Dipto on 2/8/2018.
 */

public class CustomerListPresenterImp implements CustomerListPresenter, CustomerListInteractor.OnRequestListener{

    CustomerListView view ;
    CustomerListInteractor customerListInteractor ;

    public CustomerListPresenterImp(CustomerListView customerListView, CustomerListInteractorImp interactorImp){
        this.view = customerListView ;
        this.customerListInteractor = interactorImp ;
    }

    @Override
    public void callCustomerList() {
        if(view != null){
            view.startLoading();
        }
        customerListInteractor.getCustomerList(view.getAppContext(), this);
    }

    @Override
    public void onDestroy() {
        view = null ;
    }

    @Override
    public void onSuccess(List<CustomerListModel> list) {
        view.getCustomerList(list);
    }

    @Override
    public void onFailure(String msg) {
        view.showMessage(msg);
    }
}
