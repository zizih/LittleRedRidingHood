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
public class Page08 extends PageView {

    private GifMovieView basket;
    private GifMovieView red;
    private GifMovieView wolf;
    private GifMovieView hat;

    public Page08(Context context) {
        super(context, R.layout.page08);

        basket = (GifMovieView) page.findViewById(R.id.gif_p08_basket);
        red = (GifMovieView) page.findViewById(R.id.gif_p08_red);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p08_wolf);
        hat = (GifMovieView) page.findViewById(R.id.gif_p08_hat);

        basket.setMovieAsset(ctx.getString(R.string.p08_basket));
        red.setMovieAsset(ctx.getString(R.string.p08_red));
        wolf.setMovieAsset(ctx.getString(R.string.p08_wolf));
        hat.setMovieAsset(ctx.getString(R.string.p08_hat));

//        params = (AbsoluteLayout.LayoutParams) basket.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        basket.setLayoutParams(params);
//
//        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        red.setLayoutParams(params);
//
//        params = (AbsoluteLayout.LayoutParams) wolf.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        wolf.setLayoutParams(params);
//
//        params = (AbsoluteLayout.LayoutParams) hat.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        hat.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.ll_p08_bg_cover);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(7));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p08);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p08_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p08_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }
}
