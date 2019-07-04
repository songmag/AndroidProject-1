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

//Throw Object 는 I_MovePattern 에서 써야할 메소드들을 강제한다.
//이런 동작으로 I_MovePattern은 작업을 한다.
//이동하는 Object의 경우 모두 사용 가능하다.