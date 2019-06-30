package org.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class GoldMissail extends Missail {
    public final static int DAMAGE = 10;
    public final static int SPEED = 5;
    public final static int LIMIT = 20;

    public GoldMissail(Bitmap m_bitmap) {
        super(m_bitmap);
    }
    public GoldMissail(Bitmap _bitmap,int x, int y,float speed,int damage)
    {
        super(_bitmap);
        set_State(speed,damage);
        setPosition(x,y);
    }
    public GoldMissail(GoldMissail missail) {
        super(missail.m_bitmap);
        set_State(missail.missail_speed,missail.damage);
        setPosition(m_x,m_y);
    }

    @Override
    public void Update() {
        m_y -= missail_speed;
        super.Update();
        if(this.m_y < 0)
        {
            this.setM_state(Missail.STATE_OUT);
        }
    }
}
