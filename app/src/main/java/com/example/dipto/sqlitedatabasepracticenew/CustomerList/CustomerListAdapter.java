package com.example.dipto.sqlitedatabasepracticenew.CustomerList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dipto.sqlitedatabasepracticenew.R;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dipto on 2/7/2018.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerListViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private List<CustomerListModel> list = Collections.emptyList();

    public CustomerListAdapter(Context context, List<CustomerListModel> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_customer_list, parent, false);
        CustomerListViewHolder customerListViewHolder = new CustomerListViewHolder(view);
        return customerListViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomerListViewHolder holder, int position) {
        CustomerListModel customerListModel = list.get(position) ;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomerListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.customer_name_text)
        TextView customerNameText;
        @BindView(R.id.customer_address_text)
        TextView customerAddressText;
        @BindView(R.id.customer_city_text)
        TextView customerCityText;
        @BindView(R.id.customer_country_text)
        TextView customerCountryText;

        public CustomerListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView) ;
        }
    }
}
