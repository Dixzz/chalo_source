package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.models.UniversalSearchItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* renamed from: tj0  reason: default package */
/* compiled from: LocationAndStopPickAdapter */
public class tj0 extends uj0 {
    public List<UniversalSearchItem> j = new ArrayList();
    public final String k;
    public final boolean l;
    public final boolean m;

    /* renamed from: tj0$a */
    /* compiled from: LocationAndStopPickAdapter */
    public class a extends Filter {
        public a() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence != null) {
                List<md1> a2 = tj0.this.a(charSequence.toString());
                filterResults.values = a2;
                filterResults.count = ((ArrayList) a2).size();
            }
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            tj0.this.i = charSequence.toString();
            Filter filter = tj0.this.h;
            if (filter != null && filter.equals(this)) {
                Object obj = filterResults.values;
            }
        }
    }

    public tj0(Context context, String str, boolean z, boolean z2) {
        super(context);
        this.k = str;
        this.m = z;
        this.l = z2;
    }

    @Override // defpackage.yf1
    public List<md1> a(String str) {
        String uuid = UUID.randomUUID().toString();
        q50 j0 = xt.f3961a.j0();
        String str2 = this.k;
        Objects.requireNonNull(j0);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            wj1 wj1 = j0.f;
            if (wj1 != null) {
                wj1.c();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("source", str2);
            String d = j0.d(j0.c.b(str), hashMap);
            d70 d70 = new d70(d, null, new t50(j0, str, System.currentTimeMillis(), uuid, d), new r50(j0, System.currentTimeMillis(), str, uuid));
            j0.f = d70;
            d70.n = true;
            j0.d.post(new o50(j0));
        } catch (Exception e) {
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            j0.d.post(new p50(j0, str, currentTimeMillis, e, uuid));
        }
        return new ArrayList();
    }

    @Override // defpackage.yf1
    public int getCount() {
        return this.j.size();
    }

    @Override // defpackage.yf1
    public Filter getFilter() {
        a aVar = new a();
        this.h = aVar;
        return aVar;
    }

    @Override // defpackage.yf1
    public Object getItem(int i) {
        UniversalSearchItem universalSearchItem = this.j.get(i);
        if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP)) {
            return universalSearchItem.getData();
        }
        if (!universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.LOCATION)) {
            return null;
        }
        md1 md1 = (md1) universalSearchItem.getData();
        return new mf1(md1.f2356a, md1.b);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        mf1 mf1;
        UniversalSearchItem universalSearchItem = this.j.get(i);
        if (getItem(i) instanceof Stop) {
            Stop stop = (Stop) getItem(i);
            mf1 = new mf1(stop.getName(), stop.getLatLong());
        } else {
            mf1 = (mf1) getItem(i);
        }
        rg1 b = uj0.b(view, mf1, this.f);
        if (universalSearchItem.getType().equals(UniversalSearchItem.UniversalSearchItemType.STOP)) {
            ((ImageView) b.findViewById(R.id.icon)).setImageResource(mk0.b(((Stop) universalSearchItem.getData()).getMode()));
        }
        return b;
    }
}
