package andr.lexibook.mylittlestory.lrrh.ui.ViewIml;

import andr.lexibook.mylittlestory.lrrh.control.BgFactory;
import andr.lexibook.mylittlestory.lrrh.control.Setting;
import andr.lexibook.mylittlestory.lrrh.model.ReadMode;
import andr.lexibook.mylittlestory.lrrh.util.ViewUtil;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;

/**
 * User: rain
 * Date: 5/1/13
 * Time: 12:11 PM
 */
@SuppressWarnings("deprecation")
public class PageView extends View {

    protected static Activity ctx;
    public AbsoluteLayout page;
    public AbsoluteLayout layout;
    public AbsoluteLayout.LayoutParams params;
    public BgFactory bgFactory;
    public Setting setting;

    public PageView(Context context, int layoutId) {
        super(context);
        this.ctx = (Activity) context;
        page = (AbsoluteLayout) ctx.getLayoutInflater().inflate(layoutId, null);
        params = (AbsoluteLayout.LayoutParams) page.getLayoutParams();
        bgFactory = BgFactory.getInstance(ctx);
        setting = Setting.getInstance();
    }

    public AbsoluteLayout getLayout() {
        return page;
    }

    public AbsoluteLayout getLayoutView() {
        return layout;
    }

    public float getDimens(int dimensId) {
        return ctx.getResources().getDimension(dimensId);
    }

    public float getWidthScale() {
        return ViewUtil.getInstance(ctx).getWidthScale();
    }

    public float getHeightScale() {
        return ViewUtil.getInstance(ctx).getHeightScale();
    }

}
