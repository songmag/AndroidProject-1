package org.Factory;

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

    public static I_MovePattern createRandomMovePattern(int i)
    {
        I_MovePattern movePattern = null;
        Random rand = new Random();
        try {
            if(i == 0)
                movePattern  = (I_MovePattern)Class.forName(MovePatternClass.movePatternLeftClasses[rand.nextInt(MovePatternClass.movePatternLeftClasses.length)].getName()).getConstructor().newInstance();
            else if(i==1)
                movePattern  = (I_MovePattern)Class.forName(MovePatternClass.movePatternDown[rand.nextInt(MovePatternClass.movePatternDown.length)].getName()).getConstructor().newInstance();
            else
                movePattern = (I_MovePattern)Class.forName(MovePatternClass.movePatternRightClasses[rand.nextInt(MovePatternClass.movePatternRightClasses.length)].getName()).getConstructor().newInstance();
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
