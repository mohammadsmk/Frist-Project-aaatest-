package com.example.mohammad.aaatest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mohammad.aaatest.L10_RationBar.RationBar_L10;
import com.example.mohammad.aaatest.L11_Spinner.SpinnerActivity;
import com.example.mohammad.aaatest.L12_CustomView.CustomView;
import com.example.mohammad.aaatest.L13_SnackBar.SimpleSnackBar;
import com.example.mohammad.aaatest.L14_URL.URLMultiImages;
import com.example.mohammad.aaatest.L14_URL.URLOneImg;
import com.example.mohammad.aaatest.L14_URL.URLTotalText;
import com.example.mohammad.aaatest.L15_JSONN.JSONN;
import com.example.mohammad.aaatest.L16_Volloy.Volloyy;
import com.example.mohammad.aaatest.L1_Basic.FormInfo;
import com.example.mohammad.aaatest.L5_Dialog.Dialog;
import com.example.mohammad.aaatest.L6_simpleList.SimpleListActivity;
import com.example.mohammad.aaatest.L7_CustomList.CustomListActivity;
import com.example.mohammad.aaatest.L8_Toast.ToastActivity;
import com.example.mohammad.aaatest.L9_RadioButton.RadioButtonActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 12;
    Button  Basic, Animation,Game , Audio, Dilod, SimpleList, CustomList , btnToast , btnRadio , btnrationbar , btnspineer;
    Button btnCustomView , btnSimpleSnackBar , btnURLONEPIC  , btnURLText , btnJSONN , btnURLMultiImages ,btnVolloy;
    ImageView Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Start = (ImageView) findViewById(R.id.Start);
//        Start.animate().translationX(-2000f).setDuration(1500).setStartDelay(5000);

        Basic = (Button) findViewById(R.id.input);
        Basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , FormInfo.class);
                startActivity(intent);

            }
        });


        Game = (Button) findViewById(R.id.Button_Game);
        Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.mohammad.aaatest.L3_Game.Game.class);
                startActivity(intent);
            }
        });
        Animation = (Button) findViewById(R.id.Button_Animation);
        Animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.mohammad.aaatest.L2_Animation.Animation.class);
                startActivity(intent);
            }
        });

        Audio = (Button) findViewById(R.id.Button_Audio);
        Audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.mohammad.aaatest.L4_Audio.Audio.class);
                startActivity(intent);
            }
        });
        Dilod = (Button) findViewById(R.id.Button_Diloag);
        Dilod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dialog.class);
                startActivity(intent);
            }
        });

        SimpleList = (Button) findViewById(R.id.Button_SimpleList);
        SimpleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleListActivity.class);
                startActivity(intent);
            }
        });

        CustomList = (Button) findViewById(R.id.Button_CustomList);
        CustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
                startActivity(intent);
            }
        });

        btnToast = (Button) findViewById(R.id.Button_Toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                startActivity(intent);
            }
        });

        btnRadio = (Button) findViewById(R.id.Button_RadioButton);
        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                startActivity(intent);
            }
        });

        btnrationbar = (Button) findViewById(R.id.Button_ration);
        btnrationbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RationBar_L10.class);
                startActivity(intent);
            }
        });

        btnspineer = (Button) findViewById(R.id.Button_spinner);
        btnspineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        btnCustomView = (Button) findViewById(R.id.CustomView);
        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomView.class);
                startActivity(intent);
            }
        });

        btnSimpleSnackBar = (Button) findViewById(R.id.SnackBar);
        btnSimpleSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleSnackBar.class);
                startActivity(intent);
            }
        });

        btnURLONEPIC = (Button) findViewById(R.id.URL_ONE_PIC);
        btnURLONEPIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, URLOneImg.class);
                startActivity(intent);
            }
        });


        btnURLMultiImages = (Button) findViewById(R.id.URL_MultiPic);
        btnURLMultiImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, URLMultiImages.class);
                startActivity(intent);
            }
        });

        btnURLText = (Button) findViewById(R.id.JSONText);
        btnURLText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, URLTotalText.class);
                startActivity(intent);
            }
        });

        btnJSONN = (Button) findViewById(R.id.JSONN);
        btnJSONN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JSONN.class);
                startActivity(intent);
            }
        });

        btnVolloy = (Button) findViewById(R.id.Volloyy);
        btnVolloy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Volloyy.class);
                startActivity(intent);
            }
        });

    }
}
