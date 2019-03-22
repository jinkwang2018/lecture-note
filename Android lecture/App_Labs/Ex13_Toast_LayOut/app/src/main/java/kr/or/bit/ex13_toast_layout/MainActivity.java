package kr.or.bit.ex13_toast_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText edit01;
    EditText edit02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showBtn = (Button)findViewById(R.id.showBtn);
        edit01 = (EditText)findViewById(R.id.edit01);
        edit02 = (EditText)findViewById(R.id.edit02);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast toastView = Toast.makeText(getApplicationContext(),
                        "Hello world", Toast.LENGTH_LONG);

                //key point
                //Integer.valueOf(edit01.getText().toString());
                int xOffset = Integer.valueOf(edit01.getText().toString());
                int yOffset = Integer.valueOf(edit02.getText().toString());
                toastView.setGravity(Gravity.CENTER, xOffset, yOffset);
                toastView.show();

            }
        });
    }
}
