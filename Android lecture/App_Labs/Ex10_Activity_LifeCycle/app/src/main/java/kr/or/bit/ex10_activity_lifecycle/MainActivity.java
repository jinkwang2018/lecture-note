package kr.or.bit.ex10_activity_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ANOTHER=1004;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBtn = (Button)findViewById(R.id.ShowBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        AnotherActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ANOTHER);
            }
        });
        Toast.makeText(getApplicationContext(), "Main_onCreate()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Main_onDestroy()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(getApplicationContext(), "Main_onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Main_onRestart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Toast.makeText(getApplicationContext(), "Main_onResume()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(getApplicationContext(), "Main_onStart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(getApplicationContext(), "Main_onStop()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ANOTHER){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "onActivityResult 호출 : 응답코드=> " +  requestCode +
                            "resultCode => " + resultCode
                    ,Toast.LENGTH_LONG);
            toast.show();
        }
        if(resultCode == RESULT_OK){
            String name = data.getExtras().getString("name");
            Toast toast = Toast.makeText(getApplicationContext(), "전달된 Data : " + name,
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }




}
