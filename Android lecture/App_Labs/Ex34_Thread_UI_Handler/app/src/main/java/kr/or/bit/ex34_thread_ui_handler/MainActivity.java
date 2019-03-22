package kr.or.bit.ex34_thread_ui_handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview01 = (TextView)findViewById(R.id.textview01);

        Button requestBtn = (Button)findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //요청 함수 하나 생성 호출
                request();
            }
        });

    }
    private void request(){
        String title = "원격요청";
        String message = "데이터 요청 하시겠습니까";
        String titleButtonYes = "예";
        String titleButtonNo = "아니오";

        //Dialog 세팅하는 함수를 만들고 .... 호출
        AlertDialog dialog = makeRequestDialog(title, message, titleButtonYes, titleButtonNo);
        dialog.show();

        textview01.setText("원격 데이터 요청 중...");
    }
    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence titleButtonyes,CharSequence titleButtonNo)
    {
        AlertDialog.Builder requestDailog = new AlertDialog.Builder(this);
        requestDailog.setTitle(title);
        requestDailog.setMessage(message);
        requestDailog.setPositiveButton(titleButtonyes, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //예버튼 클릭시  처리코드
                RequestHandler handler = new RequestHandler();
                handler.sendEmptyMessageDelayed(0, 10);
            }
        });
        requestDailog.setNegativeButton(titleButtonNo, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });

        return  requestDailog.show();
    }


    //요청 스레드
    class RequestHandler extends Handler{

        //Main Thread UI요소 접근
        @Override
        public void handleMessage(Message msg) {
            for(int i = 0 ; i <10 ;i++){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
            textview01.setText("원격 데이터 요청 완료");

        }

    }




}
