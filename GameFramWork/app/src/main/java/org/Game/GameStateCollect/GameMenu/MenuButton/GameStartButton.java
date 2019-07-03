package org.Game.GameStateCollect.GameMenu.MenuButton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import org.FrameWork.AppManager;
import org.FrameWork.GraphicObject;

public class GameStartButton extends GraphicObject implements I_Button {

    public GameStartButton(Bitmap m_bitmap,int _x,int _y) {
        super(m_bitmap);
        setPosition(_x,_y);
    }
    @Override
    public boolean check_contain_point(int x, int y) {
        Rect rect = new Rect((int)this.getM_x(),(int)this.getM_y(),(int)this.getM_x()+ this.getM_bitmap().getWidth(),(int)this.getM_y()+ this.getM_bitmap().getHeight());
        return rect.contains(x, y);
    }

    @Override
    public void Draw(Canvas canvas) {
        super.Draw(canvas);
        Paint paint = AppManager.getInstance().getPaint();
        paint.setTextSize(70);
        canvas.drawText("Start",this.getM_x()+this.getM_bitmap().getWidth()/4,this.getM_y()+this.getM_bitmap().getHeight()-paint.getTextSize()/2,paint);
    }

    @Override
    public void method() {
        AppManager.getInstance().getM_GameView().changeGameState(
                AppManager.getInstance().m_stage.gameStates[0]
        );
    }
}
