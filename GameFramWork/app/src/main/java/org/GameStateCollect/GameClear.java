package org.GameStateCollect;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SoundManager;
import com.example.gameframework.org.FrameWork.SpriteAddBackground;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.Game.GameState;

public class GameClear extends GameState {
    public long stay_time;
    @Override
    public void init(int background) {
        SpriteAnimation m_animation;
        m_animation = new SpriteAnimation(AppManager.getInstance().getBitMap(R.drawable.game_clear));
        m_background = new SpriteAddBackground(m_animation,(AppManager.getInstance().getM_GameView().getFullWidth()/2)-m_animation.getM_bitmap().getWidth()/3/2,
                AppManager.getInstance().getM_GameView().getHeight()/3);
        stay_time = System.currentTimeMillis()+ 2000;
        SoundManager.getInstance().play_by_name("clearmusic");
    }
    @Override
    public void Update() {
        if(m_background != null)
        m_background.Update(System.currentTimeMillis());
    }
    @Override
    public void Render(Canvas canvas) {
        if(m_background != null) {
            m_background.Draw(canvas);
            canvas.drawText("Now Money = "+ AppManager.getInstance().getPlayer().getM_Money().getM_Money(),
                    0+ AppManager.getInstance().getM_GameView().getFullWidth()/8,
                    AppManager.getInstance().getM_GameView().getFullHeight()/9,AppManager.getInstance().getPaint());
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         if(System.currentTimeMillis() - stay_time >= 0) {
             if (AppManager.getInstance().getPlayer().getM_stage() > 3) {
                 AppManager.getInstance().getPlayer().setM_stage(0);
             }
             AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.gameStates[AppManager.getInstance().getPlayer().getM_stage()]);
         }
         return false;
    }
}
