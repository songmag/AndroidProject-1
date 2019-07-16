package org.Game.GameStateCollect.ShopPackage;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.GraphicManager;
import org.FrameWork.GraphicObject;

import org.Game.GameView.IStat;
import org.Game.GameStateCollect.ShopPackage.TalkStatePackage.FirstState;
import org.Game.GameStateCollect.ShopPackage.TalkStatePackage.I_DrawText;

public class ShopIntro implements IStat {
    private GraphicObject merchant;
    private GraphicObject text_box;
    private I_DrawText text;
    private BackGround m_background;
    private boolean destroy_flag = false;
    public ShopIntro() {
    }

    @Override
    public boolean get_DestroyFlag() {
        return destroy_flag;
    }

    @Override
    public void set_DestroyFlag(boolean flag) {
        this.destroy_flag = flag;
    }

    @Override
    public void init(int background) {
        destroy_flag = false;
        m_background = new BackGround(GraphicManager.getInstance().getM_Background_Default());
        m_background.setPosition(0,0);
        int x_margin = AppManager.getInstance().getM_GameView().getFullWidth()/8;
        int y_margin = AppManager.getInstance().getM_GameView().getFullHeight()/4;
        int width =   AppManager.getInstance().getM_GameView().getFullWidth() -x_margin*2;
        int height =   AppManager.getInstance().getM_GameView().getFullHeight() -y_margin;
        merchant = new GraphicObject(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.merchant),
                width,height));
        text_box = new GraphicObject(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.text_box),AppManager.getInstance().getM_GameView().getFullWidth(),
                AppManager.getInstance().getM_GameView().getFullHeight()/5));
        text_box.setPosition(0,0);
        merchant.setPosition(x_margin,y_margin);
        set_TextState(new FirstState());
    }
    @Override
    public void Update() {
        if(destroy_flag) return;
        text.Update(this);
    }
    @Override
    public void Render(Canvas canvas) {
        if(destroy_flag) return;
            m_background.Draw(canvas);
            merchant.Draw(canvas);
            text_box.Draw(canvas);
            text.Draw(canvas);
    }

    @Override
    public void Destroy() {
            merchant = null;
            text = null;
            text_box = null;
            m_background = null;
    }
    public void set_TextState(I_DrawText text)
    {
        text.init();
        this.text = text;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return text.onTouch(event);
    }
}
