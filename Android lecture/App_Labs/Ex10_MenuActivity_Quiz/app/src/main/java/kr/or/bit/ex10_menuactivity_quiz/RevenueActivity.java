package kr.or.bit.ex10_menuactivity_quiz;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
/**
 * Customer Activity
 *
 * @author Mike
 */
public class RevenueActivity extends Activity {
    public static final int RESPONSE_CODE_OK = 200;
    public static final int RESPONSE_CODE_ERROR = 400;
 
    TextView titleText;
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revenue_activity);
 
        titleText = (TextView) findViewById(R.id.titleText);
 
        // process received intent
        Intent receivedIntent = getIntent();
        String titleMsg = receivedIntent.getStringExtra("titleMsg");
 
        Toast.makeText(this, "titleMsg : " + titleMsg, Toast.LENGTH_LONG).show();
 
        if (titleText != null) {
            titleText.setText(titleMsg);
        }
 
 
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");
 
                setResult(RESPONSE_CODE_OK, resultIntent);
                finish();
            }
        });
 
    }
 
}