package kr.or.bit.ex14_dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button showBtn;
    TextView txtMsg;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView)findViewById(R.id.txtMsg);
        showBtn = (Button)findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                AlertDialog dialog = createDialog();
                dialog.show();


            }
        });
    }

    //대화상자 처리 (예 , 아니오 , 취소 등의 버튼)
    private AlertDialog createDialog(){
        // AlertDialog.Builder 객체 통해서 모달창
        // 옵션 : 예 버튼 , 아니오 버튼 만들기 설정

        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setTitle("안녕");
        builder.setMessage("종료하시겠습니까");
        //builder.setIcon(R.drawable.icon);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "예 버튼이 클릭되었습니다" + Integer.toString(which);
                txtMsg.setText(msg);
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "아니오 버튼이 클릭되었습니다" + Integer.toString(which);
                txtMsg.setText(msg);
            }
        });

        builder.setNeutralButton("취소" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "취소 버튼이 클릭되었습니다" + Integer.toString(which);
                txtMsg.setText(msg);
            }
        });
        AlertDialog dialog = builder.create();
        return dialog;

    }

}
