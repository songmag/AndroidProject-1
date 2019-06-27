package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Enermy_1 extends Enermy {
    public Enermy_1() {
        super(AppManager.getInstance().getBitMap(R.drawable.enemy1));
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        movetype = Enermy.MOVE_PATTERN_2;
        set_State();
    }
    public Enermy_1(Bitmap m_bitmap) {
        super(m_bitmap);
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        movetype = Enermy.MOVE_PATTERN_2;
        set_State();
    }

    @Override
    public void attack() {

    }

    @Override
    public void set_State() {
        hp = 10;
        speed = 2.5f;
    }
}
