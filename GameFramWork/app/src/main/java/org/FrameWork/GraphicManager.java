package org.FrameWork;

import android.graphics.Bitmap;

import com.example.gameframework.R;

import org.Game.CoinPackage.BronzeMoney;
import org.Game.CoinPackage.StarMoney;

import java.util.HashMap;

public class GraphicManager {
    public static GraphicManager instance= null;

    private HashMap<Class,Bitmap> m_enemyBitmap;
    private HashMap<Class,Bitmap> m_money;
    //2개만 있으므로 다른 동작이 있을 이유가 없이 비슷해도 상관없다.
    private HashMap<Class,Bitmap> m_missail;
    private Bitmap m_chargingMissail = null;
    private GraphicManager()
    {
        m_enemyBitmap = new HashMap<>();
        m_money = new HashMap<>();
        m_missail = new HashMap<>();
        m_money.put(BronzeMoney.class,
                AppManager.getInstance().reSizing(
                        AppManager.getInstance().getBitMap(R.drawable.coin),
                        AppManager.getInstance().getM_GameView().getFullWidth(),
                        AppManager.getInstance().getM_GameView().getFullHeight()/10
                ));
        m_money.put(StarMoney.class,AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.star),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()/10
        ));
    }
    public Bitmap getMoney(Class name){
        return m_money.get(name);
    }
    public Bitmap getEnemy(Class name)
    {
        if(m_enemyBitmap.get(name) == null)
            return null;
        return m_enemyBitmap.get(name);
    }
    public void setEnemy(Class name,Bitmap enemy)
    {
        m_enemyBitmap.put(name,enemy);
    }
    public void destroy()
    {
        this.m_enemyBitmap.clear();
    }
    public static GraphicManager getInstance()
    {
        if(instance == null)
        {
            instance = new GraphicManager();
        }
        return instance;
    }
    public Bitmap getMissail(Class name)
    {
        if(m_missail.get(name) == null)
            return null;
        return m_missail.get(name);
    }
    public void setMissail(Class name,Bitmap bitmap)
    {
        m_missail.put(name,bitmap);
    }
    public Bitmap getChargingMissail()
    {
        return this.m_chargingMissail;
    }
    public void setChargingMissail(Bitmap bitmap)
    {
        m_chargingMissail = bitmap;
    }
}
