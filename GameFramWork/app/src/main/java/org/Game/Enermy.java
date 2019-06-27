package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public abstract class Enermy extends SpriteAnimation {
    public static final int MOVE_PATTERN_1 = 0;
    public static final int MOVE_PATTERN_2 = 1;
    public static final int MOVE_PATTERN_3 = 2;

    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;
    private int m_state;
    protected int hp;
    protected float speed;
    protected int movetype;
    protected Missail missail;

    public int getM_state() {
        return m_state;
    }
    public void setM_state(int m_state) {
        this.m_state = m_state;
    }

    public Enermy(Bitmap m_bitmap) {
        super(m_bitmap);
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
    }
    public void move() {
        if (movetype == MOVE_PATTERN_1) {
            if(m_y <= 200) m_y += speed;
            else m_y += speed *2;
        }
        else if (movetype == MOVE_PATTERN_2) {
            if (m_y <= 200)
                m_y += speed; // 중간지점까지 일자로 이동
            else {
                m_x += speed; // 중감지점이후 대각선 이동
                m_y += speed;
            }
        }
        else if (movetype == MOVE_PATTERN_3) {
            if(m_y <= 200)
                m_y += speed;
            else
            {
                m_x -= speed;
                m_y += speed;
            }
        }
    }
    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        move();
        if(getM_x()>= AppManager.getInstance().getM_view().getFullWidth() || getM_x() < 0 - m_bitmap.getWidth() ||
        getM_y() > AppManager.getInstance().getM_view().getFullHeight())
        {
            m_state = Enermy.STATE_OUT;
        }
    }
    public void attack(){}
    abstract public void set_State(int hp,float speed,int type);
}
