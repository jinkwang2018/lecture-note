package com.example.part5_15;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab15_2Activity extends AppCompatActivity implements View.OnClickListener{
    Button keyboardBtn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab15_2);
        keyboardBtn=(Button)findViewById(R.id.lab2_toggleBtn);
        editText=(EditText)findViewById(R.id.lab2_edit);

        keyboardBtn.setOnClickListener(this);
    }

    
}

