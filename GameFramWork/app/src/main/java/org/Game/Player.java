package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

public class Player extends SpriteAnimation {
    public Player(Bitmap m_bitmap) {
        super(m_bitmap);
        this.initSpriteData(62,104,20,6);
        this.setPosition(140,380);
    }
}
