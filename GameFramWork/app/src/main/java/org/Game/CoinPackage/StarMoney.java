package org.Game.CoinPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class StarMoney extends Money implements I_Money,I_MoneyMove {

    public StarMoney()
    {
        super(AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.star),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()/10
        ));
        initSpriteData(m_bitmap.getWidth()/5,m_bitmap.getHeight(),20,5);
        setM_Money(100);
    }
    public StarMoney(Bitmap m_bitmap) {
        super(m_bitmap);
        initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
    }
}
