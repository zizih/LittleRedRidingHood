package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.control.BtnGifSrc;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.MenuRedGif;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnClickListener {

    private GifMovieView wolf;
    private MenuRedGif red;
    private GifMovieView grand;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;
    private AbsoluteLayout.LayoutParams params;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        btnSrc = BtnGifSrc.getInstance(this);

        //init
        wolf = (GifMovieView) findViewById(R.id.gif_menu_wolf);
        red = (MenuRedGif) findViewById(R.id.gif_menu_red);
        grand = (GifMovieView) findViewById(R.id.gif_menu_grand);
        btn_read_auto = (GifMovieView) findViewById(R.id.gif_menu_read_auto);
        btn_read_self = (GifMovieView) findViewById(R.id.gif_menu_read_self);

        wolf.setMovieAsset(getString(R.string.menu_wolf));
        red.setMovieAsset(getString(R.string.menu_red));
        grand.setMovieAsset(getString(R.string.menu_grand));
        btn_read_auto.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(setting.getLangId()).getMenuSelf());

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

        //
        red.setMenuCallBack(this);
        setMenuView(findViewById(R.id.any_widget_4_menu));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
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
        red.releasePlay();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toPage(Pages.class);
                onDestroy();
            }
        }, 2000);
    }

    @Override
    public void setLanguage(int langId) {
        super.setLanguage(langId);
        /**
         *  here need to change menu button suitted language
         */
        btn_read_auto.setMovieAsset(btnSrc.setLang(langId).getMenuAuto());
        btn_read_self.setMovieAsset(btnSrc.setLang(langId).getMenuSelf());
        /**
         * set player
         */
        red.changLanguage();
    }

    @Override
    protected void onDestroy() {
        wolf = null;
        red = null;
        grand = null;
        btn_read_self = null;
        btn_read_auto = null;
        super.onDestroy();
    }

}
