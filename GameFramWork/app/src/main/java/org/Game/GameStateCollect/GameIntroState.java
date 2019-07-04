package org.Game.GameStateCollect;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.SpriteAddBackground;
import org.FrameWork.SpriteAnimation;

import org.Game.GameState;

public class GameIntroState extends GameState {
    private long m_ChangeState;
    @Override
    public void init(int background) {
        SpriteAnimation animation = new SpriteAnimation(
                AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.first_logo),
                        AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight()/5));
        animation.initSpriteData(animation.getM_bitmap().getWidth()/3,animation.getM_bitmap().getHeight(),10,3);
        animation.setPosition(AppManager.getInstance().getM_GameView().getFullWidth()/2 - animation.getM_bitmap().getWidth()/3/2,AppManager.getInstance().getM_GameView().getFullHeight()/5);
        m_background = new SpriteAddBackground(AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.background_block),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight())
        ,animation);
        m_background.setPosition(0,0);

        m_ChangeState = System.currentTimeMillis()+3000;
    }
    @Override
    public void Update() {
        if (m_background != null) {
            m_background.Update(System.currentTimeMillis());
            if (System.currentTimeMillis() - m_ChangeState >= 0)
                AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);
        }
    }
    @Override
    public void Render(Canvas canvas) {
        if(m_background != null)
            m_background.Draw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
//인트로 화면
