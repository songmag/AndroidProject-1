package org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GraphicObject {

    protected Bitmap m_bitmap;
    protected float m_x;
    protected float m_y;

    public GraphicObject(Bitmap m_bitmap) {
        this.m_bitmap = m_bitmap;
        m_x = 0;
        m_y = 0;
    }
    public void setPosition(float x, float y)
    {
        m_x = x;
        m_y = y;
    }
    public Bitmap getM_bitmap() {
        return m_bitmap;
    }

    public void setM_bitmap(Bitmap m_bitmap) {
        this.m_bitmap = m_bitmap;
    }

    public void Draw(Canvas canvas){
        canvas.drawBitmap(m_bitmap,m_x,m_y,null);
    }

    public float getM_x() {
        return m_x;
    }
    public float getM_y() {
        return m_y;
    }
}
