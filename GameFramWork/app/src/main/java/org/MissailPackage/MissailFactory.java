package org.MissailPackage;

import org.Game.Player;

public class MissailFactory {

    public static Missail missailMaker(Player player)
    {
        if(player.getDefault_missail() == BlackMissail.class)
        {
            return new BlackMissail(BlackMissail.BITMAP,player.getM_x(),player.getM_y(), BlackMissail.SPEED, BlackMissail.DAMAGE);
        }
        else
        {
            return new GoldMissail(GoldMissail.BITMAP,player.getM_x(),player.getM_y(),GoldMissail.SPEED,GoldMissail.DAMAGE);
        }
    }
    public static Missail missailMaker(Player player,int x,int y)
    {
        if(player.getDefault_missail() == BlackMissail.class)
        {
            return new BlackMissail(BlackMissail.BITMAP,x,y, BlackMissail.SPEED, BlackMissail.DAMAGE);
        }
        else
        {
            return new GoldMissail(GoldMissail.BITMAP,x,y,GoldMissail.SPEED,GoldMissail.DAMAGE);
        }
    }
}
