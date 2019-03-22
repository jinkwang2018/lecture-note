package kr.or.bit.ex05_layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageview01;
    ImageView imageview02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview01 = (ImageView)findViewById(R.id.imageView01);
        imageview02 = (ImageView)findViewById(R.id.imageView02);

        Button button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //UP
                moveImageUp();
            }
        });
        Button button02 = (Button)findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                moveImageDown();
            }
        });

    }

    private void moveImageDown(){
        imageview01.setImageResource(0);
        imageview02.setImageResource(R.drawable.r); //drawable

    }
    private void moveImageUp(){
        imageview01.setImageResource(R.drawable.t);
        imageview02.setImageResource(0);

    }


}

