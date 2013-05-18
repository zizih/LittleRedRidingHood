package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * User: rain
 * Date: 5/14/13
 * Time: 2:41 PM
 */
public class SoundFactory {

    private Activity ctx;
    private SoundPool pool;
    private int soundId;
    private String langPath;

    private static SoundFactory instance;
    private int engSoundId = -1;
    private int fraSoundId = -1;
    private int deuSoundId = -1;
    private int espSoundId = -1;
    private int itaSoundId = -1;

    public static SoundFactory getInstance(Context context) {
        if (instance == null)
            instance = new SoundFactory(context);
        return instance;
    }

    public SoundFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        this.pool = new SoundPool(1, AudioManager.STREAM_SYSTEM, 0);
        this.langPath = ctx.getResources().getString(R.string.mp3_lang_default);
    }

    public int getSound(String path, int priority) {
        try {
            soundId = pool.load(ctx.getAssets().openFd(path), priority);
            System.out.println(path + " soundId: " + soundId);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(" Err: " + e.getCause());
            return 0;
        }
        return soundId;
    }

    public SoundPool getSoundpool() {
        return pool;
    }

    public SoundFactory setLang(String langPath) {
        this.langPath = langPath;
        return getInstance(ctx);
    }

    public int getMenuAutoSoundId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_menu_auto), priority);
    }

    public int getMenuSelfSoundId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_menu_self), priority);
    }

    public int getSplashSoundId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_splash), priority);
    }

    public int getLangId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_lang), priority);
    }

    public int getPage11SoundId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_p11), priority);
    }

    public int getPage12SoundId(int priority) {
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_p12), priority);
    }

    public int getEngSoundId() {
        if (engSoundId == -1) {
            engSoundId = setLang(ctx.getResources().getString(R.string.mp3_lang_eng)).getLangId(1);
        }
        return engSoundId;
    }

    public int getFraSoundId() {
        if (fraSoundId == -1) {
            fraSoundId = setLang(ctx.getResources().getString(R.string.mp3_lang_fra)).getLangId(1);
        }
        return fraSoundId;
    }

    public int getDeuSoundId() {
        if (deuSoundId == -1) {
            deuSoundId = setLang(ctx.getResources().getString(R.string.mp3_lang_deu)).getLangId(1);
        }
        return deuSoundId;
    }

    public int getEspSoundId() {
        if (espSoundId == -1) {
            espSoundId = setLang(ctx.getResources().getString(R.string.mp3_lang_esp)).getLangId(1);
        }
        return espSoundId;
    }

    public int getItaSoundId() {
        if (itaSoundId == -1) {
            itaSoundId = setLang(ctx.getResources().getString(R.string.mp3_lang_ita)).getLangId(1);
        }
        return itaSoundId;
    }
}
