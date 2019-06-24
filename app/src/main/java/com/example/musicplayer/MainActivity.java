package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,stop,pause;
    MediaPlayer mediaPlayer;
    int pauseCurrentPostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.btn_play);
        stop = (Button) findViewById(R.id.btn_stop);
        pause = (Button) findViewById(R.id.btn_pause);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn_play:
               if(mediaPlayer == null) {
                   mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                   mediaPlayer.start();
                   break;
               }
               else if(!mediaPlayer.isPlaying()){
                  mediaPlayer.seekTo(pauseCurrentPostion);
                  mediaPlayer.start();
               }
           case R.id.btn_pause:
               if(mediaPlayer != null){
                   mediaPlayer.pause();
                   pauseCurrentPostion = mediaPlayer.getCurrentPosition();

               }
               break;

           case R.id.btn_stop:
               if (mediaPlayer!=null){
                   mediaPlayer.stop();
                   mediaPlayer = null;

               }
               break;
       }
    }
}
