package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
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
import java.util.Map;

/* renamed from: n80  reason: default package */
/* compiled from: TripsRecentStore */
public class n80 implements j80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2521a;
    public rf1 b;
    public rf1 c;
    public final mv d = new mv();

    /* renamed from: n80$a */
    /* compiled from: TripsRecentStore */
    public class a implements Comparator<TripFavourite>, j$.util.Comparator {
        public a(n80 n80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(TripFavourite tripFavourite, TripFavourite tripFavourite2) {
            return Long.compare(tripFavourite.getTime(), tripFavourite2.getTime());
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<TripFavourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<TripFavourite> thenComparing(java.util.Comparator<? super TripFavourite> comparator) {
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

    /* renamed from: n80$b */
    /* compiled from: TripsRecentStore */
    public class b implements java.util.Comparator<StopBasedTripFavourite>, j$.util.Comparator {
        public b(n80 n80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(StopBasedTripFavourite stopBasedTripFavourite, StopBasedTripFavourite stopBasedTripFavourite2) {
            return Long.compare(stopBasedTripFavourite.getTime(), stopBasedTripFavourite2.getTime());
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<StopBasedTripFavourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<StopBasedTripFavourite> thenComparing(java.util.Comparator<? super StopBasedTripFavourite> comparator) {
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

    public n80(Context context, City city) {
        this.f2521a = context;
        k(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.j80
    public void a(StopBasedTripFavourite stopBasedTripFavourite) {
        if (stopBasedTripFavourite.getOriginStop() != null && stopBasedTripFavourite.getDestinationStop() != null) {
            try {
                i(stopBasedTripFavourite);
                this.c.j(stopBasedTripFavourite.getId(), this.d.h(stopBasedTripFavourite).toString());
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    @Override // defpackage.j80
    public void b(Favourite favourite) {
        favourite.setTime(System.currentTimeMillis());
        if (favourite instanceof TripFavourite) {
            g((TripFavourite) favourite);
        } else if (favourite instanceof StopBasedTripFavourite) {
            a((StopBasedTripFavourite) favourite);
        }
    }

    @Override // defpackage.j80
    public List<TripFavourite> c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.b.b().entrySet()) {
            try {
                arrayList.add(this.d.q((String) entry.getValue()));
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        Collections.sort(arrayList, new a(this));
        return arrayList;
    }

    @Override // defpackage.j80
    public List<StopBasedTripFavourite> d() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.c.b().entrySet()) {
            try {
                arrayList.add(this.d.m((String) entry.getValue()));
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        Collections.sort(arrayList, new b(this));
        return arrayList;
    }

    @Override // defpackage.j80
    public void e(String str) {
        rf1 rf1 = this.b;
        rf1.f3075a.remove(str);
        rf1.f3075a.commit();
    }

    @Override // defpackage.j80
    public void f(String str) {
        rf1 rf1 = this.c;
        rf1.f3075a.remove(str);
        rf1.f3075a.commit();
    }

    @Override // defpackage.j80
    public void g(TripFavourite tripFavourite) {
        if (tripFavourite.getFrom() != null && tripFavourite.getTo() != null) {
            try {
                j(tripFavourite);
                this.b.j(tripFavourite.getId(), this.d.i(tripFavourite).toString());
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    public final String h(City city, String str) {
        return hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, str);
    }

    public final void i(StopBasedTripFavourite stopBasedTripFavourite) {
        List<StopBasedTripFavourite> d2 = d();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) d2).iterator();
        while (it.hasNext()) {
            StopBasedTripFavourite stopBasedTripFavourite2 = (StopBasedTripFavourite) it.next();
            if (stopBasedTripFavourite2 != null) {
                if (stopBasedTripFavourite.match(stopBasedTripFavourite2)) {
                    f(stopBasedTripFavourite2.getId());
                } else {
                    arrayList.add(stopBasedTripFavourite2.getId());
                }
            }
        }
        if (arrayList.size() >= 5) {
            for (int i = 0; i < (arrayList.size() - 5) + 1; i++) {
                f((String) arrayList.get(i));
            }
        }
    }

    public final void j(TripFavourite tripFavourite) {
        List<TripFavourite> c2 = c();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) c2).iterator();
        while (it.hasNext()) {
            TripFavourite tripFavourite2 = (TripFavourite) it.next();
            if (tripFavourite2 != null) {
                if (tripFavourite.match(tripFavourite2)) {
                    e(tripFavourite2.getId());
                } else {
                    arrayList.add(tripFavourite2.getId());
                }
            }
        }
        if (arrayList.size() >= 5) {
            for (int i = 0; i < (arrayList.size() - 5) + 1; i++) {
                e((String) arrayList.get(i));
            }
        }
    }

    public void k(City city) {
        if (city != null) {
            this.b = new rf1(this.f2521a, h(city, "recent_trips_store"));
            this.c = new rf1(this.f2521a, h(city, "recent_stop_based_trips_store"));
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        k(cityChangedEvent._city);
    }
}
