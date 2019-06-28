package org.GameView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import com.example.gameframework.org.FrameWork.AppManager;

import org.Game.GameState;

public class MerchantView extends SurfaceView implements SurfaceHolder.Callback,I_GameView {

    private MerchantThread m_thread;
    private IStat m_state;
    private int fullWidth,fullHeight;



    public MerchantView(Context context) {
        super(context);
        setSize();
        setFocusable(true);
        getHolder().addCallback(this);
        AppManager.getInstance().setM_view(this);
        AppManager.getInstance().setM_res(getResources());
        m_thread = new MerchantThread(getHolder(),this);
    }
    public int getFullWidth() {
        return fullWidth;
    }
    public int getFullHeight() {
        return fullHeight;
    }
    public void setSize()
    {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        fullWidth = metrics.widthPixels;
        fullHeight = metrics.heightPixels;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        m_state.onTouchEvent(event);
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        m_state.onKeyDown(keyCode,event);
        return true;
    }
    public void Update(){
        m_state.Update();
    }
    public void changeGameState(GameState _state)
    {
        if(m_state != null)
        {
            m_state.Destroy();
        }
        _state.init();
        m_state = _state;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        m_state.Render(canvas);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        m_thread.setRunning(true);
        m_thread.start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        m_thread.setRunning(false);
        while(retry)
        {
            try {
                m_thread.join();
                retry= false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public IStat getM_state() {
        return m_state;
    }
    public void setM_state(IStat m_state) {
        this.m_state = m_state;
    }
}
