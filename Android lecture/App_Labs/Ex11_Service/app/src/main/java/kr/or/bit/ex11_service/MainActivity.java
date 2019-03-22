package kr.or.bit.ex11_service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button)findViewById(R.id.button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //서비스를 시작 (UI 갖지 않는다) : 백그라운드 프로세스
                //주 구현은 : Thread 를 활용해서 만듬
                Intent intent = new Intent(getApplicationContext(),MyService.class);

                //일반 (UI)
                //startActivity();
                //startActivityForResult();

                startService(intent);  //시작
                // stopService(intent); //정지
                //service 구현한 클래스 정보는 AndroidMainfest.xml에
                //등록 :  <service android:name=".MyService" />


                //Spring 같은 경우 (환경설정 : web.xml)
                //안드로이드 같은 경우(manifests.xml) 담당

            }
        });
    }

    public void OnMainClick(View v){
        Toast.makeText(getApplicationContext(),"Main",Toast.LENGTH_SHORT).show();
    }


}
