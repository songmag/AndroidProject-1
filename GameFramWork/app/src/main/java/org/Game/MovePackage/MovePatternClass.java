package org.Game.MovePackage;

public class MovePatternClass {
    public static final Class[] movePatternClasses ={LeftDownDiaGonal.class,RightDownDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternLeftClasses = {LeftDownDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternRightClasses = {RightDownDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternDown = {LeftDownDiaGonal.class,RightDownDiaGonal.class,DownMovePattern.class};
}
//각 move pattern 들에 대한 static Class 정보