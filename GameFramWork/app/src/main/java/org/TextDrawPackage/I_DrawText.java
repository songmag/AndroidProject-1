package org.TextDrawPackage;

import android.graphics.Canvas;
import android.view.MotionEvent;

import org.GameStateCollect.ShopIntro;

public interface I_DrawText {
    void Update(ShopIntro state);
    void init();
    void Draw(Canvas canvas);
    void Destroy();
    boolean onTouch(MotionEvent event);
}
