package com.example.mohammad.aaatest.L13_SnackBar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

public class SimpleSnackBar extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_snack_bar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cordinator_layout);

    }

    public void simpleSnackbar(View v) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Simple Snackbar ...", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    public void SnackbarWituAction(View view) {
        Snackbar.make(coordinatorLayout, "No Internet Connection ... ", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(coordinatorLayout, "Connecing", Snackbar.LENGTH_LONG)
                                .show();
                    }
                }).show();
    }

    public void customSnackbar(View view) {

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "No Internet Connection ... ", Snackbar.LENGTH_LONG);
        snackbar.setAction("RETRY", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "Connecing", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        snackbar.setActionTextColor(Color.GREEN);
        View sbview = snackbar.getView();
        TextView sbtext = (TextView) sbview.findViewById(android.support.design.R.id.snackbar_text);
        sbtext.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    public void infoSnackbar(View view){
        Snackbar snackbar =  Snackbar.make(coordinatorLayout, "No Internet Connection ... ", Snackbar.LENGTH_LONG);
                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(coordinatorLayout, "Connecing", Snackbar.LENGTH_LONG)
                                .show();
                    }
                });
        ColoredSnakbar.info(snackbar).show();


    }
}
