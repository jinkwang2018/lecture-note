package com.example.part7_21;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    ListView listView;
    EditText nameView;
    EditText phoneView;
    Button btn;

    boolean isUpdate;
    String _id;

    ArrayList<HashMap<String, String>> datas;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.lab1_listview);
        nameView=(EditText) findViewById(R.id.lab1_name);
        phoneView=(EditText) findViewById(R.id.lab1_phone);
        btn=(Button)findViewById(R.id.lab1_btn);

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        btn.setOnClickListener(this);



        
    }

    private void setAdapter(){
        
    }

    @Override
    public void onClick(View v) {
        if(isUpdate){
            //update.......
            
        }else {
            //insert.......
            
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String, String> map=datas.get(position);
        nameView.setText(map.get("name"));
        phoneView.setText(map.get("phone"));
        _id=map.get("id");
        isUpdate=true;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return false;
    }
}
