package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;
import com.example.gameframework.org.FrameWork.SoundManager;
import com.example.gameframework.org.FrameWork.SpriteAnimation;

import org.Factory.MissailFactory;
import org.Game.CoinPackage.Money;
import org.MissailPackage.BlackMissail;
import org.MissailPackage.GoldMissail;
import org.MissailPackage.Missail;

import java.util.LinkedList;
public class Player extends SpriteAnimation {
    private boolean move_flag;
    private Class default_missail, charging_missail;
    private LinkedList<Missail> missails;
    private boolean m_death;
    private Money m_Money;
    private int m_stage;
    private long chargingTime;

    public int getM_stage() {
        return m_stage;
    }
    public void clearStage() {
        this.m_stage += 1;
    }
    public Money getM_Money() {
        return m_Money;
    }
    public void setM_Money(Money m_Money) {
        this.m_Money = m_Money;
    }
    public LinkedList<Missail> getMissails() {
        return missails;
    }
    public void setMissails(LinkedList<Missail> missails) {
        this.missails = missails;
    }
    public void shootingMissail(Missail missail) {
        missails.add(missail);
    }
    public boolean isMove_flag() {
        return move_flag;
    }
    public void setMove_flag(boolean move_flag) {
        this.move_flag = move_flag;
    }
    public Player(Bitmap _bitmap) {
        super(AppManager.getInstance().reSizing(_bitmap,
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight() / 10));
        this.default_missail = BlackMissail.class;
        this.charging_missail = GoldMissail.class;
        this.initSpriteData(m_bitmap.getWidth() / 5, m_bitmap.getHeight(), 20, 5);
        this.setPosition(AppManager.getInstance().getM_GameView().getFullWidth() / 2 - (m_bitmap.getWidth() / 12), AppManager.getInstance().getM_GameView().getFullHeight() - 300);
        this.missails = new LinkedList<Missail>();
        m_death = false;
        m_Money = new Money();
        this.m_stage = 0;
    }
    public Player(Player clone) {
        super(clone.m_bitmap);
        this.m_death = false;
        this.default_missail = clone.getDefault_missail();
        this.move_flag = false;
        this.charging_missail = clone.charging_missail;
        this.missails = new LinkedList<Missail>();
        this.initSpriteData(m_bitmap.getWidth() / 5, m_bitmap.getHeight(), 20, 5);
        this.setPosition(AppManager.getInstance().getM_GameView().getFullWidth() / 2 - (m_bitmap.getWidth() / 12), AppManager.getInstance().getM_GameView().getFullHeight() - 300);
        this.m_Money = clone.m_Money;
        this.m_stage = clone.m_stage;
    }

    public Class getDefault_missail() {
        return default_missail;
    }

    public void setDefault_missail(Class default_missail) {
        this.default_missail = default_missail;
    }
    public boolean isM_death() {
        return m_death;
    }
    public void setM_death(boolean m_death) {
        this.m_death = m_death;
    }
    public void destroy() {
        this.m_bitmap = AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.explosion),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight() / 10);
        initSpriteData(this.m_bitmap.getWidth() / 6, this.m_bitmap.getHeight(), 20, 6);
        m_death = true;
        SoundManager.getInstance().play_by_name("diemusic");
    }
    public void setM_stage(int m_stage) {
        this.m_stage = m_stage;
    }
    public void chargingattack()
    {
        Missail missail = MissailFactory.ChargingmissailMaker(this.charging_missail,this.m_x,this.m_y,20,25);
        shootingMissail(missail);
    }

    public void attack(){
        Missail missail = MissailFactory.missailMaker(this.default_missail,this.m_x,this.m_y);
        if(missails.size() >= missail.getLimit())
        {
            return;
        }
        shootingMissail(missail);
    }

    public Class getCharging_missail() {
        return charging_missail;
    }

    public void setCharging_missail(Class charging_missail) {
        this.charging_missail = charging_missail;
    }
    public void startCharging(){
        chargingTime = System.currentTimeMillis() + 1000;
    }
    public boolean checkCharging()
    {
        return System.currentTimeMillis() - chargingTime >= 0;
    }
}
