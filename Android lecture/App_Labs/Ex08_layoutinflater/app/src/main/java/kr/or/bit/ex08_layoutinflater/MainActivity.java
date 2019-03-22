package kr.or.bit.ex08_layoutinflater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startbtn  = (Button)findViewById(R.id.startButton);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflaterLayout();
            }
        });

    }

    //button.xml 에 정의되  layout 을
    //activity_main의 부분으로  가져오기 (화면의 일부로....)

    private void inflaterLayout(){

        //activity_main 가지고 있는 자원
        //button.xml LinearLayout 에 인플레이션 하겠다
        LinearLayout contentLayout = (LinearLayout)findViewById(R.id.contentlayout);

        //인플레이션(R.layout.button 객체화 되는 작업)//
        LayoutInflater inflater =  (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button, contentLayout, true);
        ////////////////

        Button btnselect = (Button)findViewById(R.id.btnSelect);

        final CheckBox allday = (CheckBox)findViewById(R.id.allday);


        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //체크 여부 확인
                if(allday.isChecked()){
                    allday.setChecked(false);
                }else{
                    allday.setChecked(true);
                }
            }
        });

    }

}

