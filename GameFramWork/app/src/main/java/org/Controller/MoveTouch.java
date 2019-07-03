package org.Controller;

import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;

import org.Game.GameState;

public class MoveTouch implements I_Controller {
    private GameState state;

    public MoveTouch(GameState state) {
        this.state = state;
    }

    @Override
    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 1) {
            if (AppManager.getInstance().getM_GameView().getM_state().getM_player() == null)
                return false;
            if (AppManager.getInstance().getM_GameView().getM_state().getM_player().isM_death())
                return false;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if(state.getM_player().checkCharging())
                    state.getM_player().chargingattack();
                state.getM_player().setMove_flag(false);
            }
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Rect rect = state.getM_player().getM_rect();
                if (rect == null) return false;
                if (rect.contains((int) event.getX(0), (int) event.getY(0))) {
                    state.getM_player().startCharging();
                    state.getM_player().setMove_flag(true);
                } else if (rect.contains((int) event.getX(0), (int) event.getY(0))) {
                    state.getM_player().startCharging();
                    state.getM_player().setMove_flag(true);
                } else {
                    state.getM_player().attack();
                    state.getM_player().setMove_flag(false);
                }
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE && state.getM_player().isMove_flag()) {
                if (state.getM_player() == null) return false;
                Rect rect = state.getM_player().getM_rect();
                if (rect.contains((int) event.getX(0), (int) event.getY(0))) {
                    state.getM_player().setPosition((int) event.getX(0) - (state.getM_player().getM_rect().width() / 2), (int) event.getY(0) - (state.getM_player().getM_rect().height() / 2));
                } else if (rect.contains((int) event.getX(0), (int) event.getY(0))) {
                    state.getM_player().setPosition((int) event.getX(1) - (state.getM_player().getM_rect().width() / 2), (int) event.getY(1) - (state.getM_player().getM_rect().height() / 2));
                }
            }
        } else {
            if (AppManager.getInstance().getM_GameView().getM_state().getM_player() == null)
                return false;
            if (AppManager.getInstance().getM_GameView().getM_state().getM_player().isM_death())
                return false;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if(state.getM_player().isMove_flag())
                {
                    if(state.getM_player().checkCharging()) {
                        state.getM_player().chargingattack();
                    }
                    state.getM_player().setMove_flag(false);
                }
            }
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Rect rect = state.getM_player().getM_rect();
                if (rect == null) return false;
                if (rect.contains((int) event.getX(), (int) event.getY())) {
                    state.getM_player().startCharging();
                    state.getM_player().setMove_flag(true);
                }
                else {
                    state.getM_player().attack();
                    state.getM_player().setMove_flag(false);
                }
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE && state.getM_player().isMove_flag()) {
                if (state.getM_player() == null) return false;
                state.getM_player().setPosition((int) event.getX() - (state.getM_player().getM_rect().width() / 2), (int) event.getY() - (state.getM_player().getM_rect().height() / 2));
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                state.getM_player().attack();
                state.getM_player().setMove_flag(false);
            }
        }
        return false;
    }
}

