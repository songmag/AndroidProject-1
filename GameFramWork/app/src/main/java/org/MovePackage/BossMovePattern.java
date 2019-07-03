package org.MovePackage;

import com.example.gameframework.org.FrameWork.AppManager;

public class BossMovePattern implements I_MovePattern {

    @Override
    public void Update(ThrowObject object) {
        move(object);
    }
    @Override
    public void move(ThrowObject object) {
        if(object.get_x() <= ((AppManager.getInstance().getM_GameView().getFullWidth()/2)-(object.get_rect().width()/2))) {
            object.set_xy(object.getSpeed(),(int)(Math.sin(AppManager.getInstance().getM_GameView().getM_state().rand.nextDouble()-0.5)*20));
        }
        else
        {

        }
    }
}
