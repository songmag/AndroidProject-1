package org.FrameWork;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.gameframework.R;

import java.util.HashMap;

public class SoundManager {
    private static SoundManager instance = null;

    private SoundPool m_SoundPool;

    private HashMap m_SoundPoolMap;
    private HashMap m_SoundPoolString;
    //사운드에 접근하는 방식 2가지 , String 을 입력하여 해당 인덱스를 트는 방식
    //int index를 통해서 접근

    private AudioManager m_AudioManager;

    private Context m_Activity;

    private MediaPlayer m_backgroundMusic;

    private SoundManager()
    {
    }
    public void init(Context _context)
    {
        m_Activity = _context;
        m_SoundPool = new SoundPool(6,AudioManager.STREAM_MUSIC,0);
        m_SoundPoolMap  = new HashMap();
        m_SoundPoolString = new HashMap();
        m_AudioManager = (AudioManager)_context.getSystemService(Context.AUDIO_SERVICE);
    }
    //context 에 대해 설정하고, 사운드풀을 설정한다.
    public static SoundManager getInstance() {
        if(instance == null)
        {
            instance = new SoundManager();
        }
        return instance;
    }
    public void startBackground()
    {
        if(m_backgroundMusic == null) {
            m_backgroundMusic = MediaPlayer.create(m_Activity, R.raw.background);
        }
        m_backgroundMusic.setLooping(true);
        m_backgroundMusic.start();
    }
    public void stopBackground()
    {
        if(m_backgroundMusic != null) {
            m_backgroundMusic.stop();
            m_backgroundMusic = null;
        }
    }
    //MediaPlayer의 경우 destroy 상태일때 null로 초기화 해준다.
    //background 를 틀어주고 꺼주는 작업
    public void addSound(String soundName,int _index, int _SoundId)
    {
        int id = m_SoundPool.load(m_Activity,_SoundId,1);
        m_SoundPoolMap.put(_index,id);
        m_SoundPoolString.put(soundName,_index);
    }
    //sound Pool setting 하는 방법. 사운드를 추가할 수 있다.
    public void play_by_name(String soundName)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)),streamVolume,streamVolume,1,0,1f);
    }
    //이름을 통한 플레이
    public void playLoop_by_name(String soundName)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)),streamVolume,streamVolume,1,-1,1f);
    }
    //이름을 통한 루프 플레이
    public void play(int _index)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(_index),streamVolume,streamVolume,1,0,1f);
    }
    //인덱스를 통한 플레이
    public void stop(int _index)
    {
        m_SoundPool.stop((Integer)m_SoundPoolMap.get(_index));
    }
    public void stop_by_Name(String soundName)
    {
        m_SoundPool.stop((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)));
    }
    //이름을 통한 종료
    public void playLooped(int _index)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(_index),streamVolume,streamVolume,1,-1,1f);
    }
    //인덱스를 통한 루프 플레이
}
//Sound Manager 즉 사운드 관리에 대한 모든 것을 한다.