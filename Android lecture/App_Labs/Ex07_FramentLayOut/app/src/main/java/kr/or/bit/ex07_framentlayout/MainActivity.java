package kr.or.bit.ex07_framentlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button01;
    ImageView imageview01;
    ImageView imageview02;
    int imageindex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 =	(Button)findViewById(R.id.button01);
        imageview01 =	(ImageView)findViewById(R.id.imageview01);
        imageview02 =	(ImageView)findViewById(R.id.imageview02);

        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ChangeImage();
            }
        });
    }
    private void ChangeImage(){
        if(imageindex == 0){
            imageview01.setVisibility(View.VISIBLE);
            imageview02.setVisibility(View.INVISIBLE);
            imageindex = 1;
        }else if(imageindex ==1 ){
            imageview01.setVisibility(View.INVISIBLE);
            imageview02.setVisibility(View.VISIBLE);
            imageindex = 0;
        }
    }
}
