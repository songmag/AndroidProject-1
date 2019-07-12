package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MoveRightDownKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(src_width/3*2,src_height/3*2,src_width,src_height);
        dest = new Rect(x_turm*2,y_turm*6,
                x_turm*3,y_turm*7);
        x = 2;
        y = 2;
    }
}
