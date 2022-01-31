package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import app.zophop.R;
import app.zophop.models.EtaUpdateInfo;
import app.zophop.models.LiveRouteData;
import app.zophop.models.Route;
import app.zophop.models.RouteLevelAvailability;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import defpackage.ii1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import server.zophop.logging.LoggingConstants;

/* renamed from: dk0  reason: default package */
/* compiled from: RouteAdapter */
public class dk0 extends BaseAdapter {
    public boolean A;
    public boolean B;
    public Map<String, RouteLevelAvailability> C;
    public final Context f;
    public final List<Stop> g;
    public final ci1<Stop> h;
    public final ci1<Boolean> i;
    public ci1<Boolean> j;
    public final x61 k;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public List<String> o;
    public List<String> p;
    public final TransitMode q;
    public String r;
    public final View.OnClickListener s;
    public final boolean t;
    public final Route u;
    public final o61 v;
    public LiveRouteData w;
    public int x = -1;
    public int y = -1;
    public final boolean z;

    /* renamed from: dk0$a */
    /* compiled from: RouteAdapter */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int f;
        public final /* synthetic */ yc1 g;

        public a(int i, yc1 yc1) {
            this.f = i;
            this.g = yc1;
        }

        public void onClick(View view) {
            int i = this.f;
            dk0 dk0 = dk0.this;
            if (i != dk0.x) {
                dk0.e(i);
                this.g.setPressStateBackground(R.drawable.eta_selector);
            }
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;Lapp/zophop/models/Route;Lci1<Lapp/zophop/models/Stop;>;Lci1<Ljava/lang/Boolean;>;Lci1<Ljava/lang/Boolean;>;Lapp/zophop/models/Stop;Lapp/zophop/models/Stop;Lapp/zophop/models/Stop;Ljava/util/List<Lapp/zophop/models/Route$RouteTiming;>;Landroid/view/View$OnClickListener;ZZLjava/util/Map<Ljava/lang/String;Lapp/zophop/models/RouteLevelAvailability;>;Ljava/lang/String;)V */
    public dk0(Context context, Route route, ci1 ci1, ci1 ci12, ci1 ci13, Stop stop, Stop stop2, Stop stop3, View.OnClickListener onClickListener, boolean z2, boolean z3, Map map, String str) {
        Route route2;
        RouteLevelAvailability routeLevelAvailability;
        this.f = context;
        this.u = route;
        this.g = route.getStopSequence();
        this.q = route.getMode();
        this.h = ci1;
        this.i = ci12;
        this.j = ci13;
        this.k = new x61(context);
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.t = z2;
        this.s = onClickListener;
        this.v = new o61(route);
        this.z = z3;
        this.C = map;
        this.r = str;
        if (!(stop == null || stop2 == null || !stop.getId().equals(stop2.getId()))) {
            this.l = 0;
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            if (stop != null && stop.getId().equals(this.g.get(i2).getId())) {
                this.l = i2;
            }
            if (stop2 != null && stop2.getId().equals(this.g.get(i2).getId())) {
                this.m = i2;
            }
            if (stop3 == null || !stop3.getId().equals(this.g.get(i2).getId())) {
                String str2 = this.r;
                if (str2 != null && str2.equals(this.g.get(i2).getId())) {
                    this.n = i2;
                    this.y = i2;
                }
            } else {
                this.n = i2;
                this.y = i2;
            }
        }
        if (this.l == -1) {
            this.l = 0;
        }
        if (this.m == -1) {
            this.m = getCount() - 1;
        }
        Map<String, RouteLevelAvailability> map2 = this.C;
        if (!(map2 == null || (route2 = this.u) == null || (routeLevelAvailability = map2.get(String.valueOf(route2.getAvailabilityStatus()))) == null || !routeLevelAvailability.isVisible())) {
            int availabilityStatus = (int) this.u.getAvailabilityStatus();
            String routeId = this.u.getRouteId();
            ed1 ed1 = new ed1("availability route banner", Long.MIN_VALUE);
            ed1.a("availability priority", Integer.valueOf(availabilityStatus));
            ed1.a("availability banner sticky", Boolean.TRUE);
            ed1.a(LoggingConstants.ROUTE_ID, routeId);
            jz5.b().g(ed1);
        }
    }

    public Stop a(int i2) {
        return this.g.get(i2);
    }

    public final int b(String str) {
        return ((int) Math.floor((double) Integer.parseInt(str))) < ui1.x(xt.f3961a.k().d().getName()) ? vn.R(this.q) : R.drawable.live_bus_list_delayed;
    }

    public final int c(String str) {
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            if (this.g.get(i2).getId().equals(str)) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean d(int i2) {
        int i3 = this.l;
        if (i3 == -1) {
            return true;
        }
        if (i2 < i3) {
            return false;
        }
        int i4 = this.m;
        if (i4 == -1 || i2 <= i4) {
            return true;
        }
        return false;
    }

    public void e(int i2) {
        this.y = i2;
        Stop stop = this.g.get(i2);
        if (!this.k.q(stop)) {
            this.x = i2;
            this.k.f3891a.clear();
            this.k.d(stop);
            this.k.c = this.w;
            this.h.a(stop);
            x61 x61 = this.k;
            x61.d = null;
            x61.e = this.i;
            notifyDataSetChanged();
        }
    }

    public void f(Stop stop, ii1.a aVar) {
        x61 x61 = this.k;
        x61.f3891a.clear();
        x61.f3891a.put(stop.getId(), aVar);
    }

    public void g(Stop stop, List<EtaUpdateInfo> list) {
        if (list.size() != 0) {
            f(stop, vn.q0(list));
            return;
        }
        ii1.a aVar = new ii1.a();
        aVar.d = ii1.a.EnumC0027a.FAILURE;
        f(stop, aVar);
    }

    public int getCount() {
        return this.g.size();
    }

    public Object getItem(int i2) {
        return this.g.get(i2);
    }

    public long getItemId(int i2) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r18, android.view.View r19, android.view.ViewGroup r20) {
        /*
        // Method dump skipped, instructions count: 1077
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dk0.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
