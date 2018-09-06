package com.example.mohammad.aaatest.L12_CustomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mohammad.aaatest.R;

public class CustomView extends AppCompatActivity {
    ValueBar valueBar;
    valueSelector valueSelector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        valueSelector = (valueSelector) findViewById(R.id.valueSelector);
        valueSelector.setMinValue(0);
        valueSelector.setMaxValue(100);

        valueBar = (ValueBar) findViewById(R.id.value_bar);
        valueBar.setMaxValue(100);
        valueBar.setValue(0);

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueBar.setValue(valueSelector.getValue());
            }
        });


    }
}
