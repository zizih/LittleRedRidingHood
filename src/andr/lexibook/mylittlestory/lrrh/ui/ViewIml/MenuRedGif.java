package andr.lexibook.mylittlestory.lrrh.ui.ViewIml;

import andr.lexibook.mylittlestory.lrrh.control.MediaFactory;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.util.AttributeSet;

import java.io.IOException;

/**
 * Created by rain on 6/2/13.
 */
public class MenuRedGif extends GifMovieView {

    private boolean isAutoPlayed = false;
    private boolean isSelfPlayed = false;
    private MediaFactory mediaFactory;
    private MediaPlayer autoPlayer;
    private MediaPlayer selfPlayer;

    public MenuRedGif(Context context) {
        super(context);
    }

    public MenuRedGif(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MenuRedGif(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void changLanguage() {
        releasePlay();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMovie != null) {
            if (!isAutoPlayed && mCurrentAnimationTime < 6600) {
                playAuto();
                isAutoPlayed = true;
                isSelfPlayed = false;
            }
            if (!isSelfPlayed && mCurrentAnimationTime > 6600) {
                playSelf();
                isAutoPlayed = false;
                isSelfPlayed = true;
            }
        }
        super.onDraw(canvas);
    }

    private void playAuto() {
        if (mediaFactory == null) {
            mediaFactory = MediaFactory.getInstance(getContext());
        }
        autoPlayer = mediaFactory.getMenuAuto();
        play(autoPlayer);
    }

    private void playSelf() {
        if (mediaFactory == null) {
            mediaFactory = MediaFactory.getInstance(getContext());
        }
        selfPlayer = mediaFactory.getMenuSelf();
        play(selfPlayer);
    }

    private void play(MediaPlayer player) {
        if (player.isPlaying())
            player.release();
        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void releasePlay() {
        if (autoPlayer != null && autoPlayer.isPlaying())
            autoPlayer.release();
        if (selfPlayer != null && selfPlayer.isPlaying())
            selfPlayer.release();
    }

}
