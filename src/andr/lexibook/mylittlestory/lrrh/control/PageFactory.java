package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.widget.*;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

/**
 * User: rain
 * Date: 5/3/13
 * Time: 11:54 PM
 */
public class PageFactory {

    private Activity ctx;
    private static PageFactory instance;
    private Class<?>[] pages = {
            Page01.class,
            Page02.class,
            Page03.class,
            Page04.class,
            Page05.class,
            Page06.class,
            Page07.class,
            Page08.class,
            Page09.class,
            Page10.class,
            Page11.class,
            Page12.class
    };
    private Setting setting;
    private OOM oom;

    private PageFactory(Context ctx) {
        this.ctx = (Activity) ctx;
        setting = Setting.getInstance(ctx);
        oom = OOM.getInstance(ctx);
    }

    public static PageFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new PageFactory(ctx);
        return instance;
    }

    public PageView getPage(int position) {
        try {
            return (PageView) pages[position].getConstructors()[0].newInstance(ctx);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Toast.makeText(ctx, "Sorry, No Enought Memonry!", 1000).show();
        System.gc();
        setting.setOOM(true);
        return oom;
    }

    public int getCount() {
        return pages.length;
    }

}
