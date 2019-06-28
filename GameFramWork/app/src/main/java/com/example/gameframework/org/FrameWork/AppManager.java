package com.example.gameframework.org.FrameWork;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.Controller.I_Controller;
import org.Controller.MoveKeyPad;
import org.Controller.MoveTouch;
import org.Game.GameState;
import org.GameView.MerchantView;

public class AppManager {
    private GameView m_view;
    private MerchantView m_MerchantView;
    private Resources m_res;
    private I_Controller m_controller= null;
    private static AppManager instance=null;

    private AppManager()
    {
        this.m_res = null;
        this.m_view = null;
    }
    public GameView getM_view() {
        return m_view;
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
    public void setM_controller(GameState state)
    {
        m_controller = new MoveTouch(state);
    }
    public I_Controller getM_controller() {
        if(m_controller == null)
        {
            setM_controller(m_view.getM_state());
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

    public MerchantView getM_MerchantView() {
        return m_MerchantView;
    }

    public void setM_MerchantView(MerchantView m_MerchantView) {
        this.m_MerchantView = m_MerchantView;
    }
}
