package org.Game.GameStateCollect;

import org.Game.GameState;
import org.Game.GameStage.GameStage_1;
import org.Game.GameStage.GameStage_2;
import org.Game.GameStage.GameStage_3;
import org.Game.GameStage.GameStage_4;
import org.Game.GameStateCollect.GameClear.GameClear;
import org.Game.GameStateCollect.GameDeath.GameDeath;
import org.Game.GameStateCollect.GameMenu.GameMenu;
import org.Game.GameStateCollect.GameOption.GameOption;
import org.Game.GameView.IStat;
import org.Game.GameStateCollect.ShopPackage.ShopClass;
import org.Game.GameStateCollect.ShopPackage.ShopIntro;

public class GameStageState {
    public GameState[] gameStates;
    public IStat clearStage;
    public IStat deathStage;
    public IStat introState;
    public IStat menuState;
    public IStat gameOption;
    public IStat shopIntro;
    public IStat shopClass;
    public GameStageState()
    {
        shopClass = new ShopClass();
        shopIntro = new ShopIntro();
        menuState = new GameMenu();
        introState = new GameIntroState();
        deathStage = new GameDeath();
        clearStage = new GameClear();
        gameOption = new GameOption();
        gameStates = new GameState[10];
        gameStates[0] = new GameStage_1();
        gameStates[1] = new GameStage_2();
        gameStates[2] = new GameStage_3();
        gameStates[3] = new GameStage_4();
    }
}
//AppManager에 등록되는 각각의 State, View들을 바꾸는 역할을 할때 사용한다.
//Stage를 생성하는 것을 각 스테이지 마다 만드는것 보다 Factory에 설정해서 만드는게 나을 듯 하다.

