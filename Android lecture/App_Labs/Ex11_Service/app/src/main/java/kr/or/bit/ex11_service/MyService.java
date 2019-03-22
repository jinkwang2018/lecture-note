package kr.or.bit.ex11_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 */
public class MyService extends Service implements Runnable {

    public static final String TAG = "MyService";
    private int count=0;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread myThread = new Thread(this);
        myThread.start(); //스레드 동작

    }


    @Override
    public void run() {

        while(true){
            try {
                Log.i(TAG,"My service Called : " + count);
                count++;
                Thread.sleep(5000);
            }catch (Exception e){
                Log.e(TAG,e.toString());
            }
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
