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


}
