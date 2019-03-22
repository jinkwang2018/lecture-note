package com.example.part9_25;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView titleView;
    TextView dateView;
    TextView contentView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView=(TextView)findViewById(R.id.lab1_title);
        dateView=(TextView)findViewById(R.id.lab1_date);
        contentView=(TextView)findViewById(R.id.lab1_content);
        imageView=(ImageView)findViewById(R.id.lab1_image);

        //add~~~~~~~~~~~~~~~~~~~~~
        

    }

    HttpCallback httpCallback=new HttpCallback() {
        @Override
        public void onResult(String result) {
            //add~~~~~~~~~~~~~~
        }
    };

    HttpImageCallback imageCallback=new HttpImageCallback() {
        @Override
        public void onResult(Bitmap d) {
            //add~~~~~~~~~~~~
            
        }
    };

}
