package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class CustomerReviewActivity extends AppCompatActivity {
Toolbar toolreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_review_);
        toolreview=findViewById(R.id.toolreview);

        setSupportActionBar(toolreview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
