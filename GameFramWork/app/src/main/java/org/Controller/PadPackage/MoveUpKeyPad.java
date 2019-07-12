package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MoveUpKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(src_width/3,0,src_width/3*2,src_height/3);
        dest = new Rect(x_turm,y_turm*4,
                x_turm*2,y_turm*5);
        x = 0;
        y = -2;
    }
}
