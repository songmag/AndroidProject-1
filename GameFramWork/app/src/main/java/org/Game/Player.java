package org.Game;

import android.graphics.Bitmap;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.SoundManager;
import org.FrameWork.SpriteAnimation;

import org.Factory.MissailFactory;
import org.Game.CoinPackage.Money;
import org.Game.MissailPackage.BlackMissail;
import org.Game.MissailPackage.GoldMissail;
import org.Game.MissailPackage.Missail;

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
    //현재 스테이지를 반환한다.
    public void clearStage() {
        this.m_stage += 1;
    }
    //클리어시 스테이지를 올린다.
    public Money getM_Money() {
        return m_Money;
    }
    //가지고 있는 돈을 반환한다.
    public void setM_Money(Money m_Money) {
        this.m_Money = m_Money;
    }
    //돈을 Money 객체를 통해 세팅한다.
    public LinkedList<Missail> getMissails() {
        return missails;
    }
    //미사일 객체들 get메소드.
    public void setMissails(LinkedList<Missail> missails) {
        this.missails = missails;
    }
    //LinkedList 를 세팅하는 set메소드
    public void shootingMissail(Missail missail) {
        missails.add(missail);
    }
    //터치시 미사일 발사
    public boolean isMove_flag() {
        return move_flag;
    }
    //움직이는 것 여부(flag를 통해서 움직이고, 움직이지 않는것을 판단)
    public void setMove_flag(boolean move_flag) {
        this.move_flag = move_flag;
    }
    //움직이는 것 여부 변경
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
    //bitmap으로 생성하는 생성자
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
    //Palyer를 ingame에서 별개로 생성해서 사용한다.
    //죽었을 경우 money의 수급을 없애기 위해서 이다.
    public Class getDefault_missail() {
        return default_missail;
    }
    //발사하는 기본 미사일을 반환한다. 클래스로 반환해서 factory에서 생성하기 위한 요소
    public void setDefault_missail(Class default_missail) {
        this.default_missail = default_missail;
    }
    //상점에서 미사일을 구매하는경우 변경하기 위함.(AppManager에 등록되어있는 player에서 변경해야함)
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
    public void chargingattack()//차징 어택했을때 미사일을 생성하는 요소가 다르다. 모든 미사일을 다 써도 쓸수 있다.
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
    }//미사일 개수만큼 쏠 수 있는 것을 계산
    //미사일 발사

    public Class getCharging_missail() {
        return charging_missail;
    }

    public void setCharging_missail(Class charging_missail) {
        this.charging_missail = charging_missail;
    }
    public void startCharging(){
        chargingTime = System.currentTimeMillis() + 1000;
    }
    //차징 미사일을 쏘는 미사일 타임 세팅
    public boolean checkCharging()
    {
        return System.currentTimeMillis() - chargingTime >= 0;
    }
    //현재 시간이 차징이 되었는지 판단.
}
