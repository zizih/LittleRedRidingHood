package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page02 extends PageView implements GifMovieView.DispearCallback {

    private GifMovieView window;
    private GifMovieView mother;
    private GifMovieView red;
    private GifMovieView grand_start;
    private GifMovieView grand_loop;

    @SuppressWarnings("deprecation")
    public Page02(Context context) {
        super(context, R.layout.page02);
        //about layout
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_p02);
        layout.setBackgroundResource(bgSrc.setLang(setting.getLangId()).getPageDrawableId(1));

        //get View
        window = (GifMovieView) page.findViewById(R.id.gif_p02_window);
        mother = (GifMovieView) page.findViewById(R.id.gif_p02_mother);
        red = (GifMovieView) page.findViewById(R.id.gif_p02_red);

        //set Asset srouce
        mother.setMovieAsset(ctx.getString(R.string.p02_mother));
        window.setMovieAsset(ctx.getString(R.string.p02_window));
        red.setMovieAsset(ctx.getString(R.string.p02_red));
        window.setPaused(4240);

        //dynamic
        params = (AbsoluteLayout.LayoutParams) mother.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_mother_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_mother_y));
        mother.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) window.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_window_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_window_y));
        window.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p02_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p02_red_y));
        red.setLayoutParams(params);


        /**
         * about grand_start & grand_loop
         */
        grand_start = new GifMovieView(ctx);
        grand_start.setMovieAsset(ctx.getString(R.string.p02_grand_start));
        params = new AbsoluteLayout.LayoutParams(240, 214,
                (int) (getWidthScale() * getDimens(R.dimen.p02_grand_start_x)),
                (int) (getHeightScale() * getDimens(R.dimen.p02_grand_start_y)));
        grand_start.setLayoutParams(params);

        grand_loop = new GifMovieView(ctx);
        grand_loop.setMovieAsset(ctx.getString(R.string.p02_grand_loop));
        params = new AbsoluteLayout.LayoutParams(230, 200,
                (int) (getWidthScale() * getDimens(R.dimen.p02_grand_loop_x)),
                (int) (getHeightScale() * getDimens(R.dimen.p02_grand_loop_y)));
        grand_loop.setLayoutParams(params);
    }

    @Override
    public void dispear(View view) {
        view.setVisibility(GONE);
    }

    public GifMovieView getGrandStart() {
        grand_start.dispear(2080, this);
        grand_start.invalidate();
        return grand_start;
    }

    public GifMovieView getGrandLoop() {
        grand_loop.delay(2080);
        grand_loop.invalidate();
        return grand_loop;
    }

}
