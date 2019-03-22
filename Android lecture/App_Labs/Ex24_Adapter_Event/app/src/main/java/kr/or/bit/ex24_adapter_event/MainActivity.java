package kr.or.bit.ex24_adapter_event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* 이벤트 코드 구현*/
        //List Item(항목)에 대한  Event 구현
        ListView listview = (ListView)findViewById(R.id.listview01);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Listview 가 가지는 각각의 항목을 클릭시
            //view (각각의 항목)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),((TextView)view).getText(),Toast.LENGTH_LONG).show();
            }
        });

    }


}



