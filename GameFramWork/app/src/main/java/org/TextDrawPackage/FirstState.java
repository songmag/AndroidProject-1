package org.TextDrawPackage;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.GameState;
import org.GameStateCollect.ShopIntro;
import org.w3c.dom.Text;

public class FirstState extends TextWriter implements I_DrawText {
    private final String text = "어서오세요, 상점에 오신걸 환영합니다.";
    @Override
    public void init() {
        value = text;
        check_time = System.currentTimeMillis()+time_term;
    }
    @Override
    public void Update(ShopIntro state) {
        if(value == null) return;
        if(value.length() == now_index)
        {
            state.set_TextState(new SecondState());
        }
        super.Update(state);
    }
}
