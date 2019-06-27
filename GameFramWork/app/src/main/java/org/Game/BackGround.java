package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.GraphicObject;

public class BackGround extends GraphicObject {
   static final float SCROLL_SPEED = 0.2f;
   private float m_scroll = -2000+480;

    public BackGround()
   {
       super(AppManager.getInstance().getBitMap(R.drawable.background2));
       this.setPosition(0,(int)m_scroll);
   }
   public void Update(long GameTime){
        m_scroll += SCROLL_SPEED;
        if(m_scroll >= 0) m_scroll = 0;
        setPosition(0,(int)m_scroll);
   }
}
