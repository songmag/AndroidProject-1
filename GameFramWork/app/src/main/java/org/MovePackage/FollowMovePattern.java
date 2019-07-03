package org.MovePackage;

import org.Factory.MovePatternFactory;

public class FollowMovePattern implements I_MovePattern {
    @Override
    public void Update(ThrowObject object) {
        if(object.checkUpdate())
        {
            object.set_State(MovePatternFactory.createRandomMovePattern());
        }
        move(object);
    }
    @Override
    public void move(ThrowObject object) {
        object.set_xy(0,-object.getSpeed());
    }
}
