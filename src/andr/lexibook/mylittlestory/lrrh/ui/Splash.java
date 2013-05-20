package andr.lexibook.mylittlestory.lrrh.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.IOException;

/**
 * @author hezi
 */
public class Splash extends BaseActivity implements View.OnTouchListener {

    private RelativeLayout page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        page = (RelativeLayout) findViewById(R.id.layout_splash);
        page.setBackgroundColor(Color.GREEN);
        page.setBackgroundDrawable(bgFactory.setLang(checkLangToId(setting.getLang())).getSplash());

        mPlayer = factory.getSplash();
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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        toMenu();
        return true;
    }

    private void toMenu() {
        System.out.println(" Splash " + setting.getReadMode().isFirst());
        if (setting.getReadMode().isFirst()) {
            setting.getReadMode().setFirst(false);
            setting.save();
            toPage(LangSelect.class);
        } else {
            toPage(Menu.class);
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}
