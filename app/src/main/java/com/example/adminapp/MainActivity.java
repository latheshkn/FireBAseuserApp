package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

 LinearLayout linearaddcar,linearremovecar,linearviewcar,linearhistory,linearremarks;
 Toolbar toolmainpage;
 TextView txtadminname;

 Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearaddcar=findViewById(R.id.linearaddcar);
        linearremovecar=findViewById(R.id.linearremovecar);
        linearviewcar=findViewById(R.id.linearviewcar);
        linearhistory=findViewById(R.id.linearhistory);
      toolmainpage=findViewById(R.id.toolmainpage);

        txtadminname=findViewById(R.id.txtadminname);
        logout=findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                Intent intent =new Intent(MainActivity.this,FirstPageActivity.class);
                startActivity(intent);
                finish();

            }
        });

        setSupportActionBar(toolmainpage);

        toolmainpage.setTitle("Menu");

        linearremarks=findViewById(R.id.linearremarks);

        linearaddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddcarActivity.class);
                startActivity(intent);


            }
        });


        linearremovecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RemoveCarActivity.class);
                startActivity(intent);
            }
        });

        linearviewcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ViewCarActivity.class);
                startActivity(intent);
            }
        });
        linearhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, VehicleHistoryActivity.class);
                startActivity(intent);
            }
        });
        linearremarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CustomerReviewActivity.class);

                startActivity(intent);
            }
        });

        showname();

    }

    public  void showname(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

       String admin=user.getEmail();

        txtadminname.setText(admin);
    }


}
