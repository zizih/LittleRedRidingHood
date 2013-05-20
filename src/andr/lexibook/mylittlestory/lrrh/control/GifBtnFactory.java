package andr.lexibook.mylittlestory.lrrh.control;

import android.app.Activity;
import android.content.Context;

/**
 * Created by rain on 5/20/13.
 */
public class GifBtnFactory {

    private Activity ctx;
    private GifBtnFactory instance;

    private GifBtnFactory(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    public GifBtnFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new GifBtnFactory(ctx);
        return instance;
    }

    private void loadEduAuto() {

    }


}
