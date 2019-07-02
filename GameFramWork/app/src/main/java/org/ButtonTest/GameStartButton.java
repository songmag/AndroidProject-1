package org.ButtonTest;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public class GameStartButton extends GraphicObject implements I_Button {

    public GameStartButton(Bitmap m_bitmap,int _x,int _y) {
        super(m_bitmap);
        setPosition(_x,_y);
    }
    @Override
    public boolean check_contain_point(int x, int y) {
        Rect rect = new Rect(this.getM_x(),this.getM_y(),this.getM_x()+this.getM_bitmap().getWidth(),this.getM_y()+this.getM_bitmap().getHeight());
        if(rect.contains(x,y))
            return true;
        return false;
    }
    @Override
    public void method() {
        AppManager.getInstance().getM_GameView().changeGameState(
                AppManager.getInstance().m_stage.gameStates[0]
        );
    }

}
