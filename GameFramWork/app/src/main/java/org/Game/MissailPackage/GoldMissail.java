package org.Game.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;
import org.FrameWork.GraphicObject;
import org.Game.Enemy.Enermy;

public class GoldMissail extends Missail {
    public final int m_Damage = 25;
    public final int m_Speed = 25;
    public final int m_Limit = 20;

    public GoldMissail() {
        super();
        if(GraphicManager.getInstance().getMissail(GoldMissail.class)==null)
        {
            GraphicManager.getInstance().setMissail(GoldMissail.class,
                    AppManager.getInstance().reSizing(
                            AppManager.getInstance().getBitMap(R.drawable.gold_missile)
                            ,100,100)
                    );
        }
        m_bitmap = GraphicManager.getInstance().getMissail(GoldMissail.class);
        set_State(m_Speed,m_Damage);
    }

    @Override
    public int getLimit() {
        return m_Limit;
    }
}
