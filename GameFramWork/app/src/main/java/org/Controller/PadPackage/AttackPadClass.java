package org.Controller.PadPackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public abstract class AttackPadClass implements I_TouchPad {
    private static Paint paint = new Paint();
    protected Rect src,dest;
    protected int x_turm = AppManager.getInstance().getM_GameView().getFullWidth()/6,y_turm = AppManager.getInstance().getM_GameView().getFullHeight()/8;
    @Override
    public abstract void setLocationFiled();
    @Override
    public void draw(Canvas canvas) {
        paint.setAlpha(30);
        canvas.drawBitmap(GraphicManager.getInstance().getAttackPad(),src,dest,paint);
    }
    @Override
    abstract public boolean touchEvent(MotionEvent event);
}
