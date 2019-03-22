package kr.or.bit.ex10_menuactivity_quiz;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
/**
 * Another activity to be launched by the main activity
 *
 * @author Mike
 */
public class MenuActivity extends Activity {
    public static final int RESPONSE_CODE_OK = 200;
    public static final int RESPONSE_CODE_ERROR = 400;
 
    public static final int REQUEST_CODE_CUSTOMER = 2001;
    public static final int REQUEST_CODE_REVENUE = 2002;
    public static final int REQUEST_CODE_PRODUCT = 2003;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        // process received intent
        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(RESPONSE_CODE_OK, resultIntent);
                finish();
            }
        });

        Button menu01Button = (Button) findViewById(R.id.menu01Button);
        menu01Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                intent.putExtra("titleMsg", "고객 관리");

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
            }
        });

        Button menu02Button = (Button) findViewById(R.id.menu02Button);
        menu02Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RevenueActivity.class);
                intent.putExtra("titleMsg", "매출 관리");

                startActivityForResult(intent, REQUEST_CODE_REVENUE);
            }
        });

        Button menu03Button = (Button) findViewById(R.id.menu03Button);
        menu03Button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("titleMsg", "상품 관리");

                startActivityForResult(intent, REQUEST_CODE_PRODUCT);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_CUSTOMER) {
            String message = intent.getStringExtra("message");

            if (message != null) {
                Toast toast = Toast.makeText(getBaseContext(), "고객관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (requestCode == REQUEST_CODE_REVENUE) {
            String message = intent.getStringExtra("message");

            if (message != null) {
                Toast toast = Toast.makeText(getBaseContext(), "매출관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (requestCode == REQUEST_CODE_PRODUCT) {
            String message = intent.getStringExtra("message");

            if (message != null) {
                Toast toast = Toast.makeText(getBaseContext(), "상품관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

}