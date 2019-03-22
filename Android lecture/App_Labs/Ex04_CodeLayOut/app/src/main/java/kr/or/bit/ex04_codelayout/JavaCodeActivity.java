package kr.or.bit.ex04_codelayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class JavaCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.login);
        //현재 UI구성하는 xml 파일 사용하지 않아요

        LinearLayout mainlayout = new LinearLayout(this);
        mainlayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT ,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Button button1 = new Button(this);
        button1.setText("Button1");
        button1.setLayoutParams(params);

        mainlayout.addView(button1);
        setContentView(mainlayout);

    }
}