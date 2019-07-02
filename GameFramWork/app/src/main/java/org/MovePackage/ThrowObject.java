package org.MovePackage;

import android.graphics.Point;

public interface ThrowObject {
    public void set_State(I_MovePattern move);
    public boolean checkUpdate();
    public float getSpeed();
    public void set_xy(float _x,float _y);
}
