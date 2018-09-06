package com.example.mohammad.aaatest.L10_RationBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

public class RationBar_L10 extends AppCompatActivity {
    RatingBar RB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ration_bar);
        RB = (RatingBar) findViewById(R.id.Score);

        RB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RationBar_L10.this, "Your Score :" + rating, Toast.LENGTH_SHORT).show();
            }
        });






    }
}
