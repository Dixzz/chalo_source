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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import zophop.models.Itinerary;
import zophop.models.TripPlannerResponse;

/* renamed from: dt0  reason: default package */
/* compiled from: AllResultsFragment */
public class dt0 extends ResultFragment {
    public static Map<String, VehicleInfo> A = new HashMap();
    public Itinerary r;
    public Itinerary s;
    public Map<String, VehicleInfo> t = new HashMap();
    public boolean u;
    public Handler v;
    public Handler w;
    public Runnable x;
    public int y = 1;
    public final Comparator<Itinerary> z = new a(this);

    /* renamed from: dt0$a */
    /* compiled from: AllResultsFragment */
    public class a implements Comparator<Itinerary>, j$.util.Comparator {
        public a(dt0 dt0) {
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
        super.i(null);
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
        if (this.v != null) {
            xt.f3961a.Z().b();
        }
        this.v = null;
        this.w = null;
        this.u = false;
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void onPause() {
        super.onPause();
        if (this.v != null) {
            xt.f3961a.Z().b();
        }
        this.v = null;
        this.w = null;
        this.u = false;
    }

    public void onResume() {
        super.onResume();
        xt.f3961a.Z().b();
        this.u = false;
        if (this.v == null) {
            this.v = new Handler();
        }
        this.y = 1;
        Handler handler = new Handler();
        this.w = handler;
        if (handler != null) {
            et0 et0 = new et0(this);
            this.x = et0;
            et0.run();
        }
        l();
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void p() {
        String str;
        this._results.removeAllViews();
        this.r = (Itinerary) Collections.min(this.f.itineraries);
        this.s = (Itinerary) Collections.min(this.f.itineraries, this.z);
        wb1.r = 0;
        A = new HashMap();
        xt.f3961a.Z().b();
        this.u = false;
        Iterator<Itinerary> it = this.f.itineraries.iterator();
        while (it.hasNext()) {
            Itinerary next = it.next();
            if (next != null) {
                Itinerary itinerary = this.s;
                boolean z2 = itinerary != null && !itinerary.inCompleteFare && itinerary.equals(next);
                Itinerary itinerary2 = this.r;
                boolean z3 = itinerary2 != null && itinerary2.equals(next);
                LinearLayout linearLayout = this._results;
                if (z2 && z3) {
                    str = getString(R.string.fastest) + "  " + getString(R.string.cheapest);
                } else if (z2) {
                    str = getString(R.string.cheapest);
                } else {
                    str = z3 ? getString(R.string.fastest) : null;
                }
                b(linearLayout, next, str, this.g.name(), z2, z3, A);
            }
        }
        this.y = 1;
    }
}
