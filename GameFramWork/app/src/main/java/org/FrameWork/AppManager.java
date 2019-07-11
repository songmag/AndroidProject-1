package org.FrameWork;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;

import com.example.gameframework.R;

import org.Controller.I_Controller;
import org.Controller.MoveKeyPad;
import org.Controller.MoveTouch;
import org.Game.Player;
import org.Game.GameStateCollect.GameStageState;
import org.Game.GameView.GameView;

public class AppManager {
    //테스트를 위한 페인트
    private Paint paint;
    private GameView m_view;
    private Resources m_res;
    private Player player;
    private I_Controller m_controller= null;
    private static AppManager instance=null;
    public GameStageState m_stage;

    private AppManager()
    {
        m_stage = new GameStageState();
        this.m_res = null;
        this.m_view = null;
    }

    public void setM_view(GameView m_view) {
        this.m_view = m_view;
    }

    public Resources getM_res() {
        return m_res;
    }
    public void setM_res(Resources m_res) {
        this.m_res = m_res;
    }
    public Bitmap getBitMap(int r)
    {
        return BitmapFactory.decodeResource(m_res,r);
    }
    public void setM_controller(I_Controller m_controller) {
        this.m_controller = m_controller;
    }
    public I_Controller getM_controller() {
        if(m_controller == null)
        {
            GameView gameView = (GameView)m_view;
            m_controller = new MoveKeyPad(getM_GameView().getM_state());
        }
        return m_controller;
    }
    public static AppManager getInstance() {
        if(instance == null)
        {
            instance = new AppManager();
        }
        return instance;
    }
    public Bitmap reSizing(Bitmap map,int width,int height)
    {
        map = Bitmap.createScaledBitmap(map,width,height,true);
        return map;
    }//비트맵을 해당 width,height 로 resizing을 한다.
    public GameView getM_GameView()
    {
        return (GameView)m_view;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Paint getPaint()
    {
        if(paint == null){
            paint = new Paint();
            Typeface type = ResourcesCompat.getFont(AppManager.getInstance().getM_GameView().getContext(),R.font.barriecito_regular);
            //Typeface 객체로 폰트 변경
            paint.setTypeface(type);
            paint.setColor(Color.BLACK);
        }
        return this.paint;
    }
    public Paint setPaintSize(float size)
    {
        paint.setTextSize(size);
        return this.paint;
    }
}
//각 객체의 정보를 가져올 수 있게끔 만들어놓은 소통 객체 한개만 존재해야 하므로, 싱글톤으로 구성됨.