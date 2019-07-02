package org.Game.Enemy;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Goomba extends Enermy {
    @Override
    public void set_State(int hp, float speed, int type) {
        this.hp = hp;
        this.speed = speed;
        this.movetype = type;
    }
    public Goomba(Bitmap m_bitmap) {
        super(m_bitmap);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }

    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap= bitmap;
    }

    public Goomba() {
        super(AppManager.getInstance().getBitMap(R.drawable.goomba));
        initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }
}
