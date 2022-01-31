package defpackage;

import android.widget.LinearLayout;
import app.zophop.R;
import app.zophop.models.TripOptions;
import app.zophop.ui.fragments.ResultFragment;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import zophop.models.Itinerary;
import zophop.models.TripPlannerResponse;

/* renamed from: zv0  reason: default package */
/* compiled from: RecommendedResultFragment */
public class zv0 extends ResultFragment {
    public List<Itinerary> r;
    public List<Itinerary> s;
    public List<Itinerary> t;
    public final Comparator<Itinerary> u = new a(this);

    /* renamed from: zv0$a */
    /* compiled from: RecommendedResultFragment */
    public class a implements Comparator<Itinerary>, j$.util.Comparator {
        public a(zv0 zv0) {
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

    /* renamed from: zv0$b */
    /* compiled from: RecommendedResultFragment */
    public enum b {
        CHEAPEST,
        FASTEST,
        TRAIN,
        BUS,
        OTHER,
        CHEAPEST_FASTEST
    }

    @Override // app.zophop.ui.fragments.ResultFragment
    public void g() {
        super.g();
        this.s = null;
        this.r = null;
        this.t = null;
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
    public void p() {
        this._results.removeAllViews();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.s.add((Itinerary) Collections.min(this.f.itineraries, this.u));
        Iterator<Itinerary> it = this.f.itineraries.iterator();
        while (it.hasNext()) {
            Itinerary next = it.next();
            if (this.r.size() < 1) {
                this.r.add(next);
            } else if (!this.s.contains(next)) {
                this.t.add(next);
            }
        }
        if (!this.g.equals(l90.OTHER)) {
            boolean z = false;
            if (this.s.get(0) != null && !this.s.get(0).inCompleteFare) {
                if (this.r.get(0) == null || !this.r.get(0).equals(this.s.get(0))) {
                    a(this._results, this.s, getString(R.string.cheapest), b.CHEAPEST.name(), true, false);
                } else {
                    LinearLayout linearLayout = this._results;
                    List<Itinerary> list = this.s;
                    a(linearLayout, list, getString(R.string.fastest) + "  " + getString(R.string.cheapest), b.CHEAPEST_FASTEST.name(), true, true);
                    z = true;
                }
            }
            List<Itinerary> list2 = this.r;
            if (list2 != null && list2.size() > 0 && !z) {
                a(this._results, this.r, getString(R.string.fastest), b.FASTEST.name(), false, true);
            }
            if (xt.f3961a.k().d().getModes().size() == 1) {
                a(this._results, this.t, null, this.g.name(), false, false);
            }
        } else if (this.t.size() == 0) {
            m();
        } else {
            a(this._results, this.t, null, b.OTHER.name(), false, false);
        }
    }
}
