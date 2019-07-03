package org.Game.Enemy;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.MovePackage.I_MovePattern;
import org.MovePackage.ThrowObject;

public abstract class Enermy extends SpriteAnimation implements ThrowObject {

    public int destroy_count=0;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;
    private int m_state;

    protected int hp;
    protected float speed;
    protected Bitmap m_DestroyBitmap = null;

    private I_MovePattern pattern;
    public void hert(int damage) {
        this.hp -=damage;
    }

    public int getM_state() {
        return m_state;
    }

    public void setM_state(int m_state) {
        this.m_state = m_state;
    }

    public Enermy(Bitmap _bitmap) {
        super(AppManager.getInstance().reSizing(_bitmap,AppManager.getInstance().getM_GameView().getFullWidth(),200));
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.m_state = Enermy.STATE_NORMAL;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        pattern.Update(this);
        if(m_state == Enermy.STATE_OUT && this.destroy_count != 0) {
            this.destroy_count += 1;
        }
        else if(m_state == Enermy.STATE_OUT){
            if(this.hp <= 0)
               AppManager.getInstance().getM_GameView().getM_state().makeMoney(this);
            destroy();
            this.destroy_count+=1;
        }
        attack();
    }
    public void attack(){}
    public void destroy(){
        setM_bitmap(this.m_DestroyBitmap);
        initSpriteData(m_DestroyBitmap.getWidth()/4,m_DestroyBitmap.getHeight(),20,4);
    }
    abstract public void setM_DestroyBitmap(Bitmap bitmap);
    abstract public void set_State(int hp,float speed);

    @Override
    public void set_State(I_MovePattern move) {
        pattern = move;
    }

    @Override
    public boolean checkUpdate() {
        if(getM_x()+getM_rect().width()*2 > AppManager.getInstance().getM_GameView().getFullWidth() && m_state != Enermy.STATE_OUT)
        {
            setPosition(m_x-10,m_y);
            return true;
        }
        if(getM_x() <= -30 && m_state != Enermy.STATE_OUT)
        {
            setPosition(-10,m_y);
            return true;
        }
        if(getM_y() >= AppManager.getInstance().getM_GameView().getFullHeight() && m_state != Enermy.STATE_OUT)
        {
            setPosition(m_x,-100);
            return true;
        }
        if(m_y <= -200)
        {
           setPosition(m_x,-100);
           return true;
        }
        return false;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void set_xy(float _x, float _y) {
        this.m_x += _x;
        this.m_y += _y;
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
        return getM_rect();
    }
}
