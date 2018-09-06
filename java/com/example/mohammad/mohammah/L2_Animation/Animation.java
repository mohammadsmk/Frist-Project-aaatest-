package com.example.mohammad.aaatest.L2_Animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mohammad.aaatest.R;

public class Animation extends AppCompatActivity {
    public static final int PICONE = 1;
    public static final int PICTWO = 2;
    int activepic = PICONE;
    ImageView picone;
    ImageView pictwo;
    ImageView picthree;
    ImageView picfour;
    ImageView picfive;
    ImageView picsix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);



            picone = (ImageView) findViewById(R.id.picone);
            pictwo = (ImageView) findViewById(R.id.pictwo);
                   picone.animate().alpha(1f - picone.getAlpha()).setDuration(4000);
                   pictwo.animate().alpha(1f - pictwo.getAlpha()).setDuration(4000);
//
//
//        if (activepic == PICONE) {
//            picone.animate().alpha(1f - picone.getAlpha()).setDuration(4000);
//            activepic = PICTWO;
//        }
//        if (activepic == PICTWO) {
//            pictwo.animate().alpha(1f - pictwo.getAlpha()).setDuration(4000);
//
//            activepic = PICONE;
//        }
//            picthree =(ImageView) findViewById(R.id.picthree);
//            picfour =(ImageView) findViewById(R.id.picfour);
//            picfive =(ImageView) findViewById(R.id.picfive);
//            picsix =(ImageView) findViewById(R.id.picsix);
//            picthree.setTranslationX(-1000f);
//            picfour.setTranslationX(-2000f);
//            picfive.setTranslationX(-3000f);
//            picsix.setTranslationX(-4000f);
//            picthree.animate().translationX(0f).setDuration(3000);
//            picfour.animate().translationX(0f).setDuration(5000);
//            picfive.animate().translationX(0f).setDuration(7000);
//            picsix.animate().translationX(0f).setDuration(9000);



     //     picone.animate().alpha(1f - picone.getAlpha()).setDuration(4000);


       //     picone.setTranslationY(1f);
       //     picone.animate().translationYBy(2000f).setDuration(4000);
       //     picone.animate().translationXBy(2000f).setDuration(6000);
       //       picone.animate().rotationXBy(180f).rotationBy(180f).setDuration(4000);

    //    picone.setOnClickListener(new View.OnClickListener() {
    //        @Override
    //        public void onClick(View v) {
        //        picone.animate().scaleX(.5f).setDuration(2000);
        //        picone.animate().scaleXBy(.5f).setDuration(2000);
        //ZOOM        picone.animate().scaleXBy(.1f).scaleYBy(.1f).setDuration(1000);
      //      }
    //    });

       // picone.setTranslationY(-1000f);        picone.setTranslationX(-1000f);        picone.setScaleX(0.2f);
       // picone.setScaleY(0.2f);        CustomAnimation();;   }   private void CustomAnimation(){        picone.animate()                .translationX(0)
       //         .translationY(0)                .rotationBy(5 * 360)                .scaleX(1f)                .scaleY(1f)                .setDuration(3000);
    }
}

