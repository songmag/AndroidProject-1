package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MoveLeftDownKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(0,src_height/3*2,src_width/3,src_height);
        dest = new Rect(0,y_turm*6,
                x_turm,y_turm*7);
        x = -2;
        y = 2;
    }
}
