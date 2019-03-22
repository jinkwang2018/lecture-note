package com.example.kosta.ex39_http_server_json;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText idET;
    private EditText passET;
    private EditText nameET;
    private EditText addressET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        Button getBtn = (Button) findViewById(R.id.getBtn);
        Button clearBtn=(Button)findViewById(R.id.clearBtn);

        // @Override     public void onClick(View v) { 이벤트 구현  }
        sendBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);


        idET = (EditText) findViewById(R.id.idET);
        passET = (EditText) findViewById(R.id.passET);
        nameET = (EditText) findViewById(R.id.nameET);
        addressET = (EditText) findViewById(R.id.addressET);
    }

   //코딩
    public void hideKeyBoard(){
        InputMethodManager im  =(InputMethodManager)this.getSystemService(
                this.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(nameET.getWindowToken(), 0);
    }


    // Activity implements View.OnClickListener
    @Override
    public void onClick(View v) {
        int id = v.getId();
        String command = null;
        try{
            if(id == R.id.getBtn){
                command="find";
                String mid = idET.getText().toString();

                //key point
                new NetService().execute(command,mid);
            }else if(id== R.id.sendBtn){
                command="register";
                String mid = idET.getText().toString();
                String password = passET.getText().toString();
                String name = nameET.getText().toString();
                String address = addressET.getText().toString();

                //key point (String 배열 > params)
                new NetService().execute(command,mid,password,name,address);


            }else{
                //clear 버튼
                idET.setText("");
                passET.setText("");
                nameET.setText("");
                addressET.setText("");
            }

        }catch (Exception e){
            Log.e("Http_Json",e.getMessage());
        }
    }
    //네트워크 연결 처리하는 작업 (AsyncTask  사용 (== Thread , Handler )

    public class NetService extends AsyncTask<String,Void ,String>{

        String command;
        String url = null;

        //요청
        @Override
        protected String doInBackground(String... params) {
            //String... params > 변수명이 params > ...배열
            //(id , name , addr)
            String p="";
            for(String data : params){
                p = data+" ";
            }
            Log.d("TEST" ,"doInBackground..." + p);
            command = params[0];
            String result="";
            if(command.equals("find")){
                url = "http://221.141.152.69:8090/Ex03_Web_Android_Client/FindServlet";

                result = netServer(url,"id="+params[1]) ; //네트워크 작업 요청

            }else if(command.equals("register")){
                url ="http://221.141.152.69:8090/Ex03_Web_Android_Client/RegisterServlet";
                StringBuilder paramdata = new StringBuilder();
                paramdata.append("id="+params[1]);
                paramdata.append("&password="+params[2]);
                paramdata.append("&name="+params[3]);
                paramdata.append("&address="+params[4]);

                result= netServer(url,paramdata.toString()); //코드 작업
            }

            return result;
        }

        //결과 처리(후)
        @Override
        protected void onPostExecute(String result) {
           if(command.equals("find")){
               Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
               //WAS 에 응답한 JSON DATA를 안드로이드  웹 에서 표현
               try{
                   JSONObject obj = new JSONObject(result); //{"address":"종로","name":"아이유"}
                   nameET.setText(obj.getString("name"));
                   addressET.setText(obj.getString("address"));
               }catch (Exception e){
                    Log.e("error",e.getMessage());
               }
           }else if(command.equals("register")){
               //작업을 해보세요
               Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
               try{
                   JSONObject obj = new JSONObject(result);
                   //was 에서 넘오 오는 값 : {"message":"kkk님 register ok!!"}
                   Toast.makeText(getApplicationContext(),obj.getString("message"),Toast.LENGTH_LONG).show();
                   idET.setText("");
                   passET.setText("");
                   nameET.setText("");
                   addressET.setText("");

               }catch (Exception e){
                   Log.e("error",e.getMessage());
               }
           }
        }
    }



    //실 네트워크 연결(서버 연결 코드 구현)
    public String netServer(String url , String param){
       StringBuffer responseData = null;
       try{
           //key point
           URL urlObj = new URL(url);
           HttpURLConnection conn = null;
           conn = (HttpURLConnection)urlObj.openConnection();
           //conn 객체에 대한 기본 속성 설정하기
           conn.setDoInput(true);
           conn.setDoOutput(true);
           conn.setUseCaches(false);
           conn.setRequestMethod("POST");
           conn.setAllowUserInteraction(true);
           conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

           //서버요청
           //conn.getOutputStream() >
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"),true);
           pw.write(param);
           pw.flush();

           //응답 처리
           int rescode = conn.getResponseCode(); //로직 rescode == 200 (OK)
           Log.d("resCode",rescode + " " + param);
           BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
           String str;
           responseData  = new StringBuffer();
           while((str = br.readLine())!= null){
               responseData.append(str + "\n");

           }
           pw.close();
           br.close();

       }catch (Exception e){
            Log.e("NetService",e.getMessage(),e);

       }
      return responseData.toString();
    }

}




