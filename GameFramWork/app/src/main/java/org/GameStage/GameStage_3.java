package org.GameStage;

import android.graphics.Canvas;

import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.GameState;
import org.Game.Player;

public class GameStage_3 extends GameState {
    private int stage = 3;
    @Override
    public void init(int background) {
        setM_player(new Player(AppManager.getInstance().getPlayer()));
        this.m_BossContain = false;
        this.m_EnemyLimit = 25;
        this.m_BossTime= 10000;
        super.init(1);
    }

    @Override
    public void Update() {
        super.Update();
        if (this.m_StageClear) {

            AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.clearStage);     }
    }

    @Override
    public void Render(Canvas canvas) {
        super.Render(canvas);
        canvas.drawText("Stage :" + Integer.toString(stage),0,50,AppManager.getInstance().getPaint());
        canvas.drawText("Destroy :"+Integer.toString(destroy_enem),0,30, AppManager.getInstance().getPaint());
    }
}
