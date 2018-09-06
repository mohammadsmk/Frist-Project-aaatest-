package com.example.mohammad.aaatest.L12_CustomView;

import android.content.Context;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.sax.StartElementListener;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

/**
 * Created by Mohammad on 7/24/2018.
 */

//public class valueSelector extends LinearLayout implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
//
//    View rootView;
//    View btnPols;
//    View btnNegative;
//    TextView TextValue;
//
//    int Max_Value = Integer.MAX_VALUE;
//    int Min_Value = Integer.MIN_VALUE;
//
//    public boolean isbtnPPress = false;
//    public boolean isbtnNPress = false;
//
//    private static final int INTERVAL_TIME = 100;
//
//    private Handler handler;
//
//
//
//
//
//    public valueSelector(Context context) {
//        super(context);
//        init(context);
//    }
//
//    public valueSelector(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(context);
//    }
//
//    public int getMinValue(){
//        return Min_Value;
//    }
//    public void setMinValue(int Min_Value){
//        this.Min_Value = Min_Value;
//    }
//    public int getMaxValue(){
//        return Max_Value;
//    }
//
//    public void setMaxValue(int Max_Value){
//        this.Max_Value = Max_Value;
//    }
//
//
//    public void init(Context context){
//        rootView = inflate(context , R.layout.view_selecter , this);
//        btnPols = rootView.findViewById(R.id.btn_P);
//        btnNegative = rootView.findViewById(R.id.btn_N);
//        TextValue = (TextView) rootView.findViewById(R.id.tv_number);
//        handler = new Handler();
//
//        btnNegative.setOnClickListener(this);
//        btnPols.setOnClickListener(this);
//
//        btnPols.setOnLongClickListener(this);
//        btnNegative.setOnLongClickListener(this);
//
//        btnNegative.setOnTouchListener(this);
//        btnPols.setOnTouchListener(this);
//
//
//
//
//    }
//
//
//
//    public int getValue(){
//        String text = TextValue.getText().toString();
//        if (text.isEmpty()){
//            TextValue.setText(0);
//            return 0;
//        }
//        return Integer.valueOf(text);
//    }
//
//    public void setValue (int newValue){
//
//        if (newValue > Max_Value){
//            TextValue.setText(String.valueOf(Min_Value));
//        } else if (newValue < Min_Value){
//            TextValue.setText(String.valueOf(Min_Value));
//        } else{
//            TextValue.setText(String.valueOf(newValue));
//        }
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == btnPols.getId()){
//            Increment();
//        }
//        else if (v.getId() == btnNegative.getId()){
//            Decrement();
//        }
//
//
//    }
//
//    private void Decrement() {
//        int value = getValue();
//        setValue(value-1);
//    }
//    private void Increment() {
//        int value = getValue();
//        setValue(value+1);
//    }
//
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL){
//            isbtnNPress = false;
//            isbtnPPress = false;
//
//        }
//
//
//        return false;
//    }
//
//
//    @Override
//    public boolean onLongClick(View v) {
//
//        if (v.getId() == btnNegative.getId()){
//            isbtnNPress = true;
//            handler.postDelayed(new AutoDecrement() , INTERVAL_TIME);
//        } else if (v.getId() == btnPols.getId()){
//            isbtnPPress = true;
//            handler.postDelayed(new AutoIncrement() , INTERVAL_TIME);
//        }
//
//        return false;
//    }
//
//
//    private class AutoDecrement implements Runnable{
//        @Override
//        public void run() {
//            if (isbtnNPress) {
//                Decrement();
//                handler.postDelayed(this, INTERVAL_TIME);
//            }
//        }
//    }
//    private class AutoIncrement implements Runnable{
//        @Override
//        public void run() {
//            if (isbtnPPress) {
//                Increment();
//                handler.postDelayed(this, INTERVAL_TIME);
//            }
//        }
//    }
//
//}
//



public class valueSelector extends LinearLayout implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    View rootView;
    TextView valueText;
    View buttonPlus;
    View buttonMinus;

    int minValue = Integer.MIN_VALUE;
    int maxValue = Integer.MAX_VALUE;

    private boolean isPlusButtonPressed = false;
    private boolean isMinusButtonPressed = false;
    private static final int TIME_INTERVAL = 100;

    private Handler handler;

    public valueSelector(Context context) {
        super(context);
        init(context);
    }

    public valueSelector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    private void init(Context context){
        setSaveEnabled(true);


        rootView = inflate(context, R.layout.view_selecter, this);
        valueText = (TextView) rootView.findViewById(R.id.value_number);
        buttonMinus = rootView.findViewById(R.id.btn_minus);
        buttonPlus = rootView.findViewById(R.id.btn_pols);

        handler = new Handler();

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);

        buttonPlus.setOnLongClickListener(this);
        buttonMinus.setOnLongClickListener(this);
        buttonMinus.setOnTouchListener(this);
        buttonPlus.setOnTouchListener(this);
    }

    public int getValue(){
        String text = valueText.getText().toString();
        if(text.isEmpty()){
            valueText.setText("0");
            return 0;
        }
        return Integer.valueOf(text);
    }

    public void setValue(int newValue){
        if(newValue > maxValue) {
            valueText.setText(String.valueOf(maxValue));
        } else if(newValue < minValue){
            valueText.setText(String.valueOf(minValue));
        } else {
            valueText.setText(String.valueOf(newValue));
        }
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == buttonMinus.getId()){
            decrementValue();
        } else if(view.getId() == buttonPlus.getId()){
            incrementValue();
        }
    }

    private void decrementValue(){
        int value = getValue();
        setValue(value-1);
    }

    private void incrementValue(){
        int value = getValue();
        setValue(value+1);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL){
//            if(view.getId() == buttonPlus.getId()){
            isPlusButtonPressed = false;
//            } else if(view.getId() == buttonMinus.getId()){
            isMinusButtonPressed = false;
//            }
        }
        return false;
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == buttonMinus.getId()){
            isMinusButtonPressed = true;
            handler.postDelayed(new AutoDecrementer(), TIME_INTERVAL);
        } else if(view.getId() == buttonPlus.getId()){
            isPlusButtonPressed = true;
            handler.postDelayed(new AutoIncrementer(), TIME_INTERVAL);
        }
        return false;
    }

    private class AutoDecrementer implements Runnable{

        @Override
        public void run() {
            if(isMinusButtonPressed){
                decrementValue();
                handler.postDelayed(this , TIME_INTERVAL);
            }
        }
    }

    private class AutoIncrementer implements Runnable{
        @Override
        public void run() {
            if(isPlusButtonPressed){
                incrementValue();
                handler.postDelayed(this , TIME_INTERVAL);
            }
        }
    }


    @Override
    protected Parcelable onSaveInstanceState() {
        ValueSelectorSavedState ss = new ValueSelectorSavedState(super.onSaveInstanceState());
        ss.minValue = this.minValue;
        ss.maxValue = this.maxValue;
        ss.currentValue = getValue();
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        ValueSelectorSavedState ss = (ValueSelectorSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setValue(ss.currentValue);
        setMinValue(ss.minValue);
        setMaxValue(ss.maxValue);
    }

    public static class ValueSelectorSavedState extends BaseSavedState {
        int currentValue;
        int minValue;
        int maxValue;

        public ValueSelectorSavedState(Parcel in) {
            super(in);
            currentValue = in.readInt();
            minValue = in.readInt();
            maxValue = in.readInt();
        }

        public ValueSelectorSavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(currentValue);
            out.writeInt(minValue);
            out.writeInt(maxValue);
        }


        public static final Parcelable.Creator<ValueSelectorSavedState> CREATOR =
                new Creator<ValueSelectorSavedState>() {
                    @Override
                    public ValueSelectorSavedState createFromParcel(Parcel parcel) {
                        return new ValueSelectorSavedState(parcel);
                    }

                    @Override
                    public ValueSelectorSavedState[] newArray(int i) {
                        return new ValueSelectorSavedState[i];
                    }
                };

    }


}




















