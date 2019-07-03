package org.Game.Enemy;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class WingBoss extends Boss {
    public WingBoss() {
        super(AppManager.getInstance().getBitMap(R.drawable.wing));
    }
}
