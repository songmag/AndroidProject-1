package org.Game.Enemy;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.gameframework.R;
import org.FrameWork.AppManager;

import org.Factory.MissailFactory;
import org.Game.MissailPackage.BossMissail;
import org.Game.MissailPackage.Missail;

import java.util.LinkedList;

public class Boss extends Enermy {
    protected Class big_missail;
    protected long missail_term=2000,m_time;
    private LinkedList<Missail> missails;
    public Boss(Bitmap m_bitmap) {
        super( AppManager.getInstance().reSizing(m_bitmap,AppManager.getInstance().getM_GameView().getFullWidth()*3,
                AppManager.getInstance().getM_GameView().getFullHeight()/5));
        big_missail = BossMissail.class;
        missails = new LinkedList<Missail>();
        m_time = System.currentTimeMillis() + missail_term;
        this.initSpriteData(this.m_bitmap.getWidth()/2,this.m_bitmap.getHeight(),20,2);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
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
    @Override
    public void setM_DestroyBitmap(Bitmap bitmap) {
        m_DestroyBitmap = bitmap;
    }
    @Override
    public void Update(long gameTime) {
        super.Update(gameTime);
        for(int i = 0 ; i<missails.size();i++)
        {
            missails.get(i).Update();
            if(missails.get(i).getM_state() == Missail.STATE_OUT)
                missails.remove(i);
        }
    }
    @Override
    public void set_State(int hp, float speed) {
        this.hp = hp;
        this.speed = speed;
    }
    public Boss()
    {
        super(
                AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.wing),
                        500,200)
        );
        this.initSpriteData(m_bitmap.getWidth()/2,m_bitmap.getHeight(),20,2);
        setM_DestroyBitmap(AppManager.getInstance().getBitMap(R.drawable.destroy_boom_1));
    }

    @Override
    public void Draw(Canvas canvas) {
        super.Draw(canvas);
        for(int i = 0 ; i<missails.size();i++)
        {
            missails.get(i).Draw(canvas);
        }
    }

    @Override
    public void attack() {
        if(System.currentTimeMillis() - m_time >= 0 )
        {
            Missail missail;
            for(int i = 0 ; i <5;i++) {
                missail = MissailFactory.createBossMissailMaker(this.big_missail, getM_rect().centerX(), getM_rect().bottom);
                shootingMissail(missail);
            }
            m_time = System.currentTimeMillis()+missail_term;
        }
    }
}
