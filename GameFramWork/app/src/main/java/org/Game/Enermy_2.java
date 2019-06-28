package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Enermy_2 extends Enermy {
    @Override
    public void set_State(int hp, float speed, int type) {
        this.hp = hp;
        this.speed = speed;
        this.movetype = type;
    }
    public Enermy_2(Bitmap m_bitmap) {
        super(m_bitmap);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));

    }

    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap= bitmap;
    }

    public Enermy_2() {
        super(AppManager.getInstance().getBitMap(R.drawable.enemy2));
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }
}
