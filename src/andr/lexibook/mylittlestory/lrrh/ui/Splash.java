package andr.lexibook.mylittlestory.lrrh.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author hezi
 */
public class Splash extends BaseActivity implements View.OnTouchListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        int soundId = soundFactory.getSplashSoundId(1);
        int tmpId = pool.play(soundId, 1, 1, 0, 0, 1);
        System.out.println(" TmpId:  " + tmpId + " soundId: " + soundId);

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
//        if (readMode.isFirst()) {
//            readMode.setFirst(false);
//            io.save(readMode);
//            toPage(LangSelect.class);
//        } else {
//            toPage(Menu.class);
//        }
        toPage(LangSelect.class);
        finish();
    }
}
