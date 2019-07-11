package org.Game.MissailPackage;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;

public class BlackMissail extends Missail {
    public final int m_Damage = 10;
    public final int m_Speed = AppManager.getInstance().getM_GameView().getFullHeight()/100;
    public final  int m_Limit = 10;
    public BlackMissail() {
        super();
        if(GraphicManager.getInstance().getMissail(BlackMissail.class)==null)
        {
            GraphicManager.getInstance().setMissail(BlackMissail.class,
                    AppManager.getInstance().reSizing(
                            AppManager.getInstance().getBitMap(R.drawable.black_missile)
                            ,100,100)
            );
        }
        m_bitmap = GraphicManager.getInstance().getMissail(BlackMissail.class);
        set_State(m_Speed,m_Damage);
    }

    @Override
    public int getLimit() {
        return m_Limit;
    }
}
