package org.TextDrawPackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SoundManager;

import org.GameStateCollect.ShopIntro;

public abstract class TextWriter implements I_DrawText {
    protected String value;
    public int now_index=0;
    public int finish_check_index=0;
    protected long time_term = 500;
    protected long check_time = 0;
    protected int x = AppManager.getInstance().getM_GameView().getFullWidth()/4;
    protected int y = 120;
    abstract public void init();
    protected boolean can_touch =false;
    @Override
    public boolean onTouch(MotionEvent event) {
        if(can_touch)
            if(value != null)
                now_index = value.length()-1;
        return false;
    }
    @Override
    public void Update(ShopIntro state) {
        if(value == null) return;
        now_index++;
    }

    @Override
    public void Draw(Canvas canvas) {
        if(value == null) return;
        Paint paint = AppManager.getInstance().getPaint();
        paint.setTextSize(25);
        if(System.currentTimeMillis()-check_time >= 0) {
            canvas.drawText(value.substring(0, now_index), x,y, paint);
            check_time = System.currentTimeMillis()+time_term;
            SoundManager.getInstance().play_by_name("coinmusic");
           if(now_index == 5)
                can_touch = true;
        }
        else{
            now_index--;
            canvas.drawText(value.substring(0, now_index), x,y, paint);
        }
       // check_finish(paint);
    }
   /* public void check_finish(Paint paint){
        if(x + paint.getTextSize()*finish_check_index >= AppManager.getInstance().getM_GameView().getFullWidth()-x)
        {
            y+=paint.getTextSize();
            finish_check_index = 0;
        }
    }*/
    @Override
    public void Destroy() {

    }
}
