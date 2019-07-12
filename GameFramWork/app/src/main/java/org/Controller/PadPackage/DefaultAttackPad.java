package org.Controller.PadPackage;

import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class DefaultAttackPad extends AttackPadClass {

    @Override
    public void setLocationFiled() {
        src = GraphicManager.getInstance().defaultAttack();
        dest = new Rect(x_turm*4,y_turm*6,x_turm*5,y_turm*7);
    }
    @Override
    public boolean touchEvent(MotionEvent event) {
        if(AppManager.getInstance().getM_GameView().getM_state().getM_player() != null)
            if(!AppManager.getInstance().getM_GameView().getM_state().getM_player().isM_death())
                if(event.getAction() == MotionEvent.ACTION_DOWN|| event.getAction() == MotionEvent.ACTION_MOVE) {
            if(dest.contains((int)event.getX(),(int)event.getY())) {
                src = GraphicManager.getInstance().onClickAttack();
                AppManager.getInstance().getM_GameView().getM_state().getM_player().attack();
            }
            else
            {
                src = GraphicManager.getInstance().defaultAttack();
            }
        }
        else
        {
            src = GraphicManager.getInstance().defaultAttack();
        }
        return false;
    }
}
