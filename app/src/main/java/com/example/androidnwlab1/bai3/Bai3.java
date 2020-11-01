package com.example.androidnwlab1.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidnwlab1.R;

public class Bai3 extends AppCompatActivity implements View.OnClickListener, Listenner {
    ImageView imageView;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imageView = findViewById(R.id.imageViewbai3);
        textView = findViewById(R.id.textView3);
        button = findViewById(R.id.buttonbai3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //gọi hàm DoInBackgound
        new Bai3AsyncTask(this, this).execute("https://i.ytimg.com/vi/isR4a85gIy4/maxresdefault.jpg");

    }

    @Override
    public void onImageDownLoad(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);// đưa ảnh Dowload lên ImgView
        textView.setText("Download thành công!");
    }

    @Override
    public void onErro() {
        textView.setText("Download Thất Bại");
    }
}