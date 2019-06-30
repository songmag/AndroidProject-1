package org.GameStateCollect;

import org.Game.GameState;
import org.GameStage.GameStage_1;
import org.GameStage.GameStage_2;
import org.GameStage.GameStage_3;
import org.GameStage.GameStage_4;
import org.GameStateCollect.GameClear;

public class GameStageState {
    public GameState[] gameStates;
    public GameStageState()
    {
        gameStates = new GameState[10];
        gameStates[0] = new GameStage_1();
        gameStates[1] = new GameStage_2();
        gameStates[2] = new GameStage_3();
        gameStates[3] = new GameStage_4();
        gameStates[4] = new GameClear();
    }
}
