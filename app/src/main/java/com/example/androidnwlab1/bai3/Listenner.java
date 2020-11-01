package com.example.androidnwlab1.bai3;

import android.graphics.Bitmap;

public interface Listenner {
    void onImageDownLoad(Bitmap bitmap);
    void onErro();
}
