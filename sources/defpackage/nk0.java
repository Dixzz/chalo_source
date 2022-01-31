package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TripLeg;
import defpackage.ii1;
import java.util.ArrayList;
import java.util.List;

/* renamed from: nk0  reason: default package */
/* compiled from: TrainishTripDetailsAdapter */
public class nk0 extends BaseAdapter {
    public final Context f;
    public final List<TripLeg> g;
    public int h = -1;
    public int i = -1;
    public final x61 j;
    public ci1<Stop> k;
    public int l = -1;
    public List<String> m;
    public List<String> n;

    /* renamed from: nk0$a */
    /* compiled from: TrainishTripDetailsAdapter */
    public class a implements View.OnTouchListener {
        public a(nk0 nk0) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public nk0(Context context, List<TripLeg> list, String str, String str2, String str3) {
        this.f = context;
        this.g = list;
        this.m = new ArrayList();
        this.n = new ArrayList();
        if (list != null) {
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                TripLeg tripLeg = this.g.get(i2);
                if (str != null && str.equals(tripLeg.getStop().getId())) {
                    this.h = i2;
                } else if (str2 != null && str2.equals(tripLeg.getStop().getId())) {
                    this.i = i2;
                }
                if (str3 != null && str3.equals(tripLeg.getStop().getId())) {
                    this.l = i2;
                }
            }
        }
        if (this.h == -1) {
            this.h = 0;
        }
        if (this.i == -1) {
            this.i = getCount() - 1;
        }
        Context context2 = this.f;
        list.get(0).getStop().getMode();
        this.j = new x61(context2);
    }

    public void a(Stop stop, ii1.a aVar) {
        this.j.f3891a.clear();
        x61 x61 = this.j;
        x61.f3891a.clear();
        x61.f3891a.put(stop.getId(), aVar);
    }

    public int b() {
        int i2 = this.l;
        if (i2 < 0 || i2 < this.h || i2 > this.i) {
            return this.h;
        }
        return i2;
    }

    public TripLeg c(int i2) {
        return this.g.get(i2);
    }

    public final int d(String str) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            if (this.g.get(i2).getStop().getId().equals(str)) {
                return i2;
            }
        }
        return -1;
    }

    public void e(int i2) {
        Stop stop = this.g.get(i2).getStop();
        if (!this.j.q(stop)) {
            this.j.f3891a.clear();
            this.j.d(stop);
            ci1<Stop> ci1 = this.k;
            if (ci1 != null) {
                ci1.a(stop);
            }
            notifyDataSetChanged();
        }
    }

    public void f(List<StreamInfo> list, boolean z) {
        if (list.size() > 0) {
            this.m = new ArrayList();
            this.n = new ArrayList();
            for (StreamInfo streamInfo : list) {
                String id = c(d(streamInfo.getNextStopId()) - 1).getStop().getId();
                String nextStopId = streamInfo.getNextStopId();
                this.m.add(nextStopId);
                this.n.add(id);
                if (z) {
                    a(c(d(nextStopId)).getStop(), ii1.n(streamInfo));
                }
            }
        }
    }

    public int getCount() {
        List<TripLeg> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i2) {
        return this.g.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: x61 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.LinearLayout, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.widget.LinearLayout, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
        // Method dump skipped, instructions count: 583
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nk0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
