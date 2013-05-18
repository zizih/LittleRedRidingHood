package andr.lexibook.mylittlestory.lrrh.ui.ViewIml;

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
    public AbsoluteLayout.LayoutParams params;

    public PageView(Context context, int layoutId) {
        super(context);
        this.ctx = (Activity) context;
        page = (AbsoluteLayout) ctx.getLayoutInflater().inflate(layoutId, null);
        params = (AbsoluteLayout.LayoutParams) page.getLayoutParams();
    }

    public AbsoluteLayout getLayout() {
        return page;
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
