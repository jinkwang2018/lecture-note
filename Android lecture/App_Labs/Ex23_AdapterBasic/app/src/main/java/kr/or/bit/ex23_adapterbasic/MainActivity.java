package kr.or.bit.ex23_adapterbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.자원 (DB , Array , JSON)
        //Adapter (데이터(원본) read 해서 어텝뷰(widget)에 공급하는 역활을 하는 클래스

        //종류
        //1. ArrayAdapter : 배열에서 데이터를 가지고 오는 클래스
        //2. CursorAdapter : 데이터베이스에서 데이터를 가지고 온다(SQLlite)
        //3. SimpleAdapter : xml파일에서 데이터를 가지고 온다
        //4. BaseAdapter   : 사용가자 임의로 상속해서 재정의 할수 있도록 만든 클래스


        //Adapter 역활   JAVA 코드 : (JDBC 드라이버 )  : Oracle 서버

        // Adapter view(widget)
        // ListView , Spinner , GridView , Gallery 등등

        //android.R.layout
        //1. simple_list_item_1 : 하나의 텍스트 뷰
        //2. simple_list_item_2 : 두개의 텍스트 뷰
        //3. simple_list_item_checked : 항목당 체크 표시 뷰
        //4. simple_list_item_single_choice : 항목당 하나만 선택(Radio 뷰)
        //5. simpel_list_item_multiple_choice : 여러개 항목 선택 기능(CheckBox 뷰)



        //1.원본
        String[] fruits = {"사과","배","귤","바나나","파인애플","망고",
                "사과2","배2","귤2","바나나2","파인애플2","망고2",
                "사과3","배3","귤3","바나나3","파인애플3","망고3"  };

        //2.Adapter 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,fruits);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,fruits);
        //3. Adapter view 선택

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);



    }


}
