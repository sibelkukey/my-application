package com.example.trackit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profil extends AppCompatActivity {

    Button add;
    ImageView photo;
    ImageView photo2;
    ImageView photo3;
    TextView type;
    EditText explain;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference oku =FirebaseDatabase.getInstance().getReference().child("").child("");



    public void init(){

        add=findViewById(R.id.ADD);
        explain=findViewById(R.id.editText6);
        type = findViewById(R.id.textView9);
        photo=findViewById(R.id.photo1);
        photo2=findViewById(R.id.photo2);
        photo3=findViewById(R.id.photo3);


    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValueEventListener dinle=new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        select_type k = new   select_type();
                        k=dataSnapshot.getValue(select_type.class);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }  ;
                oku.addValueEventListener(dinle);




                Intent kayıt = new Intent(profil.this, ana_akiş.class);
                startActivity(kayıt);
                finish();
            }
        });


    }

}


