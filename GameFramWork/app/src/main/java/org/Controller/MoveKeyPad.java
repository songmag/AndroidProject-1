package org.Controller;

import android.view.MotionEvent;

import com.example.gameframework.org.FrameWork.IStat;

import org.Game.GameState;

public class MoveKeyPad implements I_Controller {
    private GameState state;

    public MoveKeyPad(GameState state) {
        this.state = state;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }


}
