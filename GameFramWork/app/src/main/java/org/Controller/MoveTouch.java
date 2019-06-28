package org.Controller;

import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.GameState;
import org.MissailPackage.Missail;
import org.MissailPackage.BlackMissail;
import org.MissailPackage.MissailFactory;

public class MoveTouch implements I_Controller {
    private GameState state;

    public MoveTouch(GameState state) {
        this.state = state;
    }

    @Override
    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_UP) {
            Missail missail = MissailFactory.missailMaker(state.getM_player());
            state.getM_player().shootingMissail(missail);
            state.getM_player().setMove_flag(false);
        }
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            Rect rect = state.getM_player().getM_rect();
            if(rect == null) return false;
            if(rect.contains((int)event.getX(),(int)event.getY()))
            {
                state.getM_player().setMove_flag(true);
            }
            else
            {
                state.getM_player().setMove_flag(false);
            }
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE && state.getM_player().isMove_flag())
        {
            if(state.getM_player() == null) return false;
            state.getM_player().setPosition((int)event.getX()-(state.getM_player().getM_rect().width()/2),(int)event.getY()-(state.getM_player().getM_rect().height()/2));
        }
        return false;
    }
}
