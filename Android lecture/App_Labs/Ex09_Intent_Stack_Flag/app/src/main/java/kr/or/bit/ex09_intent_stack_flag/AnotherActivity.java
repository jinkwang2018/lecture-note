package kr.or.bit.ex09_intent_stack_flag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends Activity {
    Button backBtn;
    TextView txtMsg;
    String msg;

    int startCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anothor);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        backBtn = (Button) findViewById(R.id.BackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
                newIntent.putExtra("startCount", startCount);
                /*

                    가장 일반적인 방법
                     Intent resultIntent = new Intent();
                        //Intent 부가데이터
                        resultIntent.putExtra("name","kglim"); //extra 부가데이터
                       setResult(RESULT_OK,resultIntent);     //데이터를 보내는 방법
                      finish(); //자기자신 소멸
                * */


                //Flag 값을 활용하기 위한 방법
                //여기는 플래그 태스트 코드 입력 예정
                //newIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //newIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)

                //1.No_FLAG (계속 새로운 화면을 띄운다)
                //2.FLAG_ACTIVITY_SINGLE_TOP || FLAG_ACTIVITY_CLEAR_TOP (기존 화면 재사용)
                //이렇게 하다보니 onCreate() 에서 사용했던 메서드 호출 안되요
                //그래서 > onNewIntent(Intent intent) 메서드를 통해서 필요한 함수 호출

                startActivity(newIntent);

            }
        });
        processIntent();
    }

    private void processIntent() {
        Intent receivedIntent = getIntent();
        startCount = receivedIntent.getIntExtra("startCount", 0);

        msg = "전달된 startCount : " + startCount;
        txtMsg.setText(msg);
    }

}