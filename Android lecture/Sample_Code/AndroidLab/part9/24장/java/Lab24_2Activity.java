package com.example.part9_24;

import android.os.Bundle;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Lab24_2Activity extends AppCompatActivity implements View.OnClickListener {
    Button domBtn;
    Button saxBtn;
    Button pullBtn;
    Button jsonBtn;

    TextView cityView;
    TextView tempView;
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab24_2);

        domBtn = (Button) findViewById(R.id.lab2_dom);
        saxBtn = (Button) findViewById(R.id.lab2_sax);
        pullBtn = (Button) findViewById(R.id.lab2_pull);
        jsonBtn = (Button) findViewById(R.id.lab2_json);

        cityView = (TextView) findViewById(R.id.lab2_city);
        tempView = (TextView) findViewById(R.id.lab2_temperature);
        resultView = (TextView) findViewById(R.id.lab2_result_title);

        domBtn.setOnClickListener(this);
        saxBtn.setOnClickListener(this);
        pullBtn.setOnClickListener(this);
        jsonBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == domBtn) {
            domParsing();
        } else if (v == saxBtn) {
            saxParsing();
        } else if (v == pullBtn) {
            pullParsing();
        } else if (v == jsonBtn) {
            jsonParsing();
        }
    }

    private void domParsing() {

        //add~~~~~~~~~~~~~~~~
    }

    private void saxParsing() {

        //add~~~~~~~~~~~~~~
    }

    private void pullParsing() {

        //add~~~~~~~~~~~~~~~
    }

    private void jsonParsing() {
        //add~~~~~~~~~~~~~~~~

    }
}
