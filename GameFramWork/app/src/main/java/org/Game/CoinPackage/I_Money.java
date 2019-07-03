package org.Game.CoinPackage;

import android.graphics.Rect;

public interface I_Money {
    int getMoney();
    void setMoney(Money money);
    int getIngameMoney();
    void setIngameMoney(Money money);
    Rect getM_rect();
    Money getMoneyClass();
}
