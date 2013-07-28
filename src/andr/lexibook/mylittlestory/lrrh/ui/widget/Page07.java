package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Page07 extends PageView {

    private GifMovieView window;
    private GifMovieView red;
    private GifMovieView wolf;

    public Page07(Context context) {
        super(context, R.layout.page07);
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p07);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(6));

        //get view
        window = (GifMovieView) page.findViewById(R.id.gif_p07_window);
        red = (GifMovieView) page.findViewById(R.id.gif_p07_red);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p07_wolf);
        window.setMovieAsset(ctx.getString(R.string.p07_window));
        red.setMovieAsset(ctx.getString(R.string.p07_red));
        wolf.setMovieAsset(ctx.getString(R.string.p07_wolf));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p07);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p07_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p07_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    public GifMovieView getWindow() {
        if (window.getParent() != null)
            ((AbsoluteLayout) window.getParent()).removeView(window);
        window.setPaused(4000);
        window.invalidate();
        return window;
    }

    @Override
    public void Clear() {
        window.Clear();
        red.Clear();
        wolf.Clear();
    }

}