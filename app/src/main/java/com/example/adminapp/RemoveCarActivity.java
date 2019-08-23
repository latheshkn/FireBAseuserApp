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
import android.widget.Toast;

import com.example.adminapp.CarRemoveModel.CarRemove;
import com.example.adminapp.CarRemoveModel.Remove_Car_Recycler_Adapter;
import com.example.adminapp.CarviewModelfirebase.Blog;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class RemoveCarActivity extends AppCompatActivity {

    private  CarRemove carRemove;
    private  DatabaseReference reference;
    FirebaseRecyclerAdapter<CarRemove,Remove_Car_Recycler_Adapter> adapter;
    FirebaseRecyclerOptions<CarRemove> option;
    RecyclerView carrecyclerView;
    Toolbar toolcarviewpage;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_car);

        carrecyclerView=findViewById(R.id.removerecycler);
        toolcarviewpage=findViewById(R.id.toolremove);
        carrecyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        carrecyclerView.setLayoutManager(layoutManager);

        setSupportActionBar(toolcarviewpage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolcarviewpage.setTitle("Remove Vehicle");
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String Id=user.getUid();
        reference=FirebaseDatabase.getInstance().getReference().child("Admin");
        reference.keepSynced(true);

        option= new FirebaseRecyclerOptions.Builder<CarRemove>().setQuery(reference,CarRemove.class).build();


        adapter =new FirebaseRecyclerAdapter<CarRemove, Remove_Car_Recycler_Adapter>(option) {

            @Override
            protected void onBindViewHolder(@NonNull Remove_Car_Recycler_Adapter remove_car_recycler_adapter, final int i, @NonNull CarRemove carRemove) {

                final String getkey=getRef(i).getKey();
                remove_car_recycler_adapter.txtcarname.setText(String.valueOf(carRemove.getName()));
                remove_car_recycler_adapter.txtcarmodel.setText(String.valueOf(carRemove.getModel()));
                Picasso.with(remove_car_recycler_adapter.removeCarimages.getContext()).load(carRemove.getImage())
                        .into(remove_car_recycler_adapter.removeCarimages);

//                Toast.makeText(RemoveCarActivity.this, carRemove.getImage(), Toast.LENGTH_SHORT).show();

                remove_car_recycler_adapter.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                            Intent intent = new Intent(RemoveCarActivity.this, AddcarActivity.class);
                            intent.putExtra("key",getkey);
                            startActivity(intent);

                        Toast.makeText(RemoveCarActivity.this, getkey, Toast.LENGTH_SHORT).show();
                    }
                });

            }






            @NonNull
            @Override
            public Remove_Car_Recycler_Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.remove_car_recyclerview_item,parent,false);

                return new Remove_Car_Recycler_Adapter(view);
            }
        };
        layoutManager=new LinearLayoutManager(this);
        carrecyclerView.setLayoutManager(layoutManager);
        adapter.startListening();
        carrecyclerView.setAdapter(adapter);



    }



    @Override
    protected void onStart() {
        super.onStart();
        if (adapter!=null){

            adapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter!=null){
            adapter.stopListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (adapter!=null){

            adapter.startListening();
        }
    }

    }


