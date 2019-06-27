package org.Game;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.IStat;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameState implements IStat {
    private Player m_player;
    private BackGround m_background;
    private List<Enermy> enermys;
    private long LastRegenEnemy;
    private Random rand = new Random();
    private List<Missail> missails;
    @Override
    public void init() {
        LastRegenEnemy = System.currentTimeMillis();
        m_player = new Player(AppManager.getInstance().getBitMap(R.drawable.player));
        m_background = new BackGround();
        enermys = new LinkedList<Enermy>();
        missails = new LinkedList<Missail>();
    }

    @Override
    public void Destroy() {

    }

    @Override
    public void Update() {
        long gameTime = System.currentTimeMillis();
        m_player.Update(gameTime);
        m_background.Update(gameTime);
        for(int i=0 ; i < enermys.size();i++)
        {
            enermys.get(i).Update(gameTime);
           if (enermys.get(i).getM_state() == Enermy.STATE_OUT) {
               enermys.remove(enermys.get(i));
           }
        }
        for(int i=0 ; i < missails.size();i++)
        {
            missails.get(i).Update();
            if (missails.get(i).getM_state()== Missail.STATE_OUT) {
                missails.remove(missails.get(i));
            }
        }
        makeEnermy();
    }
    @Override
    public void Render(Canvas canvas) {
        m_background.Draw(canvas);
        m_player.Draw(canvas);
        for(int i=0 ; i < enermys.size();i++)
        {
            enermys.get(i).Draw(canvas);
        }
        for(int i =0 ; i< missails.size();i++)
        {
            missails.get(i).Draw(canvas);
        }
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
        if(event.getAction() == MotionEvent.ACTION_UP) {
            Missail missail = new PlayerMissail(this.m_player.getM_x(), this.m_player.getM_y());
            missail.set_State(3.0f, 10);
            missails.add(missail);
        }
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(m_player.getM_rect().contains((int)event.getX(),(int)event.getY()))
            {
                m_player.setMove_flag(true);
            }
            else
            {
                m_player.setMove_flag(false);
            }
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE && m_player.isMove_flag())
        {
            m_player.setPosition((int)event.getX()-(m_player.getM_rect().width()/2),(int)event.getY()-(m_player.getM_rect().height()/2));
        }
        return false;
    }
    public void makeEnermy()
    {
        if(System.currentTimeMillis()-LastRegenEnemy >= 1000) {
            LastRegenEnemy = System.currentTimeMillis();
            Enermy enermy;
            switch(rand.nextInt(3))
            {
                case 0:
                    enermy = new Enermy_1();
                    break;
                case 1:
                    enermy = new Enermy_2();
                    break;
                default:
                    enermy = new Enermy_3();
                    break;
            }
            enermy.set_State(10,2.5f,rand.nextInt(3));
            enermy.setPosition(rand.nextInt(AppManager.getInstance().getM_view().getFullWidth()), -60);
            this.enermys.add(enermy);
        }
    }

}
