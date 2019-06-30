package org.Game.CoinPackage;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public class Money extends SpriteAnimation implements I_Money,I_MoneyMove{
    private int m_Money;
    private int m_InGameMoney;
    protected float m_speed;
    private int m_state;
    public static final int STATE_NOMAL= 0;
    public static final int STATE_OUT = 1;

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
    public int getM_Money() {
        return m_Money;
    }
    public void setM_Money(int m_Money) {
        this.m_Money = m_Money;
    }
    public int getM_InGameMoney() {
        return m_InGameMoney;
    }
    public void setM_InGameMoney(int m_InGameMoney) {
        this.m_InGameMoney = m_InGameMoney;
    }

    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        if(getM_x()>= AppManager.getInstance().getM_GameView().getFullWidth() || getM_x() < 0  ||
                getM_y() > AppManager.getInstance().getM_GameView().getFullHeight() && m_state != 0)
        {
            this.m_state = Money.STATE_OUT;
        }
        move();
    }

    @Override
    public int getState() {
        return m_state;
    }

    @Override
    public void move() {
        m_y += m_speed;
    }

    @Override
    public void destroy() {

    }
    @Override
    public void addMoney(Money money) {

    }
    @Override
    public void spendMoney(int value) {

    }
    @Override
    public int getMoney() {
        return this.m_Money;
    }
    @Override
    public void setMoney(Money money) {
        m_Money = money.m_Money;
    }
    @Override
    public int getIngameMoney() {
        return m_InGameMoney;
    }
    @Override
    public void setIngameMoney(Money money) {
        m_InGameMoney = money.m_InGameMoney;
    }
}
