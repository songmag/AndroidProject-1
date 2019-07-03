package org.Game.MovePackage;

import android.graphics.Rect;

public interface ThrowObject {
    void set_State(I_MovePattern move);
    boolean checkUpdate();
    float getSpeed();
    void set_xy(float _x, float _y);
    float get_x();
    float get_y();
    Rect get_rect();
}
