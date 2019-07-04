package org.Game.GameStateCollect;

import org.Game.GameState;
import org.Game.GameStage.GameStage_1;
import org.Game.GameStage.GameStage_2;
import org.Game.GameStage.GameStage_3;
import org.Game.GameStage.GameStage_4;
import org.Game.GameStateCollect.GameClear.GameClear;
import org.Game.GameStateCollect.GameDeath.GameDeath;
import org.Game.GameStateCollect.GameMenu.GameMenu;
import org.Game.ShopPackage.ShopIntro;

public class GameStageState {
    public GameState[] gameStates;
    public GameState clearStage;
    public GameState deathStage;
    public GameState introState;
    public GameState menuState;
    public GameState shopIntro;
    public GameStageState()
    {
        shopIntro = new ShopIntro();
        menuState = new GameMenu();
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
//AppManager에 등록되는 각각의 State, View들을 바꾸는 역할을 할때 사용한다.
//Stage를 생성하는 것을 각 스테이지 마다 만드는것 보다 Factory에 설정해서 만드는게 나을 듯 하다.

