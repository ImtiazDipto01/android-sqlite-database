package com.example.dipto.sqlitedatabasepracticenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dipto.sqlitedatabasepracticenew.CustomerList.CustomerListActivity;
import com.example.dipto.sqlitedatabasepracticenew.InsertData.InsertDataActivity;
import com.example.dipto.sqlitedatabasepracticenew.SearchData.SearchDataActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insert_data)
    Button insertData;
    @BindView(R.id.show_customer_info)
    Button showCustomerInfo;
    @BindView(R.id.search_customer)
    Button searchCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.insert_data, R.id.show_customer_info, R.id.search_customer})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.insert_data: {
                Intent intent = new Intent(this, InsertDataActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.show_customer_info: {
                Intent intent = new Intent(this, CustomerListActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.search_customer: {
                Intent intent = new Intent(this, SearchDataActivity.class);
                startActivity(intent);
                break;
            }

        }
    }
}
