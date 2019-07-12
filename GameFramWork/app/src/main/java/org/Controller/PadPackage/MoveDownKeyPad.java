package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;

public class MoveDownKeyPad extends PadClass implements I_TouchPad {
    @Override
    public void setLocationFiled() {
        src = new Rect(src_width/3,src_height/3*2,src_width/3*2,src_height);
        dest = new Rect(dest_width/3,dest_height/3,
                dest_width/3*2,dest_height);
        x = 0;
        y = 2;
    }
}
