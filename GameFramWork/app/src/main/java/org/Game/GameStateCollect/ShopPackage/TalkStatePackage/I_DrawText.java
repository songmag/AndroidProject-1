package org.Game.GameStateCollect.ShopPackage.TalkStatePackage;

import android.graphics.Canvas;
import android.view.MotionEvent;

import org.Game.GameStateCollect.ShopPackage.ShopIntro;

public interface I_DrawText {
    void Update(ShopIntro state);
    void init();
    void Draw(Canvas canvas);
    void Destroy();
    boolean onTouch(MotionEvent event);
}//택스트를 그리기 위한 메소드들, TextWriter에서 로직을 구현했다.
