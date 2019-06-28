package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.MissailPackage.BlackMissail;
import org.MissailPackage.Missail;

import java.util.LinkedList;

public class Player extends SpriteAnimation {

    private boolean move_flag;
    private Class default_missail;
    private LinkedList<Missail> missails;
    public LinkedList<Missail> getMissails() {
        return missails;
    }
    public void setMissails(LinkedList<Missail> missails) {
        this.missails = missails;
    }
    public void shootingMissail(Missail missail)
    {
        missails.add(missail);
    }
    public boolean isMove_flag() {
        return move_flag;
    }
    public void setMove_flag(boolean move_flag) {
        this.move_flag = move_flag;
    }
    public Player(Bitmap m_bitmap) {
        super(m_bitmap);
        this.default_missail = BlackMissail.class;
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setPosition(AppManager.getInstance().getM_GameView().getFullWidth()/2-(m_bitmap.getWidth()/12),AppManager.getInstance().getM_GameView().getFullHeight()-300);
        this.missails = new LinkedList<Missail>();
    }
    public Class getDefault_missail() {
        return default_missail;
    }
    public void setDefault_missail(Class default_missail) {
        this.default_missail = default_missail;
    }
}
