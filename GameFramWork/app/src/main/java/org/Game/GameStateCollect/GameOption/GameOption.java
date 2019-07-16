package org.Game.GameStateCollect.GameOption;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.GraphicManager;
import org.FrameWork.SoundManager;
import org.Game.GameState;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameExitButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameOptionButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameShopButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameStartButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.I_Button;
import org.Game.GameStateCollect.GameOption.OptionButton.ControllerButton;
import org.Game.GameStateCollect.GameOption.OptionButton.OptionExitButton;
import org.Game.GameView.IStat;

public class GameOption implements IStat {
    private BackGround m_background;
    private I_Button[] button;
    private boolean destroy_flag= false;
    @Override
    public void init(int background) {
        destroy_flag = false;
        m_background = new BackGround(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.background_block),
                AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight()));
        m_background.setPosition(0,0);
        button = new I_Button[2];
        int x_margin,y_margin,width,height;
        x_margin = AppManager.getInstance().getM_GameView().getFullWidth()/6;
        y_margin = AppManager.getInstance().getM_GameView().getFullHeight()/9;
        width = AppManager.getInstance().getM_GameView().getFullWidth()- x_margin*2;
        height = AppManager.getInstance().getM_GameView().getFullHeight()-y_margin*8;
        Bitmap bitmap = AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.menubutton),width,height);
        button[0] = new ControllerButton(GraphicManager.getInstance().getM_OptionSwitch(width,height),x_margin,y_margin*3);
        button[1] = new OptionExitButton(bitmap,x_margin,y_margin*5);
    }
    @Override
    public void Render(Canvas canvas) {
        if(destroy_flag) return;
            m_background.Draw(canvas);
            for(int i = 0 ; i < button.length;i++) {
                if(button[i] == null) break;
                button[i].Draw(canvas);
            }

    }
    @Override
    public void Destroy() {
        m_background = null;
        synchronized (button) {
            for (int i = 0; i < button.length; i++)
                button[i] = null;
        }
        GraphicManager.getInstance().deleteOptionSwitch();
    }
    @Override
    public void Update() {
        if(destroy_flag) return;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(destroy_flag) return false;
        if(event.getAction() == MotionEvent.ACTION_UP)
        for(int i = 0 ; i< button.length;i++)
        {
            if(button[i].check_contain_point((int)event.getX(),(int)event.getY()))
            {
                SoundManager.getInstance().play(5);
                button[i].method();
                break;
            }
        }
        return false;
    }

    @Override
    public void set_DestroyFlag(boolean flag) {
        this.destroy_flag = flag;
    }
}
