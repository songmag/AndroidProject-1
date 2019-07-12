package org.Game;

import android.graphics.Canvas;
import android.view.MotionEvent;

import org.FrameWork.AppManager;
import org.FrameWork.BackGround;
import org.FrameWork.CollisionManager;
import org.FrameWork.GraphicManager;
import org.FrameWork.SoundManager;

import org.Controller.I_Controller;
import org.Factory.EnemyFactory;
import org.Factory.MovePatternFactory;
import org.Game.CoinPackage.BronzeMoney;
import org.Game.CoinPackage.Money;
import org.Game.CoinPackage.StarMoney;
import org.Game.Enemy.Boss;
import org.Game.Enemy.Enermy;
import org.Game.GameView.IStat;
import org.Game.MissailPackage.Missail;
import org.Game.MovePackage.DownMovePattern;
import org.Game.MovePackage.SinMovePattern;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameState implements IStat {
    private Player m_player;
    private LinkedList<Enermy> enermys;
    private long LastRegenEnemy;
    public Random rand = new Random();
    private boolean m_BossFlag = false;
    private LinkedList<Money> moneys;
    protected long m_BossTime=0;//millie second
    protected BackGround m_background = null;
    protected long m_StageRegenTime;//millie second
    protected boolean m_StageClear = false;
    protected int m_EnemyLimit=0;
    protected boolean m_BossContain;
    protected int destroy_enem = 0;
    protected I_Controller controller;
    private long waitTime;
    protected HashMap<Integer,Class> enemys_name;
    protected int contain_enemy;
    protected Class boss_class;
    /*
    stage 생성시 변경할 수 있는 변수
    m_background, m_BossTime, m_BossContain, m_enemylimit
    */
    @Override
    public void init(int background) {
        controller = AppManager.getInstance().getM_controller();
        LastRegenEnemy = System.currentTimeMillis();
        m_BossTime = 30000;
        waitTime = 2000;
        m_BossTime = LastRegenEnemy + m_BossTime;
        this.m_background = new BackGround(background);
        enermys = new LinkedList<Enermy>();
        m_BossFlag = false;
        m_StageClear = false;
        destroy_enem =0;
        this.m_EnemyLimit = 10;
        SoundManager.getInstance().startBackground();
        m_StageRegenTime = 1000;
        moneys = new LinkedList<Money>();
        enemys_name = new HashMap<Integer,Class>();
        contain_enemy = 2;
    }
    //일반적인 요소 초기화
    //스테이지 구성하면서 생각한게.. 이거 굳이 여기에 정의를 해서 써야 하는가..
    //매 스테이지마다 init이 다를탠데 그럼 abstract로 만들어도 되지 않는가..
    //다하고 생각난다..

    @Override
    public void Destroy() {
        SoundManager.getInstance().stopBackground();
        m_background = null;
        m_player = null;
        controller =null;
        enermys = null;
        moneys = null;
        GraphicManager.getInstance().destroy();
    }
    @Override
    public void Update() {
        if(m_player == null) return;
        long gameTime = System.currentTimeMillis();
        m_player.Update(gameTime);
        m_background.Update(gameTime);
        for(int i=0;i<moneys.size();i++) {
            moneys.get(i).Update(gameTime);
            if(moneys.get(i).getM_state() == Money.STATE_OUT)
            {
                moneys.remove(i);
            }
        }
        for(int i=0 ; i < enermys.size();i++)
        {
            enermys.get(i).Update(gameTime);
            if (enermys.get(i).getM_state() == Enermy.STATE_OUT && enermys.get(i).destroy_count >= 20){
                   enermys.remove(i);
            }
        }
        for(int i=0 ; i < m_player.getMissails().size();i++)
        {
            m_player.getMissails().get(i).Update();
            if (m_player.getMissails().get(i).getM_state()== Missail.STATE_OUT) {
                m_player.getMissails().remove(i);
            }
        }
        makeEnermy();
        checkCollision();
        if(enermys.size() == 0 && m_BossFlag && moneys.size() == 0)
        {
            this.m_StageClear = true;
            AppManager.getInstance().getPlayer().getM_Money().addMoney(m_player.getM_Money().getM_Money());
            AppManager.getInstance().getPlayer().clearStage();
        }
        deathCheck();
    }
    //GameState 안에 있는 모든 요소들을 Update한다.

    public void makeMoney(Enermy enemy)
    {
        if(enemy instanceof Boss)
        {
            for(int i = 0 ; i <4;i++)
            {
                Money money = new StarMoney(GraphicManager.getInstance().getMoney(StarMoney.class));
                money.set_State(MovePatternFactory.createRandomMovePattern());
                money.setPosition(enemy.getM_x()+i*20,enemy.getM_y()+enemy.getM_bitmap().getHeight());
                moneys.add(money);
            }
        }
        else
        {
            Money money = new BronzeMoney(GraphicManager.getInstance().getMoney(BronzeMoney.class));
            money.set_State(MovePatternFactory.createMovePattern(DownMovePattern.class));
            money.setPosition(enemy.getM_x(),enemy.getM_y());
            moneys.add(money);
        }
    }//돈을 만든다, Factory패턴을 적용해서 만들었으면..
    public void deathCheck()
    {
        if(m_player.isM_death() && System.currentTimeMillis() - waitTime >= 0)
        {
            AppManager.getInstance().getPlayer().setM_stage(0);
            AppManager.getInstance().getM_GameView().vibratorStop();
            AppManager.getInstance().getM_GameView().changeGameState(
                    AppManager.getInstance().m_stage.deathStage
            );
        }
    }

    @Override
    public void Render(Canvas canvas) {
        if(m_background == null) return;
        m_background.Draw(canvas);
        m_player.Draw(canvas);
        for(int i = 0 ; i <moneys.size();i++)
        {
            moneys.get(i).Draw(canvas);
        }
        for(int i=0 ; i < enermys.size();i++)
        {
            enermys.get(i).Draw(canvas);
        }
        for(int i =0 ; i< m_player.getMissails().size();i++)
        {
            m_player.getMissails().get(i).Draw(canvas);
        }
        controller.drawController(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(controller == null) return false;
        return controller.onTouchEvent(event);
    }
    public void makeEnermy(){
        if(System.currentTimeMillis()-LastRegenEnemy >= m_StageRegenTime && !m_BossFlag && m_EnemyLimit > 0 ) {
            LastRegenEnemy = System.currentTimeMillis();
            Enermy enermy;
            enermy = EnemyFactory.createEnemy(this.enemys_name.get(rand.nextInt(contain_enemy)),50,AppManager.getInstance().getM_GameView().getHeight()/150);
            enermy.setPosition(rand.nextInt(AppManager.getInstance().getM_GameView().getFullWidth()), -200);
            enermy.set_State(MovePatternFactory.createMovePattern(SinMovePattern.class));
            this.enermys.add(enermy);
            m_EnemyLimit -= 1;
        }
        else if(m_BossContain) {
            if (System.currentTimeMillis() - m_BossTime >= 0 && !m_BossFlag && m_EnemyLimit == 0) {
                for (int i = 0; i < enermys.size(); i++) {
                    enermys.get(i).destroy();
                    enermys.get(i).setM_state(Enermy.STATE_OUT);
                }
                Enermy boss = EnemyFactory.createBoss(boss_class,400,AppManager.getInstance().getM_GameView().getHeight()/150);
                boss.setPosition(0, 200);
                this.enermys.add(boss);
                m_BossFlag = true;
            }
        }
        else if(!m_BossContain){
            if(System.currentTimeMillis() - m_BossTime >= 0 && !m_BossFlag && m_EnemyLimit == 0) {
                enermys.add(EnemyFactory.createEnemy(this.enemys_name.get(rand.nextInt(contain_enemy)),20,AppManager.getInstance().getM_GameView().getHeight()/240));
                m_BossFlag = true;
            }
        }
    }
    //보스를 만드는 작업을 한다. 보스가 들어있는것,없는것을 구분했고
    //보스가 생성되는 시간을 체크해서 만든다.
    //각 스테이지별 적을 생성하는 개수를 만들어서 세팅한다.
    public void checkCollision(){
        LinkedList<Missail> missails = m_player.getMissails();
        for(int i = 0 ; i < enermys.size();i++) {
            for(int j = 0 ; j<missails.size();j++) {
                if(enermys.get(i).getM_state() != Enermy.STATE_OUT)
                if( CollisionManager.checkBoxToBox(missails.get(j).getM_nowRect(), enermys.get(i).getM_rect())){
                    if(missails.get(j).getClass() != m_player.getCharging_missail() || enermys.get(i) instanceof Boss)
                        missails.get(j).setM_state(Missail.STATE_OUT);
                    enermys.get(i).hert(missails.get(j).getDamage());
                    if(enermys.get(i).getHp() <= 0) {
                        destroy_enem += 1;
                        enermys.get(i).setM_state(Enermy.STATE_OUT);
                    }
                }
            }
            if(enermys.get(i).getM_state() != Enermy.STATE_OUT)
                if(CollisionManager.checkBoxToBox(m_player.getM_rect(),enermys.get(i).getM_rect())){
                if(!m_player.isM_death())
                {
                    m_player.destroy();
                    AppManager.getInstance().getM_GameView().vibratorStart();
                    waitTime += System.currentTimeMillis();
                    return;
                }
            }
            if(enermys.get(i) instanceof Boss)
            {
                Boss enemy = (Boss)enermys.get(i);
                for(int j = 0 ; j<enemy.getMissails().size();j++)
                if( CollisionManager.checkBoxToBox(enemy.getMissails().get(j).getM_nowRect(), m_player.getM_rect())){
                        enemy.getMissails().get(j).setM_state(Missail.STATE_OUT);
                        if(!m_player.isM_death())
                        {
                          m_player.destroy();
                          AppManager.getInstance().getM_GameView().vibratorStart();
                          waitTime += System.currentTimeMillis();
                         return;
                        }
                    }
            }
        }
        for(int i = 0 ; i <moneys.size();i++)
        {
            if(CollisionManager.checkBoxToBox(moneys.get(i).getM_rect(),m_player.getM_rect()))
            {
                m_player.getM_Money().addMoney((moneys.get(i).getM_Money()));
                if(moneys.get(i) instanceof BronzeMoney) {
                    SoundManager.getInstance().play_by_name("coinmusic");
                }
                else
                {
                    SoundManager.getInstance().play_by_name("starcoinmusic");
                }
                moneys.remove(i);
            }
        }
    }//모든 요소들에 대한 충돌처리

    public Player getM_player() {
        return m_player;
    }
    public void setM_player(Player m_player) {
        this.m_player = m_player;
    }
}
