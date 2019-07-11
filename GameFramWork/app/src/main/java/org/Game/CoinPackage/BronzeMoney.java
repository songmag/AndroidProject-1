package org.Game.CoinPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.SpriteAnimation;

public class BronzeMoney extends Money  {
    public BronzeMoney() {
        super();
        initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setM_Money(50);
    }
    public BronzeMoney(Bitmap _bitmap) {
        super(_bitmap);
        initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setM_Money(50);
    }
    public BronzeMoney(SpriteAnimation animation) {
        super(animation);
    }

}
