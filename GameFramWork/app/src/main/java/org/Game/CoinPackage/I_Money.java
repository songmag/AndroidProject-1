package org.Game.CoinPackage;

import android.graphics.Rect;

public interface I_Money {
    public int getMoney();
    public void setMoney(Money money);
    public int getIngameMoney();
    public void setIngameMoney(Money money);
    public Rect getM_rect();
    public Money getMoneyClass();
}
