package org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class SpriteAnimation extends GraphicObject {
    //테스트용 페인트
    private Rect m_rect;
    private int m_fps;//초당 몇 프레임
    private int m_iFrames;//총 프레임 개수
    private long m_frameTimer; //프레임 타이머 현재 시간을 가져온다.
    private int m_currentFrame;//현재 프레임
    private int m_spriteWidth; //보여줄 width
    private int m_spriteHeight; //보여줄 hight
    private Rect dest= null;
    public SpriteAnimation(Bitmap m_bitmap) {
        super(m_bitmap);
        m_rect = new Rect(0,0,0,0);
        m_frameTimer = 0;
        m_currentFrame=0;
    }
    public SpriteAnimation(SpriteAnimation animation)
    {
        super(animation.m_bitmap);
        initSpriteData(animation.m_spriteWidth,animation.m_spriteHeight,animation.m_fps,animation.m_iFrames);
    }
    public Rect getM_rect() {
       return dest;
    }
    public void initSpriteData(int _width,int _height,int _fps,int _iFrame)
    {
        m_frameTimer = 0;
        m_currentFrame = 0;
        m_spriteHeight = _height;
        m_spriteWidth = _width;
        m_rect.top = 0; m_rect.bottom = m_spriteHeight;
        m_rect.left = 0; m_rect.right = m_spriteWidth;
        m_fps = 1000/_fps;
        m_iFrames = _iFrame;
    }
    @Override
    public void Draw(Canvas canvas) {
        if(dest == null)
        this.dest = new Rect((int)m_x,(int)m_y,(int)m_x+ m_spriteWidth,(int)m_y+ m_spriteHeight);
        dest.set((int)m_x,(int)m_y,(int)m_x+ m_spriteWidth,(int)m_y+ m_spriteHeight);
        canvas.drawBitmap(m_bitmap,m_rect,dest,null);
    }
    public void Update(long gameTime)
    {
        if(gameTime > m_frameTimer + m_fps)
        {
            m_frameTimer = gameTime;
            m_currentFrame += 1;
            if(m_currentFrame >= m_iFrames)
            {
                m_currentFrame = 0;
            }//프레임의 순환
        }
        m_rect.left = m_currentFrame*m_spriteWidth;
        m_rect.right = m_rect.left+m_spriteWidth;
    }
}//Grapic Object를 상속받아서 target Rect를 변환시켜, 해당 이미지를 애니메이션 효과를 주는 클래스
