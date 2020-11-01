package com.example.androidnwlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnLoad;
    private TextView txtResult;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoad=findViewById(R.id.button);
        txtResult=findViewById(R.id.textView);
        img=findViewById(R.id.imageView);
        btnLoad.setOnClickListener(this);
    }
//su dung thread
    @Override
    public void onClick(View v) {
        Runnable target;
        final  Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap=loadIMG("https://i.ytimg.com/vi/isR4a85gIy4/maxresdefault.jpg");
                img.post(new Runnable() {
                    @Override
                    public void run() {
                        txtResult.setText("Dowload Thành Công!");
                        img.setImageBitmap(bitmap);
                    }
                });
            }
        });
        thread.start();
    }
    //hàm load anh tu mang
    private  Bitmap loadIMG(String link){
        URL url;
        Bitmap bitmap=null;
        try {
            url=new URL(link);
            bitmap= BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}