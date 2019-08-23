package com.example.adminapp.CarRemoveModel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

public class Remove_Car_Recycler_Adapter extends RecyclerView.ViewHolder {

   public TextView txtcarname, txtcarmodel;
   public ImageView removeCarimages;


    public Remove_Car_Recycler_Adapter(@NonNull View itemView) {
        super(itemView);

        txtcarname=itemView.findViewById(R.id.txtcarname);
        txtcarmodel=itemView.findViewById(R.id.txtcarmodel);
        removeCarimages=itemView.findViewById(R.id.removeCarimages);


    }
}


