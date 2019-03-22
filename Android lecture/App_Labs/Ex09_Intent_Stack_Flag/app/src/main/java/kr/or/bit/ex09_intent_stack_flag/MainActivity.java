package kr.or.bit.ex09_intent_stack_flag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button showBtn;
    TextView txtMsg;
    String msg;

    //요청코드
    public static final int REQUEST_CODE_ANOTHER=1001;

    //시작횟수////////////////////
    public static int startCount=0;
    /////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView)findViewById(R.id.txtMsg);
        showBtn = (Button)findViewById(R.id.ShowBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startCount++; //

                Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                intent.putExtra("startCount", startCount);

                startActivityForResult(intent, REQUEST_CODE_ANOTHER);

            }
        });

        //전달받은 인텐트를 처리하는 함수 가 호출 되느냐
        processIntent();
    }

    //이미 만들어져 있는 액티비티를 다시 띄울때 인텐트의 처리 방법 ????????
    //액티비티가 이미 메모리상에 객체로 만들어져 있는 경우에는  액티비티를 다시 띄우더라도
    //onCreate()를 타지 않으므로 ..... 머리가 .....
    //위 문제 때문에 위 문제를 해결하는 메서드가 필요
    //호출하는 액티비티로 부터 전달되는 인텐트를 받아서 처리할 수 있도록 하는 메서드가
    // => onNewIntent
  /*
    @Override
  protected void onNewIntent(Intent intent) {

        // TODO Auto-generated method stub
        processIntent();
        super.onNewIntent(intent);
    }*/



    private void processIntent(){
        //초기화
        Log.d("gogo","gogo");
        Intent receivedIntent = getIntent();
        startCount = receivedIntent.getIntExtra("startCount", 10);
        Toast toast = Toast.makeText(getApplicationContext(),"Process",Toast.LENGTH_LONG);
        toast.show();
        msg = "전달된 startCount : " + startCount ;
        txtMsg.setText(msg);
    }

    //새로운 액티비티에서 돌아올때 자동 호출되는 함수(메서드)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ANOTHER){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "onActivieyResult()호춯 :" +requestCode +
                            "결과 코드 : " + requestCode
                    , Toast.LENGTH_LONG);
            toast.show();

        }
    }



}