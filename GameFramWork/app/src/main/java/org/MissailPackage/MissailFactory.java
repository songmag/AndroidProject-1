package org.MissailPackage;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.Player;

public class MissailFactory {

    public static Missail missailMaker(Player player)
    {
        Missail missail = null;
        if(player.getDefault_missail() == BlackMissail.class)
        {
            if(player.getMissails().size() >= BlackMissail.LIMIT) return null;
            missail = new BlackMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.black_missile),100,100));
            missail.setPosition(player.getM_x()+missail.getM_bitmap().getWidth()/2,player.getM_y());
            missail.set_State(BlackMissail.SPEED,BlackMissail.DAMAGE);
        }
        else
        {
            if(player.getMissails().size() >= GoldMissail.LIMIT) return null;
            missail = new GoldMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.gold_missile),100,100));
            missail.setPosition(player.getM_x()+missail.getM_bitmap().getWidth()/2,player.getM_y());
            missail.set_State(GoldMissail.SPEED,GoldMissail.DAMAGE);
        }
        return missail;
    }
    public static Missail missailMaker(Player player,int x,int y)
    {
        Missail missail = null;
        if(player.getDefault_missail() == BlackMissail.class)
        {
            if(player.getMissails().size() >= BlackMissail.LIMIT) return null;
            missail = new BlackMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.black_missile),100,100));
            missail.setPosition(x,y);
            missail.set_State(BlackMissail.SPEED,BlackMissail.DAMAGE);
        }
        else
        {
            if(player.getMissails().size() >= GoldMissail.LIMIT) return null;
            missail = new GoldMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.gold_missile),100,100));
            missail.setPosition(x,y);
            missail.set_State(GoldMissail.SPEED,GoldMissail.DAMAGE);
        }
        return missail;
    }
    public static Missail ChargingmissailMaker(Player player)
    {
        Missail missail = null;
        if(player.getCharging_missail() == BlackMissail.class)
        {
             missail = new BlackMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.black_missile),300,100));
            missail.setPosition(player.getM_x(),player.getM_y());
            missail.set_State(BlackMissail.SPEED*2,BlackMissail.DAMAGE*2);
        }
        else
        {
            missail = new GoldMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.gold_missile),300,100));
            missail.setPosition(player.getM_x(),player.getM_y());
            missail.set_State(GoldMissail.SPEED*2,GoldMissail.DAMAGE*2);
        }
        return missail;
    }
    public static Missail ChargingmissailMaker(Player player,int x,int y)
    {
        Missail missail;
        if(player.getCharging_missail() == BlackMissail.class)
        {
            missail = new BlackMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.black_missile),300,100));
            missail.setPosition(player.getM_x(),player.getM_y());
            missail.set_State(BlackMissail.SPEED*2,BlackMissail.DAMAGE*2);
        }
        else
        {
             missail = new GoldMissail(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.gold_missile),300,100));
            missail.setPosition(player.getM_x(),player.getM_y());
            missail.set_State(GoldMissail.SPEED*2,GoldMissail.DAMAGE*2);
        }
        return missail;
    }
}
