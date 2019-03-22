package com.example.part9_24;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> datas;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lab1_listview);

        datas = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);

        //add~~~~~~~~~~~~~

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(wifiReceiver);
    }

    PhoneStateListener listener = new PhoneStateListener() {
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            //add~~~~~~~~~~~~~~~

        }

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            //add~~~~~~~~~~~~~~

        }

    };

    private void checkNetwork() {
        //add~~~~~~~~~~~~~~~

    }

    private void checkWifi(){
        //add~~~~~~~~~~~~~~~~

    }

    BroadcastReceiver wifiReceiver=new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //add~~~~~~~~~~~~~~~~~~~~
        }
    };


}
