package org.GameView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gameframework.R;
import com.example.gameframework.org.FrameWork.AppManager;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
    public void onGameStart(View v){
        setContentView(new GameView(this));
    }
    public void onShop(View v){
        setContentView(new MerchantView(this));
    }
    public void onSetting(View v){

    }
    public void onExit(View v){
        super.onDestroy();
    }
    public void startIntent(Intent intent)
    {
        startIntent(intent);
    }
}
