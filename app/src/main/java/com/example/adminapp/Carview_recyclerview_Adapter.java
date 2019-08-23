package com.example.adminapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.CarviewModelfirebase.Blog;

import java.util.List;

public class Carview_recyclerview_Adapter extends RecyclerView.Adapter<Carview_recyclerview_Adapter.Vhadapter> {
List<Blog> list;

    public Carview_recyclerview_Adapter(List<Blog> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Vhadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_recycler_item,parent,false);

        return  new Vhadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vhadapter holder, int position) {

//        holder.txtcarname.setText(list.get(position).getCar_name());
//        holder.txtcarmodel.setText(list.get(position).getCar_model());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vhadapter extends RecyclerView.ViewHolder{
        TextView txtcarname,txtcarmodel;
        public Vhadapter(@NonNull View itemView) {
            super(itemView);

            txtcarmodel=itemView.findViewById(R.id.txtcarmodel);
            txtcarname=itemView.findViewById(R.id.txtcarname);

        }
    }
}
