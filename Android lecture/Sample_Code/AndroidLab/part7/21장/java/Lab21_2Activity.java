package com.example.part7_21;

import android.Manifest;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Lab21_2Activity extends AppCompatActivity implements View.OnClickListener{
    Button contactBtn;
    Button galleryBtn;
    LinearLayout mainContent;

    int reqWidth;
    int reqHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab21_2);

        contactBtn=(Button)findViewById(R.id.lab2_contacts);
        galleryBtn=(Button)findViewById(R.id.lab2_gallery);
        mainContent=(LinearLayout)findViewById(R.id.lab2_content);

        contactBtn.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        reqWidth = metrics.widthPixels;
        reqHeight = metrics.heightPixels;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 100);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }

    }

    private void insertImageView(String filePath) {
        
    }
    private String getFilePathFromDocumentUri(Context context, Uri uri){
        
    }

    private String getFilePathFromUriSegment(Uri uri){
        
    }

    @Override
    public void onClick(View v) {
        if(v==contactBtn){
            
        }else if(v==galleryBtn){
            
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        
    }

    
}

