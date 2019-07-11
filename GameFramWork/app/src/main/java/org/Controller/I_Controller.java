package org.Controller;

import android.graphics.Canvas;
import android.view.MotionEvent;

import org.Game.GameState;

public interface I_Controller {
    boolean onTouchEvent(MotionEvent e);
    void setState(GameState state);
    void drawController(Canvas canvas);
}//컨트롤러 변경을 위한 인터페이스 각 모듈들은 모두 I_Controller를 통해서 컨트롤을 한다.
