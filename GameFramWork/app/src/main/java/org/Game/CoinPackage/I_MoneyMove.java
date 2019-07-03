package org.Game.CoinPackage;

import android.graphics.Canvas;

public interface I_MoneyMove extends I_Money {
    void Update(long currenttime);
    int getState();
    void move();
    void destroy();

    void addMoney(Money money);
    void addInGameMoney(Money money);
    void addMoney(int money);
    void addInGameMoney(int money);

    void spendMoney(int value);
    void Draw(Canvas canvas);
}
