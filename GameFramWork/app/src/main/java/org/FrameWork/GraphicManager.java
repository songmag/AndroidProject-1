package org.FrameWork;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;

import com.example.gameframework.R;

import org.Controller.MoveKeyPad;
import org.Game.CoinPackage.BronzeMoney;
import org.Game.CoinPackage.StarMoney;
import org.Game.GameState;

import java.util.HashMap;

public class GraphicManager {
    public static GraphicManager instance= null;
    private Bitmap keypad = null;
    private HashMap<Class,Bitmap> m_enemyBitmap;
    private HashMap<Class,Bitmap> m_money;

    //2개만 있으므로 다른 동작이 있을 이유가 없이 비슷해도 상관없다.

    private HashMap<Class,Bitmap> m_missail;
    private Bitmap m_chargingMissail = null;
    private ColorFilter colorFilter = null;
    private Bitmap m_attackPad = null;
    private Bitmap m_OptionSwitch = null;
    private Bitmap m_Background_Default = null;
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
    public Bitmap getKeyPad()
    {
        if(keypad == null)
        {
            keypad = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.pad)
                    ,AppManager.getInstance().getM_GameView().getFullWidth()/4,
                    AppManager.getInstance().getM_GameView().getFullHeight()/5);
        }
        return keypad;
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
    public ColorFilter getColorFilter(){
        if(colorFilter == null)
        {
            colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }
        return colorFilter;
    }
    public Bitmap getAttackPad()
    {
        if(m_attackPad == null)
        {
            m_attackPad = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.attack_game),
                    AppManager.getInstance().getM_GameView().getFullWidth()/5,
                    AppManager.getInstance().getM_GameView().getFullHeight()/6);
        }
        return m_attackPad;
    }
    public Rect defaultAttack(){
        return new Rect(0,0,getAttackPad().getWidth()/2,getAttackPad().getHeight());
    }
    public Rect onClickAttack()
    {
        return new Rect(getAttackPad().getWidth()/2,0,getAttackPad().getWidth(),getAttackPad().getHeight());
    }

    public Bitmap getM_OptionSwitch(int width,int height) {
        if(m_OptionSwitch == null)
        {
            m_OptionSwitch = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.option_switch),
                width*2,height);
        }
        return m_OptionSwitch;
    }
    public void deleteOptionSwitch()
    {
        m_OptionSwitch = null;
    }

    public Bitmap getM_Background_Default() {
        if(m_Background_Default == null)
        {
            m_Background_Default = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.background_block),
                    AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight());
        }
        return m_Background_Default;
    }
    public void setDestroy()
    {
        if(m_attackPad != null && AppManager.getInstance().getM_controller() instanceof MoveKeyPad) {
            m_attackPad = null;
            keypad = null;
        }
        if(AppManager.getInstance().getM_GameView().getM_state() instanceof GameState)
        {
            if(m_Background_Default != null)
                m_Background_Default = null;
        }
        else
        {
            m_enemyBitmap.clear();
        }
        System.gc();
    }

}
