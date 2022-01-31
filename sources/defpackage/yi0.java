package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.zophop.models.EtaModel;
import app.zophop.models.SeatInfo;
import java.util.List;
import java.util.Map;

/* renamed from: yi0  reason: default package */
/* compiled from: EtaAdapter */
public class yi0 extends BaseAdapter {
    public final Context f;
    public Map<Long, String> g;
    public List<EtaModel> h;
    public final boolean i;
    public TextView j;
    public List<SeatInfo> k;
    public ci1 l;

    /* renamed from: yi0$a */
    /* compiled from: EtaAdapter */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ci1 ci1 = yi0.this.l;
            if (ci1 != null) {
                ci1.a(Boolean.TRUE);
            }
        }
    }

    public yi0(Context context, boolean z, List<EtaModel> list, Map<Long, String> map, ci1 ci1) {
        this.f = context;
        this.g = map;
        this.h = list;
        this.i = z;
        this.l = ci1;
    }

    /* renamed from: a */
    public EtaModel getItem(int i2) {
        List<EtaModel> list = this.h;
        if (list != null && list.size() > 0) {
            return this.h.get(i2);
        }
        Map<Long, String> map = this.g;
        if (map == null || map.size() <= 0) {
            return null;
        }
        int i3 = 0;
        for (Map.Entry<Long, String> entry : this.g.entrySet()) {
            if (i2 == i3) {
                EtaModel etaModel = new EtaModel(null, -1, entry.getKey().longValue(), false);
                etaModel.set_variableTime(String.valueOf(entry.getValue()));
                return etaModel;
            }
            i3++;
        }
        return null;
    }

    public int getCount() {
        List<EtaModel> list = this.h;
        if (list != null && list.size() > 0) {
            return this.h.size();
        }
        Map<Long, String> map = this.g;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public long getItemId(int i2) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r18, android.view.View r19, android.view.ViewGroup r20) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void notifyDataSetChanged() {
        TextView textView;
        super.notifyDataSetChanged();
        if (getCount() == 0 && (textView = this.j) != null) {
            textView.setVisibility(0);
        }
    }
}
