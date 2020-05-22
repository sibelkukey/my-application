package com.example.trackit;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
private  DatabaseReference mdatabaseLike;
 private boolean mprocesslike=false;


 protected void oncretae....... ()// bunu altına yazz
mdatabaseLike=FirabaseDatabase.getInstance().getReference().child("like");
 mdatabaselike.keepSynced(true);


public static class ana_akiş extends AppCompatActivity {
    View view;
    ImageButton like; //tanımla
    public ViewHolder(View itemsView) //bu kısma yazıcaksın
        super(itemView);
    view=itemsView;
        like=(ImageButton) view.findViewById(R.id.like);  // tanımla




}
 // sonra  butona click özelliği ver
viewHolder.like.setOnclickListener(new view.OnclickListener) {

    mprocessLike=true;

    mdatabaselike.addValueListener(newEventListener()){ // bunu yazınca alttakiler otomatik gelicek

        public void ondatachange(......)

        if(mpocesslike){


        if(datasnapshot.child(post_key).haschild(mAuth.getCurrent().getUid())){
        mdatabaselike.child(pos_key).child(mAuth.getCurrentUser().getUid()).removeValue();
        mprocesslike=false;

        }else{

        mdatabaselike.child(postkey).child(mAuth.getCurrentUser().getUid()).setValue("randomvalue");
        mprocesslike=false;
        }
        }
        }
    public void onCalled(databaseerror......){



        }
        }