package kr.or.bit.ex33_thread_handler2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    //기존 코드 :
    //class Pro extends  Handler{ public void handleMessage(){} }

    ProgressBar bar;
    TextView textView01;
    boolean isRunning = false;


    Handler handler;
    ProgressRunnable runnable;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar) findViewById(R.id.progress);
        textView01 = (TextView) findViewById(R.id.textView01);

        handler = new Handler();
        runnable = new ProgressRunnable();
    }

    public void onStart() {
        super.onStart();

        bar.setProgress(0);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 20 && isRunning; i++) {
                        Thread.sleep(1000);

                        //간략하게 사용하기
                        //아래 한줄을 통해서
                        //get 얻어내고 , send 하는 작업을 생략
                        //handler.post(Thread 구현하는 객체)

                        handler.post(runnable);
                    }
                } catch (Exception ex) {
                    Log.e("SampleThreadActivity", "Exception in processing message.", ex);
                }
            }
        });

        isRunning = true;
        thread1.start();
    }

    public void onStop() {
        super.onStop();

        isRunning = false;
    }


    public class ProgressRunnable implements Runnable {

        public void run() {

            //기존 handlemessage 에서 구현했던 코드
            bar.incrementProgressBy(5);

            if (bar.getProgress() == bar.getMax()) {
                textView01.setText("Runnable Done");
            } else {
                textView01.setText("Runnable Working ..." + bar.getProgress());
            }

        }

    }

}