package org.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class BlackMissail extends Missail {
    public final static int DAMAGE = 5;
    public final static int SPEED = 5;
    public final static int LIMIT = 10;
    public BlackMissail(Bitmap bitmap, int x, int y, float speed, int damage)
    {
        super(bitmap);
        setPosition(x,y);
        set_State(speed,damage);
    }

    public BlackMissail(Bitmap m_bitmap) {
        super(m_bitmap);
    }

    @Override
    public void Update()
    {
        m_y -= missail_speed;
        super.Update();
        if(this.m_y < 0)
        {
            this.setM_state(Missail.STATE_OUT);
        }
    }

}
