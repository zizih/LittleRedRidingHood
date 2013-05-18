package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.libs.FlipViewController;
import andr.lexibook.mylittlestory.lrrh.model.FlipAdapter;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * User: rain
 * Date: 4/23/13
 * Time: 8:05 PM
 */
public class Pages extends BaseActivity {

    private FlipViewController flipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
        flipView.setAdapter(new FlipAdapter(this));
        setContentView(flipView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.lang_english:
                setLanguage(ENGLISH);
                break;
            case R.id.lang_franch:
                setLanguage(FRANCH);
                break;
            case R.id.lang_eutsch:
                setLanguage(EUTSCH);
                break;
            case R.id.lang_espanol:
                setLanguage(ESPANOL);
                break;
            case R.id.lang_italiano:
                setLanguage(ITALIANO);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        flipView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        flipView.onPause();
    }

}


