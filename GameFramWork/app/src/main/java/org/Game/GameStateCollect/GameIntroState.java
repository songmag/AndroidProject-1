package org.Game.GameStateCollect;

import android.graphics.Canvas;
import android.text.style.BackgroundColorSpan;
import android.view.MotionEvent;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.GraphicManager;
import org.FrameWork.SpriteAddBackground;
import org.FrameWork.SpriteAnimation;

import org.Game.GameState;
import org.Game.GameView.IStat;

public class GameIntroState implements IStat {
    private long m_ChangeState;
    private BackGround m_background;

    private boolean destroy_flag=false;
    @Override
    public void Destroy() {
        m_background = null;
    }

    @Override
    public boolean get_DestroyFlag() {
        return destroy_flag;
    }

    @Override
    public void init(int background) {
        destroy_flag = false;
        SpriteAnimation animation = new SpriteAnimation(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.first_logo),
                        AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight()/5));
        animation.initSpriteData(animation.getM_bitmap().getWidth()/3,animation.getM_bitmap().getHeight(),10,3);
        animation.setPosition(AppManager.getInstance().getM_GameView().getFullWidth()/2 - animation.getM_bitmap().getWidth()/3/2,AppManager.getInstance().getM_GameView().getFullHeight()/5);
        m_background = new SpriteAddBackground(GraphicManager.getInstance().getM_Background_Default(),animation);
        m_background.setPosition(0,0);
        m_ChangeState = System.currentTimeMillis()+3000;
    }
    @Override
    public void Update() {
        if(destroy_flag) return;
            m_background.Update(System.currentTimeMillis());
            if (System.currentTimeMillis() - m_ChangeState >= 0)
                AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);

    }
    @Override
    public void Render(Canvas canvas) {
        if(destroy_flag) return;
            m_background.Draw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void set_DestroyFlag(boolean flag) {
        this.destroy_flag = flag;
    }
}
//인트로 화면
