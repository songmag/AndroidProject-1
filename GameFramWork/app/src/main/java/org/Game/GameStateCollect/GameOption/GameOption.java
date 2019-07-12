package org.Game.GameStateCollect.GameOption;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.SoundManager;
import org.Game.GameState;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameExitButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameOptionButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameShopButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameStartButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.I_Button;

public class GameOption extends GameState {
    private I_Button[] button;
    public GameOption() {

    }
    @Override
    public void init(int background) {
        m_background = new BackGround(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.background_block),
                AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight()));
        m_background.setPosition(0,0);
        button = new I_Button[4];
        int x_margin,y_margin,width,height;
        x_margin = AppManager.getInstance().getM_GameView().getFullWidth()/6;
        y_margin = AppManager.getInstance().getM_GameView().getFullHeight()/9;
        width = AppManager.getInstance().getM_GameView().getFullWidth()- x_margin*2;
        height = AppManager.getInstance().getM_GameView().getFullHeight()-y_margin*8;
        Bitmap bitmap = AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.menubutton),width,height);
        button[0] = new GameStartButton(bitmap,x_margin,y_margin);
        button[1] = new GameShopButton(bitmap,x_margin,y_margin*3);
        button[2] = new GameOptionButton(bitmap,x_margin,y_margin*5);
        button[3] = new GameExitButton(bitmap,x_margin,y_margin*7);
    }
    @Override
    public void Render(Canvas canvas) {
        if(m_background != null) {
            m_background.Draw(canvas);
            for(int i = 0 ; i < button.length;i++) {
                if(button[i] == null) break;
                button[i].Draw(canvas);
            }
        }
    }
    @Override
    public void Destroy() {
        m_background = null;
        synchronized (button) {
            for (int i = 0; i < button.length; i++)
                button[i] = null;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP)
        for(int i = 0 ; i< 4;i++)
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
}
