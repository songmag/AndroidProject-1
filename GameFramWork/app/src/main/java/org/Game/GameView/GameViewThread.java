package org.Game.GameView;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import org.FrameWork.AppManager;

public class GameViewThread extends Thread {
    private GameView m_view;
    private SurfaceHolder m_holder;
    private boolean m_run;
    private boolean m_destroyflag;
    public GameViewThread(SurfaceHolder holder, GameView gameView)
    {
        m_view = gameView;
        m_holder = holder;
        m_run = false;
    }
    public void setRunning(boolean run)
    {
        m_run = run;
    }
    @Override
    public void run() {

        Canvas _canvas;
        while(m_run)
        {
            if(AppManager.getInstance().getM_GameView().getM_state().get_DestroyFlag())
                continue;
            _canvas = null;
            try {
                 m_view.Update();
                 _canvas = m_holder.lockCanvas(null);
                synchronized (m_holder) {
                    m_view.onDraw(_canvas);
                }
            }catch(NullPointerException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(_canvas != null)
                {
                    m_holder.unlockCanvasAndPost(_canvas);
                }
            }
        }
    }
}
