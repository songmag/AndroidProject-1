package com.example.songdevelop.cardgame2;

import android.view.MotionEvent;

public class StateGame {
    private I_GameState current;
    private I_GameState ready;
    private I_GameState play;
    private I_GameState end;
    public StateGame() {
        
        ready = new GameReady();
        play = new GamePlay();
        end = new EndGame();
        current = ready;
    }
    public I_GameState getCurrent() {
        return current;
    }
    public I_GameState getReady() {
        return ready;
    }
    public I_GameState getPlay() {
        return play;
    }
    public I_GameState getEnd() {
        return end;
    }
    public void setCurrent(I_GameState current) {
        this.current = current;
    }
    public void Game(StateGame game,MotionEvent event,CardGameView view)
    {
        current.execute(game,event,view);
    }
}
