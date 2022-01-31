package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.ui.activities.PickStopFilterableActivity;
import defpackage.k90;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: ij0  reason: default package */
/* compiled from: FilterableAdapter */
public class ij0<T> extends BaseAdapter implements Filterable {
    public final Context f;
    public final List<T> g;
    public List<T> h;
    public final di1 i;
    public final TransitMode j;
    public final k90 k;

    /* renamed from: ij0$a */
    /* compiled from: FilterableAdapter */
    public class a extends Filter {
        public a() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence == null || charSequence.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<T> list = ij0.this.g;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    T t = ij0.this.g.get(i);
                    Objects.requireNonNull((PickStopFilterableActivity) ij0.this.i);
                    if (t.getName().toLowerCase().contains(charSequence)) {
                        arrayList.add(t);
                    }
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults != null) {
                ij0 ij0 = ij0.this;
                ij0.h = (List) filterResults.values;
                ij0.notifyDataSetChanged();
                od1 od1 = new od1();
                od1.f2678a = charSequence.toString();
                jz5.b().g(od1);
            }
        }
    }

    public ij0(Context context, List<T> list, di1 di1, TransitMode transitMode, k90 k90) {
        this.f = context;
        this.g = list;
        this.h = list;
        this.i = di1;
        this.j = transitMode;
        this.k = k90;
    }

    public int getCount() {
        List<T> list = this.h;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Filter getFilter() {
        return new a();
    }

    public Object getItem(int i2) {
        return this.h.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        rg1 rg1;
        if (view == null) {
            rg1 = new rg1(this.f);
        } else {
            rg1 = (rg1) view;
        }
        di1 di1 = this.i;
        T t = this.h.get(i2);
        Objects.requireNonNull((PickStopFilterableActivity) di1);
        String name = t.getName();
        int ordinal = this.j.ordinal();
        rg1.a(name, null, ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? 0 : R.drawable.monorail_search : R.drawable.metro_search : R.drawable.bus_search : R.drawable.train_search);
        return rg1;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (getCount() == 0) {
            k90 k90 = this.k;
            ((de0) k90).f825a.q0(k90.a.NO_MATCH_FOUND);
        }
    }
}
