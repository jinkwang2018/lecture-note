package kr.or.bit.ex09_intent_object;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    //상수값 (액티비티 구분값)
    public static final int REQUEST_CODE_ANOTHER = 1001;
    public static final int REQUEST_CODE_LOGIN = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showBtn = (Button)findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent : 우편물(하고 싶은 것들을 담아서)
                Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
                //1.startActivity(intent); //일반 화면 띄우기 (기존 Main 뒤로)
                startActivityForResult(intent,REQUEST_CODE_ANOTHER);
                // startActivityForResult : 띄워면 화면에서 무었인가를 돌려 받겠다
                //삼총사
                //1.startActivityForResult()
                //2.다른 UI -> setResult()
                //3.onActivityResult()

            }
        });
    }


    //자동 호출 되는 함수
    //새로 띄워진 액티비티에서 돌아왔을때 자동 호출 되는 호수
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ANOTHER){ //1001
            Toast toast = Toast.makeText(getApplicationContext(), "요청코드 : " + requestCode + "결과코드 : "
                    + resultCode, Toast.LENGTH_LONG);

            toast.show();
            if(resultCode == RESULT_OK){
                String name = data.getExtras().getString("name"); //key 값
                toast = Toast.makeText(getApplicationContext(),"응답 데이터 : " + name ,
                        Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}

