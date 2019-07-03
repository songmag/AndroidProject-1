package org.Game.CoinPackage;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.MovePackage.I_MovePattern;
import org.MovePackage.ThrowObject;

public class Money extends SpriteAnimation implements ThrowObject,I_Money,I_MoneyMove{
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
        movePattern.Update(this);
    }

    @Override
    public Money getMoneyClass() {
        return this;
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

    @Override
    public void addInGameMoney(Money money) {
        m_InGameMoney += money.m_InGameMoney;
    }

    @Override
    public void addMoney(int money) {
        this.m_Money += money;
    }
    @Override
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
