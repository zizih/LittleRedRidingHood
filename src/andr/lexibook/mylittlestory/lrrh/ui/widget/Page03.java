package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page03 extends PageView {


    private GifMovieView red;
    private GifMovieView board;
    private GifMovieView wolf;

    public Page03(Context context) {
        super(context, R.layout.page03);
        red = (GifMovieView) page.findViewById(R.id.gif_p03_red);
        board = (GifMovieView) page.findViewById(R.id.gif_p03_board);
        wolf = (GifMovieView) page.findViewById(R.id.gif_p03_wolf);

        red.setMovieAsset(ctx.getString(R.string.p03_red));
        board.setMovieAsset(ctx.getString(R.string.p03_board));
        wolf.setMovieAsset(ctx.getString(R.string.p03_wolf));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p03);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(2));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p03);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p03_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p03_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        red.Clear();
        board.Clear();
        wolf.Clear();
    }
}
