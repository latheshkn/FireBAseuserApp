package com.example.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPageActivity extends AppCompatActivity {
    Firebase mref;
    EditText input_email, input_password;
    Button btn_Reg;
    FirebaseAuth maut;
    FirebaseAuth.AuthStateListener mAuthlisner;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mref = new Firebase("https://adminapp-c9ff1.firebaseio.com/Admin");
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        btn_Reg = findViewById(R.id.btn_Reg);

        toolbar = findViewById(R.id.toolloginpage);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        maut = FirebaseAuth.getInstance();


        btn_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memail = input_email.getText().toString();
                String mpassword = input_password.getText().toString();

                maut.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(LoginPageActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "createUserWithEmail:success");
//                    FirebaseUser user = maut.getCurrentUser();
//                    updateUI(user);
                            Toast.makeText(LoginPageActivity.this, "Registrtion Successfull", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(LoginPageActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
//                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginPageActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    updateUI(null);
                        }


                    }
                });
            }
        });


    }
}
