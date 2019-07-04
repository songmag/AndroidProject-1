package org.Factory;

import org.Game.Enemy.Boss;
import org.Game.Enemy.Enermy;
import org.Game.MovePackage.BossMovePattern;

import java.lang.reflect.InvocationTargetException;

public class EnemyFactory {
    public static Enermy createEnemy(Class enemyName,int hp,float speed)
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
        enermy.set_State(hp,speed);
        enermy.set_State(MovePatternFactory.createRandomMovePattern(1));
        return enermy;
    }
    public static Boss createBoss(Class enemyName,int hp,float speed)
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
        enermy.set_State(hp,speed);
        enermy.set_State(MovePatternFactory.createMovePattern(BossMovePattern.class));
        return enermy;
    }
}
//클래스 객체를 받아, 해당 클래스 기본 생성자를 이용해서 만드는 인스턴스 객체를 세팅하여 만들어 반환한다.
