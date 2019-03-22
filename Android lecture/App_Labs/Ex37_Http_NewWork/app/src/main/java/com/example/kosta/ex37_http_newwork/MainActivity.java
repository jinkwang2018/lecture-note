package com.example.kosta.ex37_http_newwork;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {

    EditText input01;
    TextView txtMsg;

    public static String defaultUrl = "http://m.naver.com";

    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input01 = (EditText) findViewById(R.id.input01);
        input01.setText(defaultUrl);

        txtMsg = (TextView) findViewById(R.id.txtMsg);

        // 버튼 이벤트 처리
        Button requestBtn = (Button) findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String urlStr = input01.getText().toString();

                ConnectThread thread = new ConnectThread(urlStr);
                thread.start();

            }
        });

    }


    /**
     * 소켓 연결할 스레드 정의
     */
    class ConnectThread extends Thread {
        String urlStr;

        public ConnectThread(String inStr) {
            urlStr = inStr;
        }

        public void run() {

            try {
                final String output = request(urlStr); //Network 작업 요청
                handler.post(new Runnable() {
                    public void run() {
                        txtMsg.setText(output); //MainThread UI 자원 접근 (Handler)
                    }
                });

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        }


        //Network 연결 작업
        //API22 상위버전에서도 사용가능한 Network 관련 클래스
        private String request(String urlStr) {
            StringBuilder output = new StringBuilder();
            try {
                //코드 구현
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection(); //API22 부터 권장사항
                if(conn !=null){
                    conn.setConnectTimeout(10000); //기본 설정
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoInput(true);

                    int resCode = conn.getResponseCode();
                    if(resCode == HttpURLConnection.HTTP_OK){
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line = null;
                        while(true){
                            line = reader.readLine();
                            if(line == null){
                                break;
                            }
                            output.append(line + "\n");
                        }
                        reader.close();
                        conn.disconnect();

                    }

                }

            } catch(Exception ex) {
                Log.e("SampleHTTP", "Exception in processing response.", ex);
            }

            return output.toString();
        }

    }




}
