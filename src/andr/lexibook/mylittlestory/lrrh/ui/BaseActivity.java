package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.MediaFactory;
import andr.lexibook.mylittlestory.lrrh.control.SoundFactory;
import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import andr.lexibook.mylittlestory.lrrh.util.ReadModeToFile;
import andr.lexibook.mylittlestory.lrrh.util.ViewUtil;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

    public MediaFactory factory;
    public MediaPlayer mPlayer;
    public MediaPlayer engPlayer;
    public MediaPlayer fraPlayer;
    public MediaPlayer deuPlayer;
    public MediaPlayer espPlayer;
    public MediaPlayer itaPlayer;

    //control read mode
    public boolean isPages = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //about public attribute for subClass
        System.out.println(" on create! ");
        toPage = new Intent();
        io = new ReadModeToFile();
        readMode = io.get();

        //about sound
        factory = new MediaFactory(this);

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
        System.out.println(" ondestry! ");
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
                engPlayer = factory.toEngLang().getLang();
                try {
                    engPlayer.prepare();
                    engPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case FRANCH:
                lang = fra;
                fraPlayer = factory.toFraLang().getLang();
                try {
                    fraPlayer.prepare();
                    fraPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case EUTSCH:
                lang = deu;
                deuPlayer = factory.toDeuLang().getLang();
                try {
                    deuPlayer.prepare();
                    deuPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ESPANOL:
                lang = esp;
                espPlayer = factory.toEspLang().getLang();
                try {
                    espPlayer.prepare();
                    espPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ITALIANO:
                lang = ita;
                itaPlayer = factory.toItaLang().getLang();
                try {
                    itaPlayer.prepare();
                    itaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

