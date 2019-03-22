package com.example.part9_25;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Lab25_3Activity extends AppCompatActivity {
    ImageView gifView;
    ImageView networkView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab25_3);
        gifView=(ImageView)findViewById(R.id.lab3_gif);
        networkView=(ImageView)findViewById(R.id.lab3_network);

        
    }
}
