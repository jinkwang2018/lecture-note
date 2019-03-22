package com.example.part7_19;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Lab19_2Activity extends AppCompatActivity implements View.OnClickListener{
    Button basicBtn;
    Button bigPictureBtn;
    Button bigTextBtn;
    Button inboxBtn;
    Button progressBtn;
    Button headsupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab19_2);

        basicBtn=(Button)findViewById(R.id.lab2_basic);
        bigPictureBtn=(Button)findViewById(R.id.lab2_bigpicture);
        bigTextBtn=(Button)findViewById(R.id.lab2_bigtext);
        inboxBtn=(Button)findViewById(R.id.lab2_inbox);
        progressBtn=(Button)findViewById(R.id.lab2_progress);
        headsupBtn=(Button)findViewById(R.id.lab2_headsup);

        basicBtn.setOnClickListener(this);
        bigPictureBtn.setOnClickListener(this);
        bigTextBtn.setOnClickListener(this);
        inboxBtn.setOnClickListener(this);
        progressBtn.setOnClickListener(this);
        headsupBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
    }
}
