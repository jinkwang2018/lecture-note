package com.example.bit.ex01_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //자바코드
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() { //인터페이스 직접 구현(1회성)
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"배고파요", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void btnClick2(View v){ //lay_out.xml에 이벤트 등록하고 사용하는 방식이다.  android:onClick="btnClick2"
        Toast.makeText(getApplicationContext(), "버튼2", Toast.LENGTH_LONG).show();
    }
}
