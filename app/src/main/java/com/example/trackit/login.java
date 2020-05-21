package com.example.trackit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private EditText txtusername,txtemail,txtpassword;
    private Button signup,login;
    private FirebaseAuth mAuth;
    private FirebaseUser currentuser;

    public void init(){

       txtemail=(EditText)findViewById(R.id.edtmail);
       txtusername=(EditText)findViewById(R.id.edusername);
       txtpassword=(EditText)findViewById(R.id.edpassword);
       signup=(Button) findViewById(R.id.btn15);
       login=(Button)findViewById(R.id.button26);
       mAuth=FirebaseAuth.getInstance();
       currentuser=mAuth.getCurrentUser();




    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayıt=new Intent(login.this,Registerr.class);
                startActivity(kayıt);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();



            }
        });

        }

    private void loginuser() {
        String email= txtemail.getText().toString();
        String password=txtemail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "E-mail Alanı Boş Olamaz !", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Şifre Alanı Boş Olamaz !", Toast.LENGTH_LONG).show();
            } else {
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                          Toast.makeText(login.this,"Giriş başarılı",Toast.LENGTH_LONG).show();
                          Intent mainIntent = new Intent(login.this,ana_akiş.class);
                          startActivity(mainIntent);
                          finish();

                        }else{
                            Toast.makeText(login.this,"Giriş başarısız",Toast.LENGTH_LONG).show();



                        }

                    }
                });
            }


            }


        }
    }