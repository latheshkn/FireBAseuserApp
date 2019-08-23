package com.example.adminapp.CarviewModelfirebase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;


public  class Car_On_Road_Recyclerview_Adapter extends RecyclerView.ViewHolder {
    TextView txtviewcarname, txtviewcarmodel;
    ImageView Carviewimages;


    public Car_On_Road_Recyclerview_Adapter(@NonNull View itemView) {
        super(itemView);

        txtviewcarname=itemView.findViewById(R.id.txtviewcarname);
        txtviewcarmodel=itemView.findViewById(R.id.txtviewcarmodel);
        Carviewimages=itemView.findViewById(R.id.Carviewimages);


    }
}
