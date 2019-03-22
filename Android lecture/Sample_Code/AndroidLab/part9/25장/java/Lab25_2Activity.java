package com.example.part9_25;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Lab25_2Activity extends AppCompatActivity {
    TextView titleView;
    TextView dateView;
    TextView contentView;
    NetworkImageView imageView;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab25_2);

        titleView = (TextView) findViewById(R.id.lab2_title);
        dateView = (TextView) findViewById(R.id.lab2_date);
        contentView = (TextView) findViewById(R.id.lab2_content);

        //add~~~~~~~~~~~~~~~


        



    }
}
