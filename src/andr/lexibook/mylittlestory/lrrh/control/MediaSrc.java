package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by rain on 5/18/13.
 */
public class MediaSrc {

    private Activity ctx;
    private static MediaSrc instance;
    private String langPath;
    private Map<String, WeakReference<MediaPlayer>> mPlayerList;

    private MediaSrc(Context ctx) {
        this.ctx = (Activity) ctx;
        this.langPath = ctx.getResources().getString(R.string.mp3_lang_default);
        this.mPlayerList = new WeakHashMap<String, WeakReference<MediaPlayer>>();
    }

    public static MediaSrc getInstance(Context ctx) {
        if (instance == null) instance = new MediaSrc(ctx);
        return instance;
    }

    public MediaPlayer getMedia(String fileName) {
        AssetFileDescriptor descriptor = null;
        MediaPlayer mPlayer = new MediaPlayer();
        try {
            descriptor = ctx.getAssets().openFd(langPath + fileName);
            mPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getDeclaredLength());
            descriptor.close();
        } catch (IOException e) {
            System.out.println("Err: " + e.getCause());
            e.printStackTrace();
            return null;
        }
        return mPlayer;
    }

    public MediaPlayer getLang() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_lang)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_lang)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_lang));
    }

    public MediaPlayer getPage01() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p01)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p01)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p01));
    }

    public MediaPlayer getPage02() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p02)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_p02)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p02));
    }

    public MediaPlayer getPage03() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p03)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_p03)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p03));
    }

    public MediaPlayer getPage04() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p04)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_p04)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p05));
    }

    public MediaPlayer getPage05() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p05)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_p05)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p06));
    }

    public MediaPlayer getPage06() {
        if (mPlayerList.containsKey(ctx.getResources().getString(R.string.mp3_p06)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p06)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p06));
    }

    public MediaPlayer getPage07() {
        if (mPlayerList.containsKey(ctx.getResources().getString(R.string.mp3_p07)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p07)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p07));
    }

    public MediaPlayer getPage08() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p08)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p08)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p08));
    }

    public MediaPlayer getPage09() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p09)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p09)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p09));
    }

    public MediaPlayer getPage10() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p10)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p10)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p10));
    }

    public MediaPlayer getPage11() {
        if (mPlayerList.containsKey(ctx.getResources().getString(R.string.mp3_p11)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p11)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p11));
    }

    public MediaPlayer getPage12() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_p12)))
            return mPlayerList.get(ctx.getResources().getString(R.string.mp3_p12)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_p12));
    }

    public MediaPlayer getSplash() {
        System.out.println(" TT: " + langPath);
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_splash)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_splash)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_splash));
    }

    public MediaPlayer getMenuAuto() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_menu_auto)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_menu_auto)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_menu_auto));
    }

    public MediaPlayer getMenuSelf() {
        if (mPlayerList.containsKey(langPath + ctx.getResources().getString(R.string.mp3_menu_self)))
            return mPlayerList.get(langPath + ctx.getResources().getString(R.string.mp3_menu_self)).get();
        return getMedia(ctx.getResources().getString(R.string.mp3_menu_self));
    }

    public void removeMediaPlayer() {

    }

    /**
     * set Language
     */

    public MediaSrc setLang(String langPath) {
        this.langPath = langPath;
        return this;
    }

    public MediaSrc toEngLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_eng));
    }

    public MediaSrc toFraLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_fra));
    }

    public MediaSrc toDeuLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_deu));
    }

    public MediaSrc toEspLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_esp));
    }

    public MediaSrc toItaLang() {
        return setLang(ctx.getResources().getString(R.string.mp3_lang_ita));
    }
}
