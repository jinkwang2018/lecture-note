package kr.or.bit.ex17_autocomplete_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] hobby ={"aaa","aac","accc","abc","fff"};

        AutoCompleteTextView autocomplete = (AutoCompleteTextView)findViewById(R.id.autocomplete);
        autocomplete.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, hobby));
    }


}
