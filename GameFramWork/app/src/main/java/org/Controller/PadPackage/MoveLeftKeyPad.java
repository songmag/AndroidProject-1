package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

public class MoveLeftKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(0,src_height/3,src_width/3,src_height/3*2);
        dest = new Rect(dest_width/3,dest_height/3,
                dest_width/3*2,dest_height);
        x = -2;
        y = 0;
    }
}
