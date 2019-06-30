package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public class BackGround extends GraphicObject {
   static final float SCROLL_SPEED = 0.2f;
   private float m_scroll = -2000+480;
    private Bitmap m_layer2;
    static final float SCROLL_SPEED_2 = 0.2f;
    private float m_scroll_2 = -2000+480;

    public BackGround() {
        super(AppManager.getInstance().getBitMap(R.drawable.background2));
        m_layer2 = AppManager.getInstance().getBitMap(R.drawable.background_2);
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*4);
        m_layer2 = AppManager.getInstance().reSizing(m_layer2, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*4);
        this.setPosition(0, (int) m_scroll);
    }
    public BackGround(Bitmap add_bitmap)
    {
        super(AppManager.getInstance().getBitMap(R.drawable.background2));
        m_layer2 = AppManager.getInstance().getBitMap(R.drawable.background_2);
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*4);
        m_layer2 = AppManager.getInstance().reSizing(m_layer2, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*4);
        this.setPosition(0, (int) m_scroll);
    }
   public BackGround(int type)
   {
       super(null);
       if(type == 0)
       {
           m_bitmap = AppManager.getInstance().getBitMap(R.drawable.background1);
       }
       else if(type == 1)
       {
           m_bitmap = AppManager.getInstance().getBitMap(R.drawable.background2);
       }
       m_layer2 = AppManager.getInstance().getBitMap(R.drawable.background_2);
       m_bitmap = AppManager.getInstance().reSizing(m_bitmap,AppManager.getInstance().getM_GameView().getFullWidth(),
               AppManager.getInstance().getM_GameView().getFullHeight()*4);
       m_layer2 = AppManager.getInstance().reSizing(m_layer2,AppManager.getInstance().getM_GameView().getFullWidth(),
               AppManager.getInstance().getM_GameView().getFullHeight()*4);
       this.setPosition(0,(int)m_scroll);
   }
   public void Update(long GameTime){
        m_scroll += SCROLL_SPEED;
        if(m_scroll >= 0) m_scroll = 0;
        setPosition(0,(int)m_scroll);
        m_scroll_2 += SCROLL_SPEED_2;
        if(m_scroll_2 >= 0) m_scroll_2=0;
   }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(m_bitmap,m_x,m_y,null);
        canvas.drawBitmap(m_layer2,m_x,m_y,null);
    }
}
