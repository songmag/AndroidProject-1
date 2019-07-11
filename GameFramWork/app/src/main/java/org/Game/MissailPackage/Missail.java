package org.Game.MissailPackage;

import android.graphics.Bitmap;
import android.graphics.Rect;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;
import org.FrameWork.GraphicObject;

import org.Game.MovePackage.I_MovePattern;
import org.Game.MovePackage.ThrowObject;

public abstract class Missail extends GraphicObject implements ThrowObject {
    public static final Class[] missail_name = {BlackMissail.class,GoldMissail.class,BossMissail.class};
    //Missail 종류를 담고있는 클래스 객체
    protected float missail_speed;
    protected int damage;
    private int m_state;
    protected Rect m_nowRect;//GrapicObject에는 없는 지금 현재 rect 상황

    public final static int STATE_NORMAL = 0;

    private I_MovePattern pattern;//미사일의 패턴(위,아래)

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
    public Missail(){
        m_state = STATE_NORMAL;
    }
    public void Update(){
        m_nowRect = new Rect((int)m_x,(int)m_y,(int)m_x+ m_bitmap.getWidth(),(int)m_y+ m_bitmap.getHeight());
        pattern.Update(this);
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

    public void setChargingImage()
    {
        if(GraphicManager.getInstance().getChargingMissail() == null)
        {
            GraphicManager.getInstance().setChargingMissail(AppManager.getInstance().reSizing(m_bitmap,getM_bitmap().getWidth()*2,100));
        }
        m_bitmap = GraphicManager.getInstance().getChargingMissail();
    }
    @Override
    public void set_State(I_MovePattern move) {
        this.pattern = move;
    }
    @Override
    public boolean checkUpdate() {
        if(getM_x()>= AppManager.getInstance().getM_GameView().getFullWidth() || getM_x() < 0  ||
                getM_y() > AppManager.getInstance().getM_GameView().getFullHeight() || getM_y() <0&& m_state == 0)
        {
            this.m_state = Missail.STATE_OUT;
        }
        return false;
    }
    @Override
    public float getSpeed() {
        return missail_speed;
    }
    @Override
    public void set_xy(float _x, float _y) {
        m_x += _x;
        m_y += _y;
    }
    @Override
    public float get_x() {
        return m_x;
    }

    @Override
    public float get_y() {
        return m_y;
    }

    @Override
    public Rect get_rect() {
        return this.m_nowRect;
    }

    public abstract int getLimit();
    //미사일마다 발사 할 수 있는 미사일이 다르므로, setting을 하는 것보다,
    //각 미사일마다 만들어서 사용하는 것으로 abstract 하여, 구현 강제
    //미사일에 setting을 하는 것을 매번 할 수 있었으면..
}
