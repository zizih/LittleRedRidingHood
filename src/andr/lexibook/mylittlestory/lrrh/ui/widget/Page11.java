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
public class Page11 extends PageView {

    private GifMovieView grand;
    private GifMovieView hunter;
    private GifMovieView red;
    private GifMovieView wolf;

    public Page11(Context context) {
        super(context, R.layout.page11);

        grand = (GifMovieView) page.findViewById(R.id.gif_p11_grand);
        red = (GifMovieView) page.findViewById(R.id.gif_p11_red);
        hunter = (GifMovieView) page.findViewById(R.id.gif_p11_hunter);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p11_wolf);

        grand.setMovieAsset(ctx.getString(R.string.p11_grand));
        hunter.setMovieAsset(ctx.getString(R.string.p11_hunter));
        red.setMovieAsset(ctx.getString(R.string.p11_red));
        wolf.setMovieAsset(ctx.getString(R.string.p11_wolf));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p11);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(10));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p11);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p11_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p11_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        grand.Clear();
        red.Clear();
        hunter.Clear();
        wolf.Clear();
    }
}
