package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
@SuppressWarnings("deprecation")
public class Page02 extends PageView implements GifMovieView.DispearCallback {

    private GifMovieView window;
    private GifMovieView mother;
    private GifMovieView red;
    private GifMovieView grand_start;
    private GifMovieView grand_loop;

    @SuppressWarnings("deprecation")
    public Page02(Context context) {
        super(context, R.layout.page02);
        setting.setP02New(true);
        //about layout
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(1));

        //get View
        window = (GifMovieView) page.findViewById(R.id.gif_p02_window);
        mother = (GifMovieView) page.findViewById(R.id.gif_p02_mother);
        red = (GifMovieView) page.findViewById(R.id.gif_p02_red);
        window.setMovieAsset(ctx.getString(R.string.p02_window));
        mother.setMovieAsset(ctx.getString(R.string.p02_mother));
        red.setMovieAsset(ctx.getString(R.string.p02_red));

        //dynamic
        params = (AbsoluteLayout.LayoutParams) window.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_window_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_window_y));
        window.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) mother.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_mother_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_mother_y));
        mother.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_red_y));
        red.setLayoutParams(params);


        /**
         * about grand_start & grand_loop
         */
        grand_start = new GifMovieView(ctx);
        grand_start.setMovieAsset(ctx.getString(R.string.p02_grand_start));
        params = new AbsoluteLayout.LayoutParams(
                (int) getDimens(R.dimen.p02_grand_start_width),
                (int) getDimens(R.dimen.p02_grand_start_height),
                (int) (getWidthScale() * getDimens(R.dimen.p02_grand_start_x)),
                (int) (getHeightScale() * getDimens(R.dimen.p02_grand_start_y)));
        grand_start.setLayoutParams(params);

        grand_loop = new GifMovieView(ctx);
        grand_loop.setMovieAsset(ctx.getString(R.string.p02_grand_loop));
        params = new AbsoluteLayout.LayoutParams(
                (int) getDimens(R.dimen.p02_grand_loop_width),
                (int) getDimens(R.dimen.p02_grand_loop_height),
                (int) (getWidthScale() * getDimens(R.dimen.p02_grand_loop_x)),
                (int) (getHeightScale() * getDimens(R.dimen.p02_grand_loop_y)));
        grand_loop.setLayoutParams(params);

    }

    @Override
    public void dispear(View view) {
        view.setVisibility(GONE);
    }

    public GifMovieView getGrandStart() {
        if (grand_start.getParent() != null)
            ((AbsoluteLayout) grand_start.getParent()).removeView(grand_start);
        grand_start.dispear(2080, this);
        grand_start.invalidate();
        return grand_start;
    }

    public GifMovieView getGrandLoop() {
        if (grand_loop.getParent() != null)
            ((AbsoluteLayout) grand_loop.getParent()).removeView(grand_loop);
        grand_loop.delay(2080);
        grand_loop.invalidate();
        return grand_loop;
    }

    public GifMovieView getWindow() {
        if (window.getParent() != null)
            ((AbsoluteLayout) window.getParent()).removeView(window);
        window.setPaused(4240);
        window.invalidate();
        return window;
    }

    public GifMovieView getMother() {
        if (mother.getParent() != null)
            ((AbsoluteLayout) mother.getParent()).removeView(mother);
        return mother;
    }

}
