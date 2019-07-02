package org.TextDrawPackage;

import android.graphics.Canvas;
import android.view.MotionEvent;

import org.Game.GameState;
import org.GameStateCollect.ShopIntro;
import org.w3c.dom.Text;

public interface I_DrawText {
    public void Update(ShopIntro state);
    public void init();
    public void Draw(Canvas canvas);
    public void Destroy();
    public boolean onTouch(MotionEvent event);
}
