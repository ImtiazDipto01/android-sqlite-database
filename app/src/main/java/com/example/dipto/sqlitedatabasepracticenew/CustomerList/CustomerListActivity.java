package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.dipto.sqlitedatabasepracticenew.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerListActivity extends AppCompatActivity implements CustomerListView {

    @BindView(R.id.customer_list)
    RecyclerView customerList;

    LinearLayoutManager layoutManager ;
    CustomerListAdapter customerListAdapter ;
    CustomerListPresenter presenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.bind(this);
        initRecycler();
        presenter = new CustomerListPresenterImp(this, new CustomerListInteractorImp());
        presenter.callCustomerList();
    }

    @Override
    public void getCustomerList(List<CustomerListModel> list) {
        if(!list.isEmpty()){
            Log.d("++++LIST++++", "not empty") ;
            customerListAdapter = new CustomerListAdapter(getAppContext(), list) ;
            customerList.setAdapter(customerListAdapter);
        }
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    private void initRecycler(){
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        customerList.setLayoutManager(layoutManager);
    }
}
