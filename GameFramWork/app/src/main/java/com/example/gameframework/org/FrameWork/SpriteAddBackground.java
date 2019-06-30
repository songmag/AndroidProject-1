package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteAddBackground extends BackGround {
    private SpriteAnimation m_spriteforeground;

    public SpriteAddBackground(SpriteAnimation m_spriteforeground,int x,int y) {
        super();
        this.m_spriteforeground = m_spriteforeground;
        m_spriteforeground.initSpriteData(m_spriteforeground.m_bitmap.getWidth()/3,m_spriteforeground.m_bitmap.getHeight(),3,3);
        m_spriteforeground.setPosition(x,y);
    }
    public SpriteAddBackground(Bitmap add_bitmap) {
        super(add_bitmap);
    }
    public SpriteAddBackground(int type) {
        super(type);
    }
    @Override
    public void Update(long GameTime) {
        m_spriteforeground.Update(GameTime);
        super.Update(GameTime);
    }

    @Override
    public void Draw(Canvas canvas) {
        super.Draw(canvas);
        m_spriteforeground.Draw(canvas);
    }
}
