package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: rain
 * Date: 5/14/13
 * Time: 2:41 PM
 */
@SuppressWarnings("AndroidLintNewApi")
public class SoundFactory {

    private Activity ctx;
    private SoundPool pool;
    private int soundId;
    private String langPath;
    private boolean loaded = false;

    private static SoundFactory instance;
    private int engSoundId = -1;
    private int fraSoundId = -1;
    private int deuSoundId = -1;
    private int espSoundId = -1;
    private int itaSoundId = -1;

    private Map<String, Integer> soundIdList;

    public static SoundFactory getInstance(Context context) {
        if (instance == null)
            instance = new SoundFactory(context);
        return instance;
    }

    public SoundFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        this.pool = new SoundPool(1, AudioManager.STREAM_SYSTEM, 0);
        this.pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                loaded = true;
            }
        });
        this.soundIdList = new HashMap<String, Integer>();
        this.langPath = ctx.getResources().getString(R.string.mp3_lang_default);
    }

    public int getSound(String path, int priority) {
        try {
            soundId = pool.load(ctx.getAssets().openFd(path), priority);
            System.out.println("loaded: " + loaded);
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


    /**
     * five language soundID
     */
    public int getEngSoundId() {
        if (engSoundId == -1) {
            engSoundId = toEngLang().getLangId(1);
        }
        return engSoundId;
    }

    public int getFraSoundId() {
        if (fraSoundId == -1) {
            fraSoundId = toFraLang().getLangId(1);
        }
        return fraSoundId;
    }

    public int getDeuSoundId() {
        if (deuSoundId == -1) {
            deuSoundId = toDeuLang().getLangId(1);
        }
        return deuSoundId;
    }

    public int getEspSoundId() {
        if (espSoundId == -1) {
            espSoundId = toEspLang().getLangId(1);
        }
        return espSoundId;
    }

    public int getItaSoundId() {
        if (itaSoundId == -1) {
            itaSoundId = toItaLang().getLangId(1);
        }
        return itaSoundId;
    }

    /**
     * private method
     */
    public int getMenuAutoId(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_menu_auto)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_menu_auto));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_menu_auto), priority);
    }

    public int getMenuSelfId(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_menu_self)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_menu_self));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_menu_self), priority);
    }

    public int getSplashId(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_splash)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_splash));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_splash), priority);
    }

    public int getLangId(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_lang)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_lang));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_lang), priority);
    }

    public int getPage11Id(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p11)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_p11));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_p11), priority);
    }

    public int getPage12Id(int priority) {
        if (soundIdList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p12)))
            return soundIdList.get(langPath + ctx.getResources().getString(R.string.mp3_p12));
        return getSound(langPath + ctx.getResources().getString(R.string.mp3_p12), priority);
    }

    /**
     * set Language
     */
    public SoundFactory setLang(String langPath) {
        this.langPath = langPath;
        return getInstance(ctx);
    }

    private SoundFactory toEngLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_eng));
    }

    private SoundFactory toFraLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_fra));
    }

    private SoundFactory toDeuLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_deu));
    }

    private SoundFactory toEspLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_esp));
    }

    private SoundFactory toItaLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_ita));
    }

}
