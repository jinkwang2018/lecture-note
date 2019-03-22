package kr.or.bit.ex02_intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     *    Intent : 시스템 자원 배달 : 전화기능 (전화 번호 전달) , 우편배달부
     *                                             브라우져 (url 주소값 전달)
     */
    public void webClick(View v){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myintent);
    }

    public void hpClick(View v){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8360-5668"));
        startActivity(myintent);
    }
}
