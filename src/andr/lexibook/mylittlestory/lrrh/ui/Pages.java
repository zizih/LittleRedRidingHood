package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BgSrc;
import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;
import andr.lexibook.mylittlestory.lrrh.model.FlipAdapter;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.widget.Page02;
import andr.lexibook.mylittlestory.lrrh.ui.widget.Page07;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
@SuppressWarnings("deprecation")
public class Pages extends BaseActivity implements PageFactory.Callback, FlipViewController.PlayPauseCallBack {

    private FlipViewController flipView;
    private boolean isFirst = true;
    private int position = 0;
    private Fliplistener flipListener;
    private MediaPlayer.OnCompletionListener langCompleteListener;
    private MediaPlayer.OnCompletionListener pageCompleteListener;
    private FlipAdapter flipAdapter;
    private PageFactory pageFactory;
    private GifMovieView p02_grand_start;
    private GifMovieView p02_grand_loop;
    private GifMovieView p02_window;
    private GifMovieView p02_mother;
    private GifMovieView p07_window;
    private Page02 p02;
    private Page07 p07;
    /**
     * there are a strange thing that p02 is true after call factory.get();
     */
    private int p07WindowIndex = -1;
    private int p02WindowIndex = -1;
    private int p02MotherIndex = -1;

    /**
     * add play & pause
     */
    protected Handler mHandler;
    protected TimerThread mTimerThead;
    protected boolean ifAllowFlip = false;
    protected int[] playPauseLocation;
    protected boolean isPaused = false;
    protected boolean isPlayed = false;

    private AbsoluteLayout ll_play;
    private AbsoluteLayout ll_pause;
    private AbsoluteLayout.LayoutParams params;
    private View preView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bgSrc = BgSrc.getInstance(this);
        pageFactory = PageFactory.getInstance(this);

        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipView.setPlayPauseCallBack(this);
        flipAdapter = new FlipAdapter(this);
        flipView.setAdapter(flipAdapter);
        flipAdapter.notifyDataSetChanged();
        setContentView(flipView);

//        setting.setAuto(false);
        flipListener = new Fliplistener();
        flipView.setFlipByTouchEnabled(true);
        flipView.setOnViewFlipListener(flipListener);

        if (setting.getReadMode().isAuto()) {
            langCompleteListener = new LangListener();
            pageCompleteListener = new PageListener();
//            flipView.setFlipByTouchEnabled(false);
            if (isFirst) {
                mPlayer = mediaFactory.getPage01();
                mPlayer.setOnCompletionListener(pageCompleteListener);
                try {
                    mPlayer.prepare();
                    mPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isFirst = false;
            }
        }
        pageFactory.setCallback(this);
        mHandler = new Handler();
        mTimerThead = new TimerThread();
        playPauseLocation = getResources().getIntArray(R.array.btn_play_pause);

        ll_play = new AbsoluteLayout(this);
        ll_pause = new AbsoluteLayout(this);
        ll_play.setBackgroundDrawable(getResources().getDrawable(R.drawable.play));
        ll_pause.setBackgroundDrawable(getResources().getDrawable(R.drawable.pause));
        params = new AbsoluteLayout.LayoutParams((int) getWinWidth(), (int) getWinHeight(), 0, 0);
        ll_play.setLayoutParams(params);
        ll_pause.setLayoutParams(params);
        ll_play.setAlpha(.20f);
        ll_pause.setAlpha(.12f);
    }

    @Override
    public void pauseOrPlay(View view, MotionEvent e) {
        preView = view;
        if ((e.getAction() == MotionEvent.ACTION_DOWN && checkLocation(e, playPauseLocation))) {// && checkLocation(e, playPauseLocation)
            if (ll_pause.getParent() != null)
                ((AbsoluteLayout) ll_pause.getParent()).removeView(ll_pause);
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
            if (isPaused) {
                ((AbsoluteLayout) view).addView(ll_pause);
                isPaused = false;
                if (isPlayed)
                    play(position);
            } else {
                ((AbsoluteLayout) view).addView(ll_play);
                isPaused = true;
            }
        }
    }


    @Override
    public void onFliped(View view) {
        if (preView != null) {
            if (ll_play.getParent() != null)
                ((AbsoluteLayout) ll_play.getParent()).removeView(ll_play);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mPlayer != null && mPlayer.isPlaying())
                mPlayer.release();
            toPage(Menu.class);
        }
        return false;
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        if (setting.getReadMode().isAuto()) {
            mPlayer.release();
            langPlayer.setOnCompletionListener(langCompleteListener);
        }
        if (langChanged) {
            pageFactory.getPage(this.position).getLayoutView().setBackgroundResource(bgSrc.setLang(langId).getPageDrawableId(this.position));
            flipAdapter.notifyDataSetChanged();
            flipView.flipToPageAgain();
            langChanged = false;
        }
    }

    private void play(int position) {
        this.position = position;
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            System.gc();
        }
        switch (position) {
            case 0:
                mPlayer = mediaFactory.getPage01();
                break;
            case 1:
                mPlayer = mediaFactory.getPage02();
                break;
            case 2:
                mPlayer = mediaFactory.getPage03();
                break;
            case 3:
                mPlayer = mediaFactory.getPage04();
                break;
            case 4:
                mPlayer = mediaFactory.getPage05();
                break;
            case 5:
                mPlayer = mediaFactory.getPage06();
                break;
            case 6:
                mPlayer = mediaFactory.getPage07();
                break;
            case 7:
                mPlayer = mediaFactory.getPage08();
                break;
            case 8:
                mPlayer = mediaFactory.getPage09();
                break;
            case 9:
                mPlayer = mediaFactory.getPage10();
                break;
            case 10:
                mPlayer = mediaFactory.getPage11();
                break;
            case 11:
                mPlayer = mediaFactory.getPage12();
                break;
        }
        try {
            mPlayer.setOnCompletionListener(pageCompleteListener);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPosition(int posit) {
        this.position = posit;
    }

    @Override
    public void autoFlip() {
        flipView.autoFlip();
        flipView.setFlipByTouchEnabled(true);
    }

    @Override
    public void diableFlip() {
        flipView.setFlipByTouchEnabled(false);
    }

    @SuppressWarnings("deprecation")
    class Fliplistener implements FlipViewController.ViewFlipListener {

        @Override
        public void onViewFlipped(View view, int position) {
            isPaused = false;
            isPlayed = false;
            mHandler.postDelayed(mTimerThead, 2000);
            flipView.setFlipByTouchEnabled(false);

            if (ll_pause.getParent() != null)
                ((AbsoluteLayout) ll_pause.getParent()).removeView(ll_pause);
            ((AbsoluteLayout) view).addView(ll_pause);

            setPosition(position);
            if (setting.getReadMode().isAuto() && !langChanged)
                play(position);
            /**
             * do with abnormal gif of page02
             */
            for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                System.out.println(position + " View " + i + "  " + ((AbsoluteLayout) view).getChildAt(i).getId());
            }

            if (position == 1) {
                p02 = (Page02) pageFactory.getPage(position);
                p02_grand_start = p02.getGrandStart();
                p02_grand_loop = p02.getGrandLoop();
                p02_window = p02.getWindow();
                p02_mother = p02.getMother();
                p02WindowIndex = -1;
                p02MotherIndex = -1;
                for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p02_window.getId())
                        p02WindowIndex = i;
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p02_mother.getId())
                        p02MotherIndex = i;
                }
                ((AbsoluteLayout) view).addView(p02_grand_start);
                ((AbsoluteLayout) view).addView(p02_grand_loop);
                ((AbsoluteLayout) view).addView(p02_window);
                ((AbsoluteLayout) view).addView(p02_mother);
                if (p02MotherIndex != -1) {
                    ((AbsoluteLayout) view).removeViewAt(p02WindowIndex);
                    if (p02MotherIndex > p02WindowIndex)
                        p02MotherIndex--;
                    ((AbsoluteLayout) view).removeViewAt(p02MotherIndex);
                }
                p02 = null;
                p02_window = null;
                p02_mother = null;
                p02_grand_loop = null;
                p02_grand_start = null;
                System.gc();
            }
            /**
             * do with abnormal gif of page07
             */
            if (position == 6) {
                p07 = (Page07) pageFactory.getPage(position);
                p07_window = p07.getWindow();
                p07WindowIndex = -1;
                for (int i = 0; i < ((AbsoluteLayout) view).getChildCount(); i++) {
                    if (((AbsoluteLayout) view).getChildAt(i).getId() == p07_window.getId())
                        p07WindowIndex = i;
                }
                ((AbsoluteLayout) view).addView(p07_window);
                if (p07WindowIndex != -1) {
                    ((AbsoluteLayout) view).removeViewAt(p07WindowIndex);
                }
                p07 = null;
                p07_window = null;
                System.gc();
            }
        }
    }


    class TimerThread implements Runnable {

        @Override
        public void run() {
            (Pages.this).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    timer();
                }
            });
        }

    }


    protected void timer() {
        if (!ifAllowFlip) {
            flipView.setFlipByTouchEnabled(true);
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
            isPlayed = true;
            if (!isPaused && position >= 0 && position < 11 && !setting.isOOM()) {
                flipView.autoFlip();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Pages OnResume ");
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pages OnPause ");
        flipView.onPause();
    }

    @Override
    protected void onDestroy() {
        flipView = null;
        mPlayer = null;
        System.out.println("Pages OnDestroy ");
        super.onDestroy();
    }

}


