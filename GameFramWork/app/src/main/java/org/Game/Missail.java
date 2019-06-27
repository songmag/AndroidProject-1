package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public class Missail extends GraphicObject {
    protected float missail_speed;
    protected int damage;
    private int m_state;

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

    }

    public void set_State(float missail_speed,int damage){
        this.missail_speed = missail_speed;
        this.damage = damage;
    }
}
