package org.Controller;

import android.view.MotionEvent;

import org.Game.GameState;

public class MoveKeyPad implements I_Controller {
    private GameState state;

    public GameState getState() {
        return state;
    }

    @Override
    public void setState(GameState state) {
        this.state = state;
    }

    public MoveKeyPad(GameState state) {
        this.state = state;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }
}//키패드로 만들어졌을때 하려고 했던 컨트롤러 클래스
