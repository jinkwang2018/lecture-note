package com.example.part5_16;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class Lab16_3Activity extends AppCompatActivity {

    OneThread oneThread;

    ArrayList<String> oddDatas;
    ArrayList<String> evenDatas;

    ArrayAdapter<String> oddAdapter;
    ArrayAdapter<String> evenAdapter;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab16_3);

        ListView oddListView=(ListView)findViewById(R.id.lab3_list_odd);
        ListView evenListView=(ListView)findViewById(R.id.lab3_list_even);

        oddDatas=new ArrayList<>();
        evenDatas=new ArrayList<>();

        oddAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, oddDatas);
        evenAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, evenDatas);

        oddListView.setAdapter(oddAdapter);
        evenListView.setAdapter(evenAdapter);

        handler=new Handler();

        oneThread=new OneThread();
        oneThread.start();

        TwoThread twoThread=new TwoThread();
        twoThread.start();

    }


    
}
