package com.example.mohammad.aaatest.L11_Spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mohammad.aaatest.L11_Spinner.CustomSpinnerAdapter;
import com.example.mohammad.aaatest.R;


//public class SpinnerActivity extends AppCompatActivity {

//
//    Spinner simpleSpinner;
//    Spinner customSpinner;
//
//    String[] simpleItems;
//    int[] countryFlags = {R.drawable.flag_cn, R.drawable.flag_cz,
//            R.drawable.flag_dk, R.drawable.flag_fr, R.drawable.flag_de,
//            R.drawable.flag_ir, R.drawable.flag_it, R.drawable.flag_jp,
//            R.drawable.flag_kr, R.drawable.flag_pt, R.drawable.flag_pl,
//            R.drawable.flag_es, R.drawable.flag_tr};
//
//    String[] countryNames = { "China", "Czech", "Denmark", "France", "Germany",
//            "Iran", "Italy", "Japan", "Korea", "Portugal", "Poland", "Spain", "Turkey"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spinner);
//
//        initSimpleSpinner();
//        initCustomSpinner();
//    }
//
//
//
//    private void initSimpleSpinner() {
//        simpleSpinner = (Spinner) findViewById(R.id.simple_spinner);
//        simpleItems = getResources().getStringArray(R.array.tours);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, simpleItems);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        simpleSpinner.setAdapter(adapter);
//        simpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SpinnerActivity.this,
//                        (String) adapterView.getSelectedItem(),
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
//
//    private void initCustomSpinner() {
//        customSpinner = (Spinner) findViewById(R.id.custom_spinner);
//        final CountrySpinnerAdapter adapter = new CountrySpinnerAdapter(this, countryFlags, countryNames);
//        customSpinner.setAdapter(adapter);
//        customSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(SpinnerActivity.this,
//                        (String) adapterView.getSelectedItem(),
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
//
//}


public class SpinnerActivity extends AppCompatActivity {

    Spinner SimpleSpinner , CustomSpinner;
    String[] ItemsSpinner;

    int[] flags = {R.drawable.ic , R.drawable.logo };
    String[] names = {"Iran" , "Germany"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initSimpleSpinner();

        customSpinner();


    }


    private void initSimpleSpinner() {
        SimpleSpinner = (Spinner) findViewById(R.id.SimpleSpinner);

        ItemsSpinner = getResources().getStringArray(R.array.tours);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ItemsSpinner);
        SimpleSpinner.setAdapter(adapter);

        SimpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, (String) parent.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void customSpinner() {
        CustomSpinner = (Spinner) findViewById(R.id.customSpinner);
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, flags , names );
        CustomSpinner.setAdapter(adapter);




    }
}
