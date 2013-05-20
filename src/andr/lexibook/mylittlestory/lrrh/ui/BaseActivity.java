package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgFactory;
import andr.lexibook.mylittlestory.lrrh.control.MediaFactory;
import andr.lexibook.mylittlestory.lrrh.control.Setting;
import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import andr.lexibook.mylittlestory.lrrh.util.ReadModeToFile;
import andr.lexibook.mylittlestory.lrrh.util.ViewUtil;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;

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

    public int WIN_WIDTH;
    public int WIN_HEIGHT;

    private MenuInflater inflater;
    private SharedPreferences sp;
    private Intent toPage;

    public Setting setting;

    public MediaFactory factory;
    public MediaPlayer mPlayer;
    public MediaPlayer langPlayer;

    //control read mode
    public boolean isPages = false;
    public BgFactory bgFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(" on create! ");

        //about public attribute for subClass
        toPage = new Intent();
        bgFactory = BgFactory.getInstance(this);

        //about menu
        inflater = getMenuInflater();
        eng = getString(R.string.lang_english);
        fra = getString(R.string.lang_franch);
        deu = getString(R.string.lang_eutsch);
        esp = getString(R.string.lang_espanol);
        ita = getString(R.string.lang_italiano);

        setting = Setting.getInstance();
        System.out.println(" ReadMode: " + setting.getReadMode().getLang());
        System.out.println(" ReadMode Auto: " + setting.getReadMode().isAuto());
        System.out.println(" ReadMode First: " + setting.getReadMode().isFirst());

        //about sound
        factory = MediaFactory.getInstance(this);
        //resume some params to last used
        factory.setLang(checkLangToPath(setting.getReadMode().getLang()));

        //about fling
        WIN_WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        WIN_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();

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
        System.out.println(Thread.currentThread().getClass() + " ondestry! ");
        setting.save();
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
        switch (langId) {
            case ENGLISH:
                lang = eng;
                langPlayer = factory.toEngLang().getLang();
                break;
            case FRANCH:
                lang = fra;
                langPlayer = factory.toFraLang().getLang();
                break;
            case EUTSCH:
                lang = deu;
                langPlayer = factory.toDeuLang().getLang();
                break;
            case ESPANOL:
                lang = esp;
                langPlayer = factory.toEspLang().getLang();
                break;
            case ITALIANO:
                lang = ita;
                langPlayer = factory.toItaLang().getLang();
                break;
        }
        try {
            langPlayer.prepare();
            langPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        changeBgByLang();
        setting.getReadMode().setLang(lang);
        setting.save();
    }

    /**
     * 设置所选的阅读模式
     */
    public void setReadMode(boolean isAuto) {
        setting.getReadMode().setAuto(isAuto);
        setting.save();
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

    private String checkLangToPath(String lang) {
        if (lang.equals(eng))
            return getResources().getString(R.string.mp3_lang_eng);
        if (lang.equals(fra))
            return getResources().getString(R.string.mp3_lang_fra);
        if (lang.equals(deu))
            return getResources().getString(R.string.mp3_lang_deu);
        if (lang.equals(esp))
            return getResources().getString(R.string.mp3_lang_esp);
        if (lang.equals(ita))
            return getResources().getString(R.string.mp3_lang_ita);
        return getResources().getString(R.string.mp3_lang_default);
    }

    public int checkLangToId(String lang) {
        if (lang.equals(eng))
            return ENGLISH;
        if (lang.equals(fra))
            return FRANCH;
        if (lang.equals(deu))
            return EUTSCH;
        if (lang.equals(esp))
            return ESPANOL;
        if (lang.equals(ita))
            return ITALIANO;
        return ENGLISH;
    }

    public void changeBgByLang() {
    }

}

