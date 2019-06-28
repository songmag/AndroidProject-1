package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.GameView.IStat;

public class IntroState implements IStat {
    Bitmap icon;
    int x,y;
    @Override
    public void init() {
        icon = AppManager.getInstance().getBitMap(R.drawable.icon);
        x = 10 ; y = 10;
    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Canvas canvas) {
        canvas.drawBitmap(icon,x,y,null);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // AppManager.getInstance().getM_view().changeGameState(new CreditState());
        return true;
    }
}
