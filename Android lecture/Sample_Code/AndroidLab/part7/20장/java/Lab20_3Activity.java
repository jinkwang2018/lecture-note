package com.example.part7_20;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab20_3Activity extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnClickListener{

    TabHost host;
    ListView serviceListView;
    ListView appListView;
    ListView pickListView;

    ArrayList<HashMap<String, String>> appsDatas;
    ArrayList<HashMap<String, String>> serviceDatas;

    SimpleAdapter appsAdapter;
    SimpleAdapter serviceAdapter;
    SimpleAdapter pickAdapter;

    Button alarmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab20_3);

        host=(TabHost)findViewById(R.id.lab3_host);
        serviceListView=(ListView)findViewById(R.id.lab3_service);
        appListView=(ListView)findViewById(R.id.lab3_apps);
        pickListView=(ListView)findViewById(R.id.lab3_pick);
        alarmBtn=(Button)findViewById(R.id.lab3_btn);

        host.setup();
        host.setOnTabChangedListener(this);
        alarmBtn.setOnClickListener(this);

        TabHost.TabSpec spec=host.newTabSpec("tab1");
        spec.setIndicator("service");
        spec.setContent(R.id.lab3_service);
        host.addTab(spec);

        spec=host.newTabSpec("tab2");
        spec.setIndicator("apps");
        spec.setContent(R.id.lab3_apps);
        host.addTab(spec);

        spec=host.newTabSpec("tab3");
        spec.setIndicator("action : PICK");
        spec.setContent(R.id.lab3_pick);
        host.addTab(spec);

        registerReceiver(receiver, new IntentFilter("com.example.ACTION_TO_ACTIVITY"));
    }

    BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast toast=Toast.makeText(Lab20_3Activity.this, intent.getStringExtra("message"), Toast.LENGTH_SHORT);
            toast.show();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        
    }

    @Override
    public void onTabChanged(String tabId) {
        
    }

}

