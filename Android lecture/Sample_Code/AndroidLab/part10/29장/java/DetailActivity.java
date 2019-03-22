package com.example.part10_29;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra("item_id",0);
        String content=getIntent().getStringExtra("item_data");

        TextView tv=(TextView)findViewById(R.id.detail_text);

        if (id != 0 && content != null) {
            tv.setText(id+":"+content);
        }
    }
}
