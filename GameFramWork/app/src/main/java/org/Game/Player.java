package org.Game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import java.util.LinkedList;

public class Player extends SpriteAnimation {

    private boolean move_flag;
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
        this.initSpriteData(m_bitmap.getWidth()/6,m_bitmap.getHeight(),20,6);
        this.setPosition(AppManager.getInstance().getM_view().getFullWidth()/2-(m_bitmap.getWidth()/12),AppManager.getInstance().getM_view().getFullHeight()-300);
        this.missails = new LinkedList<Missail>();
    }
}
