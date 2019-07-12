package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MoveLeftUpKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(0,0,src_width/3,src_height/3);
        dest = new Rect(0,y_turm*4,
                x_turm,y_turm*5);
        x = -2;
        y = -2;
    }
}
