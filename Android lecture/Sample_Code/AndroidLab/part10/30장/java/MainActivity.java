package com.example.part10_30;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SurfaceHolder.Callback {

    Button soundMediaBtn;
    Button soundPoolBtn;
    Button videoMediaBtn;
    Button videoViewBtn;

    SurfaceView surfaceView;
    VideoView videoView;

    private MediaPlayer mediaPlayer;
    private SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundMediaBtn=(Button)findViewById(R.id.lab1_sound_media);
        soundPoolBtn=(Button)findViewById(R.id.lab1_sound_pool);
        videoMediaBtn=(Button)findViewById(R.id.lab1_video_media);
        videoViewBtn=(Button)findViewById(R.id.lab1_video_view);
        surfaceView=(SurfaceView)findViewById(R.id.lab1_surface);
        videoView=(VideoView)findViewById(R.id.lab1_video);

        soundMediaBtn.setOnClickListener(this);
        soundPoolBtn.setOnClickListener(this);
        videoMediaBtn.setOnClickListener(this);
        videoViewBtn.setOnClickListener(this);

        holder = surfaceView.getHolder();
        holder.addCallback(this);

    }


    @Override
    public void onClick(View v) {
        //add~~~~~~~~~~~~~~~

        
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}
