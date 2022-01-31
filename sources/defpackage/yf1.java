package defpackage;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import java.util.List;

/* renamed from: yf1  reason: default package */
/* compiled from: PickerAdapter */
public abstract class yf1<T> extends BaseAdapter implements Filterable {
    public Context f;
    public List<T> g;
    public Filter h;
    public String i;

    /* renamed from: yf1$a */
    /* compiled from: PickerAdapter */
    public class a extends Filter {
        public a() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence != null) {
                List<T> a2 = yf1.this.a(charSequence.toString());
                filterResults.values = a2;
                filterResults.count = a2.size();
            }
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            yf1.this.i = charSequence.toString();
            Filter filter = yf1.this.h;
            if (filter != null && filter.equals(this) && filterResults.values != null) {
                od1 od1 = new od1();
                od1.f2678a = charSequence.toString();
                jz5.b().g(od1);
                yf1 yf1 = yf1.this;
                yf1.g = (List) filterResults.values;
                yf1.notifyDataSetChanged();
            }
        }
    }

    public yf1(Context context) {
        this.f = context;
    }

    public abstract List<T> a(String str);

    public int getCount() {
        List<T> list = this.g;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Filter getFilter() {
        a aVar = new a();
        this.h = aVar;
        return aVar;
    }

    public Object getItem(int i2) {
        return this.g.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }
}
