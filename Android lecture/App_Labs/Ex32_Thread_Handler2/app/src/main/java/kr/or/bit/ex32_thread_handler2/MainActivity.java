package kr.or.bit.ex32_thread_handler2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
/**
 * 스레드를 이용해 프로그레스바를 보여주는 방법에 대해 알 수 있습니다.
 * 별도로 만든 스레드에서 메인 스레드를 접근할 때 핸들러를 사용해야 한다는 것을 알 수 있습니다.
 */
public class MainActivity extends AppCompatActivity {

    /*
     * 프로그레스바
     */
    ProgressBar bar;
    TextView textView01;
    boolean isRunning = false;
    ProgressHandler handler;

    /*
     * 메인 스레드의 UI에 접근하기 위한 핸들러
     * 별도의 서브 스레드가 메인 스레드의 UI 요소에 접근 하는 방법
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar)findViewById(R.id.progress);
        textView01 = (TextView)findViewById(R.id.textView01);

        //핸들러 객체 생성
        handler = new ProgressHandler();


    }


    public void onStart() {
        super.onStart();

        bar.setProgress(0);
        //쓰레드 활용하기
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i = 0 ; i<20 && isRunning;i++ ){
                        Thread.sleep(1000);
                        //여기서 부터//////////////////////////
                        //1초마다 핸들러로 메시지 객체 전송

                        //새로 만든 스레드가 수행하려는 정보를 메인스레드에 전달하기 위해서는
                        //먼저 핸들러가 관리하는 MessageQueue 에서 처리할 수 있는 핸들러 객체
                        //하는 참조
                        //이때 활용하는 것이 : handler.obtainMessage();
                        //                   호출의결과로  Message 객체를 리턴
                        //여기서 필요하다면  : Message 객체에 정보를 넣은후 다시 메시지 큐에 넣는다

                        //그럼 메시지큐에 들어간 순서대로 핸들러가 처리 이때
                        //handleMessage 의 구현 코드가 실행된다
                        //handleMessage코드가 수행되는 위치는 메인 스레드가 된다


                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                        //////////////////////////////////////
                    }
                }catch (Exception e){

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

    public class ProgressHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            //여기 있는 작업 MainThread UI 가지고 있는 쪽에서 실행
            bar.incrementProgressBy(5);
            if(bar.getProgress() == bar.getMax()){
                textView01.setText("Progress Bar DONE ...");
            }else{
                textView01.setText("Loading ..." + bar.getProgress());
            }

        }
    }



}
