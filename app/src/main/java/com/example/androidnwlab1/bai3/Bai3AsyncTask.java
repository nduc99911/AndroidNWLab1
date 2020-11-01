package com.example.androidnwlab1.bai3;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai3AsyncTask extends AsyncTask<String,Void, Bitmap> {

    Listenner listenner;//khai báo sử dụng giao diện
    ProgressDialog progressDialog;//sử dụng tiếng trình
    Bitmap bitmap=null;
    public Bai3AsyncTask(Listenner listenner, Context context) {
        this.listenner = listenner;//khởi tạo listenter
        this.progressDialog = new ProgressDialog(context);//khởi tạo tiến trình
    }
    //chuẩn bị thực hiện
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Bắt đầu Download");
        progressDialog.show();
    }
//thực hiện
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;

        try {
            url=  new URL(strings[0]);
            bitmap= BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {


    }
        return bitmap;
    }
//sau thực hiện
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()){// nếu đang hiển thị
            progressDialog.dismiss();//tắt đi
        }
        if(bitmap!=null){// nếu ảnh khác null đưa lên
            listenner.onImageDownLoad(bitmap);
        }
        else {
            listenner.onErro();//neu không báo lỗi
        }
    }
}
