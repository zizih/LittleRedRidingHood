package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by rain on 5/18/13.
 */
public class MediaFactory {

    private Activity ctx;
    private static MediaFactory instance;
    private String langPath;

    public MediaFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        this.langPath = ctx.getResources().getString(R.string.mp3_lang_default);
    }

    public static MediaFactory getInstance(Context ctx) {
        if (instance == null) instance = new MediaFactory(ctx);
        return instance;
    }

    public MediaFactory setLang(String langPath) {
        this.langPath = langPath;
        return getInstance(ctx);
    }

    public MediaPlayer getMedia(String fileName) {
        AssetFileDescriptor descriptor = null;
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            descriptor = ctx.getAssets().openFd(langPath + fileName);
            System.out.println("Path: " + langPath + fileName);
            mPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getDeclaredLength());
            descriptor.close();
        } catch (IOException e) {
            System.out.println("Err: " + e.getCause());
            e.printStackTrace();
            return null;
        }
        return mPlayer;
    }

    public MediaPlayer getPage07() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p07));
    }

    public MediaPlayer getPage01SoundId() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p01));
    }

    public MediaPlayer getPage02SoundId() {
        return getMedia(ctx.getResources().getString(R.string.mp3_p02));
    }

    public MediaPlayer getPage03SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p03));
    }

    public MediaPlayer getPage04SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p05));
    }

    public MediaPlayer getPage05SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p06));
    }

    public MediaPlayer getPage06SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p06));
    }

    public MediaPlayer getPage08SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p08));
    }

    public MediaPlayer getPage09SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p09));
    }

    public MediaPlayer getPage10SoundId(MediaPlayer priority) {
        return getMedia(ctx.getResources().getString(R.string.mp3_p10));
    }
}
