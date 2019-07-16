package org.Controller;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.Controller.PadPackage.ChargingAttackPad;
import org.Controller.PadPackage.DefaultAttackPad;
import org.Controller.PadPackage.I_TouchPad;
import org.Controller.PadPackage.MoveDownKeyPad;
import org.Controller.PadPackage.MoveLeftDownKeyPad;
import org.Controller.PadPackage.MoveLeftKeyPad;
import org.Controller.PadPackage.MoveLeftUpKeyPad;
import org.Controller.PadPackage.MoveRightDownKeyPad;
import org.Controller.PadPackage.MoveRightKeyPad;
import org.Controller.PadPackage.MoveRightUpKeyPad;
import org.Controller.PadPackage.MoveUpKeyPad;
import org.FrameWork.AppManager;
import org.Game.GameState;

public class MoveKeyPad implements I_Controller {
    private GameState state;
    I_TouchPad[] pad;
    public GameState getState() {
        return state;
    }
    @Override
    public void setState(GameState state) {
        this.state = state;
    }
    public MoveKeyPad(){
        pad = new I_TouchPad[10];
        pad[0] =new MoveDownKeyPad();
        pad[1] =new MoveUpKeyPad();
        pad[2] =new MoveLeftKeyPad();
        pad[3] =new MoveLeftDownKeyPad();
        pad[4] =new MoveLeftUpKeyPad();
        pad[5] =new MoveRightKeyPad();
        pad[6] =new MoveRightDownKeyPad();
        pad[7] =new MoveRightUpKeyPad();
        pad[8] = new DefaultAttackPad();
        pad[9] = new ChargingAttackPad();
        for(int i = 0 ; i<10;i++)
        {
            pad[i].setLocationFiled();
        }
    }
    public MoveKeyPad(GameState state) {
        this.state = state;
        pad = new I_TouchPad[10];
        pad[0] =new MoveDownKeyPad();
        pad[1] =new MoveUpKeyPad();
        pad[2] =new MoveLeftKeyPad();
        pad[3] =new MoveLeftDownKeyPad();
        pad[4] =new MoveLeftUpKeyPad();
        pad[5] =new MoveRightKeyPad();
        pad[6] =new MoveRightDownKeyPad();
        pad[7] =new MoveRightUpKeyPad();
        pad[8] = new DefaultAttackPad();
        pad[9] = new ChargingAttackPad();
        for(int i = 0 ; i<10;i++)
        {
            pad[i].setLocationFiled();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            pad[i].touchEvent(e);
        }
        return false;
    }
    @Override
    public void drawController(Canvas canvas) {
        for(int i = 0 ; i <10;i++)
        {
            pad[i].draw(canvas);
        }
    }
}//키패드로 만들어졌을때 하려고 했던 컨트롤러 클래스
