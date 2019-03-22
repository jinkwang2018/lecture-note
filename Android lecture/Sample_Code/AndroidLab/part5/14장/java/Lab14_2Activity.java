package com.example.part5_14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Lab14_2Activity extends AppCompatActivity implements View.OnClickListener{
    Button contactsBtn;
    Button cameraDataBtn;
    Button cameraFileBtn;
    Button speechBtn;
    Button mapBtn;
    Button browserBtn;
    Button callBtn;

    TextView resultView;
    ImageView resultImageView;

    File filePath;

    int reqWidth;
    int reqHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab14_2);

        resultView=(TextView)findViewById(R.id.resultView);
        contactsBtn=(Button)findViewById(R.id.btn_contacts);
        cameraDataBtn=(Button)findViewById(R.id.btn_camera_data);
        cameraFileBtn=(Button)findViewById(R.id.btn_camera_file);
        speechBtn=(Button)findViewById(R.id.btn_speech);
        mapBtn=(Button)findViewById(R.id.btn_map);
        browserBtn=(Button)findViewById(R.id.btn_browser);
        callBtn=(Button)findViewById(R.id.btn_call);
        resultImageView=(ImageView)findViewById(R.id.resultImageView);

        contactsBtn.setOnClickListener(this);
        cameraDataBtn.setOnClickListener(this);
        cameraFileBtn.setOnClickListener(this);
        speechBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
        browserBtn.setOnClickListener(this);
        callBtn.setOnClickListener(this);
        resultImageView.setOnClickListener(this);

        reqWidth = getResources().getDimensionPixelSize(R.dimen.request_image_width);
        reqHeight = getResources().getDimensionPixelSize(R.dimen.request_image_height);
    }

    @Override
    public void onClick(View v) {

    }
}
