package org.Game;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.IStat;

public class GameState implements IStat {
    private Player m_player;
    private BackGround m_background;
    private Enermy_1 enermy1;
    @Override
    public void init() {
        m_player = new Player(AppManager.getInstance().getBitMap(R.drawable.player));
        m_background = new BackGround();
        enermy1 = new Enermy_1();
    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {
        long gameTime = System.currentTimeMillis();
        m_player.Update(gameTime);
        m_background.Update(gameTime);
        enermy1.Update(gameTime);
    }

    @Override
    public void Render(Canvas canvas) {
        m_background.Draw(canvas);
        m_player.Draw(canvas);
        enermy1.Draw(canvas);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int x = m_player.getM_x();
        int y = m_player.getM_y();
        if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
        {
            m_player.setPosition(x-1,y);
        }
        if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
        {
            m_player.setPosition(x+1,y);
        }
        if(keyCode == KeyEvent.KEYCODE_DPAD_UP)
        {
            m_player.setPosition(x,y-1);
        }
        if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN)
        {
            m_player.setPosition(x,y+1);
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
