package com.example.gameframework.org.FrameWork;

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
    private AudioManager m_AudioManager;
    private Context m_Activity;
    private MediaPlayer m_backgroundMusic;
    private SoundManager()
    {
    }
    public void init(Context _context)
    {
        m_Activity = _context;
        m_SoundPool = new SoundPool(4,AudioManager.STREAM_MUSIC,0);
        m_SoundPoolMap  = new HashMap();
        m_SoundPoolString = new HashMap();
        m_AudioManager = (AudioManager)_context.getSystemService(Context.AUDIO_SERVICE);
    }
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
    public void addSound(String soundName,int _index, int _SoundId)
    {

        int id = m_SoundPool.load(m_Activity,_SoundId,1);
        m_SoundPoolMap.put(_index,id);
        m_SoundPoolString.put(soundName,_index);
    }
    public void play_by_name(String soundName)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)),streamVolume,streamVolume,1,0,1f);
    }
    public void playLoop_by_name(String soundName)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)),streamVolume,streamVolume,1,0,1f);
    }
    public void play(int _index)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(_index),streamVolume,streamVolume,1,-1,1f);
    }
    public void stop(int _index)
    {
        m_SoundPool.stop((Integer)m_SoundPoolMap.get(_index));
    }
    public void stop_by_Name(String soundName)
    {
        m_SoundPool.stop((Integer)m_SoundPoolMap.get(m_SoundPoolString.get(soundName)));
    }
    public void playLooped(int _index)
    {
        float streamVolume = m_AudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        streamVolume = streamVolume/m_AudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        m_SoundPool.play((Integer)m_SoundPoolMap.get(_index),streamVolume,streamVolume,1,-1,1f);
    }
}
