package org.GameView;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameViewThread extends Thread {
    private GameView m_view;
    private SurfaceHolder m_holder;
    private boolean m_run;
    private boolean m_pause;
    public GameViewThread(SurfaceHolder holder, GameView gameView)
    {
        m_view = gameView;
        m_holder = holder;
        m_run = false;
        m_pause = false;
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
            while(m_pause){}
            _canvas = null;
            try {
                m_view.Update();
                _canvas = m_holder.lockCanvas(null);
                synchronized (m_holder) {
                    m_view.onDraw(_canvas);
                }
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
    public void pause(boolean flag)
    {
        m_pause = flag;
    }
}
