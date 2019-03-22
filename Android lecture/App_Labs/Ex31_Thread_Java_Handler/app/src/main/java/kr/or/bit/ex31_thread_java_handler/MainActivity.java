package kr.or.bit.ex31_thread_java_handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/**
 * 자바에서 사용하는 일반적인 스레드 기능을 그대로 사용할 수 있다는 것을 알 수 있습니다.
 *
 */
public class MainActivity extends AppCompatActivity {

    private int value=0;
    private boolean running = false;

    TextView textview01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBtn = (Button)findViewById(R.id.showBtn);
        textview01 = (TextView)findViewById(R.id.textView01);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview01.setText("스레드에서 얻은 값 : " + value);
            }
        });

    }

    /**
     * 화면 보일 때 스레드 시작
     */
    protected void onResume() {
        super.onResume();
        running = true;
        Thread thread1 = new BackgroundThread();
        thread1.start();

    }

    /**
     * 화면 안보일 때 스레드 중지
     */
    protected void onPause() {
        super.onPause();
        running = false;
        value=0;


    }

    /**
     * 스레드 정의
     */
    class BackgroundThread extends Thread {

        @Override
        public void run() {
            while(running){
                try{
                    Thread.sleep(1000);

                    value++; //1씩 증가

                    //문제 : 여기 쓰레드에서 직접 UI 접근
                    //textview01.setText(value);

                }catch (Exception ex){
                    Log.e("Thread 예외",ex.getMessage());
                }
            }
        }
    }



}

