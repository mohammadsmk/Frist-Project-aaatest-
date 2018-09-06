package com.example.mohammad.aaatest.L8_Toast;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

//public class ToastActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_toast);
//    }
//    public void simpleToast(View v) {
//        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
//    }
//
//    public void testColorForToast(View v){
//        Toast toast = Toast.makeText(this, "Test Color For Toast", Toast.LENGTH_LONG);
//        toast.getView().setBackgroundColor(0x7ff44436);
//        toast.show();
//    }
//    public void testColoredToast(View v){
//        String tag = (String) v.getTag();
//        switch (tag){
//            case "alert" :
//                ColoredToast.alert(this, "this is an alert toast", ColoredToast.LENGTH_LONG).show();
//                break;
//            case "warning" :
//                ColoredToast.warning(this, "this is a warning toast", ColoredToast.LENGTH_SHORT).show();
//                break;
//            case "info" :
//                ColoredToast.info(this, "this is an info toast", ColoredToast.LENGTH_LONG).show();
//                break;
//            case "success":
//                ColoredToast.success(this, "this is a success toast", ColoredToast.LENGTH_SHORT).show();
//                break;
//            default: break;
//        }
//    }
//    public void imageToast(View v){
//        ColoredToast.imageToast(this, R.drawable.back, ColoredToast.LENGTH_SHORT).show();
//    }

public class ToastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }


    public void testColoredToast(View v){
        String tag = (String) v.getTag();
        switch (tag){
            case "alert" :
                ColoredToast.alert(this, "this is an alert toast", Toast.LENGTH_LONG).show();
                break;
            case "warning" :
                ColoredToast.alert(this, "this is a warning toast", Toast.LENGTH_LONG).show();
                break;
            case "info" :
                ColoredToast.alert(this, "this is an info toast", Toast.LENGTH_LONG).show();
                break;
            case "success":
                ColoredToast.alert(this, "this is a success toast", Toast.LENGTH_LONG).show();
                break;
            default: break;
        }
    }
    public void imageToast(View v){
        ColoredToast.imageToast(this, R.drawable.back, Toast.LENGTH_SHORT).show();
    }


}







