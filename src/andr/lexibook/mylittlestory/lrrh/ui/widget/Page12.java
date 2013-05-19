package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.Menu;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 4/22/13
 * Time: 8:23 PM
 */
public class Page12 extends PageView implements View.OnClickListener {

    private GifMovieView btn_menu;
    private GifMovieView btn_quit;
    private GifMovieView red;
    private Intent menuIntent;


    public Page12(Context context) {
        super(context, R.layout.page12);
        menuIntent = new Intent();
        menuIntent.setClass(context, Menu.class);

        red = (GifMovieView) page.findViewById(R.id.gif_p12_red);
        btn_menu = (GifMovieView) page.findViewById(R.id.gif_p12_btn_menu);
        btn_quit = (GifMovieView) page.findViewById(R.id.gif_p12_btn_quit);

        btn_menu.setMovieAsset(ctx.getString(R.string.p12_btn));
        btn_quit.setMovieAsset(ctx.getString(R.string.p12_btn));
        red.setMovieAsset(ctx.getString(R.string.p12_red));

        params = (AbsoluteLayout.LayoutParams) red.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_red_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_red_y));
        red.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_menu.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_btn_menu_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_btn_menu_y));
        btn_menu.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) btn_quit.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.p12_btn_quit_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.p12_btn_quit_y));
        btn_quit.setLayoutParams(params);

        btn_menu.setOnClickListener(this);
        btn_quit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gif_p12_btn_menu:
                ctx.startActivity(menuIntent);
                break;
            case R.id.gif_p12_btn_quit:
                System.exit(1);
                break;
        }
    }

}
