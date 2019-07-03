package org.Game.CoinPackage;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.SpriteAnimation;

import org.Game.MovePackage.I_MovePattern;
import org.Game.MovePackage.ThrowObject;

public class Money extends SpriteAnimation implements ThrowObject{
    private int m_Money;
    private int m_InGameMoney;
    protected float m_speed;
    private int m_state;
    public static final int STATE_NOMAL= 0;
    public static final int STATE_OUT = 1;
    protected I_MovePattern movePattern;
    public Money(){
        super(AppManager.getInstance().getBitMap(R.drawable.coin));
    }
    public Money(SpriteAnimation animation) {
        super(animation);
        m_state = Money.STATE_NOMAL;
        m_speed = 5.5f;
    }
    public Money(Bitmap m_bitmap) {
        super(m_bitmap);
        m_state = Money.STATE_NOMAL;
        m_speed = 5.5f;
    }

    public int getM_state() {
        return m_state;
    }

    public int getM_Money() {
        return m_Money;
    }
    public void setM_Money(int m_Money) {
        this.m_Money = m_Money;
    }

    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        movePattern.Update(this);
    }

    public int getIngameMoney() {
        return m_InGameMoney;
    }
    public void addMoney(int money) {
        this.m_Money += money;
    }
    public void addInGameMoney(int money) {
        this.m_InGameMoney += money;
    }

    @Override
    public void set_State(I_MovePattern move) {
        this.movePattern = move;
    }

    @Override
    public boolean checkUpdate() {
        if(getM_x()>= AppManager.getInstance().getM_GameView().getFullWidth() || getM_x() < 0  ||
                getM_y() > AppManager.getInstance().getM_GameView().getFullHeight() || getM_y() <0&& m_state == 0)
        {
            this.m_state = Money.STATE_OUT;
        }
        return false;
    }

    @Override
    public float getSpeed() {
        return this.m_speed;
    }

    @Override
    public void set_xy(float _x, float _y) {
        m_x += (int)_x;
        m_y += (int)_y;
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
