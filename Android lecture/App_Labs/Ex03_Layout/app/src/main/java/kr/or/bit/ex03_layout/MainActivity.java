package kr.or.bit.ex03_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn01 = (Button)findViewById(R.id.btn01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.table_layout);
            }
        });
    }
    public void OnTableClick(View v){
        setContentView(R.layout.table_layout2);
    }

    public void OnTClick(View v){
        setContentView(R.layout.table_layout3);
    }
}
