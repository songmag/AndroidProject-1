package org.GameView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

import com.example.gameframework.org.FrameWork.AppManager;

import org.Controller.I_Controller;
import org.Game.GameState;
import org.GameStage.GameStage_1;

public class GameView extends SurfaceView implements SurfaceHolder.Callback,I_GameView {

    private GameViewThread m_thread;
    private GameState m_state;
    private int fullWidth,fullHeight;
    private I_Controller controller;

    public GameView(Context context) {
        super(context);
        setSize();
        setFocusable(true);
        AppManager.getInstance().setM_view(this);
        AppManager.getInstance().setM_res(getResources());
        changeGameState(new GameStage_1());
        //get GameStage를 통해 생성해서 가져온다.
        this.controller = AppManager.getInstance().getM_controller();
        //컨트롤러를 AppManager을 통해서 가져온다.
        getHolder().addCallback(this);
        m_thread = new GameViewThread(getHolder(),this);
    }
    public void setFocus()
    {
        setFocusable(true);
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
        controller.onTouchEvent(event);
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
            controller.setState(_state);
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

    public GameState getM_state() {
        return m_state;
    }
    public void setM_state(GameState m_state) {
        this.m_state = m_state;
    }
}
