package kr.or.bit.ex10_menuactivity_quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class LoginActivity extends Activity {
    public static final int REQUEST_CODE_MENU = 1001;
 
    EditText usernameInput;
    EditText passwordInput;
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
 
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.length() < 1) {
                    Toast.makeText(getApplicationContext(), "사용자명을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.length() < 1) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
 
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
 
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
 
        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
 
    }
 
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
 
        if (requestCode == REQUEST_CODE_MENU) {
            String message = intent.getStringExtra("message");
 
            if (message != null) {
                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }
 
    }
 
}