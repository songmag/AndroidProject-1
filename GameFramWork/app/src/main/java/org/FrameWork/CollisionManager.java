package org.FrameWork;

import android.graphics.Rect;

public class CollisionManager {
    public static boolean checkBoxToBox(Rect rect_1,Rect rect_2)
    {
        if(rect_1 == null || rect_2 == null)return false;
        return rect_1.right > rect_2.left && rect_1.left < rect_2.right && rect_1.top < rect_2.bottom && rect_1.bottom > rect_2.top;
    }//rect1 이 rect2 에 충돌하는가
}
