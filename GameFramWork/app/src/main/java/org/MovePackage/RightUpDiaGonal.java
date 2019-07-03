package org.MovePackage;

import org.Factory.MovePatternFactory;

public class RightUpDiaGonal implements I_MovePattern {
    @Override
    public void Update(ThrowObject object) {
        if(object.checkUpdate())
        {
            object.set_State(MovePatternFactory.createRandomMovePattern(0));
        }
        move(object);
    }
    @Override
    public void move(ThrowObject object) {
        object.set_xy(object.getSpeed(),-object.getSpeed());
    }
}
