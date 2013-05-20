package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;

import java.io.IOException;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnClickListener {

    private GifMovieView wolf;
    private GifMovieView red;
    private GifMovieView grand;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;
    private AbsoluteLayout.LayoutParams params;
    private AbsoluteLayout page;

    private MediaPlayer autoPlayer;
    private MediaPlayer selfPlayer;
    private AutoCompleteListener autoListener;
    private SelfCompleteListener selfListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        page = (AbsoluteLayout) findViewById(R.id.layout_menu);
        refreshBg();

        //init
        wolf = (GifMovieView) findViewById(R.id.gif_menu_wolf);
        red = (GifMovieView) findViewById(R.id.gif_menu_red);
        grand = (GifMovieView) findViewById(R.id.gif_menu_grand);
        btn_read_auto = (GifMovieView) findViewById(R.id.gif_menu_read_auto);
        btn_read_self = (GifMovieView) findViewById(R.id.gif_menu_read_self);

        wolf.setMovieAsset(getString(R.string.menu_wolf));
        red.setMovieAsset(getString(R.string.menu_red));
        grand.setMovieAsset(getString(R.string.menu_grand));
        btn_read_auto.setMovieAsset(getString(R.string.menu_read_auto));
        btn_read_self.setMovieAsset(getString(R.string.menu_read_self));

        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_wolf_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_wolf_y));
        wolf.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_grand_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_grand_y));
        grand.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_read_auto.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_auto_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_auto_y));
        btn_read_auto.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_read_self.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.menu_read_self_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.menu_read_self_y));
        btn_read_self.setLayoutParams(params);


        //set listener
        btn_read_auto.setOnClickListener(this);
        btn_read_self.setOnClickListener(this);
        autoListener = new AutoCompleteListener();
        selfListener = new SelfCompleteListener();

        //
        playAuto();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_menu_read_auto:
                setReadMode(true);
                break;
            case R.id.gif_menu_read_self:
                setReadMode(false);
                break;
            default:
                break;
        }
        releasePlaying();
        toPage(Pages.class);
    }

    private void releasePlaying() {
        if (autoPlayer != null)
            autoPlayer.release();
        if (selfPlayer != null)
            selfPlayer.release();
    }

    class AutoCompleteListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            playSelf();
        }
    }

    class SelfCompleteListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            playAuto();
        }
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        refreshBg();
    }

    private void refreshBg() {
        this.page.setBackgroundDrawable(bgFactory.setLang(checkLangToId(setting.getLang())).getMenu());
    }

    private void playAuto() {
        autoPlayer = factory.getMenuAuto();
        autoPlayer.setOnCompletionListener(autoListener);
        play(autoPlayer);
    }

    private void playSelf() {
        selfPlayer = factory.getMenuSelf();
        selfPlayer.setOnCompletionListener(selfListener);
        play(selfPlayer);
    }

    private void play(MediaPlayer player) {
        try {
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlaying();
    }
}
