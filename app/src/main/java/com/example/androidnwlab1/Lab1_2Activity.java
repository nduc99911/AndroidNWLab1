package com.example.androidnwlab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Lab1_2Activity extends AppCompatActivity {
public static int TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Lab1_2Activity.this,Lab1_1_2_Activity.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);
    }
}