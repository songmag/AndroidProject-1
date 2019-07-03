package org.Game.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;

public class GoldMissail extends Missail {
    public final int m_Damage = 25;
    public final int m_Speed = 25;
    public final int m_Limit = 20;
    public GoldMissail(Bitmap m_bitmap) {
        super(m_bitmap);
    }
    public GoldMissail(Bitmap _bitmap,int x, int y,float speed,int damage)
    {
        super(_bitmap);
        set_State(speed,damage);
        setPosition(x,y);
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap,100,100);
    }
    public GoldMissail(GoldMissail missail) {
        super(missail.m_bitmap);
        set_State(missail.missail_speed,missail.damage);
        setPosition(m_x,m_y);
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap,100,100);
    }

    public GoldMissail() {
        super(AppManager.getInstance().getBitMap(R.drawable.gold_missile));
        m_bitmap = AppManager.getInstance().reSizing(m_bitmap,100,100);
        set_State(m_Speed,m_Damage);
    }
    @Override
    public int getLimit() {
        return m_Limit;
    }
}
