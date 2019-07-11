package org.Controller;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.FrameWork.AppManager;
import org.Game.GameState;

public class MoveKeyPad implements I_Controller {
    private GameState state;
    private Bitmap pad;
    private Paint paint;
    private Rect src,dest;
    public GameState getState() {
        return state;
    }
    @Override
    public void setState(GameState state) {
        this.state = state;
    }

    public MoveKeyPad(GameState state) {
        this.state = state;
        pad = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.pad)
                ,AppManager.getInstance().getM_GameView().getFullWidth()/4,
                AppManager.getInstance().getM_GameView().getFullHeight()/5);
        src = new Rect(0,0,pad.getWidth(),pad.getHeight());
        int width = pad.getWidth();
        int height = pad.getHeight();
        paint = new Paint();
        paint.setAlpha(75);
        dest = new Rect(10,AppManager.getInstance().getM_GameView().getFullHeight()-height-30,
                width,
                AppManager.getInstance().getM_GameView().getFullHeight()-30);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }
    @Override
    public void drawController(Canvas canvas) {
        canvas.drawBitmap(pad,src,dest,paint);
    }
}//키패드로 만들어졌을때 하려고 했던 컨트롤러 클래스
