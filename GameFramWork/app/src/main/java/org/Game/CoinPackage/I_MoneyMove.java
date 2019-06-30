package org.Game.CoinPackage;

import android.graphics.Canvas;

public interface I_MoneyMove extends I_Money {
    public void Update(long currenttime);
    public int getState();
    public void move();
    public void destroy();

    public void addMoney(Money money);
    public void addInGameMoney(Money money);
    public void addMoney(int money);
    public void addInGameMoney(int money);

    public void spendMoney(int value);
    public void Draw(Canvas canvas);
}
