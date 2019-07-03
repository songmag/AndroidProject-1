package org.Controller;

import android.view.MotionEvent;

import org.Game.GameState;

public interface I_Controller {
    boolean onTouchEvent(MotionEvent e);
    void setState(GameState state);
}
