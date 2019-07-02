package org.Factory;

import org.Game.Enemy.Boss;
import org.Game.Enemy.Enermy;
import org.Game.Enemy.Goomba;
import org.MissailPackage.BlackMissail;

import java.lang.reflect.InvocationTargetException;

public class EnemyFactory {
    public static Enermy createEnemy(Class enemyName,int hp,float speed,int type)
    {
        Enermy enermy = null;
        try {
            enermy = (Enermy)Class.forName(enemyName.getName()).getConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        enermy.set_State(hp,speed,type);
        return enermy;
    }
    public static Boss createBoss(Class enemyName,int hp,float speed,int type)
    {
        Boss enermy = null;
        try {
            enermy = (Boss)Class.forName(enemyName.getName()).getConstructor().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        enermy.set_State(hp,speed,Enermy.MOVE_BOSS_PATTERN);
        return enermy;
    }
}
