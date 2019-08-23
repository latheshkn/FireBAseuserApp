package com.example.adminapp;

import android.app.Application;

import com.firebase.client.Firebase;

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
