package com.example.gameframework;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AppManager {
    private GameView m_view;
    private Resources m_res;
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
    public static AppManager getInstance() {
        if(instance == null)
        {
            instance = new AppManager();
        }
        return instance;
    }
}
