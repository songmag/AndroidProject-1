package org.ButtonTest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public class GameOptionButton extends GraphicObject implements I_Button {
    public GameOptionButton(Bitmap m_bitmap,int _x,int _y) {
        super(m_bitmap);
        setPosition(_x,_y);
    }
    @Override
    public void method() {

    }

    @Override
    public void Draw(Canvas canvas) {
        super.Draw(canvas);
        Paint paint = AppManager.getInstance().getPaint();
        paint.setTextSize(70);
        canvas.drawText("Option",this.getM_x()+this.getM_bitmap().getWidth()/4,this.getM_y()+this.getM_bitmap().getHeight()-paint.getTextSize()/2,paint);
    }

    @Override
    public boolean check_contain_point(int x, int y) {
        Rect rect = new Rect(this.getM_x(),this.getM_y(),this.getM_x()+this.getM_bitmap().getWidth(),this.getM_y()+this.getM_bitmap().getHeight());
        if(rect.contains(x,y))
            return true;
        return false;
    }
}
