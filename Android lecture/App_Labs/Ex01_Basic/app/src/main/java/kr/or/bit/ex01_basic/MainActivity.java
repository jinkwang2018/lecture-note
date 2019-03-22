package kr.or.bit.ex01_basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
  1.클래스 구조 : ctrl + shift + /
              마우스 오른쫀 : go to
  2. Activity : 하나의 화면 (UI) : xml
     -setContentView(): 화면에 무었을 보여줄지 결정 (layout.xml) 로드
     -접근방법(R.layout.xml 파일 이름)

  3. Intent : 어떤 기느을 수행할지를 지정하기 위해서 사용되는 객체


  4. Toast : 화면에 메시지를 출력하는 객체

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //자바코드
        /*
          res 접근 방법 > R (res 폴더)  > R.layout (레이아웃 xml)
                                      > R.id (component 식별값)
        */
        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() { //인터페이스 직접 구현(1회성)
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"배고파요",Toast.LENGTH_LONG).show();

                //새로운 화면 띄우기
                //Intent 객체 활용
                //Intent : 전달객체 ...
                Intent myintent = new Intent(getApplicationContext(),NewAct.class);
                startActivity(myintent); //시작하는 화면 (intent 를 통해서 전환)
            }
        });



    }

    public void btnClick2(View v){ //lay_out.xml 이벤트 등록 android:onClick="btnClick2"
        Toast.makeText(getApplicationContext(),"버튼2",Toast.LENGTH_LONG).show();
    }
}
