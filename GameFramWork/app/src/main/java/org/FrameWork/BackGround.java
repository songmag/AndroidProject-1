package org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.gameframework.R;

public class BackGround extends GraphicObject {
    static final float SCROLL_SPEED = 7.0f;
    private float m_scroll = -AppManager.getInstance().getM_GameView().getFullHeight()*5+AppManager.getInstance().getM_GameView().getFullHeight();
    private Bitmap m_layer2 = null;
    static final float SCROLL_SPEED_2 = 7.0f;
    private float m_scroll_2 = -AppManager.getInstance().getM_GameView().getFullHeight()*5+AppManager.getInstance().getM_GameView().getFullHeight();

    public BackGround() {
        super(AppManager.getInstance().getBitMap(R.drawable.background2));
        m_layer2 = AppManager.getInstance().getBitMap(R.drawable.background_2);
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*5);
        m_layer2 = AppManager.getInstance().reSizing(m_layer2, AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*5);
        this.setPosition(0, (int) m_scroll);
    }//background 생성자 기본(2개의 layer로 구성)
    public BackGround(Bitmap add_bitmap)
    {
        super(add_bitmap);
       this.setPosition(0, (int) m_scroll);
    }//background 생성자.
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
               AppManager.getInstance().getM_GameView().getFullHeight()*5);
       m_layer2 = AppManager.getInstance().reSizing(m_layer2,AppManager.getInstance().getM_GameView().getFullWidth(),
               AppManager.getInstance().getM_GameView().getFullHeight()*5);
       this.setPosition(0,(int)m_scroll);
   }//생성될때 type으로 해당 배경을 설정한다.

   public void Update(long GameTime){
        if(m_bitmap.getHeight() == AppManager.getInstance().getM_GameView().getFullHeight()) return;
        m_scroll += SCROLL_SPEED;
        if(m_scroll >= 0) m_scroll = 0;
        setPosition(0,(int)m_scroll);
        m_scroll_2 += SCROLL_SPEED_2;
        if(m_scroll_2 >= 0) m_scroll_2=0;
   }//스크롤링 방식으로 위로 올라가는 효과를 발생하기 위한 방법.

    @Override
    public void setM_bitmap(Bitmap m_bitmap) {
        super.setM_bitmap(m_bitmap);
        this.m_bitmap = AppManager.getInstance().reSizing(this.m_bitmap,AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()*5);
        this.setPosition(0,(int)m_scroll);        
    }
    //GrapicObject에 담는 기본이 되는 게임 백그라운드를 설정한다.
    //height의 경우 스크롤링 방식을 위해 늘린다.
    @Override
    public void Draw(Canvas canvas) {
        canvas.drawBitmap(m_bitmap,m_x,m_y,null);
        if(m_layer2 != null)
        canvas.drawBitmap(m_layer2,m_x,m_y,null);
    }
    //해당 비트맵 뷰에 그린다.
}
