package com.example.adminapp;

import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;


    public  class Car_On_Road_Recyclerview_Adapter extends RecyclerView.ViewHolder {
        TextView txtviewcarname, txtviewcarmodel;
        ImageView Carviewimages;


        public Car_On_Road_Recyclerview_Adapter(@NonNull View itemView) {
            super(itemView);

            txtviewcarname=itemView.findViewById(R.id.txtviewcarname);
            txtviewcarmodel=itemView.findViewById(R.id.txtviewcarmodel);
            Carviewimages=itemView.findViewById(R.id.Carviewimages);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
