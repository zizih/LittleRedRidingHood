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
public class Page01 extends PageView {

    private GifMovieView red;
    private GifMovieView grand;

    public Page01(Context context) {
        super(context, R.layout.page01);
        red = (GifMovieView) page.findViewById(R.id.gif_p01_red);     //50,300
        grand = (GifMovieView) page.findViewById(R.id.gif_p01_grand); //200, 250

        red.setMovieAsset(context.getString(R.string.p01_red));
        grand.setMovieAsset(context.getString(R.string.p01_grand));

        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p01);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(0));

        if (setting.isAuto()) {
            pause = (AbsoluteLayout) page.findViewById(R.id.al_pause_p01);
            pause.setVisibility(VISIBLE);
            params = (AbsoluteLayout.LayoutParams) pause.getLayoutParams();
            params.x = (int) (getWidthScale() * getDimens(R.dimen.btn_play_pause_p01_x));
            params.y = (int) (getHeightScale() * getDimens(R.dimen.btn_play_pause_p01_y));
            params.width = (int) (getWidthScale() * 43);
            params.height = (int) (getWidthScale() * 43);
            pause.setLayoutParams(params);
        }
    }

    @Override
    public void Clear() {
        red.Clear();
        grand.Clear();
    }
}
