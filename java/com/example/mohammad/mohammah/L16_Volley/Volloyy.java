package com.example.mohammad.aaatest.L16_Volloy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mohammad.aaatest.R;

public class Volloyy extends AppCompatActivity
{

    ImageView btnJsonRequest , btnJson , btnJsonPic;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volloyy);


        btnJsonRequest = (ImageView) findViewById(R.id.image_VolleyRequestString);
        btnJsonRequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Volloyy.this , StringRequest.class);
                startActivity(intent);
            }
        });

        btnJson = (ImageView) findViewById(R.id.image_Volloy);
        btnJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Volloyy.this , JsonRequest.class);
                startActivity(intent);
            }
        });

        btnJsonPic = (ImageView) findViewById(R.id.image_VolloyRequestImage);
        btnJsonPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Volloyy.this , imageVolley.class);
                startActivity(intent);
            }
        });



    }
}
