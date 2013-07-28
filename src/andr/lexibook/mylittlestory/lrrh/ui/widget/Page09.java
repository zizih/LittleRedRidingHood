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
public class Page09 extends PageView {

    private GifMovieView basket;
    private GifMovieView hunter;
    private GifMovieView wolf;

    public Page09(Context context) {
        super(context, R.layout.page09);

        basket = (GifMovieView) page.findViewById(R.id.gif_p09_basket);
        hunter = (GifMovieView) page.findViewById(R.id.gif_p09_hunter);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p09_wolf);

        basket.setMovieAsset(ctx.getString(R.string.p09_basket));
        hunter.setMovieAsset(ctx.getString(R.string.p09_hunter));
        wolf.setMovieAsset(ctx.getString(R.string.p09_wolf));

        params = (AbsoluteLayout.LayoutParams) basket.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p09_basket_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p09_basket_y));
        basket.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p09);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(8));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p09);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p09_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p09_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        basket.Clear();
        wolf.Clear();
        hunter.Clear();
    }
}
