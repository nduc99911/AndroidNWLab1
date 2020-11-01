package com.example.androidnwlab1.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidnwlab1.R;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
EditText editText;
Button button;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        editText=findViewById(R.id.edtTime);
        button=findViewById(R.id.btnRun);
        textView=findViewById(R.id.txtResult);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String slepp=editText.getText().toString();
new Bai4AsyncTask(this,textView,editText).execute(slepp);
    };
}