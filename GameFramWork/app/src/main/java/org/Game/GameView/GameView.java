package org.Game.GameView;
import android.content.Context;
import android.graphics.Canvas;

import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.example.gameframework.R;
import org.FrameWork.AppManager;
import org.FrameWork.GraphicManager;
import org.FrameWork.SoundManager;
import org.Game.GameState;
import org.Game.Player;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private GameViewThread m_thread;
    private IStat m_state;
    private Vibrator vi;
    private int fullWidth,fullHeight;
    public GameView(Context context) {
        super(context);
        setSize();

        SoundManager.getInstance().init(context);
        SoundManager.getInstance().addSound("clearmusic",0,R.raw.clearmusic);
        SoundManager.getInstance().addSound("coinmusic",1,R.raw.coinmusic);
        SoundManager.getInstance().addSound("diemusic",2,R.raw.diemusic);
        SoundManager.getInstance().addSound("gameovermusic",3,R.raw.gameover);
        SoundManager.getInstance().addSound("starcoinmusic",4,R.raw.starcoin);
        SoundManager.getInstance().addSound("buttonmusic",5,R.raw.smw_kick);
        vi = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        setFocusable(true);
        AppManager.getInstance().setM_view(this);
        AppManager.getInstance().setM_res(getResources());
        AppManager.getInstance().setPlayer(new Player(AppManager.getInstance().getBitMap(R.drawable.super_mario)));
        changeGameState(AppManager.getInstance().m_stage.introState);
        //get GameStage를 통해 생성해서 가져온다.
        //컨트롤러를 AppManager을 통해서 가져온다.
        getHolder().addCallback(this);
        m_thread = new GameViewThread(getHolder(),this);
    }
    //유일한 View , 생성시 필요한 자원들을 초기화하고 Appmanager에 등록한다.
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
    }//보여줄 디바이스 크기를 가져오는 size함수
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        m_state.onTouchEvent(event);
        return true;
    }//각 스테이트에 맞는 행동을한다.
    public void Update(){
        m_state.Update();
    }

    public void changeGameState(IStat _state)
    {
        if(m_state != null)
        {
            m_state.set_DestroyFlag(true);
            Thread destroy = new Thread(){
                @Override
                public void run() {
                    m_state.Destroy();
                    GraphicManager.getInstance().destroy();
                }
            };
            destroy.start();
        }
        _state.init(0);
        m_state = _state;
    }// 스테이트를 바꾼다 그동안 SurfaceView가 Update를 수행하지 않도록 Pause 시킨다.
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
    public void vibratorStart(){
            vi.vibrate(1000);
    }
    public void vibratorStop()
    {
        vi.cancel();
    }
    //Vibrator 같은 경우는 한개만 필요하므로, 동작과 스탑을 View에서 실행한다.
    public IStat getM_state() {
        return m_state;
    }
    public void setM_state(IStat m_state) {
        this.m_state = m_state;
    }
    public GameState getM_GameState()
    {
        return (GameState)m_state;
    }
}
