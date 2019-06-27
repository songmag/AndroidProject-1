package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GraphicObject {
    public Bitmap getM_bitmap() {
        return m_bitmap;
    }

    protected Bitmap m_bitmap;
    protected int m_x;
    protected int m_y;

    public GraphicObject(Bitmap m_bitmap) {
        this.m_bitmap = m_bitmap;
        m_x = 0;
        m_y = 0;
    }
    public void setPosition(int x,int y)
    {
        m_x = x;
        m_y = y;
    }

    public void Draw(Canvas canvas){
        canvas.drawBitmap(m_bitmap,m_x,m_y,null);
    }
    public int getM_x() {
        return m_x;
    }
    public int getM_y() {
        return m_y;
    }
}
