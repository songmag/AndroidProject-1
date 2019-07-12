package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;

public class MoveDownKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(src_width/3,src_height/3*2,src_width/3*2,src_height);
        dest = new Rect(x_turm,y_turm*6,
                x_turm*2,y_turm*7);
        x = 0;
        y = 2;
    }
}
