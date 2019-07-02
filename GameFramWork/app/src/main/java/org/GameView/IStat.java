package org.GameView;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

public interface IStat {
    public void init(int background);
    public void Destroy();
    public void Update();
    public void Render(Canvas canvas);
    public boolean onTouchEvent(MotionEvent event);
}
