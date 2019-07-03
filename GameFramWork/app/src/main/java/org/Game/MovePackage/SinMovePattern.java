package org.Game.MovePackage;

import org.Factory.MovePatternFactory;

public class SinMovePattern implements I_MovePattern {
    public double sinvalue=0;
    @Override
    public void Update(ThrowObject object) {
        if(object.checkUpdate())
        {
            object.set_State(MovePatternFactory.createRandomMovePattern(1));
        }
        move(object);
    }
    @Override
    public void move(ThrowObject object) {
        sinvalue += 0.01;
        object.set_xy((float)(object.get_x()+Math.sin(Math.PI/180)+sinvalue),object.get_y()+object.getSpeed());
    }
}
