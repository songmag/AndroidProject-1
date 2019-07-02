package org.Game.Enemy;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Flower extends Enermy {
    public Flower() {
        super(AppManager.getInstance().getBitMap(R.drawable.flower));
        initSpriteData(m_bitmap.getWidth()/5,m_bitmap.getHeight(),20,5);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }

    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap = bitmap;
    }

    public Flower(Bitmap m_bitmap) {
        super(m_bitmap);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }
    @Override
    public void attack() {
    }
    @Override
    public void set_State(int hp,float speed,int type) {
        super.hp = hp;
        super.speed = speed;
        super.movetype = type;
    }
}
