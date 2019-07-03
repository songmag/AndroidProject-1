package org.Game.Enemy;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class OhBoss extends Boss {
    public OhBoss() {
        super(AppManager.getInstance().getBitMap(R.drawable.ohh));
        initSpriteData(m_bitmap.getWidth()/8,m_bitmap.getHeight(),20,8);
    }
}
