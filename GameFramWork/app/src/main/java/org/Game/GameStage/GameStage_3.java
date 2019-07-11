package org.Game.GameStage;

import android.graphics.Canvas;

import com.example.gameframework.R;
import org.FrameWork.AppManager;

import org.FrameWork.GraphicManager;
import org.Game.Enemy.Flower;
import org.Game.Enemy.Goomba;
import org.Game.Enemy.OhBoss;
import org.Game.Enemy.Turtle;
import org.Game.Enemy.WingBoss;
import org.Game.GameState;
import org.Game.Player;

public class GameStage_3 extends GameState {
    private int stage = 3;
    @Override
    public void init(int background) {
        super.init(0);
        setM_player(new Player(AppManager.getInstance().getPlayer()));
        this.m_BossContain = true;
        this.m_StageRegenTime = 500;
        this.m_EnemyLimit = 30;
        this.m_BossTime= 10000;
        m_background.setM_bitmap(AppManager.getInstance().getBitMap(R.drawable.mario_background));
        this.enemys_name.put(0, Goomba.class);
        this.enemys_name.put(1, Turtle.class);
        this.enemys_name.put(2, Flower.class);
        this.contain_enemy = 3;
        this.boss_class = OhBoss.class;
        GraphicManager.getInstance().setEnemy(Goomba.class,AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.goomba),
                AppManager.getInstance().getM_GameView().getFullWidth(),
                200));
        GraphicManager.getInstance().setEnemy(Turtle.class,
                AppManager.getInstance().reSizing(
                        AppManager.getInstance().getBitMap(R.drawable.yellow),
                        AppManager.getInstance().getM_GameView().getFullWidth(),
                        200));
        GraphicManager.getInstance().setEnemy(Flower.class,
                AppManager.getInstance().reSizing(
                        AppManager.getInstance().getBitMap(R.drawable.flower),
                        AppManager.getInstance().getM_GameView().getFullWidth(),
                        200));
        GraphicManager.getInstance().setEnemy(OhBoss.class,
                AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.ohh),
                        500,200)
        );
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
        canvas.drawText("Stage :" + stage,0,AppManager.getInstance().getPaint().getTextSize(),AppManager.getInstance().getPaint());
        canvas.drawText("Destroy :"+ destroy_enem,0,AppManager.getInstance().getPaint().getTextSize()*2, AppManager.getInstance().getPaint());
    }
}
