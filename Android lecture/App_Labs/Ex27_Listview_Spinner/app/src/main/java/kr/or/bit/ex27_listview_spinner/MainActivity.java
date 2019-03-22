package kr.or.bit.ex27_listview_spinner;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] data ={"java" , "jsp" , "Oralce" , "mySql" , "Spring"};
        ListView list = (ListView)findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //다이얼 로그 창
        //Toast.makeText(getApplicationContext(),"go",Toast.LENGTH_SHORT).show();
        final String[] classData = {"초급" , "중급" , "고급"};
        String title = ((TextView)view).getText().toString();
        new AlertDialog.Builder(this).setTitle(title + "등급 선택").setItems(classData, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"title" + which +":"+ classData[which], Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("", null).show();

    }
}
