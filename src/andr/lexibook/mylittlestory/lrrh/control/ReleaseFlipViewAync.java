package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;

/**
 * Created by rain on 6/7/13.
 */
public class ReleaseFlipViewAync extends BaseAysc {


    private FlipViewController flipView;

    public ReleaseFlipViewAync(FlipViewController flipView) {
        this.flipView = flipView;
    }

    @Override
    protected Class<?> doInBackground(Class<?>... classes) {
        return super.doInBackground(classes);
    }
}
