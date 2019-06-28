package org.Game;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.CollisionManager;

import org.Game.Enemy.Boss;
import org.Game.Enemy.Enermy;
import org.Game.Enemy.Enermy_1;
import org.Game.Enemy.Enermy_2;
import org.Game.Enemy.Enermy_3;
import org.GameView.IStat;
import org.MissailPackage.Missail;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameState implements IStat {
    private Player m_player;
    private BackGround m_background;
    private LinkedList<Enermy> enermys;
    private long LastRegenEnemy;
    public Random rand = new Random();
    private long m_BossTime;
    private boolean m_BossFlag = false;
    protected boolean m_StageClear = false;
    protected int distroy_enem = 0;

    @Override
    public void init() {
        LastRegenEnemy = System.currentTimeMillis();
        m_BossTime = LastRegenEnemy + 10000;
        m_player = new Player(AppManager.getInstance().getBitMap(R.drawable.player));
        m_background = new BackGround();
        enermys = new LinkedList<Enermy>();
        m_BossFlag = false;
        m_StageClear = false;
        distroy_enem =0;
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
            if(enermys.get(i).getM_state() == Enermy.STATE_OUT && enermys.get(i).destroy_count==0)
            {
                enermys.get(i).destroy();
            }
            if (enermys.get(i).getM_state() == Enermy.STATE_OUT && enermys.get(i).destroy_count >= 20){
                enermys.remove(i);
                distroy_enem += 1;
            }
        }
        for(int i=0 ; i < m_player.getMissails().size();i++)
        {
            m_player.getMissails().get(i).Update();
            if (m_player.getMissails().get(i).getM_state()== Missail.STATE_OUT) {
                m_player.getMissails().remove(i);
            }
        }
        makeEnermy();
        checkCollision();
        if(enermys.size() == 0 && m_BossFlag)
        {
            this.m_StageClear = true;
        }
    }
    @Override
    public void Render(Canvas canvas) {
        m_background.Draw(canvas);
        m_player.Draw(canvas);
        for(int i=0 ; i < enermys.size();i++)
        {
            enermys.get(i).Draw(canvas);
        }
        for(int i =0 ; i< m_player.getMissails().size();i++)
        {
            m_player.getMissails().get(i).Draw(canvas);
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
        return AppManager.getInstance().getM_controller().onTouchEvent(event);
    }
    public void makeEnermy()
    {
        if(System.currentTimeMillis()-LastRegenEnemy >= 1000 && !m_BossFlag) {
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
            enermy.setPosition(rand.nextInt(AppManager.getInstance().getM_GameView().getFullWidth()), -60);
            this.enermys.add(enermy);
        }
        if(System.currentTimeMillis()-m_BossTime >= 0 && !m_BossFlag)
        {
            for(int i = 0 ; i < enermys.size();i++)
            {
                enermys.get(i).destroy();
                enermys.get(i).setM_state(Enermy.STATE_OUT);
            }
            Enermy boss = new Boss();
            boss.set_State(50,1.0f,Enermy.MOVE_BOSS_PATTERN);
            boss.setPosition(0,200);
            this.enermys.add(boss);
            m_BossFlag = true;
        }
    }
    public void checkCollision(){
        for(Missail missail: m_player.getMissails()) {
            for(Enermy enem: enermys) {
                if(enem.getM_state() != Enermy.STATE_OUT)
                if( CollisionManager.checkBoxToBox(missail.getM_nowRect(), enem.getM_rect())){
                    missail.setM_state(Missail.STATE_OUT);
                    enem.hert(missail.getDamage());
                    if(enem.getHp() <= 0) {
                        enem.setM_state(Enermy.STATE_OUT);
                    }
                }
            }
        }
    }
    public Player getM_player() {
        return m_player;
    }

    public void setM_player(Player m_player) {
        this.m_player = m_player;
    }

    public List<Enermy> getEnermys() {
        return enermys;
    }

    public void setEnermys(LinkedList<Enermy> enermys) {
        this.enermys = enermys;
    }

}
