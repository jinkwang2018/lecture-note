package com.example.kosta.ex38_android_weblogin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends Activity {

    private EditText id;
    private EditText passwd;
    private ProgressDialog pDialog;
    private LinearLayout layout01;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText)findViewById(R.id.id);
        passwd = (EditText)findViewById(R.id.passwd);
        button = (Button)findViewById(R.id.loginButton);
        layout01 = (LinearLayout)findViewById(R.id.layout01);

        button.setOnClickListener(new View.OnClickListener() {

            //별도의 Thread 사용 여부 -> 한다면 -> MainActive(UI) 접근 -> Handler
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //로그인 처리 Method 호출
                //loginProcess();
                loginProcess();
            }
        });

    }

    private final	Handler handler = new Handler(){
        //사용목적 : 별도의 쓰레드를 통한 업무 구현 ... Main UI접근
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            //다이얼로그 창 제어
            pDialog.dismiss(); //창 없애기

            String result = msg.getData().getString("RESULT");
            if(result.equals("success")){
                layout01.setBackgroundColor(Color.GRAY); //Handle 목적
                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_LONG).show();
            } else{
                layout01.setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(), "로그인 실패",Toast.LENGTH_LONG).show();
            }
        }

    };

	/*
	 * 이런식의 표현도 가능 .....
	 * class innerHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
		}

	}*/
    //innerHandler h = new i......


    //함수 (xml 객체 다룰 수 있는 함수)
    //    (json)
    public String parsingData(InputStream input){
        String result = null;
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new InputStreamReader(input)); //xml 데이를 read parser 객체가 가지고 있다
            while(parser.next() != XmlPullParser.END_DOCUMENT){
                String name = parser.getName();
                if(name != null && name.equals("result")){
                    result = parser.nextText(); //<result>success</result>  or <result>fail</result>
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public void loginProcess(){
        //콜백함수 (Http 요청을 하고나서 Response가 오면 호출되는 함
        final ResponseHandler<String> responsehandler = new ResponseHandler<String>() {
            //요청 응답(response) 자동 호출 함수 handleResponse
            @Override
            public String handleResponse(HttpResponse response)
                    throws ClientProtocolException, IOException {
                String result = null;

                HttpEntity entity = response.getEntity();
                //받은 데이터가 XML형태이기 때문에 (해석 작업) => 함수
                result = parsingData(entity.getContent()); //success or fail
                //result 메인화면 UI 제어
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                if(result.endsWith("success")){
                    bundle.putString("RESULT", "success");
                }else{
                    bundle.putString("RESULT", "fail");
                }
                message.setData(bundle);
                handler.sendMessage(message);

                return result;
            }

        };

        //loginProcess 함수 호출 - 1
        pDialog = ProgressDialog.show(this, "","로그인 처리중....");


        //서버 요청 작업 처리 (별도의 Thread 구현)
        new Thread(){

            @Override
            public void run() {
                System.out.println("RUN");
                String url = "http://192.168.7.88:8090/Ex02_Web_Login/login.jsp";
                //http 요청 처리 객체
                HttpClient http = new DefaultHttpClient();
                try{
                    //파라메터 설정 작업
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("id", id.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("pwd", passwd.getText().toString()));


                    //HTTP 서버에 요청 처리
                    HttpPost httpost = new HttpPost(url);
                    UrlEncodedFormEntity entityRequest = new UrlEncodedFormEntity(nameValuePairs,"UTF-8");
                    httpost.setEntity(entityRequest);

                    //전송
                    http.execute(httpost, responsehandler);
                    //응답이 넘어오면 responsehandler 가 구현하고 있는handleResponse() 호출
                }catch(Exception e){

                }

            }

        }.start();

    }

	}