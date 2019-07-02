package org.Factory;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.Enemy.Enermy;
import org.Game.Player;
import org.MissailPackage.BlackMissail;
import org.MissailPackage.GoldMissail;
import org.MissailPackage.Missail;

import java.lang.reflect.InvocationTargetException;

public class MissailFactory {

    public static Missail missailMaker(Class missailName)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        return missail;
    }
    public static Missail missailMaker(Class missailName,int x,int y ,int damage,float speed)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        missail.set_State(speed,damage);
        missail.setPosition(x,y);
        return missail;
    }
    public static Missail missailMaker(Class missailName,int x,int y)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        missail.setPosition(x,y);
        return missail;
    }
    public static Missail ChargingmissailMaker(Class missailName)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        missail.setBitmap(AppManager.getInstance().reSizing(missail.getM_bitmap(),missail.getM_bitmap().getWidth()*2,100));
        return missail;
    }
    public static Missail ChargingmissailMaker(Class missailName,int x,int y,int damage,float speed)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        missail.setBitmap(AppManager.getInstance().reSizing(missail.getM_bitmap(),missail.getM_bitmap().getWidth()*2,100));
        missail.set_State(speed,damage);
        missail.setPosition(x,y);
        return missail;
    }

    public static Missail ChargingmissailMaker(Class missailName,int x,int y)
    {
        Missail missail = null;
        try {
            missail = (Missail)Class.forName(missailName.getName()).getConstructor().newInstance();
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
        missail.setBitmap(AppManager.getInstance().reSizing(missail.getM_bitmap(),missail.getM_bitmap().getWidth()*2,100));
        missail.set_State(missail.getMissail_speed()*3,missail.getDamage()*2);
        missail.setPosition(x,y);
        return missail;
    }
}
