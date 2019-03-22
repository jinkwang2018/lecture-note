package com.example.part7_20;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Lab20_2Activity extends AppCompatActivity implements View.OnClickListener{

    public static final int MEDIA_STATUS_STOP = 0;
    public static final int MEDIA_STATUS_RUNNING = 1;
    public static final int MEDIA_STATUS_COMPLETED = 2;

    ImageView playBtn;
    ImageView stopBtn;
    ProgressBar progressBar;
    TextView titleView;

    String filePath;
    boolean runThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab20_2);

        playBtn=(ImageView)findViewById(R.id.lab2_play);
        stopBtn=(ImageView)findViewById(R.id.lab2_stop);
        progressBar=(ProgressBar)findViewById(R.id.lab2_progress);
        titleView=(TextView)findViewById(R.id.lab2_title);

        playBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);

        titleView.setText("music.mp3");
        stopBtn.setEnabled(false);
        playBtn.setEnabled(false);

        filePath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music/music.mp3";


        
    }

    
    

    @Override
    public void onClick(View v) {
        if(v==playBtn){
            
        }else if(v==stopBtn){
            
        }
    }

    class ProgressThread extends Thread{
        @Override
        public void run() {
            while (runThread){
                progressBar.incrementProgressBy(1000);
                SystemClock.sleep(1000);
                if(progressBar.getProgress()==progressBar.getMax()){
                    runThread=false;
                }
            }
        }
    }


}

