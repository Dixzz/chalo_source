package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import java.util.List;

/* renamed from: xi0  reason: default package */
/* compiled from: DirectionFilterAdapter */
public class xi0 extends BaseAdapter {
    public final List<String> f;
    public final Context g;

    public xi0(List<String> list, Context context) {
        this.f = list;
        this.g = context;
    }

    public String a(int i) {
        return this.f.get(i);
    }

    public int getCount() {
        return this.f.size();
    }

    public Object getItem(int i) {
        return this.f.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        TextView textView = (TextView) LayoutInflater.from(this.g).inflate(R.layout.spinner_filter_item, (ViewGroup) null);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, (int) this.g.getResources().getDimension(R.dimen.spinner_filter_item_height)));
        String str2 = this.f.get(i);
        if (str2.equals("_all")) {
            str = this.g.getString(R.string.all_routes);
        } else {
            str = String.format(this.g.getString(R.string.towards), str2);
        }
        textView.setText(str);
        return textView;
    }
}
