package com.example.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.CarviewModelfirebase.Blog;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ViewCarActivity extends AppCompatActivity {
    private Blog carviewModel;
    private DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Blog, Car_On_Road_Recyclerview_Adapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Blog> options;
    RecyclerView recyclerView;
    Toolbar toolcarviewpage;


   LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);

        recyclerView=findViewById(R.id.recyclercarview);
        toolcarviewpage=findViewById(R.id.toolcarviewpage);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       setSupportActionBar(toolcarviewpage);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String Id=user.getUid();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Admin");
        databaseReference.keepSynced(true);

       options= new FirebaseRecyclerOptions.Builder<Blog>().setQuery(databaseReference,Blog.class).build();


       firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Blog, Car_On_Road_Recyclerview_Adapter>(options) {

           @Override
           protected void onBindViewHolder(@NonNull Car_On_Road_Recyclerview_Adapter car_on_road_recyclerview_adapter, int i, @NonNull Blog blog) {

               String getkey=getRef(i).getKey();
               car_on_road_recyclerview_adapter.txtviewcarname.setText(String.valueOf(blog.getName()));
               car_on_road_recyclerview_adapter.txtviewcarmodel.setText(String.valueOf(blog.getAge()));

               Picasso.with(car_on_road_recyclerview_adapter.Carviewimages.getContext()).load(blog.getImage())
                       .into(car_on_road_recyclerview_adapter.Carviewimages);

               Toast.makeText(ViewCarActivity.this, getkey, Toast.LENGTH_SHORT).show();


//               car_on_road_recyclerview_adapter.itemView.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//
//                       Intent intent=new Intent(ViewCarActivity.this,AddcarActivity.class);
//                       startActivity(intent);
//                   }
//               });


           }




           @NonNull
           @Override
           public Car_On_Road_Recyclerview_Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

               View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_recycler_item,parent,false);

               return new Car_On_Road_Recyclerview_Adapter(view);
           }
       };
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);



    }



    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseRecyclerAdapter!=null){

            firebaseRecyclerAdapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.stopListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (firebaseRecyclerAdapter!=null){

            firebaseRecyclerAdapter.startListening();
        }
    }
}
