package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class PlayerMissail extends Missail {
    public PlayerMissail(int x,int y) {
        super(AppManager.getInstance().getBitMap(R.drawable.missile_1));
       setPosition(x,y);
    }
    @Override
    public void Update()
    {
        m_y -= missail_speed;
        if(this.m_y < 0)
        {
            this.setM_state(Missail.STATE_OUT);
        }
    }
}
