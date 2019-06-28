package com.example.gameframework.org.FrameWork;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;

import org.Controller.I_Controller;
import org.Controller.MoveKeyPad;
import org.Controller.MoveTouch;
import org.Game.GameState;
import org.Game.Player;
import org.GameView.GameView;
import org.GameView.I_GameView;
import org.GameView.MerchantView;

public class AppManager {
    //테스트를 위한 페인트
    Paint paint;

    private I_GameView m_view;
    private Resources m_res;
    private Player player;
    private I_Controller m_controller= null;
    private static AppManager instance=null;
    private AppManager()
    {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        this.m_res = null;
        this.m_view = null;
    }
    public I_GameView getM_view() {
        return m_view;
    }
    public void setM_view(I_GameView m_view) {
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
            m_controller = new MoveTouch(getM_GameView().getM_state());
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
    }
    public GameView getM_GameView()
    {
        return (GameView)m_view;
    }
    public MerchantView getM_MerchantView(){
        return (MerchantView)m_view;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Paint getPaint()
    {
        return this.paint;
    }
}
