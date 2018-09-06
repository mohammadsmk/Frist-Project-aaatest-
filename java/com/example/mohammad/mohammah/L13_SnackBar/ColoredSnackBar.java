package com.example.mohammad.aaatest.L13_SnackBar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Mohammad on 7/31/2018.
 */

public class ColoredSnakbar {

    private static final int BLUE = Color.BLUE;

//    private static View getSnackbarLayout(Snackbar snackbar){
//        if (snackbar != null){
//            return snackbar.getView();
//        }
//        return null;
//    }
//
//    private static Snackbar colorSnackbar(Snackbar snackbar , int color){
//        View sbview = getSnackbarLayout(snackbar);
//        if (sbview != null){
//            sbview.setBackgroundColor(color);
//        }
//        return snackbar;
//    }
//
//    public static Snackbar info (Snackbar snackbar){
//        return colorSnackbar(snackbar , BLUE);
//    }


    private static View getSnackBarLayout(Snackbar snackbar){
        if (snackbar != null){
            return snackbar.getView();
        }
        return null;
    }

    private static Snackbar ColorSet(Snackbar snackbar , int color){
        View sb = getSnackBarLayout(snackbar);
        sb.setBackgroundColor(color);
        return snackbar;
    }

    public static Snackbar info(Snackbar snackbar){
        return ColorSet(snackbar , BLUE);
    }


    }
