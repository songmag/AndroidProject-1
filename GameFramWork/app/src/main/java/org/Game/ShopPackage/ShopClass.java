package org.Game.ShopPackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.gameframework.R;

import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.GraphicObject;
import org.Game.GameStateCollect.GameMenu.MenuButton.GameStartButton;
import org.Game.GameStateCollect.GameMenu.MenuButton.I_Button;
import org.Game.GameView.IStat;
import org.Game.ShopPackage.ShopButton.ChargingMissailButton;
import org.Game.ShopPackage.ShopButton.DefaultMissailButton;
import org.Game.ShopPackage.ShopButton.ShopExitButton;
import org.Game.ShopPackage.TalkStatePackage.FirstState;
import org.Game.ShopPackage.TalkStatePackage.I_DrawText;

public class ShopClass implements IStat {
    private GraphicObject merchant;
    private BackGround m_background;
    private boolean destory_flag = false;
    private I_Button[] button;
    public ShopClass() {

    }

    @Override
    public void set_DestroyFlag(boolean flag) {
        this.destory_flag = flag;
    }

    @Override
    public void init(int background) {
        destory_flag = false;
        m_background = new BackGround(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.background_block),AppManager.getInstance().getM_GameView().getFullWidth(),AppManager.getInstance().getM_GameView().getFullHeight()));
        m_background.setPosition(0,0);
        int x_margin = AppManager.getInstance().getM_GameView().getFullWidth()/8;
        int y_margin = AppManager.getInstance().getM_GameView().getFullHeight()/4;
        int width =   AppManager.getInstance().getM_GameView().getFullWidth() -x_margin*2;
        int height =   AppManager.getInstance().getM_GameView().getFullHeight() -y_margin;
        merchant = new GraphicObject(AppManager.getInstance().reSizing(AppManager.getInstance().getBitMap(R.drawable.merchant),
                width,height));
        merchant.setPosition(x_margin,y_margin);
        button = new I_Button[3];
        x_margin = AppManager.getInstance().getM_GameView().getFullWidth()/6;
        y_margin = AppManager.getInstance().getM_GameView().getFullHeight()/9;
        width = AppManager.getInstance().getM_GameView().getFullWidth()- x_margin*2;
        height = AppManager.getInstance().getM_GameView().getFullHeight()-y_margin*8;
        Bitmap bitmap = AppManager.getInstance().reSizing(
                AppManager.getInstance().getBitMap(R.drawable.menubutton),width,height);
        button[0] = new DefaultMissailButton(bitmap,x_margin,y_margin*2);
        button[1] = new ChargingMissailButton(bitmap,x_margin,y_margin*4);
        button[2] = new ShopExitButton(bitmap,x_margin,y_margin*6);
    }
    @Override
    public void Update() {
    }
    @Override
    public void Render(Canvas canvas) {
        if(destory_flag) return;
        m_background.Draw(canvas);
        merchant.Draw(canvas);
        for(int i = 0 ; i<button.length;i++)
        {
            button[i].Draw(canvas);
        }
    }

    @Override
    public void Destroy() {
            merchant = null;
            m_background = null;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for(int i = 0 ; i<button.length;i++)
        {
            if(button[i].check_contain_point((int)event.getX(),(int)event.getY()))
            {
                button[i].method();
            }
        }
        return false;
    }
}
