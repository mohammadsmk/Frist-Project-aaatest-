package com.example.mohammad.aaatest.L3_Game;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mohammad.aaatest.R;

public class Game extends AppCompatActivity {

    public static final int YELLOW_CODE = 0;
    public static final int RED_CODE = 1;
    public static final int NOT_PLAYER = 2 ;
    public static final int NO_WINNER = -1;

    int[] GameStats = {NOT_PLAYER , NOT_PLAYER , NOT_PLAYER ,
                        NOT_PLAYER ,NOT_PLAYER ,NOT_PLAYER ,
                        NOT_PLAYER ,NOT_PLAYER ,NOT_PLAYER };

    int[][] Willing = {{0,1,2} , {3,4,5} , {6,7,8}
                        , {0,4,8} , {2,4,6} ,
                            {0,3,6} , {1,4,7} , {2,5,8}};

    int activeplayer = RED_CODE;

    int Winner = NO_WINNER;

    RelativeLayout MSGLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        MSGLayout = (RelativeLayout) findViewById(R.id.MSG_Winner);
        MSGLayout.setVisibility(View.GONE);

    }
    public void DropIn(View v){
        int tag = Integer.parseInt((String) v.getTag());
        if (Winner != NO_WINNER && GameStats[tag] != NOT_PLAYER){
            return;
        }

        ImageView img = (ImageView) v;
        img.setTranslationY(-2000f);
        if (activeplayer == RED_CODE){
            img.setImageResource(R.drawable.red);
            img.animate().translationY(0f).setDuration(500);
            GameStats[tag] = activeplayer;
            activeplayer = YELLOW_CODE;
        }
        else if (activeplayer == YELLOW_CODE){
            img.setImageResource(R.drawable.yellow);
            img.animate().translationY(0f).setDuration(500);
            GameStats[tag] = activeplayer;
            activeplayer = RED_CODE;
        }
        MSGmessage();



    }

    private void MSGmessage() {
        Winner = CheckWinner();
        if (Winner != NO_WINNER || filled()){
            String MSG = "";
            if (Winner == NO_WINNER){
                MSG = "No Won";
                MSGLayout.setBackgroundColor(Color.GREEN);
            }

            else if (Winner == RED_CODE){
                MSG = "Red Won";
                MSGLayout.setBackgroundColor(Color.RED);
            }

            else if (Winner == YELLOW_CODE){
                MSG = "Yellow Won";
                MSGLayout.setBackgroundColor(Color.YELLOW);
            }

            ((TextView)MSGLayout.findViewById(R.id.MSG_Text)).setText(MSG);
            MSGLayout.setVisibility(View.VISIBLE);
        }

    }

    private boolean filled() {
        for (int i = 0; i < GameStats.length; i++) {
            if (GameStats[i]!=NOT_PLAYER){
                return false;
            }
        }
        return true;
    }

    private int CheckWinner() {
        for (int[] position : Willing) {
           if(GameStats[position[0]] == GameStats[position[1]] &&
                    GameStats[position[1]] == GameStats[position[2]] &&
                    GameStats[position[0]] != NOT_PLAYER){
              return GameStats[position[0]];
            }
        }
        return NO_WINNER;
    }

    public void reset(View v){
        activeplayer = RED_CODE;
        Winner = NO_WINNER;
        for (int i = 0; i <GameStats.length ; i++) {
            GameStats[i] = NOT_PLAYER;
        }
        LinearLayout pglayout = (LinearLayout) findViewById(R.id.pg_layout);
        for (int i = 0; i < pglayout.getChildCount() ; i++) {
            LinearLayout row = (pglayout.getChildAt(i) instanceof  LinearLayout)?
                    (LinearLayout) pglayout.getChildAt(i) : null;
                    if (row == null){return;}
            for (int j = 0; j < row.getChildCount(); j++) {
                ImageView iv = (row.getChildAt(j) instanceof  ImageView) ?
                        (ImageView) row.getChildAt(j) : null;
                if (iv ==null){return;}

                iv.setImageResource(0);
                MSGLayout.setVisibility(View.GONE);

            }


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add("Reset");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                reset(null);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
