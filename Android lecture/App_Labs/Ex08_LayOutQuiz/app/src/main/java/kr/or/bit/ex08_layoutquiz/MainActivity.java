package kr.or.bit.ex08_layoutquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputmessage;
    TextView inputcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputmessage = (EditText)findViewById(R.id.inputMessage);
        inputcount = (TextView)findViewById(R.id.inputCount);

        Button sendbutton = (Button)findViewById(R.id.sendButton);
        sendbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String message = inputmessage.getText().toString();
                Toast.makeText(getApplicationContext(),
                        "입력한 내용\n" + message, Toast.LENGTH_LONG).show();
            }
        });
        Button closebutton = (Button)findViewById(R.id.closeButton);
        closebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });


        //class aa impl... TextWatcher
        //{  }
        //EditText 변환에 이벤트 구현하는 객체
        //인터페이스를 바로 구현
        TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                byte[] bytes = null;
                try{
                    bytes = s.toString().getBytes();
                    int strcount = bytes.length;
                    inputcount.setText(strcount + " / 80 바이트");
                }catch(UnsupportedOperationException ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable strEdit) {
                // TODO Auto-generated method stub
                String str = strEdit.toString();
                try{
                    byte[] strbytes = str.getBytes();
                    if(strbytes.length > 80){
                        strEdit.delete(strEdit.length()-2, strEdit.length()-1);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };

        //watcher 이벤트를 inputmessage 에 등록
        inputmessage.addTextChangedListener(watcher);


    }



}
