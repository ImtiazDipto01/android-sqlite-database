package com.example.dipto.sqlitedatabasepracticenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.dipto.sqlitedatabasepracticenew.InsertData.InsertDataActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insert_data)
    Button insertData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.insert_data)
    public void onInsetDataClicked() {
        Intent intent = new Intent(this, InsertDataActivity.class);
        startActivity(intent);
    }
}
