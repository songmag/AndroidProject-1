package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class Enermy_3 extends Enermy {
    public Enermy_3(Bitmap m_bitmap) {
        super(m_bitmap);
    }
    public Enermy_3()
    {
        super(AppManager.getInstance().getBitMap(R.drawable.enemy3));
    }
    @Override
    public void set_State(int hp, float speed, int type) {
        this.hp = hp;
        this.speed = speed;
        this.movetype = type;
    }
}
