package org.Game.MovePackage;

public class MovePatternClass {
    public static final Class[] movePatternClasses ={LeftDownDiaGonal.class,RightDownDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternLeftClasses = {LeftMovePattern.class,LeftDownDiaGonal.class,LeftUpDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternRightClasses = {RightMovePattern.class,RightDownDiaGonal.class,RightUpDiaGonal.class,DownMovePattern.class};
    public static final Class[] movePatternDown = {LeftDownDiaGonal.class,RightDownDiaGonal.class,DownMovePattern.class};
}
