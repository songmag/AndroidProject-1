package org.Game.CoinPackage;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public class BronzeMoney extends Money implements I_Money,I_MoneyMove {
    public BronzeMoney() {
        super(AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.coin),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()/10
        ));
        initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setM_Money(50);
    }
    public BronzeMoney(SpriteAnimation animation) {
        super(animation);
    }

}
