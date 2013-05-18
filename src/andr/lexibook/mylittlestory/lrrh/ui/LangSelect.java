package andr.lexibook.mylittlestory.lrrh.ui;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.GifMovieView;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;


/**
 * User: rain
 * Date: 4/16/13
 * Time: 7:44 PM
 */
@SuppressWarnings("deprecation")
public class LangSelect extends BaseActivity implements GifMovieView.DispearCallback, View.OnClickListener {

    private GifMovieView eng;
    private GifMovieView fra;
    private GifMovieView deu;
    private GifMovieView esp;
    private GifMovieView ita;
    private GifMovieView grand;
    private AbsoluteLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lang);

        //init
        eng = (GifMovieView) findViewById(R.id.gif_lang_eng);
        fra = (GifMovieView) findViewById(R.id.gif_lang_fra);
        deu = (GifMovieView) findViewById(R.id.gif_lang_deu);
        esp = (GifMovieView) findViewById(R.id.gif_lang_esp);
        ita = (GifMovieView) findViewById(R.id.gif_lang_ita);
        grand = (GifMovieView) findViewById(R.id.gif_lang_grand);

        eng.setMovieAsset(getString(R.string.lang_box));
        fra.setMovieAsset(getString(R.string.lang_box));
        deu.setMovieAsset(getString(R.string.lang_box));
        esp.setMovieAsset(getString(R.string.lang_box));
        ita.setMovieAsset(getString(R.string.lang_box));
        grand.setMovieAsset(getString(R.string.lang_grand));

        params = (AbsoluteLayout.LayoutParams) eng.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_eng_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_eng_y));
        eng.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) fra.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_fra_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_fra_y));
        fra.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) deu.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_deu_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_deu_y));
        deu.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) esp.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_esp_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_esp_y));
        esp.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) ita.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_ita_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_ita_y));
        ita.setLayoutParams(params);

        params = (AbsoluteLayout.LayoutParams) grand.getLayoutParams();
        params.x = (int) (getWidthScale() * getDimens(R.dimen.lang_grand_x));
        params.y = (int) (getHeightScale() * getDimens(R.dimen.lang_grand_y));
        grand.setLayoutParams(params);

        eng.dispear(3400, this);
        fra.delay(3000);
        fra.dispear(3000 + 3400, this);
        deu.delay(3000 * 2);
        deu.dispear(3000 * 2 + 3400, this);
        esp.delay(3000 * 3);
        esp.dispear(3000 * 3 + 3000, this);
        ita.delay(3000 * 4);
        ita.dispear(3000 * 4 + 3000, this);

        eng.setOnClickListener(this);
        fra.setOnClickListener(this);
        deu.setOnClickListener(this);
        esp.setOnClickListener(this);
        ita.setOnClickListener(this);

    }

    @Override
    public void dispear(View view) {
        view.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lang_english:
                pool.play(soundFactory.getEngSoundId(), 1, 1, 0, 0, 1);
                setLanguage(ENGLISH);
                break;
            case R.id.lang_franch:
                pool.play(soundFactory.getFraSoundId(), 1, 1, 0, 0, 1);
                setLanguage(FRANCH);
                break;
            case R.id.gif_lang_deu:
                pool.play(soundFactory.getDeuSoundId(), 1, 1, 0, 0, 1);
                setLanguage(EUTSCH);
                break;
            case R.id.lang_espanol:
                pool.play(soundFactory.getEspSoundId(), 1, 1, 0, 0, 1);
                setLanguage(ESPANOL);
                break;
            case R.id.lang_italiano:
                pool.play(soundFactory.getItaSoundId(), 1, 1, 0, 0, 1);
                setLanguage(ITALIANO);
                break;
        }
        toPage(Menu.class);
    }

}
