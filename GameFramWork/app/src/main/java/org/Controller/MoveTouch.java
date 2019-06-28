package org.Controller;

import android.view.MotionEvent;

import com.example.gameframework.org.FrameWork.IStat;

import org.Game.GameState;
import org.Game.Missail;
import org.Game.PlayerMissail;

public class MoveTouch implements I_Controller {
    private GameState state;

    public MoveTouch(GameState state) {
        this.state = state;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            Missail missail = new PlayerMissail(state.getM_player().getM_x(), state.getM_player().getM_y());
            missail.set_State(3.0f, 10);
            state.getM_player().shootingMissail(missail);
        }
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(state.getM_player().getM_rect().contains((int)event.getX(),(int)event.getY()))
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
            state.getM_player().setPosition((int)event.getX()-(state.getM_player().getM_rect().width()/2),(int)event.getY()-(state.getM_player().getM_rect().height()/2));
        }
        return false;
    }
}
