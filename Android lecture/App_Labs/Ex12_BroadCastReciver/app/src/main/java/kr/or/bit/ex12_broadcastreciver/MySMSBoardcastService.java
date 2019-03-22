package kr.or.bit.ex12_broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by KOSTA on 2015-07-14.
 */
public class MySMSBoardcastService extends BroadcastReceiver {
    //Log.i("MySMSBoardcastService","onReceive called");
    //자동 호출되는 함수

    @Override
    public void onReceive(Context context, Intent intent) {
       Log.i("MySMSBoardcastService", "onReceive called");
       if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
           Intent myintent = new Intent(context,MainActivity.class);
           myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           context.startActivity(myintent);
       }


    }
}
