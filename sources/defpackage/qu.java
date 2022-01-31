package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductSubCategory;
import java.util.Map;

/* renamed from: qu  reason: default package */
/* compiled from: SubCategoryAdapter.kt */
public final class qu extends BaseAdapter {
    public final Context f;
    public final Map<String, ProductSubCategory> g;
    public int h = -1;

    public qu(Context context, Map<String, ProductSubCategory> map) {
        n86.e(context, "_context");
        this.f = context;
        this.g = map;
    }

    public int getCount() {
        if (this.h == -1) {
            Map<String, ProductSubCategory> map = this.g;
            int i = 0;
            if (map != null) {
                for (Map.Entry<String, ProductSubCategory> entry : map.entrySet()) {
                    entry.getKey();
                    if (entry.getValue().isVisible()) {
                        i++;
                    }
                }
            }
            this.h = i;
        }
        return this.h;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.g == null) {
            return view;
        }
        View inflate = LayoutInflater.from(this.f).inflate(R.layout.sub_category_bubble_layout, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.sub_category_name);
        if (textView != null) {
            LinearLayout linearLayout2 = (LinearLayout) inflate;
            if (view == null) {
                view = linearLayout2;
            }
            int i2 = 0;
            for (Map.Entry<String, ProductSubCategory> entry : this.g.entrySet()) {
                String key = entry.getKey();
                ProductSubCategory value = entry.getValue();
                if (i2 == i) {
                    textView.setText(value.getName());
                    textView.setTag(key);
                    if (!value.isActive()) {
                        linearLayout.setAlpha(0.4f);
                        linearLayout2.setClickable(false);
                    }
                }
                i2++;
            }
            return view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.sub_category_name)));
    }
}
