package kr.or.bit.ex10_activity_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AnotherActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another);

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", "kglim");

                setResult(RESULT_OK, resultIntent);
                finish(); //현재 액티비티는 종료

            }
        });
        Toast.makeText(getApplicationContext(), "NEW onCreate()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "NEW onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(getApplicationContext(), "NEW onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(getApplicationContext(), "NEW onRestart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Toast.makeText(getApplicationContext(), "NEW onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(getApplicationContext(), "NEW onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(getApplicationContext(), "NEW onStop()", Toast.LENGTH_LONG).show();
    }

}
