package org.Game.Enemy;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class WingBoss extends Boss {
    public WingBoss() {
        super(GraphicManager.getInstance().getEnemy(WingBoss.class));
    }
}
