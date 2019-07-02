package org.MovePackage;

public class LeftMovePattern implements I_MovePattern {
    @Override
    public void Update(ThrowObject object) {
        if(object.checkUpdate())
        {
            object.set_State(new DownMovePattern());
        }
        move(object);
    }
    @Override
    public void move(ThrowObject object) {
        object.set_xy(-object.getSpeed(),0);
    }
}
