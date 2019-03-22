package com.example.part9_27;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Lab27_2Activity extends AppCompatActivity {
    TextView proximityView;
    TextView accelerometerView;

    SensorManager manager;
    //근접센서
    Sensor proximity;
    //가속도 센서
    Sensor accelerometer;

    //근접센서 max 값.
    float proximityMaximumRange;
    //가속도 센서 이전값
    float lastX;
    float lastY;
    float lastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab27_2);

        proximityView = (TextView) findViewById(R.id.lab2_proximity);
        accelerometerView=(TextView)findViewById(R.id.lab2_accelerometer);

        //add~~~~~~~~~~~~~~~~~~~~~


    }

    @Override
    protected void onResume() {
        super.onResume();
        //add~~~~~~~~~~~~~~~

    }

    @Override
    protected void onPause() {
        super.onPause();
        //add~~~~~~~~~~~~~~~
    }

    
    //add~~~~~~~~~~~~~~~~~~~~~
    
}