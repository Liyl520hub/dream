package com.dream.cleaner.widget;

import android.media.MediaPlayer;

/**
 * @author lyl
 * <p>
 * created 2018/9/15
 * <p>
 * class use:
 */
public enum DIYMediaPlayer {

    /**
     * 单例播放器
     */
    DIYMEDIAPLAER;

    private MediaPlayer mediaPlayer = null;

    DIYMediaPlayer() {
        try {
            mediaPlayer = new MediaPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}
