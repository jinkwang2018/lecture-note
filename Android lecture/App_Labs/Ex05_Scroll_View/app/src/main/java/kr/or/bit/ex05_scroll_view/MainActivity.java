package kr.or.bit.ex05_scroll_view;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollview01;
    ImageView imageview01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("메시지","정보");
        scrollview01 =	(ScrollView)findViewById(R.id.scrollview);
        imageview01 = (ImageView)findViewById(R.id.imageview);
        Button button01 = (Button)findViewById(R.id.button01);

        scrollview01.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        //drowable (안에 파일명은 첫문자가 소문자로)
        BitmapDrawable bitmap =(BitmapDrawable) res.getDrawable(R.drawable.r);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageview01.setImageDrawable(bitmap);
        imageview01.getLayoutParams().width = bitmapWidth;
        imageview01.getLayoutParams().height = bitmapHeight;

        button01.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                changeImage();
            }
        });


    }
    private void changeImage(){
        Resources res = getResources();
        //drowable (안에 파일명은 첫문자가 소문자로) ***************
        BitmapDrawable bitmap =(BitmapDrawable)res.getDrawable(R.drawable.t);//  res.getDrawable(R.drawable.t,null); // res.getDrawable(R.drawable.t);

        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageview01.setImageDrawable(bitmap);
        imageview01.getLayoutParams().width = bitmapWidth;
        imageview01.getLayoutParams().height = bitmapHeight;
    }

}
