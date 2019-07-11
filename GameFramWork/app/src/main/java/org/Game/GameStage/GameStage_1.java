package org.Game.GameStage;

import android.graphics.Canvas;

import com.example.gameframework.R;
import org.FrameWork.AppManager;

import org.FrameWork.GraphicManager;
import org.Game.Enemy.Goomba;
import org.Game.Enemy.OhBoss;
import org.Game.GameState;
import org.Game.Player;

public class GameStage_1 extends GameState {
    private int stage = 1;
    @Override
    public void init(int background) {
        super.init(0);
        setM_player(new Player(AppManager.getInstance().getPlayer()));
        this.m_BossContain = false;
        this.boss_class = OhBoss.class;
        this.m_StageRegenTime = 1000;
        this.m_EnemyLimit = 10;
        this.m_BossTime= 10000;
        m_background.setM_bitmap(AppManager.getInstance().getBitMap(R.drawable.mario_background));
        this.enemys_name.put(0, Goomba.class);
        GraphicManager.getInstance().setEnemy(Goomba.class,AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.goomba),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                200));
        this.contain_enemy = 1;
    }

    @Override
    public void Update() {
        super.Update();
        if (this.m_StageClear) {
            AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.clearStage);
        }
    }
    @Override
    public void Render(Canvas canvas) {
        super.Render(canvas);
        canvas.drawText("Stage :" + stage,0,AppManager.getInstance().getPaint().getTextSize(),AppManager.getInstance().getPaint());
        canvas.drawText("Destroy :"+ destroy_enem,0,AppManager.getInstance().getPaint().getTextSize()*2, AppManager.getInstance().getPaint());
    }
}
