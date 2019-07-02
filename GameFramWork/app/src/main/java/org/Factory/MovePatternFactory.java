package org.Factory;

import org.Game.Enemy.Enermy;
import org.MovePackage.I_MovePattern;
import org.MovePackage.MovePatternClass;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class MovePatternFactory {
    public static I_MovePattern createMovePattern(Class moveName){
        I_MovePattern movePattern = null;
        try {
          movePattern  = (I_MovePattern)Class.forName(moveName.getName()).getConstructor().newInstance();
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
        return movePattern;
    }
    public static I_MovePattern createRandomMovePattern()
    {
        I_MovePattern movePattern = null;
        Random rand = new Random();
        try {
            movePattern  = (I_MovePattern)Class.forName(MovePatternClass.movePatternClasses[rand.nextInt(MovePatternClass.movePatternClasses.length)].getName()).getConstructor().newInstance();
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
        return movePattern;
    }

}
