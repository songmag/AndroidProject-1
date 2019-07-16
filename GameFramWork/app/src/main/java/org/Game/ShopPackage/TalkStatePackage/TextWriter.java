package org.Game.ShopPackage.TalkStatePackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.SoundManager;

import org.Game.ShopPackage.ShopIntro;

public abstract class TextWriter implements I_DrawText {
    protected String value;
    public int now_index=0;
    public int finish_check_index=0;
    protected long time_term = 200;
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
    //터치작업을 하면 5개 이상 찍었을때, 터치하면 자동으로 모든 글씨를 쓴다.
    @Override
    public void Update(ShopIntro state) {
        if(value == null) return;
        now_index++;
    }//한칸씩 인덱스를 늘려가며 텍스트를 표시

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
            if(now_index != 0)
            now_index--;
            canvas.drawText(value.substring(0, now_index), x,y, paint);
        }
       // check_finish(paint);
    }
   /* public void check_finish(Paint paint){

    }*/
   //하려던 작업 : 텍스트가 칸을 벗어나면 \n 을 친것처럼 옮겨져서 마저 적어지는것.
    @Override
    public void Destroy() {

    }
}
