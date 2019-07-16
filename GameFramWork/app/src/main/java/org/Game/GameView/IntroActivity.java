package org.Game.GameView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import org.FrameWork.AppManager;
import org.FrameWork.SoundManager;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window. FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new GameView(this));
    }
    @Override
    protected void onPause() {
        super.onPause();
        SoundManager.getInstance().stopBackground();
    }

    @Override
    public void onBackPressed() {
        AppManager.getInstance().getM_GameView().changeGameState(AppManager.getInstance().m_stage.menuState);
    }
}//처음 실행시 GameView를 보여주는 역할.
