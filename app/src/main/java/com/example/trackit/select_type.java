package com.example.trackit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class select_type extends AppCompatActivity {

    Button selectImageBtn;
    Button report;
    ImageView imageView1,imageView2,imageView3;
    static final int SELECT_IMAGE=12;
    Uri imageUri;
    RadioButton murder,accident,robbery,others;
    EditText explain2;
    FirebaseDatabase database;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectImageBtn=findViewById(R.id.gallery);
        imageView1=findViewById(R.id.photo1);
        imageView2=findViewById(R.id.photo2);
        imageView3=findViewById(R.id.photo3);
        murder=findViewById(R.id.radioButton1);
        accident=findViewById(R.id.radioButton2);
        robbery=findViewById(R.id.radioButton3);
        others=findViewById(R.id.radioButton4);
        explain2=findViewById(R.id.editText7);
        report=findViewById(R.id.ADD);
        database = FirebaseDatabase.getInstance();




        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference dbRef= database.getReference("explain");
                String key =dbRef.push().getKey();
                DatabaseReference dbRefyeni=database.getReference("explain/"+key);
                dbRefyeni.setValue(explain2);

                DatabaseReference dbRef2= database.getReference("picture");
                String key1 =dbRef.push().getKey();
                DatabaseReference dbRefyeni2=database.getReference("picture/"+key);
                dbRefyeni.setValue(imageView1,imageView2, (DatabaseReference.CompletionListener) imageView3);

                DatabaseReference dbRef3= database.getReference("select");
                String key3 =dbRef.push().getKey();
                DatabaseReference dbRefyeni3=database.getReference("select/"+key);
                dbRefyeni.setValue(murder,robbery, (DatabaseReference.CompletionListener) accident);






                Intent kayıt=new Intent(select_type.this,ana_akiş.class);
                startActivity(kayıt);
                finish();
                Toast.makeText(select_type.this,"REPORTED",Toast.LENGTH_LONG).show();



            }
        });

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
