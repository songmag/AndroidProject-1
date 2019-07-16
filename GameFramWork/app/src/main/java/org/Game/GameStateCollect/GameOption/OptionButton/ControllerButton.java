package org.Game.GameStateCollect.GameOption.OptionButton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import org.Controller.I_Controller;
import org.Controller.MoveKeyPad;
import org.Controller.MoveTouch;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;
import org.FrameWork.GraphicObject;
import org.Game.GameStateCollect.GameMenu.MenuButton.I_Button;

public class ControllerButton implements I_Button {
    private Bitmap m_switch;
    private Rect src,dest;
    public ControllerButton(Bitmap _bitmap,int _x,int _y)
    {
        m_switch = _bitmap;
        if(checkController(AppManager.getInstance().getM_controller())==0)
        {
            src = new Rect(0,0,m_switch.getWidth()/2,m_switch.getHeight());
        }
        else
        {
            src = new Rect(m_switch.getWidth()/2,0,m_switch.getWidth(),m_switch.getHeight());
        }
        dest = new Rect(_x,_y,_x+m_switch.getWidth()/2,_y+m_switch.getHeight());
    }
    private int checkController(I_Controller controller)
    {
        if(controller instanceof MoveKeyPad)
            return 0;
        else
            return 1;
    }
    @Override
    public void method() {
        if(checkController(AppManager.getInstance().getM_controller())==0)
        {
            AppManager.getInstance().setM_controller(new MoveTouch());
            src.set(m_switch.getWidth()/2,0,m_switch.getWidth(),m_switch.getHeight());
        }
        else
        {
            AppManager.getInstance().setM_controller(new MoveKeyPad());
            src = new Rect(0,0,m_switch.getWidth()/2,m_switch.getHeight());
        }
    }
    @Override
    public boolean check_contain_point(int x, int y) {
        return dest.contains(x,y);
    }
    @Override
    public void Draw(Canvas canvas) {
        float text_size = AppManager.getInstance().getPaint().getTextSize();
        Paint paint = AppManager.getInstance().getPaint();
        canvas.drawText("KeyPad",dest.left-text_size,dest.top-text_size,paint);
        canvas.drawText("Touch",dest.right-text_size*2,dest.top-text_size,paint);
        canvas.drawBitmap(m_switch,src,dest,null);
    }
}
