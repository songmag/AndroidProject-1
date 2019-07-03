package org.ButtonTest;

import android.graphics.Canvas;

public interface I_Button {
    void method();
    boolean check_contain_point(int x, int y);
    void Draw(Canvas canvas);
}
