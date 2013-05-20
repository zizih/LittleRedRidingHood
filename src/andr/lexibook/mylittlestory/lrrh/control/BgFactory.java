package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by rain on 5/20/13.
 */
public class BgFactory {

    private Activity ctx;
    private static BgFactory instance;

    private Drawable splash;
    private Drawable menu;
    private Drawable p01;
    private Drawable p02;
    private Drawable p03;
    private Drawable p04;
    private Drawable p05;
    private Drawable p06;
    private Drawable p07;
    private Drawable p08;
    private Drawable p09;
    private Drawable p10;
    private Drawable p11;
    private Drawable p12;

    private int langId;

    private final int ENGLISH = 1;
    private final int FRANCH = 2;
    private final int EUTSCH = 3;
    private final int ESPANOL = 4;
    private final int ITALIANO = 5;

    private BgFactory(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    public static BgFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new BgFactory(ctx);
        return instance;
    }

    public BgFactory setLang(int langId) {
        this.langId = langId;
        return this;
    }

    public Drawable getPageBg(int position) {
        switch (position) {
            case 0:
                return getP01();
            case 1:
                return getP02();
            case 2:
                return getP03();
            case 3:
                return getP04();
            case 4:
                return getP05();
            case 5:
                return getP06();
            case 6:
                return getP07();
            case 7:
                return getP08();
            case 8:
                return getP09();
            case 9:
                return getP10();
            case 10:
                return getP11();
            case 11:
                return getP12();
            default:
                return null;
        }
    }

    public Drawable getSplash() {
        switch (this.langId) {
            case ENGLISH:
                splash = getDrawable(R.drawable.eng_splash);
                break;
            case FRANCH:
                splash = getDrawable(R.drawable.fra_splash);
                break;
            case EUTSCH:
                splash = getDrawable(R.drawable.deu_splash);
                break;
            case ESPANOL:
                splash = getDrawable(R.drawable.esp_splash);
                break;
            case ITALIANO:
                splash = getDrawable(R.drawable.ita_splash);
                break;
        }
        return splash;
    }

    public Drawable getMenu() {
        switch (this.langId) {
            case ENGLISH:
                menu = getDrawable(R.drawable.eng_menu_bkg);
                break;
            case FRANCH:
                menu = getDrawable(R.drawable.fra_menu_bkg);
                break;
            case EUTSCH:
                menu = getDrawable(R.drawable.deu_menu_bkg);
                break;
            case ESPANOL:
                menu = getDrawable(R.drawable.esp_menu_bkg);
                break;
            case ITALIANO:
                menu = getDrawable(R.drawable.ita_menu_bkg);
                break;
        }
        return menu;
    }

    public Drawable getP01() {
        switch (this.langId) {
            case ENGLISH:
                p01 = getDrawable(R.drawable.eng_p01_bkg);
                break;
            case FRANCH:
                p01 = getDrawable(R.drawable.fra_p01_bkg);
                break;
            case EUTSCH:
                p01 = getDrawable(R.drawable.deu_p01_bkg);
                break;
            case ESPANOL:
                p01 = getDrawable(R.drawable.esp_p01_bkg);
                break;
            case ITALIANO:
                p01 = getDrawable(R.drawable.ita_p01_bkg);
                break;
        }
        return p01;
    }

    public Drawable getP02() {
        switch (this.langId) {
            case ENGLISH:
                p02 = getDrawable(R.drawable.eng_p02_bkg);
                break;
            case FRANCH:
                p02 = getDrawable(R.drawable.fra_p02_bkg);
                break;
            case EUTSCH:
                p02 = getDrawable(R.drawable.deu_p02_bkg);
                break;
            case ESPANOL:
                p02 = getDrawable(R.drawable.esp_p02_bkg);
                break;
            case ITALIANO:
                p02 = getDrawable(R.drawable.ita_p02_bkg);
                break;
        }
        return p02;
    }

    public Drawable getP03() {
        switch (this.langId) {
            case ENGLISH:
                p03 = getDrawable(R.drawable.eng_p03_bkg);
                break;
            case FRANCH:
                p03 = getDrawable(R.drawable.fra_p03_bkg);
                break;
            case EUTSCH:
                p03 = getDrawable(R.drawable.deu_p03_bkg);
                break;
            case ESPANOL:
                p03 = getDrawable(R.drawable.esp_p03_bkg);
                break;
            case ITALIANO:
                p03 = getDrawable(R.drawable.ita_p03_bkg);
                break;
        }
        return p03;
    }

    public Drawable getP04() {
        switch (this.langId) {
            case ENGLISH:
                p04 = getDrawable(R.drawable.eng_p04_bkg);
                break;
            case FRANCH:
                p04 = getDrawable(R.drawable.fra_p04_bkg);
                break;
            case EUTSCH:
                p04 = getDrawable(R.drawable.deu_p04_bkg);
                break;
            case ESPANOL:
                p04 = getDrawable(R.drawable.esp_p04_bkg);
                break;
            case ITALIANO:
                p04 = getDrawable(R.drawable.ita_p04_bkg);
                break;
        }
        return p04;
    }

    public Drawable getP05() {
        switch (this.langId) {
            case ENGLISH:
                p05 = getDrawable(R.drawable.eng_p05_bkg);
                break;
            case FRANCH:
                p05 = getDrawable(R.drawable.fra_p05_bkg);
                break;
            case EUTSCH:
                p05 = getDrawable(R.drawable.deu_p05_bkg);
                break;
            case ESPANOL:
                p05 = getDrawable(R.drawable.esp_p05_bkg);
                break;
            case ITALIANO:
                p05 = getDrawable(R.drawable.ita_p05_bkg);
                break;
        }
        return p05;
    }

    public Drawable getP06() {
        switch (this.langId) {
            case ENGLISH:
                p06 = getDrawable(R.drawable.eng_p06_bkg);
                break;
            case FRANCH:
                p06 = getDrawable(R.drawable.fra_p06_bkg);
                break;
            case EUTSCH:
                p06 = getDrawable(R.drawable.deu_p06_bkg);
                break;
            case ESPANOL:
                p06 = getDrawable(R.drawable.esp_p06_bkg);
                break;
            case ITALIANO:
                p06 = getDrawable(R.drawable.ita_p06_bkg);
                break;
        }
        return p06;
    }

    public Drawable getP07() {
        switch (this.langId) {
            case ENGLISH:
                p07 = getDrawable(R.drawable.eng_p07_bkg);
                break;
            case FRANCH:
                p07 = getDrawable(R.drawable.fra_p07_bkg);
                break;
            case EUTSCH:
                p07 = getDrawable(R.drawable.deu_p07_bkg);
                break;
            case ESPANOL:
                p07 = getDrawable(R.drawable.esp_p07_bkg);
                break;
            case ITALIANO:
                p07 = getDrawable(R.drawable.ita_p07_bkg);
                break;
        }
        return p07;
    }

    public Drawable getP08() {
        switch (this.langId) {
            case ENGLISH:
                p08 = getDrawable(R.drawable.eng_p08_bkg);
                break;
            case FRANCH:
                p08 = getDrawable(R.drawable.fra_p08_bkg);
                break;
            case EUTSCH:
                p08 = getDrawable(R.drawable.deu_p08_bkg);
                break;
            case ESPANOL:
                p08 = getDrawable(R.drawable.esp_p08_bkg);
                break;
            case ITALIANO:
                p08 = getDrawable(R.drawable.ita_p08_bkg);
                break;
        }
        return p08;
    }

    public Drawable getP09() {
        switch (this.langId) {
            case ENGLISH:
                p09 = getDrawable(R.drawable.eng_p09_bkg);
                break;
            case FRANCH:
                p09 = getDrawable(R.drawable.fra_p09_bkg);
                break;
            case EUTSCH:
                p09 = getDrawable(R.drawable.deu_p09_bkg);
                break;
            case ESPANOL:
                p09 = getDrawable(R.drawable.esp_p09_bkg);
                break;
            case ITALIANO:
                p09 = getDrawable(R.drawable.ita_p09_bkg);
                break;
        }
        return p09;
    }

    public Drawable getP10() {
        switch (this.langId) {
            case ENGLISH:
                p10 = getDrawable(R.drawable.eng_p10_bkg);
                break;
            case FRANCH:
                p10 = getDrawable(R.drawable.fra_p10_bkg);
                break;
            case EUTSCH:
                p10 = getDrawable(R.drawable.deu_p10_bkg);
                break;
            case ESPANOL:
                p10 = getDrawable(R.drawable.esp_p10_bkg);
                break;
            case ITALIANO:
                p10 = getDrawable(R.drawable.ita_p10_bkg);
                break;
        }
        return p10;
    }

    public Drawable getP11() {
        switch (this.langId) {
            case ENGLISH:
                p11 = getDrawable(R.drawable.eng_p11_bkg);
                break;
            case FRANCH:
                p11 = getDrawable(R.drawable.fra_p11_bkg);
                break;
            case EUTSCH:
                p11 = getDrawable(R.drawable.deu_p11_bkg);
                break;
            case ESPANOL:
                p11 = getDrawable(R.drawable.esp_p11_bkg);
                break;
            case ITALIANO:
                p11 = getDrawable(R.drawable.ita_p11_bkg);
                break;
        }
        return p11;
    }

    public Drawable getP12() {
        switch (this.langId) {
            case ENGLISH:
                p12 = getDrawable(R.drawable.eng_p12_bkg);
                break;
            case FRANCH:
                p12 = getDrawable(R.drawable.fra_p12_bkg);
                break;
            case EUTSCH:
                p12 = getDrawable(R.drawable.deu_p12_bkg);
                break;
            case ESPANOL:
                p12 = getDrawable(R.drawable.esp_p12_bkg);
                break;
            case ITALIANO:
                p12 = getDrawable(R.drawable.ita_p12_bkg);
                break;
        }
        return p12;
    }

    private Drawable getDrawable(int dId) {
        return ctx.getResources().getDrawable(dId);
    }
}
