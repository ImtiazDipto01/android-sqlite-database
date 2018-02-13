package com.example.dipto.sqlitedatabasepracticenew.SearchData;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dipto.sqlitedatabasepracticenew.R;
import com.example.dipto.sqlitedatabasepracticenew.Utils.DatabaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchDataActivity extends AppCompatActivity {

    @BindView(R.id.search_name)
    EditText searchName;
    @BindView(R.id.search_btn)
    Button searchBtn;
    @BindView(R.id.customer_name)
    TextView customerName;
    @BindView(R.id.customer_country)
    TextView customerCountry;

    DatabaseHelper databaseHelper ;
    SQLiteDatabase sqLiteDatabase ;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.search_btn)
    public void onViewClicked() {
        String name = searchName.getText().toString() ;

        databaseHelper = new DatabaseHelper(getApplicationContext()) ;
        sqLiteDatabase = databaseHelper.getReadableDatabase() ;
        cursor = databaseHelper.getTestSearch(name, sqLiteDatabase) ;

        if(cursor != null){
            Log.d("+++++CUSRSOR_NULL++++", "cursor not null") ;
            cursor.moveToNext() ;
            customerName.setText(cursor.getString(0));
            //customerCountry.setText(cursor.getString(1));
        }
    }
}
