package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.ui.widget.Page10;
import android.os.Bundle;

/**
 * Created by rain on 5/29/13.
 */
public class Test extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Page10(this).getLayout());
    }
}
