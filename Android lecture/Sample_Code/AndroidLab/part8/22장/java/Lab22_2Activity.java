package com.example.part8_22;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lab22_2Activity extends AppCompatActivity  {
    ImageView onOffView;
    TextView latitudeView;
    TextView longitudeView;
    TextView accuracyView;
    TextView timeView;

    //add~~~~~~~~~~~~~~

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab22_2);

        onOffView = (ImageView) findViewById(R.id.lab2_onOffView);
        latitudeView = (TextView) findViewById(R.id.lab2_latitude);
        longitudeView = (TextView) findViewById(R.id.lab2_longitude);
        accuracyView = (TextView) findViewById(R.id.lab2_accuracy);
        timeView = (TextView) findViewById(R.id.lab2_time);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        }

        //add~~~~~~~~~~~~~~~~~~~

    }

    private void showToast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
    private void setLocationInfo(Location location){
        if(location != null){
            latitudeView.setText(String.valueOf(location.getLatitude()));
            longitudeView.setText(String.valueOf(location.getLongitude()));
            accuracyView.setText(String.valueOf(location.getAccuracy()+" m"));
            Date date=new Date(location.getTime());
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            timeView.setText(sd.format(date));
            onOffView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_on, null));
        }else {
            showToast("location null....");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //add~~~~~~~~~~~~~~~
    }

    //add~~~~~~~~~~~~~~~~~~

}

