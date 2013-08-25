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
public class Page04 extends PageView {

    private GifMovieView wolf;
    private GifMovieView grand;
    private AbsoluteLayout al_extra_up;

    public Page04(Context context) {
        super(context, R.layout.page04);

        wolf = (GifMovieView) page.findViewById(R.id.gif_p04_wolf);
        grand = (GifMovieView) page.findViewById(R.id.gif_p04_grand);
        al_extra_up = (AbsoluteLayout) page.findViewById(R.id.al_extra_up);

        wolf.setMovieAsset(ctx.getString(R.string.p04_wolf));
        grand.setMovieAsset(ctx.getString(R.string.p04_grand));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) al_extra_up.getLayoutParams();
        params.width = (int) getWinWidth();
        params.height = (int) getWinHeight();
        al_extra_up.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p04);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(3));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p04);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p04_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p04_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        wolf.Clear();
        grand.Clear();
    }
}
