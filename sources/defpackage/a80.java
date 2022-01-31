package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithExtras;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingItemType;
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
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: a80  reason: default package */
/* compiled from: BookingsRecentStore */
public class a80 implements d80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f132a;
    public rf1 b;
    public final mv c = new mv();

    /* renamed from: a80$a */
    /* compiled from: BookingsRecentStore */
    public class a implements Comparator<BusFavourite>, j$.util.Comparator {
        public a(a80 a80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(BusFavourite busFavourite, BusFavourite busFavourite2) {
            return Long.compare(busFavourite2.getTime(), busFavourite.getTime());
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<BusFavourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<BusFavourite> thenComparing(java.util.Comparator<? super BusFavourite> comparator) {
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

    /* renamed from: a80$b */
    /* compiled from: BookingsRecentStore */
    public class b implements java.util.Comparator<BusFavourite>, j$.util.Comparator {
        public b(a80 a80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(BusFavourite busFavourite, BusFavourite busFavourite2) {
            return Long.compare(busFavourite2.getTime(), busFavourite.getTime());
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<BusFavourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<BusFavourite> thenComparing(java.util.Comparator<? super BusFavourite> comparator) {
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

    public a80(Context context, City city) {
        this.f132a = context;
        f(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.d80
    public void a(BookingItemType bookingItemType, String str, String str2, String str3, String str4, String str5, List<SPECIAL_FEATURE> list, List<String> list2, boolean z) {
        Exception e;
        rf1 d = d(bookingItemType);
        if (d != null) {
            try {
                BusFavouriteWithExtras busFavouriteWithExtras = new BusFavouriteWithExtras(str, str2, str3, str4, UUID.randomUUID().toString(), System.currentTimeMillis(), RouteStoreType.RECENT, str5, list, list2, z);
                try {
                    JSONObject c2 = this.c.c(busFavouriteWithExtras);
                    if (busFavouriteWithExtras.getSpecialFeatures() != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (SPECIAL_FEATURE special_feature : busFavouriteWithExtras.getSpecialFeatures()) {
                            jSONArray.put(special_feature.toString());
                        }
                        c2.put("_specialFeatureArray", jSONArray);
                    }
                    d.f3075a.putString(str, c2.toString());
                    d.f3075a.commit();
                    e(bookingItemType);
                } catch (Exception e2) {
                    e = e2;
                    e.getMessage();
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
            } catch (Exception e3) {
                e = e3;
                e.getMessage();
                b00 b002 = b00.f358a;
                b00.a().b(e);
            }
        }
    }

    @Override // defpackage.d80
    public void b(BookingItemType bookingItemType, String str) {
        rf1 d;
        if (bookingItemType != null && str != null && (d = d(bookingItemType)) != null && d.b.contains(str)) {
            d.f3075a.remove(str);
            d.f3075a.commit();
        }
    }

    @Override // defpackage.d80
    public List<RouteInfo> c(BookingItemType bookingItemType) {
        rf1 d;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bookingItemType == null || (d = d(bookingItemType)) == null) {
            return arrayList2;
        }
        for (Map.Entry<String, ?> entry : d.b().entrySet()) {
            try {
                arrayList.add(this.c.b((String) entry.getValue()));
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        Collections.sort(arrayList, new a(this));
        for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
            BusFavouriteWithExtras busFavouriteWithExtras = (BusFavouriteWithExtras) it.next();
            arrayList2.add(new RouteInfo(busFavouriteWithExtras.getRouteId(), TransitMode.bus, busFavouriteWithExtras.getRouteName(), busFavouriteWithExtras.getStartStopName(), busFavouriteWithExtras.getEndStopName(), busFavouriteWithExtras.getEndStopName(), busFavouriteWithExtras.getAgency(), busFavouriteWithExtras.getSpecialFeatures(), busFavouriteWithExtras.get_spfList(), null, false, bookingItemType.equals(BookingItemType.MTICKET), busFavouriteWithExtras.isFreeRide(), bookingItemType.equals(BookingItemType.ROUTE_PASS), ""));
        }
        return arrayList2;
    }

    public final rf1 d(BookingItemType bookingItemType) {
        if (bookingItemType == BookingItemType.MTICKET) {
            return this.b;
        }
        return null;
    }

    public final void e(BookingItemType bookingItemType) {
        rf1 d;
        ArrayList arrayList = new ArrayList();
        if (bookingItemType != null && (d = d(bookingItemType)) != null) {
            for (Map.Entry<String, ?> entry : d.b().entrySet()) {
                try {
                    arrayList.add(this.c.b((String) entry.getValue()));
                } catch (Exception e) {
                    e.getMessage();
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
            }
            Collections.sort(arrayList, new b(this));
            int size = arrayList.size();
            while (true) {
                size--;
                if (size >= 5) {
                    d.k(((BusFavouriteWithExtras) arrayList.get(size)).getRouteId());
                } else {
                    return;
                }
            }
        }
    }

    public void f(City city) {
        if (city != null) {
            this.b = new rf1(this.f132a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "recent_routes_tickets_store"));
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        f(cityChangedEvent._city);
    }
}
