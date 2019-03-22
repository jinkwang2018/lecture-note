package com.example.kosta.ex35_thared_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * AsyncTask 를 이용하여 백그라운드 작업을 실행하는 방법에 대해 알 수 있습니다.
 * 안드로이드에서는 Thread 클래스, Runnable 인터페이스 외에
 * 백그라운드 작업을 수행할 수 있는 또 다른 클래스가 있습니다.
 * 그것은 바로 [ AsyncTask ]입니다.
 * 이것은 하나의 클래스로 [ 백그라운드 작업 ]과 [ UI 업데이트 ]를 모두 할 수 있음을
 * 의미합니다. 그리고 사전, 사후 처리를 할 수 있는 메소드들도 있어 편리합니다

 AsyncTask의 특징

 백그라운드 작업을 수행하는 메소드  [ doInBackground ]
 백그라운드 수행을 작업하기 전에 실행되는 메소드 [ onPreExecute ]
 백그라운드 작업을 수행하면서 중간 결과를 보여줄 수 있는 메소드 [ onProgressUpdate ]
 백그라운드 수행을 마친 후 실행되는 메소드 [ onPostExecute]
 onPreExecute, onProgressUpdate, onPostExecute, onCancelled
 메소드들은 [ UI 업데이트 ] 를 할 수 있습니다.
 따라서 [ 별도의 핸들러 클래스 ]를 정의할 필요가 없습니다.
 cancel 메소드를 호출하여 백그라운드 수행을 취소할 수 있습니다.
 백그라우드 작업 취소 후 실행되는 메소드 onCancelled가 있습니다.



 AsyncTask

 백그라우드 작업을 하기위해서는 스레드, 핸들러 등을 각각 만들어야 하고
 작업중에 핸들러를 주기적으로 호출해야하는 번거로움이 있다.
 이런 작업을 대신 수행해주는 도우미 클래스가 AsyncTask 이다.

 내부적으로 작업 스레드를 생성하며 필요할때마다 UI스레드에서 실행되는 콜백메서드를 호출한다.

 API문서 참고 : http://developer.android.com/reference/android/os/AsyncTask.html


 AsyncTask는 자체는 추상클래스이므로 파생클래스를 생성하고 콜백 메서드를 구현해야한다.
 AsyncTask는 다음과 같이 사용하며 제네릭인수록 세가지 타입을 전달받는데 미사용 타입에 대해서는 Void라고 적는다.

 private class MyTask extends AsyncTask<Void, Void, Void> { ... }


 Params : 실행할때 전달할 인수의 타입이다. 즉 배경 작업거리이다.
 Progress: 매 작업 단계마다 진행상태를 표기하는 타입이다.
 Result : 작업의 결과로 리턴될 타입이다.


 AsyncTask 콜백 메서드

 void onPreExecute()

 Result doInBackground(Params... params)

 void onProgressUpdate (Progress.. value)

 void onPostExecute (Result result)

 void onCancelled()
 cancel 메서드로 작업을 취소했을 때 호출되며 UI스레드에서 실행된다.


 UI스레드에서 호출하는 메서드

 AsyncTask<Params, Progress, Result> execute (Params... params)

 boolean cancel (boolean mayInterruptIfRunning)
 boolean isCancelled()

 Result get([long timeout, TimeUnit unit])

 AsyncTask.Status getStatus()

 */
public class MainActivity extends Activity {

    TextView textView01;
    ProgressBar progress;
    BackgroundTask task;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView01 = (TextView) findViewById(R.id.textView01);
        progress = (ProgressBar) findViewById(R.id.progress);

        // 실행 버튼 이벤트 처리
        Button executeBtn = (Button) findViewById(R.id.executeBtn);
        executeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 새로운 Task 객체를 만들고 실행
                task = new BackgroundTask();
                task.execute(100);
            }
        });

        // 취소 버튼 이벤트 처리
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                task.cancel(true);
            }
        });
    }

    /**
     * 새로운 Task 객체를 정의
     *  AsyncTask<Params, Progress, Result>
     *       Result doInBackground(Params... params)
             void onProgressUpdate (Progress.. value)
             void onPostExecute (Result result)
     *
     */
    class BackgroundTask extends AsyncTask<Integer , Integer , Integer> {
        protected void onPreExecute() {
            value = 0;
            progress.setProgress(value);
        }

        protected Integer doInBackground(Integer ... values) {
            while (isCancelled() == false) {
                value++;
                if (value >= 100) {
                    break;
                } else {
                    publishProgress(value);

                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {}
            }

            return value;
        }

        protected void onProgressUpdate(Integer ... values) {
            progress.setProgress(values[0].intValue());
            textView01.setText("Current Value : " + values[0].toString());
        }

        protected void onPostExecute(Integer result) {
            progress.setProgress(0);
            textView01.setText("Finished.");
        }

        protected void onCancelled() {
            progress.setProgress(0);
            textView01.setText("Cancelled.");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
