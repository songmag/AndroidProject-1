package org.GameStage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.FontRes;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.GameState;
import org.GameStateCollect.GameClear;

public class GameStage_1 extends GameState {
    Paint paint = new Paint();

    @Override
    public void init() {
        super.init();
        paint.setColor(Color.BLACK);
        paint.setTextSize(10.0f);
    }

    @Override
    public void Update() {
        super.Update();
        if (this.m_StageClear) {
            AppManager.getInstance().getM_GameView().changeGameState(new GameClear());
        }
    }

    @Override
    public void Render(Canvas canvas) {
        super.Render(canvas);
        canvas.drawText(String.valueOf(distroy_enem),0,10, paint);
    }
}
