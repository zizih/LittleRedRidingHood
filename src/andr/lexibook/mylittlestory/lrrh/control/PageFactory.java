package andr.lexibook.mylittlestory.lrrh.control;

import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.MyProgressDialog;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import andr.lexibook.mylittlestory.lrrh.ui.widget.*;
import android.app.Activity;
import android.content.Context;

import java.lang.reflect.InvocationTargetException;

/**
 * User: rain
 * Date: 5/3/13
 * Time: 11:54 PM
 */
public class PageFactory {

    private Activity ctx;
    private static PageFactory instance;
    private PageView pageView;
    private int pageIndex;
    private Class[] clzz = {
            Page01.class
            , Page02.class
            , Page03.class
            , Page04.class
            , Page05.class
            , Page06.class
            , Page07.class
            , Page08.class
            , Page09.class
            , Page10.class
            , Page11.class
            , Page12.class
    };

    private PageFactory(Context ctx) {
        this.ctx = (Activity) ctx;
    }

    public static PageFactory getInstance(Context ctx) {
        if (instance == null)
            instance = new PageFactory(ctx);
        return instance;
    }

    public PageView getPage(int position) {
        if (position != position) {
            pageIndex = position;
            pageView.Clear();
        }
        try {
            pageView = (PageView) clzz[position].getConstructors()[0].newInstance(ctx);
        } catch (InstantiationException e) {
            e.printStackTrace();
            reloadPage();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return pageView;
    }

    public int getCount() {
        return clzz.length;
    }

    private void reloadPage() {
        Setting.getInstance(ctx).setOOM(true);
        callback.diableFlip();

        //dialog
        MyProgressDialog dialog = new MyProgressDialog(ctx, pageIndex);
        dialog.setMessage("loading...");
        dialog.show();

        //after
        Setting.getInstance(ctx).setOOM(false);
        callback.autoFlip();
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    private Callback callback;

    public interface Callback {
        public void autoFlip();

        public void diableFlip();

    }

}