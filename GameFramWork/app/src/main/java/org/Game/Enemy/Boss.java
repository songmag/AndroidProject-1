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
    //미사일 발사 텀을 구한다.
    private LinkedList<Missail> missails;
    //미사일 발사를 하므로, 충돌처리를 위해서 미사일 객체를 리스트로 가지고 있는다.
    public Boss(Bitmap m_bitmap) {
        super(m_bitmap);
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
    //보스의 경우 Update 할때 미사일을 발사하는 것 까지 Update한다.
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
    //보스의 경우 Draw 할때 미사일을 발사하는 것 까지 Draw한다.
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
    }//Enemy 클래스에 없는 미사일 발사 공격
}
