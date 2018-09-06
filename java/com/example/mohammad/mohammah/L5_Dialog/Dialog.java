package com.example.mohammad.aaatest.L5_Dialog;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mohammad.aaatest.R;

import java.util.Timer;
import java.util.TimerTask;

public class Dialog extends AppCompatActivity {

    Button btnone , btntwo , btnthree , btnfour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

//        btnone = (Button) findViewById(R.id.btnone);
//
//        btnone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final ProgressDialog Dlog= new ProgressDialog(Dialog.this);
//                Dlog.setTitle("Example Progress");
//                Dlog.setMessage("Please Wait ....");
//                Dlog.setCancelable(false);
//                Dlog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                Dlog.show();
//                new Timer().scheduleAtFixedRate(new TimerTask() {
//                    @Override
//                    public void run() {
//                        if (Dlog.getProgress() < Dlog.getMax()){
//                            Dlog.incrementProgressBy(1);
//                        }else {
//                            Dlog.dismiss();
//                        }
//                    }
//                },0,100);
//                new Timer().scheduleAtFixedRate(new TimerTask() {
//                    @Override
//                    public void run() {
//                        if (Dlog.getProgress() < Dlog.getMax()){
//                            Dlog.incrementSecondaryProgressBy(1);
//                        }
//                    }
//                },0,50);
//            }
//        });
//
//
//        btntwo = (Button) findViewById(R.id.btntwo);
//        btntwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Dialog.this);
//                builder.setTitle("Example AlertDialog")
//                        .setIcon(android.R.drawable.alert_dark_frame)
//                        .setCancelable(false)
//                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(Dialog.this, "Yes", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("No" , null)
//                        .show();

//                builder.setTitle("Question ? ")
//                        .setSingleChoiceItems(new String[]{"A", "B", "C"}, -1, new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(Dialog.this, "i = " +which, Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                        ).show();

//                builder.setTitle("Choise Item")
//                        .setMultiChoiceItems(new String[]{"A", "B", "C"}, new boolean[]{false, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                Toast.makeText(Dialog.this, "i :"+which + isChecked, Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
//
//
//            }
//        });


        btnone = (Button) findViewById(R.id.btnone);
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dlog = new ProgressDialog(Dialog.this);
                dlog.setMessage("Please Wait");
                dlog.setCancelable(false);
                dlog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
             //   dlog.setIndeterminate(true);
                dlog.show();
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (dlog.getProgress() < dlog.getMax()) {
                            dlog.incrementProgressBy(1);
                        } else {
                            dlog.dismiss();
                        }
                    }


                }, 0, 100);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (dlog.getProgress() < dlog.getMax()){
                            dlog.incrementSecondaryProgressBy(1);
                        }
                    }
                },0,50);

            }
   });
//

        btntwo = (Button) findViewById(R.id.btntwo);
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Dialog.this);

                builder.setMessage("Are You Sure ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Dialog.this, "Yes", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No" , null)
                        .show();
            }
        });



        btnthree = (Button) findViewById(R.id.btnthree);
        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSelect = new AlertDialog.Builder(Dialog.this);
                builderSelect.setTitle("Select Your Items")
                       .setMultiChoiceItems(new String[]{"A", "B", "C"}, new boolean[]{false, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
                           @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(Dialog.this, "i :"+which + isChecked, Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });

        btnfour = (Button) findViewById(R.id.btnfour);
        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSelect = new AlertDialog.Builder(Dialog.this);
                builderSelect.setTitle("Choice Your Items")
                        .setSingleChoiceItems(new String[]{"A", "B", "C"}, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Dialog.this, "i"+which, Toast.LENGTH_SHORT).show();
                            }
                        }).show();

            }
        });






    }

}
