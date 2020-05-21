package com.example.trackit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class select_type extends AppCompatActivity {
    Button selectImageBtn;

    ImageView imageView1,imageView2,imageView3;
    static final int SELECT_IMAGE=12;
    Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectImageBtn=findViewById(R.id.gallery);
        imageView1=findViewById(R.id.photo1);
        imageView2=findViewById(R.id.photo2);
        imageView3=findViewById(R.id.photo3);
        selectImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,SELECT_IMAGE);
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==SELECT_IMAGE&& resultCode==RESULT_OK){
           imageUri= data.getData();
           imageView1.setImageURI(imageUri);
           imageView2.setImageURI(imageUri);
           imageView3.setImageURI(imageUri);


        }else if (resultCode==RESULT_CANCELED){

            Toast.makeText(this,"Resim seçme iptal edildi",Toast.LENGTH_LONG).show();
        }
    }

}
