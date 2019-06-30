package com.example.gameframework.org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteAddBackground extends BackGround {
    private SpriteAnimation m_spriteforeground;

    public SpriteAddBackground(SpriteAnimation m_spriteforeground) {
        this.m_spriteforeground = m_spriteforeground;
    }
    public SpriteAddBackground(Bitmap add_bitmap) {
        super(add_bitmap);
    }
    public SpriteAddBackground(int type) {
        super(type);
    }
    @Override
    public void Draw(Canvas canvas) {
        super.Draw(canvas);
        m_spriteforeground.Draw(canvas);
    }
}
