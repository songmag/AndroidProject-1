package org.Controller;

import android.view.MotionEvent;

import org.Game.GameState;

public interface I_Controller {
    public boolean onTouchEvent(MotionEvent e);
    public void setState(GameState state);
}
