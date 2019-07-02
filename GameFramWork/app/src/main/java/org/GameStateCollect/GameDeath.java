package org.GameStateCollect;

import android.graphics.Canvas;
import android.media.SoundPool;
import android.view.MotionEvent;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SoundManager;
import com.example.gameframework.org.FrameWork.SpriteAddBackground;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.Game.GameState;

public class GameDeath extends GameState {
    private long stay_Time;
    @Override
    public void init(int background) {
        SpriteAnimation m_animation;
        m_animation = new SpriteAnimation(AppManager.getInstance().getBitMap(R.drawable.game_death));
        m_background = new SpriteAddBackground(m_animation,(AppManager.getInstance().getM_GameView().getFullWidth()/2)-m_animation.getM_bitmap().getWidth()/3/2,
                AppManager.getInstance().getM_GameView().getHeight()/3);
        stay_Time = System.currentTimeMillis()+1000;
        SoundManager.getInstance().play_by_name("gameovermusic");
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
            canvas.drawText(Integer.toString(AppManager.getInstance().getPlayer().getM_Money().getM_Money()),AppManager.getInstance().getM_GameView().getFullWidth()-500,40,AppManager.getInstance().getPaint());
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(System.currentTimeMillis() - stay_Time >=0)
        AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);
        return false;
    }
}
