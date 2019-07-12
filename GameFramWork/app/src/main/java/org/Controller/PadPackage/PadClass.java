package org.Controller.PadPackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public abstract class PadClass implements I_TouchPad {
    private static Paint paint = new Paint();

    protected Rect src,dest;
    protected int dest_width = GraphicManager.getInstance().getKeyPad().getWidth(),
            dest_height= GraphicManager.getInstance().getKeyPad().getHeight();
    protected int src_width = AppManager.getInstance().getM_GameView().getFullWidth()
            ,src_height=AppManager.getInstance().getM_GameView().getFullHeight();
    protected int x,y;
    @Override
    public abstract void setLocationFiled();
    @Override
    public void draw(Canvas canvas) {
        paint.setAlpha(75);
        canvas.drawBitmap(GraphicManager.getInstance().getKeyPad(),src,dest,paint);
    }
    @Override
    public boolean touchEvent(MotionEvent event)
    {
        AppManager.getInstance().getM_GameView().getM_state().getM_player().setPosition(
                AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_x()+x,
                AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_y()+y
        );
        return false;
    }
}
