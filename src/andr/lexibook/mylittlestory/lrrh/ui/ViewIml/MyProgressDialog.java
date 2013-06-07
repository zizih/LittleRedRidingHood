package andr.lexibook.mylittlestory.lrrh.ui.ViewIml;

import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.control.Setting;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by rain on 6/6/13.
 */
public class MyProgressDialog extends ProgressDialog {

    private Handler mHandler;
    private PageFactory pageFactory;
    private Setting setting;

    public MyProgressDialog(Context context) {
        super(context);
        pageFactory = PageFactory.getInstance(context);
        setting = Setting.getInstance(context);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("B OnShow...");
        try {
            Looper.getMainLooper();
            mHandler = new SynHandler();
            Looper.loop();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        System.out.println("A OnShow...");
    }

    @Override
    protected void onStop() {
        System.out.println("B OnStop...");
        mHandler.sendEmptyMessage(0);
        System.out.println("A OnStop...");
        super.onStop();
    }

    @Override
    public void incrementProgressBy(int diff) {
        super.incrementProgressBy(diff);
    }

    class SynHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            throw new RuntimeException();
        }
    }
}
