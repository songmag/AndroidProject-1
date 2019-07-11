package org.Game.Enemy;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class OhBoss extends Boss {
    public OhBoss() {
        super(GraphicManager.getInstance().getEnemy(OhBoss.class));
        initSpriteData(m_bitmap.getWidth()/8,m_bitmap.getHeight(),20,8);
    }
}
