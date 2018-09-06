package com.example.mohammad.aaatest.L8_Toast;

import android.content.Context;
import android.graphics.Color;
import android.sax.StartElementListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

/**
 * Created by Mohammad on 7/21/2018.
 */

//public class ColoredToast {
//
//    private static final int RED = 0xfff44336;
//    private static final int BLUE = 0xff2195f3;
//    private static final int ORANGE = 0xffffc107;
//    private static final int GREEN = 0xff4caf50;
//
//    private static final int IC_ALERT = R.drawable.ic1;
//    private static final int IC_WARNING = R.drawable.ic1;
//    private static final int IC_INFO = R.drawable.ic1;
//    private static final int IC_SUCCESS = R.drawable.ic1;
//
//    public static final int LENGTH_LONG  = 1;
//    public static final int LENGTH_SHORT = 0;
//
//
//    private Context context;
//    public View view;
//    Toast toast;
//    public ColoredToast(Context context){
//        this.context = context;
//        this.toast = new Toast(context);
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.view = inflater.inflate(R.layout.colored_toast_layout, null);
//        toast.setView(view);
//    }
//
//    public View getView(){
//        return view;
//    }
//    public void setText(String text){
//        if(view==null)
//            return;
//        ((TextView) view.findViewById(R.id.toast_msg)).setText(text);
//    }
//
//    public void setIcon(int iconResId){
//        if(view==null)
//            return;
//        ((ImageView) view.findViewById(R.id.toast_icon)).setImageResource(iconResId);
//    }
//    public Toast getToast(){
//        return toast;
//    }
//
//
//    public static Toast alert(Context context, String text, int duration){
//        ColoredToast coloredToast = new ColoredToast(context);
//        coloredToast.setText(text);
//        coloredToast.getToast().setDuration(duration);
//        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
//        coloredToast.setIcon(IC_ALERT);
//        coloredToast.getView().setBackgroundColor(RED);
//        return coloredToast.getToast();
//    }
//
//    public static Toast info(Context context, String text, int duration){
//        ColoredToast coloredToast = new ColoredToast(context);
//        coloredToast.setText(text);
//        coloredToast.getToast().setDuration(duration);
//        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
//        coloredToast.setIcon(IC_INFO);
//        coloredToast.getView().setBackgroundColor(BLUE);
//        return coloredToast.getToast();
//    }
//    public static Toast warning(Context context, String text, int duration){
//        ColoredToast coloredToast = new ColoredToast(context);
//        coloredToast.setText(text);
//        coloredToast.getToast().setDuration(duration);
//        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
//        coloredToast.setIcon(IC_WARNING);
//        coloredToast.getView().setBackgroundColor(ORANGE);
//        return coloredToast.getToast();
//    }
//    public static Toast success(Context context, String text, int duration){
//        ColoredToast coloredToast = new ColoredToast(context);
//        coloredToast.setText(text);
//        coloredToast.getToast().setDuration(duration);
//        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
//        coloredToast.setIcon(IC_SUCCESS);
//        coloredToast.getView().setBackgroundColor(GREEN);
//        return coloredToast.getToast();
//    }
//
//
//    public static Toast imageToast(Context context, int imageRes, int duration){
//        Toast toast = new Toast(context);
//        ImageView iv = new ImageView(context);
//        LinearLayout layout = new LinearLayout(context);
//        layout.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
//        layout.addView(iv);
//        iv.setScaleType(ImageView.ScaleType.FIT_XY);
//        iv.requestLayout();
//        iv.setLayoutParams(layout.getLayoutParams());
//        iv.setImageResource(imageRes);
//        toast.setView(layout);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.setDuration(duration);
//        return toast;
//    }
//}


    public class ColoredToast{

    public static final int RED = Color.RED;
    public static final int IC_ALERT = R.drawable.ic;

    private Context context;
    public View view;
    Toast toast;

    public ColoredToast(Context context){
        this.context = context;
        this.toast = new Toast(context);
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.view = inflator.inflate(R.layout.colored_toast_layout , null);
        toast.setView(view);
    }

    public View getView() {
        return view;
    }

    public void setText (String text){
        ((TextView)view.findViewById(R.id.toast_msg)).setText(text);
    }
    public void setIcon (int ImageIconREsourse){
        ((ImageView)view.findViewById(R.id.img_sms)).setImageResource(ImageIconREsourse);
    }

    public Toast getToast() {
        return toast;
    }

    public static Toast alert(Context context, String text, int duration){
        ColoredToast coloredToast = new ColoredToast(context);
        coloredToast.setText(text);
        coloredToast.getToast().setDuration(duration);
        coloredToast.getToast().setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 50);
        coloredToast.setIcon(IC_ALERT);
        coloredToast.getView().setBackgroundColor(RED);
        return coloredToast.getToast();
    }


    public static Toast imageToast (Context context , int imageRes , int duration){
        Toast toast = new Toast(context);
        ImageView iv = new ImageView(context);
        LinearLayout layout = new LinearLayout(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
        layout.addView(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        iv.requestLayout();
        iv.setLayoutParams(layout.getLayoutParams());
        iv.setImageResource(imageRes);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(duration);
        return toast;

    }



}
