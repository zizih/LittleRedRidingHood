package andr.lexibook.mylittlestory.lrrh.ui.widget;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.widget.AbsoluteLayout;

/**
 * Created by rain on 6/4/13.
 */
public class OOM extends PageView {

    private static OOM instance;

    public static OOM getInstance(Context ctx) {
        if (instance == null)
            instance = new OOM(ctx);
        return instance;
    }

    public OOM(Context context) {
        super(context, R.layout.oom);
        layout = (AbsoluteLayout) page.findViewById(R.id.layout_oom);
    }

    public void refreshBg(int position) {
        layout.setBackgroundDrawable(bgSrc.setLang(setting.getLangId()).getPageDrawable(position));
        bgSrc.Clear();
    }

}
