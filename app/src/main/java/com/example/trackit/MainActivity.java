package com.example.trackit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentuser;
    public void init(){


        mAuth= FirebaseAuth.getInstance();
        currentuser=mAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onStart() {

        if(currentuser==null){

            Intent welcomeIntent=new Intent(MainActivity.this,Registerr.class);
            startActivity(welcomeIntent);
            finish();
        }
        super.onStart();
    }
}
