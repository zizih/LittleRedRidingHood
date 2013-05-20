package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgFactory;
import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;
import andr.lexibook.mylittlestory.lrrh.model.FlipAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class Pages extends BaseActivity {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private PageFactory pageFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageFactory = PageFactory.getInstance(this);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipView.setAdapter(new FlipAdapter(this));
        setContentView(flipView);

        flipView.setFlipByTouchEnabled(true);
        flipView.setOnViewFlipListener(new FlipViewController.ViewFlipListener() {
            @Override
            public void onViewFlipped(View view, int position) {

            }
        });

        if (setting.getReadMode().isAuto()) {
            flipView.setFlipByTouchEnabled(false);
            if (isFirst) {
                play(0);
                isFirst = false;
            }
            langCompleteListener = new LangListener();
            pageCompleteListener = new PageListener();
        }
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        if (setting.getReadMode().isAuto()) {
            mPlayer.release();
            langPlayer.setOnCompletionListener(langCompleteListener);
        }
    }

    private void play(int position) {
        switch (position) {
            case 0:
                mPlayer = factory.getPage01();
                break;
            case 1:
                mPlayer = factory.getPage02();
                break;
            case 2:
                mPlayer = factory.getPage03();
                break;
            case 3:
                mPlayer = factory.getPage04();
                break;
            case 4:
                mPlayer = factory.getPage05();
                break;
            case 5:
                mPlayer = factory.getPage06();
                break;
            case 6:
                mPlayer = factory.getPage07();
                break;
            case 7:
                mPlayer = factory.getPage08();
                break;
            case 8:
                mPlayer = factory.getPage09();
                break;
            case 9:
                mPlayer = factory.getPage10();
                break;
            case 10:
                mPlayer = factory.getPage11();
                break;
            case 11:
                mPlayer = factory.getPage12();
                break;
        }
        try {
            mPlayer.setOnCompletionListener(pageCompleteListener);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.position = position;
    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }

    class Fliplistener implements FlipViewController.ViewFlipListener {

        @Override
        public void onViewFlipped(View view, int position) {
            pageFactory.getPage(position).getLayoutView()
                    .setBackgroundDrawable(bgFactory.setLang(checkLangToId(setting.getLang()))
                            .getPageBg(position));
            if (setting.getReadMode().isAuto())
                play(position);
        }
    }

    class LangListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            play(position);
        }
    }

    class PageListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (position >= 0 && position < 12) {
                mPlayer.release();
                flipView.setSelection(++position);
                play(position);
            }
        }
    }
}


