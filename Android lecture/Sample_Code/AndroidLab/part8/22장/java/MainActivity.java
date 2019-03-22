package com.example.part8_22;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView onOffView;
    TextView allProviderView;
    TextView enableProviderView;
    TextView providerView;
    TextView latitudeView;
    TextView longitudeView;
    TextView accuracyView;
    TextView timeView;

    LocationManager manager;

    List<String> enabledProviders;
    float bestAccuracy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onOffView = (ImageView) findViewById(R.id.lab1_onOffView);
        allProviderView = (TextView) findViewById(R.id.lab1_allProviders);
        enableProviderView = (TextView) findViewById(R.id.lab1_enableProviders);
        providerView = (TextView) findViewById(R.id.lab1_provider);
        latitudeView = (TextView) findViewById(R.id.lab1_latitude);
        longitudeView = (TextView) findViewById(R.id.lab1_longitude);
        accuracyView = (TextView) findViewById(R.id.lab1_accuracy);
        timeView = (TextView) findViewById(R.id.lab1_time);

        //add~~~~~~~~~~~~~~~~~~~

    }

    private void showToast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getProviders();
                getLocation();
            } else {
                showToast("no permission...");
            }
        }
    }

    private void getProviders(){
        //add~~~~~~~~~~~~~~

    }

    private void getLocation(){
        //add~~~~~~~~~~~~~

    }
    private void setLocationInfo(String provider, Location location){
        //add~~~~~~~~~~~~~~~~

    }

}
