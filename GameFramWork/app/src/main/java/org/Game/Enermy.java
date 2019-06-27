package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.org.FrameWork.SpriteAnimation;

public abstract class Enermy extends SpriteAnimation {
    public static final int MOVE_PATTERN_1 = 0;
    public static final int MOVE_PATTERN_2 = 1;
    public static final int MOVE_PATTERN_3 = 2;

    protected int hp;
    protected float speed;
    protected int movetype;

    public Enermy(Bitmap m_bitmap) {
        super(m_bitmap);
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
    }
    public void attack(){}
    abstract public void set_State();
}
