package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * Created by rain on 5/20/13.
 */
public class BgFactory {

    private Activity ctx;
    private static BgFactory instance;

    private WeakHashMap<String, WeakReference<Drawable>> drawables;

    private int langId;

    private final int ENGLISH = 1;
    private final int FRANCH = 2;
    private final int EUTSCH = 3;
    private final int ESPANOL = 4;
    private final int ITALIANO = 5;

    private int[] splashs = {R.drawable.eng_splash
            , R.drawable.fra_splash
            , R.drawable.deu_splash
            , R.drawable.esp_splash
            , R.drawable.ita_splash};
    private int[] menus = {R.drawable.eng_menu_bkg
            , R.drawable.fra_menu_bkg
            , R.drawable.deu_menu_bkg
            , R.drawable.esp_menu_bkg
            , R.drawable.ita_menu_bkg};
    private int[] p01s = {R.drawable.eng_p01_bkg
            , R.drawable.fra_p01_bkg
            , R.drawable.deu_p01_bkg
            , R.drawable.esp_p01_bkg
            , R.drawable.ita_p01_bkg};
    private int[] p02s = {R.drawable.eng_p02_bkg
            , R.drawable.fra_p02_bkg
            , R.drawable.deu_p02_bkg
            , R.drawable.esp_p02_bkg
            , R.drawable.ita_p02_bkg};
    private int[] p03s = {R.drawable.eng_p03_bkg
            , R.drawable.fra_p03_bkg
            , R.drawable.deu_p03_bkg
            , R.drawable.esp_p03_bkg
            , R.drawable.ita_p03_bkg};
    private int[] p04s = {R.drawable.eng_p04_bkg
            , R.drawable.fra_p04_bkg
            , R.drawable.deu_p04_bkg
            , R.drawable.esp_p04_bkg
            , R.drawable.ita_p04_bkg};
    private int[] p05s = {R.drawable.eng_p05_bkg
            , R.drawable.fra_p05_bkg
            , R.drawable.deu_p05_bkg
            , R.drawable.esp_p05_bkg
            , R.drawable.ita_p05_bkg};
    private int[] p06s = {R.drawable.eng_p06_bkg
            , R.drawable.fra_p06_bkg
            , R.drawable.deu_p06_bkg
            , R.drawable.esp_p06_bkg
            , R.drawable.ita_p06_bkg};
    private int[] p07s = {R.drawable.eng_p07_bkg
            , R.drawable.fra_p07_bkg
            , R.drawable.deu_p07_bkg
            , R.drawable.esp_p07_bkg
            , R.drawable.ita_p07_bkg};
    private int[] p08s = {R.drawable.eng_p08_bkg
            , R.drawable.fra_p08_bkg
            , R.drawable.deu_p08_bkg
            , R.drawable.esp_p08_bkg
            , R.drawable.ita_p08_bkg};
    private int[] p09s = {R.drawable.eng_p09_bkg
            , R.drawable.fra_p09_bkg
            , R.drawable.deu_p09_bkg
            , R.drawable.esp_p09_bkg
            , R.drawable.ita_p09_bkg};
    private int[] p10s = {R.drawable.eng_p10_bkg
            , R.drawable.fra_p10_bkg
            , R.drawable.deu_p10_bkg
            , R.drawable.esp_p10_bkg
            , R.drawable.ita_p10_bkg};
    private int[] p11s = {R.drawable.eng_p11_bkg
            , R.drawable.fra_p11_bkg
            , R.drawable.deu_p11_bkg
            , R.drawable.esp_p11_bkg
            , R.drawable.ita_p11_bkg};
    private int[] p12s = {R.drawable.eng_p12_bkg
            , R.drawable.fra_p12_bkg
            , R.drawable.deu_p12_bkg
            , R.drawable.esp_p12_bkg
            , R.drawable.ita_p12_bkg};

    private String[] pagesNameSpace = {"page01"
            , "page02"
            , "page03"
            , "page04"
            , "page05"
            , "page06"
            , "page07"
            , "page08"
            , "page09"
            , "page10"
            , "page11"
            , "page12"
    };
    private int[][] pagesDrawablesId = {p01s
            , p02s
            , p03s
            , p04s
            , p05s
            , p06s
            , p07s
            , p08s
            , p09s
            , p10s
            , p11s
            , p12s
    };

    private BgFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        this.drawables = new WeakHashMap<String, WeakReference<Drawable>>();
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
        return getDrawable("splash", this.langId, splashs);
    }

    public Drawable getMenu() {
        return getDrawable("menu", this.langId, menus);
    }

    public Drawable getP01() {
        return getPage(0);
    }

    public Drawable getP02() {
        return getPage(1);
    }

    public Drawable getP03() {
        return getPage(2);
    }

    public Drawable getP04() {
        return getPage(3);
    }

    public Drawable getP05() {
        return getPage(4);
    }

    public Drawable getP06() {
        return getPage(5);
    }

    public Drawable getP07() {
        return getPage(6);
    }

    public Drawable getP08() {
        return getPage(7);
    }

    public Drawable getP09() {
        return getPage(8);
    }

    public Drawable getP10() {
        return getPage(9);
    }

    public Drawable getP11() {
        return getPage(10);
    }

    public Drawable getP12() {
        return getPage(11);
    }

    //private function at level 3
    private Drawable getPage(int pageId) {
        return getDrawable(pagesNameSpace[langId], langId, pagesDrawablesId[pageId]);
    }

    //private function at level 2
    private Drawable getDrawable(String namespace, int langId, int[] drawableIds) {
        if (!drawables.containsKey(namespace + langId) || drawables.get(namespace + langId) == null)
            drawables.put(namespace + langId, new WeakReference<Drawable>(getDrawable(drawableIds[langId])));
        return drawables.get(namespace + langId).get();
    }

    //private function at level 1
    private Drawable getDrawable(int dId) {
        return ctx.getResources().getDrawable(dId);
    }
}
