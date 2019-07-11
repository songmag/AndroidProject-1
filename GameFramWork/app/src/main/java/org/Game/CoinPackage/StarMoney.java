package org.Game.CoinPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;

public class StarMoney extends Money {

    public StarMoney()
    {
        super();
        initSpriteData(m_bitmap.getWidth()/5,m_bitmap.getHeight(),20,5);
        setM_Money(100);
    }
    public StarMoney(Bitmap m_bitmap) {
        super(m_bitmap);
        initSpriteData(this.m_bitmap.getWidth()/5,this.m_bitmap.getHeight(),20,5);
        setM_Money(100);
    }
}
