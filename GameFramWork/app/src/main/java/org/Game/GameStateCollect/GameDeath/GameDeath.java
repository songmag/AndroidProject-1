package org.Game.GameStateCollect.GameDeath;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.SoundManager;
import org.FrameWork.SpriteAddBackground;
import org.FrameWork.SpriteAnimation;

import org.Game.GameState;
import org.Game.GameView.IStat;

public class GameDeath implements IStat {
    private long stay_Time;
    private BackGround m_background;
    private boolean destroy_flag=false;
    @Override
    public void init(int background) {
        destroy_flag = false;
        SpriteAnimation m_animation;
        m_animation = new SpriteAnimation(AppManager.getInstance().getBitMap(R.drawable.game_death));
        m_background = new SpriteAddBackground(m_animation,(AppManager.getInstance().getM_GameView().getFullWidth()/2)-m_animation.getM_bitmap().getWidth()/3/2,
                AppManager.getInstance().getM_GameView().getHeight()/3);
        stay_Time = System.currentTimeMillis()+1000;
        SoundManager.getInstance().play_by_name("gameovermusic");
    }

    @Override
    public void Destroy() {
        m_background = null;
    }

    @Override
    public void Update() {
        if(destroy_flag) return;
        m_background.Update(System.currentTimeMillis());
    }
    @Override
    public void Render(Canvas canvas) {
        if(destroy_flag) return;
            m_background.Draw(canvas);
            canvas.drawText("Now Money = "+ AppManager.getInstance().getPlayer().getM_Money().getM_Money(),
                    0+ AppManager.getInstance().getM_GameView().getFullWidth()/8,
                    AppManager.getInstance().getM_GameView().getFullHeight()/9,AppManager.getInstance().getPaint());

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(System.currentTimeMillis() - stay_Time >=0)
        AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);
        return false;
    }

    @Override
    public void set_DestroyFlag(boolean flag) {
        this.destroy_flag = flag;
    }
}
//사망시 나오는 화면