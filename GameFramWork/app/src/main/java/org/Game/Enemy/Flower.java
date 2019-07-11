package org.Game.Enemy;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class Flower extends Enermy {
    public Flower() {
        super(GraphicManager.getInstance().getEnemy(Flower.class));
        initSpriteData(m_bitmap.getWidth()/5,m_bitmap.getHeight(),20,5);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }
    public Flower(Bitmap m_bitmap) {
        super(m_bitmap);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }
    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap = bitmap;
    }
    @Override
    public void attack() {
    }
    @Override
    public void set_State(int hp,float speed) {
        super.hp = hp;
        super.speed = speed;
    }
}
