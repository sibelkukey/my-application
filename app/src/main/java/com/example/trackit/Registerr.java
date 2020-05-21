package com.example.trackit;

import androidx.annotation.NonNull;
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

public class Registerr extends AppCompatActivity {
    private EditText txtusername,txtemail,txtpassword;
    private Button btnsignup;
    private FirebaseAuth mAuth;

    public void init(){
        txtusername=(EditText)findViewById(R.id.edusername);
        txtemail=(EditText)findViewById(R.id.editemail);
        txtpassword=(EditText)findViewById(R.id.editpassword);
        btnsignup=(Button) findViewById(R.id.singup);
        mAuth = FirebaseAuth.getInstance();





    }

    private void createNewAccount() {
        String username = txtusername.getText().toString();
        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "E-mail Alanı Boş Olamaz !", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Şifre Alanı Boş Olamaz !", Toast.LENGTH_LONG).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {


                    if (task.isSuccessful()) {
                        Toast.makeText(Registerr.this, "Hesabınız başarıyla oluşturuldu", Toast.LENGTH_LONG).show();
                        Intent loginIntent = new Intent(Registerr.this,ana_akiş.class);
                        startActivity(loginIntent);
                        finish();

                    } else {
                        Toast.makeText(Registerr.this, "Hesabınız oluşturulamadı", Toast.LENGTH_LONG).show();
                    }


                }


            });
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();

            }
        });

    }
}
