package kr.or.bit.ex09_intent_object;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);

        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //전달 (Intent)
                Intent resultIntent = new Intent();
                //Intent 부가데이터
                resultIntent.putExtra("name","kglim"); //extra 부가데이터
                setResult(RESULT_OK,resultIntent);     //데이터를 보내는 방법
                finish();

               // public static final int RESULT_CANCELED    = 0;
                /** Standard activity result: operation succeeded. */
               // public static final int RESULT_OK       = -1;

            }
        });
    }


}
