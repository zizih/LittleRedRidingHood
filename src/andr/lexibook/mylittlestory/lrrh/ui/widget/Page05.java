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
public class Page05 extends PageView {

    private GifMovieView door;
    private GifMovieView grand_wolf;

    public Page05(Context context) {
        super(context, R.layout.page05);

        door = (GifMovieView) page.findViewById(R.id.gif_p05_door);
        grand_wolf = (GifMovieView) page.findViewById(R.id.gif_p05_grand_wolf);

        door.setMovieAsset(ctx.getString(R.string.p05_door));
        grand_wolf.setMovieAsset(ctx.getString(R.string.p05_grand_wolf));
//
//        params = (AbsoluteLayout.LayoutParams) door.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        door.setLayoutParams(params);
//
//        params = (AbsoluteLayout.LayoutParams) grand_wolf.getLayoutParams();
//        params.width = (int) getWinWidth();
//        params.height = (int) getWinHeight();
//        grand_wolf.setLayoutParams(params);

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p05);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(4));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p05);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p05_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p05_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }
}
