package org.GameStateCollect;

import com.example.gameframework.org.FrameWork.BackGround;
import org.Game.GameState;

public class GameClear extends GameState {
    @Override
    public void init() {
        this.m_background = new BackGround();
        super.init();
    }
}
