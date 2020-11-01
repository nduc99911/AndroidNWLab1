package com.example.androidnwlab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab1_1_2_Activity extends AppCompatActivity implements View.OnClickListener {
private ImageView imageView;
private Button button;
private TextView textView;
private String url="https://i.ytimg.com/vi/isR4a85gIy4/maxresdefault.jpg";
private Bitmap bitmap=null;
private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_1_2_);
        imageView=findViewById(R.id.imgLab1_2);
        button=findViewById(R.id.btnLoad);
        textView=findViewById(R.id.tvMessenger);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        progressDialog=ProgressDialog.show(Lab1_1_2_Activity.this,"","Dowloading...");
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
               bitmap=dowloadBitMap(url);
               Message message=Messagehandler.obtainMessage();
               Bundle bundle=new Bundle();
               String thMessange="Đã dowload xong";
               bundle.putString("message",thMessange);
               message.setData(bundle);
               Messagehandler.sendMessage(message);
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

    private Handler Messagehandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            String messager=bundle.getString("message");
            textView.setText(messager);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    private Bitmap dowloadBitMap(String link){
        try {
            URL url=new URL(link);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
            InputStream inputStream=httpURLConnection.getInputStream();
            Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }

         catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}