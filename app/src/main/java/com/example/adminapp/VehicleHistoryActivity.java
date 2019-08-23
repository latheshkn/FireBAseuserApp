package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class VehicleHistoryActivity extends AppCompatActivity {
    RecyclerView mrecyclerView;
    LinearLayoutManager mlayoutManager;
    Toolbar toovehiclehistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_history);
        toovehiclehistory=findViewById(R.id.toovehiclehistory);

        setSupportActionBar(toovehiclehistory);

      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mlayoutManager=  new LinearLayoutManager(this);

//        mrecyclerView.setLayoutManager(mlayoutManager);


    }
}
