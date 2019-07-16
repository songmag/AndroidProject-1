package org.Controller;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import org.FrameWork.AppManager;

import org.Game.GameState;

public class MoveTouch implements I_Controller {
    private GameState state;//state 를 매번 가져오는 것의 소요를 줄이기 위한 레퍼런스 객체
    public MoveTouch(){
    }
    public MoveTouch(GameState state) {
        this.state = state;
    }
    //컨트롤러 생성하면 잡는 스테이트
    @Override
    public void setState(GameState state) {
        this.state = state;
    }//스테이트가 교체될때 이것도 교체된다.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         if (AppManager.getInstance().getM_GameView().getM_GameState().getM_player() == null)
                return false;
        //SurfaceView의 state를 변경시 init 함수가 호출되기전 TouchEvent 시행 되는경우 방지.
        if (AppManager.getInstance().getM_GameView().getM_GameState().getM_player().isM_death())
                return false;
        //죽었을때, 바로 터치를 하는 경우 방지
        if (event.getAction() == MotionEvent.ACTION_UP) {
                if(state.getM_player().isMove_flag())
                {
                    if(state.getM_player().checkCharging()) {
                        state.getM_player().chargingattack();
                    }
                    state.getM_player().setMove_flag(false);
                }
        } //터치를 땟을때, 플레이어가 차징 상태이면, 미사일 발사

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Rect rect = state.getM_player().getM_rect();
                if (rect == null) return false;
                //플레이어가 생성되지 않았을때 터치 방지
                if (rect.contains((int) event.getX(), (int) event.getY())) {
                    state.getM_player().startCharging();
                    state.getM_player().setMove_flag(true);
                }//플레이어 안에 터치가 되었을떄, 차징을 시작하고, 움직일 수 있도록 한다.
                else {
                    state.getM_player().attack();
                    state.getM_player().setMove_flag(false);
                }//다른 곳을 클릭시 공격한다.
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE && state.getM_player().isMove_flag()) {
               if (state.getM_player() == null) return false;
               state.getM_player().setPosition((int) event.getX() - (state.getM_player().getM_rect().width() / 2), (int) event.getY() - (state.getM_player().getM_rect().height() / 2));
        } //플레이어가 움직이는 상태가 아닌데 드레그 되는경우, 리턴, 움직이는 상태일때 드레그 하면 캐릭터가 움직인다.
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            state.getM_player().attack();
            state.getM_player().setMove_flag(false);
        }//움직이는 상태가 아닌데 플레이어가 드레그하면 미사일 자동발사, 이유는 난이도가 높기 때문에 미리 드레그로 공격해야함
        return false;
    }
    @Override
    public void drawController(Canvas canvas) {

    }
}

