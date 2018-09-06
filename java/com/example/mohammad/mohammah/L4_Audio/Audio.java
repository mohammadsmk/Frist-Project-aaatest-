package com.example.mohammad.aaatest.L4_Audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.mohammad.aaatest.R;

import java.util.Timer;
import java.util.TimerTask;

public class Audio extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnPause;
    SeekBar VolumeBar, ScuBar;
    MediaPlayer mplayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
//
//        btnPlay = (Button) findViewById(R.id.btnPlay);
//        btnPause = (Button) findViewById(R.id.btnPause);
//
//        VolumeBar = (SeekBar) findViewById(R.id.volumbar);
//        ScuBar = (SeekBar) findViewById(R.id.scrubbar);
//
//        btnPause.setOnClickListener(this);
//        btnPlay.setOnClickListener(this);
//
//        mplayer = MediaPlayer.create(this , R.raw.mey);
//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//        int MaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        int CurVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//
//        VolumeBar.setMax(MaxVolume);
//        VolumeBar.setProgress(CurVolume);
//
//        VolumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        ScuBar.setMax(mplayer.getDuration());
//        ScuBar.setProgress(0);
//
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                ScuBar.setProgress(mplayer.getCurrentPosition());
//            }
//        },0,100);
//
//        ScuBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser){
//                    mplayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnPlay:
//                mplayer.start();
//                break;
//            case R.id.btnPause:
//                mplayer.stop();
//                break;
//        }
//    }

        btnPause = (Button) findViewById(R.id.btnPause);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnPause.setOnClickListener(this);
        btnPlay.setOnClickListener(this);

        ScuBar = (SeekBar) findViewById(R.id.scrubbar);
        VolumeBar = (SeekBar) findViewById(R.id.volumbar);

        mplayer = MediaPlayer.create(this , R.raw.mey);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int MaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int CurVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        VolumeBar.setMax(MaxVolume);
        VolumeBar.setProgress(CurVolume);

        VolumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC , progress , 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ScuBar.setMax(mplayer.getDuration());
        ScuBar.setProgress(0);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ScuBar.setProgress(mplayer.getCurrentPosition());
            }
        },0,100);

        ScuBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mplayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                mplayer.start();
                break;
            case R.id.btnPause:
                mplayer.pause();
                break;
        }
    }
}
