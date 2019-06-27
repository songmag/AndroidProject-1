package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.R;

public class CreditState implements IStat {
    Bitmap android;
    int x,y;
    @Override
    public void init() {
        android = AppManager.getInstance().getBitMap(R.drawable.android);
        x = 20 ; y=20;
    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Canvas canvas) {
        canvas.drawBitmap(android,x,y,null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
