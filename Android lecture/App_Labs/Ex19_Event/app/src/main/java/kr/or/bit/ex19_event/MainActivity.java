package kr.or.bit.ex19_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1 , button2 , button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3.제일 많이 사용하는 방법
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Process("내부 무명 클래스 사용");

            }
        });

        //4.inner class 사용해서 이벤트 처리하기
        button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new ButtonClick());


        //2.
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        //this 통해서 MainActivity 구현한 클릭 이벤트 함수 호출
        //안에서 어떤 버튼에 의해서 클릭되었는 확인하는 작업
    }




    //1. 속성값 사용하기
    public void MyClick(View v){
        Process("속성값(xml) 설정 이벤트 처리");
    }

    //2. 클릭 이벤트 Activity 가 가지고 있다
    @Override
    public void onClick(View v) {
        //안쪽에서 판단 (버튼의 id 판단 로직 처리)
        if(v.getId() == R.id.button3) {
            Process("MainActivity 가 리스너 구현");
            //}else(v.getId() == R.id.button4){

            //}
        }
    }

    private void Process(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

       //inner class (Outer class 의 자원을 그대로 사용할 수 있다
    class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Process("Inner Class 사용");
        }
    }

}
