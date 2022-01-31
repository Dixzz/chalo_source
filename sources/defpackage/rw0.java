package defpackage;

import android.os.Handler;
import android.widget.LinearLayout;
import app.zophop.R;
import app.zophop.models.TripOptions;
import app.zophop.models.VehicleInfo;
import app.zophop.ui.fragments.ResultFragment;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zophop.models.Itinerary;
import zophop.models.TripPlannerResponse;

/* renamed from: rw0  reason: default package */
/* compiled from: StopBasedTripPlannerResultFragment */
public class rw0 extends ResultFragment {
    public static Map<String, VehicleInfo> C = new HashMap();
    public int A = 1;
    public final Comparator<Itinerary> B = new a(this);
    public Itinerary r;
    public Itinerary s;
    public List<Itinerary> t;
    public List<Itinerary> u;
    public Map<String, VehicleInfo> v = new HashMap();
    public boolean w;
    public Handler x;
    public Handler y;
    public Runnable z;

    /* renamed from: rw0$a */
    /* compiled from: StopBasedTripPlannerResultFragment */
    public class a implements Comparator<Itinerary>, j$.util.Comparator {
        public a(rw0 rw0) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Itinerary itinerary, Itinerary itinerary2) {
            Itinerary itinerary3 = itinerary;
            Itinerary itinerary4 = itinerary2;
            if (itinerary3.inCompleteFare) {
                return 1;
            }
            if (itinerary4.inCompleteFare) {
                return -1;
            }
            return new Integer(ui1.D(itinerary3.fares)).compareTo(new Integer(ui1.D(itinerary4.fares)));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Itinerary> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Itinerary> thenComparing(java.util.Comparator<? super Itinerary> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void g() {
        super.g();
        this.s = null;
        this.r = null;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void i(TripOptions tripOptions) {
        if (tripOptions == null) {
            this.n = h();
        } else {
            this.n = tripOptions;
        }
        this.h = xt.f3961a.h0().a(this.i, this.n);
        this.j = true;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void l() {
        if (this.j) {
            o();
            return;
        }
        TripPlannerResponse tripPlannerResponse = this.f;
        if (tripPlannerResponse == null) {
            n();
        } else if (tripPlannerResponse.itineraries.size() == 0) {
            m();
        } else {
            jz5.b().g(new ed1("trip planner used", Long.MIN_VALUE));
            q();
        }
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.x != null) {
            xt.f3961a.Z().b();
        }
        this.x = null;
        this.y = null;
        this.w = false;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void onPause() {
        super.onPause();
        if (this.x != null) {
            xt.f3961a.Z().b();
        }
        this.x = null;
        this.y = null;
        this.w = false;
    }

    public void onResume() {
        super.onResume();
        xt.f3961a.Z().b();
        this.w = false;
        if (this.x == null) {
            this.x = new Handler();
        }
        this.A = 1;
        Handler handler = new Handler();
        this.y = handler;
        if (handler != null) {
            sw0 sw0 = new sw0(this);
            this.z = sw0;
            sw0.run();
        }
        l();
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void p() {
        this._results.removeAllViews();
        this.t = new ArrayList();
        this.u = new ArrayList();
        Iterator<Itinerary> it = this.f.itineraries.iterator();
        while (it.hasNext()) {
            Itinerary next = it.next();
            if (next.legs.size() == 1) {
                this.t.add(next);
            } else {
                this.u.add(next);
            }
        }
        this.r = (Itinerary) Collections.min(this.f.itineraries);
        this.s = (Itinerary) Collections.min(this.f.itineraries, this.B);
        if (this.g.equals(l90.DIRECT_BUSES)) {
            if (this.t.size() == 0) {
                m();
            } else {
                r(this.t);
            }
        } else if (this.u.size() == 0) {
            m();
        } else {
            r(this.u);
        }
    }

    public final void r(List<Itinerary> list) {
        String str;
        wb1.r = 0;
        C = new HashMap();
        xt.f3961a.Z().b();
        this.w = false;
        for (Itinerary itinerary : list) {
            if (itinerary != null) {
                Itinerary itinerary2 = this.s;
                boolean z2 = itinerary2 != null && !itinerary2.inCompleteFare && itinerary2.equals(itinerary);
                Itinerary itinerary3 = this.r;
                boolean z3 = itinerary3 != null && itinerary3.equals(itinerary);
                LinearLayout linearLayout = this._results;
                if (z2 && z3) {
                    str = getString(R.string.fastest) + "  " + getString(R.string.cheapest);
                } else if (z2) {
                    str = getString(R.string.cheapest);
                } else {
                    str = z3 ? getString(R.string.fastest) : null;
                }
                b(linearLayout, itinerary, str, this.g.name(), z2, z3, C);
            }
        }
        this.A = 1;
    }
}
