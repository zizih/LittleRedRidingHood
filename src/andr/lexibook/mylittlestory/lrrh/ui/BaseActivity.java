package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.SoundFactory;
import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import andr.lexibook.mylittlestory.lrrh.util.ReadModeToFile;
import andr.lexibook.mylittlestory.lrrh.util.ViewUtil;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class BaseActivity extends Activity {

    public String eng;
    public String fra;
    public String deu;
    public String esp;
    public String ita;
    private String lang;

    public final int ENGLISH = 1;
    public final int FRANCH = 2;
    public final int EUTSCH = 3;
    public final int ESPANOL = 4;
    public final int ITALIANO = 5;
    public String SPName;

    public int WIN_WIDTH;
    public int WIN_HEIGHT;

    private MenuInflater inflater;
    private SharedPreferences sp;
    private Intent toPage;

    public ReadModeToFile io;
    public ReadMode readMode;
    public String READ_SELF;
    public String READ_AUTO;

    public SoundFactory soundFactory;
    public SoundPool pool;

//    public int engSoundId;
//    public int fraSoundId;
//    public int deuSoundId;
//    public int espSoundId;
//    public int itaSoundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //about public attribute for subClass
        toPage = new Intent();
        io = new ReadModeToFile();
        readMode = io.get();

        //about sound
        soundFactory = SoundFactory.getInstance(this);
        pool = soundFactory.getSoundpool();

        //about fling
        READ_SELF = getString(R.string.read_self);
        READ_AUTO = getString(R.string.read_auto);
        WIN_WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        WIN_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();

        //about menu
        inflater = getMenuInflater();
        SPName = getResources().getString(R.string.sp_name);
        sp = this.getSharedPreferences(SPName, 0);
        eng = getString(R.string.lang_english);
        fra = getString(R.string.lang_franch);
        deu = getString(R.string.lang_eutsch);
        esp = getString(R.string.lang_espanol);
        ita = getString(R.string.lang_italiano);

//        engSoundId = soundFactory.setLang(getResources().getString(R.string.mp3_lang_eng)).getLangId(1);
//        fraSoundId = soundFactory.setLang(getResources().getString(R.string.mp3_lang_fra)).getLangId(1);
//        deuSoundId = soundFactory.setLang(getResources().getString(R.string.mp3_lang_deu)).getLangId(1);
//        espSoundId = soundFactory.setLang(getResources().getString(R.string.mp3_lang_esp)).getLangId(1);
//        itaSoundId = soundFactory.setLang(getResources().getString(R.string.mp3_lang_ita)).getLangId(1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater.inflate(R.menu.language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lang_english:
                setLanguage(ENGLISH);
                break;
            case R.id.lang_franch:
                setLanguage(FRANCH);
                break;
            case R.id.lang_eutsch:
                setLanguage(EUTSCH);
                break;
            case R.id.lang_espanol:
                setLanguage(ESPANOL);
                break;
            case R.id.lang_italiano:
                setLanguage(ITALIANO);
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //pool.release();
        System.out.println(" POOL RELEASE! ");
        System.gc();
        finish();
    }

    /**
     * 清理gif后 页面跳转
     */
    public void toPage(Class<?> cls) {
        toPage.setClass(this, cls);
        startActivity(toPage);
        this.finish();
    }

    /**
     * 设置所选的语言
     */
    public void setLanguage(int langId) {
        int tmpId;
        switch (langId) {
            case ENGLISH:
                lang = eng;
                tmpId = pool.play(soundFactory.getEngSoundId(), 1, 1, 0, 0, 1);
                Toast.makeText(this, lang + " Press: " + soundFactory.getEngSoundId() + " playId: " + tmpId, 1000).show();
                break;
            case FRANCH:
                lang = fra;
                tmpId = pool.play(soundFactory.getFraSoundId(), 1, 1, 0, 0, 1);
                Toast.makeText(this, lang + " Press: " + soundFactory.getFraSoundId() + " playId: " + tmpId, 1000).show();
                break;
            case EUTSCH:
                lang = deu;
                tmpId = pool.play(soundFactory.getDeuSoundId(), 1, 1, 0, 0, 1);
                Toast.makeText(this, lang + " Press: " + soundFactory.getDeuSoundId() + " playId: " + tmpId, 1000).show();
                break;
            case ESPANOL:
                lang = esp;
                tmpId = pool.play(soundFactory.getEspSoundId(), 1, 1, 0, 0, 1);
                Toast.makeText(this, lang + " Press: " + soundFactory.getEspSoundId() + " playId: " + tmpId, 1000).show();
                break;
            case ITALIANO:
                lang = ita;
                tmpId = pool.play(soundFactory.getItaSoundId(), 1, 1, 0, 0, 1);
                Toast.makeText(this, lang + " Press: " + soundFactory.getItaSoundId() + " playId: " + tmpId, 1000).show();
                break;
        }
        readMode.setLang(lang);
        sp.edit().putString("lang", lang).commit();
        //Toast.makeText(this, "Choose " + lang, 1000).show();
    }

    /**
     * 设置所选的阅读模式
     */
    public void setReadMode(String mode) {
        readMode.setMode(mode);
        sp.edit().putString("mode", mode).commit();
    }

    public String getLanguage() {
        return sp.getString("lang", lang);
    }

    public String getReadMode() {
        return sp.getString("mode", READ_SELF);
    }

    public boolean isReadAuto() {
        return getReadMode().equals(READ_AUTO);
    }

    public boolean isReadSelf() {
        return getReadMode().equals(READ_SELF);
    }

    public float getDimens(int dimensId) {
        return getResources().getDimension(dimensId);
    }

    public float getWidthScale() {
        return ViewUtil.getInstance(this).getWidthScale();
    }

    public float getHeightScale() {
        return ViewUtil.getInstance(this).getHeightScale();
    }

}

