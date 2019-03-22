package com.example.kosta.ex36_android_socket_client;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends Activity {

    EditText input01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input01 = (EditText)findViewById(R.id.input01);
        Button conBtn = (Button)findViewById(R.id.button01);
        conBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String addr = input01.getText().toString().trim();
            Toast.makeText(getApplicationContext(),addr,Toast.LENGTH_SHORT).show();

            //안드로이드에서 네트워크 사용은 Thread 사용해야 합니다
            ConnectThread thread = new ConnectThread(addr);
            thread.start();

        }
    });

    }

    //inner class 사용
    //소켓 설정 및 연결 쓰레드 사용
    class ConnectThread extends Thread{
        String hostname;

        public ConnectThread(String addr){
            hostname = addr;
        }

        public void run(){
            try{
                int portNumber = 9999;
                Socket socket = new Socket(hostname,portNumber);


                //Server Write
                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("Hello Android Data ^^");
                outstream.flush();

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                String obj = (String)instream.readObject();

                Log.d("MainActivity", "서버에서 받은 메시지" + obj);

                socket.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


}