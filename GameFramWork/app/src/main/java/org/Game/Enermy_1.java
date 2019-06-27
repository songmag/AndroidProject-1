package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Enermy_1 extends Enermy {
    public Enermy_1() {
        super(AppManager.getInstance().getBitMap(R.drawable.enemy1));
    }
    public Enermy_1(Bitmap m_bitmap) {
        super(m_bitmap);
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
