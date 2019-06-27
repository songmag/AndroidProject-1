package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public class Player extends SpriteAnimation {
    public Player(Bitmap m_bitmap) {
        super(m_bitmap);
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setPosition(AppManager.getInstance().getM_view().getFullWidth()/2-(m_bitmap.getWidth()/12),AppManager.getInstance().getM_view().getFullHeight()-300);
    }
}
