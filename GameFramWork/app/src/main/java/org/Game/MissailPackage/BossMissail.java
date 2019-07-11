package org.Game.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class BossMissail extends Missail {
    public final float speed = 7;
    public final int damage =5;
    public final int m_Limit = 10;
    public BossMissail()
    {
        super();
        if(GraphicManager.getInstance().getMissail(BossMissail.class)==null)
        {
            GraphicManager.getInstance().setMissail(BossMissail.class,
                    AppManager.getInstance().reSizing(
                            AppManager.getInstance().getBitMap(R.drawable.boss_missile1)
                            ,100,100)
            );
        }
        m_bitmap = GraphicManager.getInstance().getMissail(BossMissail.class);
        set_State(speed,damage);
    }
    @Override
    public int getLimit() {
        return m_Limit;
    }

}
