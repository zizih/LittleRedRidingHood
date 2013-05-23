package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgSrc;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/**
 * @author hezi
 */
public class Splash extends BaseActivity implements View.OnClickListener {

    private Button btn_splash_bg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        bgSrc = BgSrc.getInstance(this);
        btn_splash_bg = (Button) findViewById(R.id.btn_splash_bg);
        btn_splash_bg.setOnClickListener(this);
        refreshBg();

        mPlayer = mediaFactory.getSplash();
        try {
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toMenu();
            }
        }, 1000);

    }

    @Override
    public void onClick(View view) {
        toMenu();
    }

    private void toMenu() {
        System.out.println(" Splash " + setting.getReadMode().isFirst());
        if (setting.isFirst()) {
            setting.setFirst(false);
            setting.save();
            toPage(LangSelect.class);
        } else {
            toPage(Menu.class);
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        mPlayer.release();
        super.onDestroy();
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        refreshBg();
    }

    private void refreshBg() {
        System.out.println("setting.getLangId(): " + setting.getLangId());
        System.out.println("Splash Id: " + bgSrc.setLang(setting.getLangId()).getSplashDrawableId());
        this.btn_splash_bg.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getSplashDrawableId());
    }

}
