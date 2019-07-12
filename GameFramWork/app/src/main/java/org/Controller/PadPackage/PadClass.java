package org.Controller.PadPackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;
import org.Game.Player;

public abstract class PadClass implements I_TouchPad {
    private Paint paint = new Paint();
    protected Rect src,dest;
    protected int dest_width = AppManager.getInstance().getM_GameView().getFullWidth(),
            dest_height= AppManager.getInstance().getM_GameView().getFullHeight();
    protected int src_width = GraphicManager.getInstance().getKeyPad().getWidth()
            ,src_height=GraphicManager.getInstance().getKeyPad().getHeight();
    protected int x,y;
    protected int x_turm = dest_width/2/3,y_turm = dest_height/8;
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
        if(AppManager.getInstance().getM_GameView().getM_state().getM_player() != null)
            if(!AppManager.getInstance().getM_GameView().getM_state().getM_player().isM_death())
                if(event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_DOWN) {
            if (dest.contains((int) event.getX(), (int) event.getY())) {
                paint.setColorFilter(GraphicManager.getInstance().getColorFilter());
                if (AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_x() + x * 4
                        >= AppManager.getInstance().getM_GameView().getFullWidth() ||
                        AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_x()
                                + x * 4 < 0 ||
                        AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_y() + y * 4 > AppManager.getInstance().getM_GameView().getFullHeight() ||
                        AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_y() + y * 4 < 0) {

                } else {
                    AppManager.getInstance().getM_GameView().getM_state().getM_player().setPosition(
                            AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_x() + x * 4,
                            AppManager.getInstance().getM_GameView().getM_state().getM_player().getM_y() + y * 4
                    );
                }
            } else {
                paint.setColorFilter(null);
            }
        }
        else
        {
            paint.setColorFilter(null);
        }
        return false;
    }
}
