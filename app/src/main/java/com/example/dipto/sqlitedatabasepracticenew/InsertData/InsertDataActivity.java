package com.example.dipto.sqlitedatabasepracticenew.InsertData;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dipto.sqlitedatabasepracticenew.R;
import com.example.dipto.sqlitedatabasepracticenew.Utils.DatabaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsertDataActivity extends AppCompatActivity {

    @BindView(R.id.customer_name)
    EditText customerName;
    @BindView(R.id.contact_name)
    EditText contactName;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.city)
    EditText city;
    @BindView(R.id.postal_code)
    EditText postalCode;
    @BindView(R.id.country)
    EditText country;
    @BindView(R.id.btn_insert)
    Button btnInsert;

    private String customer_name = "";
    private String contact_name = "";
    private String city_str = "";
    private String address_str = "";
    private String country_str = "";
    private String postal_code = "";
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_insert)
    public void onbtnInsertClicked() {
        customer_name = customerName.getText().toString() ;
        contact_name = contactName.getText().toString() ;
        address_str = address.getText().toString() ;
        country_str = country.getText().toString() ;
        postal_code = postalCode.getText().toString() ;
        city_str = city.getText().toString() ;

        if(customer_name.equals("") || contact_name.equals("") || country_str.equals("")){
            Toast.makeText(this, "Customer name, Contact name, Country can not be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            databaseHelper = new DatabaseHelper(this);
            sqLiteDatabase = databaseHelper.getWritableDatabase() ;
            databaseHelper.addCustomerInfo(customer_name, contact_name, address_str, city_str,
                    postal_code, country_str, sqLiteDatabase);
            databaseHelper.close();
        }

    }
}
