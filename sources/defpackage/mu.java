package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductCategory;
import java.util.Map;

/* renamed from: mu  reason: default package */
/* compiled from: CategoriesAdapter */
public class mu extends BaseAdapter {
    public final Context f;
    public final Map<Integer, ProductCategory> g;

    public mu(Context context, Map<Integer, ProductCategory> map) {
        this.f = context;
        this.g = map;
    }

    public int getCount() {
        return this.g.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f).inflate(R.layout.supersaver_category, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.groupingId);
        int i2 = 0;
        for (Map.Entry<Integer, ProductCategory> entry : this.g.entrySet()) {
            if (i2 == i) {
                textView.setText(entry.getValue().get_categoryName());
                textView.setTag(entry.getValue().getCategoryId());
            }
            i2++;
        }
        return view;
    }
}
