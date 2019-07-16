package org.Game.GameStateCollect.GameMenu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.GraphicManager;
import org.FrameWork.SoundManager;

import org.Game.GameStateCollect.GameMenu.MenuButton.GameExitButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameOptionButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameShopButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameStartButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.I_Button;
import org.Game.GameState;
import org.Game.GameView.IStat;

public class GameMenu implements IStat {
    private I_Button[] button;
    private BackGround m_background;
    private long onTouchTime;
    private boolean destroy_flag=false;
    public GameMenu() {

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
        onTouchTime = System.currentTimeMillis()+800;
        m_background = new BackGround(GraphicManager.getInstance().getM_Background_Default());
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
    }
    @Override
    public void Update() {
        if(destroy_flag) return;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(destroy_flag) return false;
        if(System.currentTimeMillis() - onTouchTime <= 0) return false;
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
