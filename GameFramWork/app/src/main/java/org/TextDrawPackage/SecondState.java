package org.TextDrawPackage;

import android.graphics.Canvas;

import com.example.gameframework.org.FrameWork.AppManager;

import org.GameStateCollect.ShopIntro;

public class SecondState extends TextWriter implements I_DrawText {
    private final String text = "어떤것이던 판매할 준비가 되어있을뻔했습니다.";
    @Override
    public void init() {
        value = text;
    }

    @Override
    public void Update(ShopIntro state) {
        if(value == null) return;
        if(value.length() == now_index)
        {
            AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);
        }
        super.Update(state);
    }
}
