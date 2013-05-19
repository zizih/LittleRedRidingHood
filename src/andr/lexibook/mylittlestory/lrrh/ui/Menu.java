package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Menu extends BaseActivity implements View.OnLongClickListener, View.OnClickListener {

    private GifMovieView wolf;
    private GifMovieView red;
    private GifMovieView grand;
    private GifMovieView btn_read_self;
    private GifMovieView btn_read_auto;
    private AbsoluteLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

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
        params.x = (int) (getHeightScale() * getDimens(R.dimen.menu_wolf_y));
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
        btn_read_auto.setOnLongClickListener(this);
        btn_read_self.setOnLongClickListener(this);
    }


    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.gif_menu_read_auto:
                setReadMode(READ_AUTO);
                break;
            case R.id.gif_menu_read_self:
                setReadMode(READ_SELF);
                break;
            default:
                break;
        }
        io.save(readMode);
        readMode = io.get();
        toPage(Pages.class);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_menu_read_auto:
                pool.play(soundFactory.getMenuAutoId(1), 1, 1, 0, 0, 1);
                break;
            case R.id.gif_menu_read_self:
                pool.play(soundFactory.getMenuSelfId(1), 1, 1, 0, 0, 1);
                break;
            default:
                break;
        }
    }

}
