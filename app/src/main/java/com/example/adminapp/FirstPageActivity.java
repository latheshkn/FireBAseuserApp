package com.example.adminapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirstPageActivity extends AppCompatActivity {
    Firebase mref;
    EditText input_email, input_password;
    Button btn_login;
    FirebaseAuth maut;
    FirebaseAuth.AuthStateListener mAuthlisner;
    Toolbar toolbar;
    TextView link_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        mref = new Firebase("https://adminapp-c9ff1.firebaseio.com/");
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        btn_login = findViewById(R.id.btn_login);
        link_signup = findViewById(R.id.link_signup);

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstPageActivity.this,LoginPageActivity.class);
                startActivity(intent);
            }
        });


        toolbar = findViewById(R.id.toolbarfrontpage);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        maut = FirebaseAuth.getInstance();

        mAuthlisner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(FirstPageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                STARTSIGNIN();


            }
        });

    }

    private void STARTSIGNIN(){

        String Aname=input_email.getText().toString();
        String Apassword=input_password.getText().toString();

        if (TextUtils.isEmpty(Aname) || TextUtils.isEmpty(Apassword)) {

            Toast.makeText(FirstPageActivity.this, "Fields are empty ", Toast.LENGTH_SHORT).show();

        }
        else {
            maut.signInWithEmailAndPassword(Aname,Apassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()){
                        Toast.makeText(FirstPageActivity.this, "SignIn Problem", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        maut.addAuthStateListener(mAuthlisner);
    }



    }

