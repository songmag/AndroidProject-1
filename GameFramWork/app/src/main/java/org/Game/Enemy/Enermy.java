package org.Game.Enemy;

import android.graphics.Bitmap;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public abstract class Enermy extends SpriteAnimation {
    public static final int MOVE_PATTERN_1 = 0;
    public static final int MOVE_PATTERN_2 = 1;
    public static final int MOVE_PATTERN_3 = 2;
    public static final int MOVE_BOSS_PATTERN = 3;
    public static final Class[] Enemys_name = {Flower.class,Goomba.class,Turtle.class};
    public int destroy_count=0;

    public static final int STATE_NORMAL = 0;
    public static final int STATE_OUT = 1;

    private int m_state;

    protected int hp;
    protected float speed;
    protected int movetype;
    protected Bitmap m_DestroyBitmap = null;

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
        else
        {
            if(m_x <= ((AppManager.getInstance().getM_GameView().getFullWidth()/2)-(m_bitmap.getWidth()/4))) {
                m_x += speed;
                m_y += (int)(Math.sin(AppManager.getInstance().getM_GameView().getM_state().rand.nextDouble()-0.5)*20);
            }
            else
            {

            }
        }
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        if(m_state == Enermy.STATE_OUT && this.destroy_count != 0)
            this.destroy_count += 1;
        else if(m_state == Enermy.STATE_OUT){
            if(this.hp <= 0)
            AppManager.getInstance().getM_GameView().getM_state().makeMoney(this);
            destroy();
            this.destroy_count+=1;
        }
        if(getM_x()>= AppManager.getInstance().getM_GameView().getFullWidth() || getM_x() < 0  ||
                getM_y() > AppManager.getInstance().getM_GameView().getFullHeight() && m_state != Enermy.STATE_OUT && movetype != Enermy.MOVE_BOSS_PATTERN)
        {
            this.setM_state(Enermy.STATE_OUT);
        }
        move();
        attack();
    }
    public void attack(){}
    public void destroy(){
        setM_bitmap(this.m_DestroyBitmap);
        initSpriteData(m_DestroyBitmap.getWidth()/4,m_DestroyBitmap.getHeight(),20,4);
    }
    abstract public void setM_DestroyBitmap(Bitmap bitmap);
    abstract public void set_State(int hp,float speed,int type);
}
