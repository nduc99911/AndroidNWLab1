package com.example.androidnwlab1.bai4;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4AsyncTask extends AsyncTask<String,Void,String> {
    private ProgressDialog progressDialog;
    TextView tvResult;
    EditText txtTime;
    Context context;
    String kq;
    public Bai4AsyncTask(Context context,TextView tvResult,EditText txtTime) {
        this.context=context;
        this.tvResult=tvResult;
        this.txtTime=txtTime;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=ProgressDialog.show(context,"Title","Xin vui lòng đợi"+txtTime.getText().toString()+"s");

    }

    @Override
    protected String doInBackground(String... strings) {
//        publishProgress("Sleeping");
        try {
            int time=Integer.parseInt(strings[0])+1000;
            Thread.sleep(time);
            kq="Đã Ngủ trong "+strings[0]+"s";
        }
        catch (Exception e){
            e.printStackTrace();
            kq=e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(s);
    }
}
