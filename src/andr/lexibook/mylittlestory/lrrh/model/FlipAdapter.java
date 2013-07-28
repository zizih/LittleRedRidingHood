package andr.lexibook.mylittlestory.lrrh.model;

import andr.lexibook.mylittlestory.lrrh.control.BgSrc;
import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.ui.ViewIml.PageView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FlipAdapter extends BaseAdapter {

    private Context ctx;
    private PageFactory pageFactory;

    public FlipAdapter(Context context) {
        this.ctx = context;
        pageFactory = PageFactory.getInstance(context);
    }

    @Override
    public int getCount() {
        return pageFactory.getCount();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PageView view = pageFactory.getPage(position);
        convertView = view == null ? null : view.getLayout();
        BgSrc.getInstance(ctx).Clear();
        return convertView;
    }
}