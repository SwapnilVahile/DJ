package com.example.dj;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnTouchListener, View.OnClickListener {
    MediaPlayer mediaPlayer1,mediaPlayer2;
    Random random=new Random();

    //For small and light Music
    SoundPool soundPool;
int dhamaka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        View view=new View(this);//created new view

        //Events
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);

        //Soundpool
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        dhamaka=soundPool.load(this,R.raw.explosion,1);

        //Media player resources linking
        mediaPlayer1=MediaPlayer.create(this,R.raw.iamthedoctor);
        mediaPlayer2=MediaPlayer.create(this,R.raw.sherlock);

        //Random background
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(286)));//set background color using RGB by passing random value between 0 To bound

    }

    @Override
    public boolean onLongClick(View v) {
        mediaPlayer2.start();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (dhamaka!=0){
            soundPool.play(dhamaka,1,1,0,0,1);
            v.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(286)));//set background color using RGB by passing random value between 0 To bound

        }
        return false;
    }

    @Override
    public void onClick(View v) {
        mediaPlayer1.start();

    }


    @Override
    protected void onPause() {
        mediaPlayer1.release();
        super.onPause();
    }
}

