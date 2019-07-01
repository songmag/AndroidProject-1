package org.GameStateCollect;

import org.Game.GameState;
import org.GameStage.GameStage_1;
import org.GameStage.GameStage_2;
import org.GameStage.GameStage_3;
import org.GameStage.GameStage_4;

public class GameStageState {
    public GameState[] gameStates;
    public GameState clearStage;
    public GameState deathStage;
    public GameState introState;
    public GameStageState()
    {
        introState = new GameIntroState();
        deathStage = new GameDeath();
        clearStage = new GameClear();
        gameStates = new GameState[10];
        gameStates[0] = new GameStage_1();
        gameStates[1] = new GameStage_2();
        gameStates[2] = new GameStage_3();
        gameStates[3] = new GameStage_4();
    }
}
