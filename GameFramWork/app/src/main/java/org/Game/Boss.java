package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public class Boss extends Enermy {
    public Boss(Bitmap m_bitmap) {
        super( AppManager.getInstance().reSizing(m_bitmap,AppManager.getInstance().getM_view().getFullWidth()/2
                ,AppManager.getInstance().getM_view().getFullHeight()/5));
    }

    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap = bitmap;
    }

    @Override
    public void set_State(int hp, float speed, int type) {
        this.hp = hp;
        this.speed = speed;
        this.movetype = type;
    }

    public Boss()
    {
        super(
                AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.default_boss),
                        AppManager.getInstance().getM_view().getFullWidth()/2
                ,AppManager.getInstance().getM_view().getFullHeight()/5)
        );
        this.initSpriteData(m_bitmap.getWidth()/4,m_bitmap.getHeight(),20,4);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));

    }
}
