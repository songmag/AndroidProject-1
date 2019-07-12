package org.Controller.PadPackage;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface I_TouchPad {
    void draw(Canvas canvas);
    boolean touchEvent(MotionEvent event);
    void setLocationFiled();
}
