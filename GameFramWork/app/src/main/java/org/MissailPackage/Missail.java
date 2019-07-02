package org.MissailPackage;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public abstract class Missail extends GraphicObject {
    public final Class[] missail_name = {BlackMissail.class,GoldMissail.class};

    protected float missail_speed;
    protected int damage;
    private int m_state;
    protected Rect m_nowRect;
    public final static int STATE_NORMAL = 0;

    public final static int STATE_OUT = 1;

    public int getM_state() {
        return m_state;
    }
    public void setM_state(int m_state) {
        this.m_state = m_state;
    }
    public Missail(Bitmap m_bitmap) {
        super(m_bitmap);
        m_state = STATE_NORMAL;
    }
    public void Update(){
        m_nowRect = new Rect(m_x,m_y,m_x+m_bitmap.getWidth(),m_y+m_bitmap.getHeight());
    }

    public void set_State(float missail_speed,int damage){
        this.missail_speed = missail_speed;
        this.damage = damage;
    }
    public Rect getM_nowRect() {
        return m_nowRect;
    }
    public int getDamage() {
        return damage;
    }
    public void setBitmap(Bitmap _bitmap)
    {
        m_bitmap = _bitmap;
    }

    public float getMissail_speed() {
        return missail_speed;
    }

    public void setMissail_speed(float missail_speed) {
        this.missail_speed = missail_speed;
    }
    public abstract int getLimit();
}
