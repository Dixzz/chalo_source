package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.RouteSubscriptionInfo;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import app.zophop.pubsub.eventbus.events.FavoriteChanged;
import com.google.firebase.messaging.Constants;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

/* renamed from: c80  reason: default package */
/* compiled from: FavoriteStore */
public class c80 implements f80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f532a;
    public rf1 b;
    public rf1 c;
    public rf1 d;
    public rf1 e;
    public final mv f = new mv();

    /* renamed from: c80$a */
    /* compiled from: FavoriteStore */
    public class a implements Comparator<Favourite>, j$.util.Comparator {
        public a(c80 c80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Favourite favourite, Favourite favourite2) {
            Favourite favourite3 = favourite;
            Favourite favourite4 = favourite2;
            if (favourite3.getAccessCount() > favourite4.getAccessCount()) {
                return -1;
            }
            return favourite3.getAccessCount() < favourite4.getAccessCount() ? 1 : 0;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<Favourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<Favourite> thenComparing(java.util.Comparator<? super Favourite> comparator) {
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

    /* renamed from: c80$b */
    /* compiled from: FavoriteStore */
    public class b implements java.util.Comparator<Favourite>, j$.util.Comparator {
        public b(c80 c80) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(Favourite favourite, Favourite favourite2) {
            Favourite favourite3 = favourite;
            Favourite favourite4 = favourite2;
            if (favourite3.getTime() > favourite4.getTime()) {
                return -1;
            }
            return favourite3.getTime() < favourite4.getTime() ? 1 : 0;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<Favourite> reversed() {
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
        public /* synthetic */ java.util.Comparator<Favourite> thenComparing(java.util.Comparator<? super Favourite> comparator) {
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

    public c80(Context context, City city) {
        this.f532a = context.getApplicationContext();
        u(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public static void q(String str, String str2, String str3, String str4, TransitMode transitMode, boolean z) {
        ed1 ed1;
        if (z) {
            ed1 = new ed1("favorite added", Long.MIN_VALUE);
        } else {
            ed1 = new ed1("favorite deleted", Long.MIN_VALUE);
        }
        ed1.a("mode", transitMode.name());
        ed1.a("route", str2);
        ed1.a(Constants.MessagePayloadKeys.FROM, str3);
        hj1.p(ed1, "to", str4, "source", str).g(ed1);
    }

    public void a(Favourite favourite, RouteStoreType routeStoreType) {
        String str;
        String i = i(favourite);
        favourite.setRouteStoreType(routeStoreType);
        try {
            if (favourite instanceof BusFavouriteWithSubscription) {
                str = this.f.d((BusFavouriteWithSubscription) favourite).toString();
            } else if (favourite instanceof BusFavourite) {
                str = this.f.c((BusFavourite) favourite).toString();
            } else {
                str = favourite instanceof RailFavourite ? this.f.e((RailFavourite) favourite).toString() : null;
            }
            if (routeStoreType.equals(RouteStoreType.FAVORITE)) {
                this.b.j(i, str);
            } else if (routeStoreType.equals(RouteStoreType.RECENT)) {
                this.c.j(i, str);
            } else if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
                this.d.j(i, str);
            }
            jz5.b().g(new FavoriteChanged(favourite, true));
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
    }

    public void b(RouteSubscriptionInfo routeSubscriptionInfo) {
        try {
            this.e.j(routeSubscriptionInfo.getRouteId(), this.f.g(routeSubscriptionInfo).toString());
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
    }

    public void c(String str, String str2, String str3, String str4, Stop stop, String str5) {
        RouteStoreType routeStoreType = RouteStoreType.RECENT;
        boolean z = true;
        if (h(str, routeStoreType) != null) {
            r(h(str, routeStoreType), routeStoreType);
        }
        RouteStoreType routeStoreType2 = RouteStoreType.FAVORITE;
        if (h(str, routeStoreType2) == null) {
            z = false;
        }
        if (!z) {
            try {
                BusFavourite busFavourite = new BusFavourite(str, str2, str3, str4, UUID.randomUUID().toString(), 0, routeStoreType2, str5, null, false);
                this.b.j(i(busFavourite), this.f.c(busFavourite).toString());
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
    }

    public void d(String str, String str2, String str3, String str4, Stop stop, String str5, List<String> list, boolean z, TransitMode transitMode) {
        boolean z2 = true;
        if (!(h(str, RouteStoreType.FAVORITE) != null)) {
            RouteStoreType routeStoreType = RouteStoreType.RECENT;
            if (h(str, routeStoreType) == null) {
                z2 = false;
            }
            if (!z2) {
                try {
                    String uuid = UUID.randomUUID().toString();
                    TransitMode transitMode2 = TransitMode.bus;
                    if (transitMode.equals(transitMode2)) {
                        BusFavourite busFavourite = new BusFavourite(str, str2, str3, str4, uuid, System.currentTimeMillis(), routeStoreType, str5, list, z);
                        this.c.j(i(busFavourite), this.f.c(busFavourite).toString());
                        s(transitMode2);
                    }
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
            }
        }
    }

    public void e(Favourite favourite) {
        favourite.setTime(System.currentTimeMillis());
        a(favourite, favourite.getRouteStoreType());
    }

    public List<Favourite> f(RouteStoreType routeStoreType) {
        Map<String, ?> map;
        Favourite favourite;
        ArrayList arrayList = new ArrayList();
        if (routeStoreType.equals(RouteStoreType.FAVORITE)) {
            map = this.b.b();
        } else if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
            map = this.d.b();
        } else {
            map = this.c.b();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            String str = (String) entry.getValue();
            try {
                if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
                    favourite = this.f.p(str);
                } else if (key.contains(TransitMode.bus.toString())) {
                    favourite = this.f.a(str);
                } else {
                    favourite = this.f.k(str);
                }
                arrayList.add(favourite);
                t(str, favourite);
            } catch (JSONException e2) {
                e2.getLocalizedMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return arrayList;
    }

    public Favourite g(Stop stop, Stop stop2, RouteStoreType routeStoreType) {
        List<Favourite> f2 = f(routeStoreType);
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) f2;
            if (i >= arrayList.size()) {
                return null;
            }
            Favourite favourite = (Favourite) arrayList.get(i);
            if ((favourite instanceof RailFavourite) && ((RailFavourite) favourite).match(stop, stop2)) {
                return favourite;
            }
            i++;
        }
    }

    public Favourite h(String str, RouteStoreType routeStoreType) {
        ArrayList arrayList = (ArrayList) j(TransitMode.bus, routeStoreType);
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add((BusFavourite) arrayList.get(i));
        }
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            BusFavourite busFavourite = (BusFavourite) arrayList2.get(i2);
            if (busFavourite.match(str)) {
                return busFavourite;
            }
        }
        return null;
    }

    public final String i(Favourite favourite) {
        return hj1.T(favourite.getMode().toString(), ProductDiscountsObject.KEY_DELIMITER, favourite.getId());
    }

    public List<Favourite> j(TransitMode transitMode, RouteStoreType routeStoreType) {
        Map<String, ?> map;
        ArrayList arrayList = new ArrayList();
        if (routeStoreType.equals(RouteStoreType.FAVORITE)) {
            map = this.b.b();
        } else if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
            map = this.d.b();
        } else {
            map = this.c.b();
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getKey().contains(transitMode.toString())) {
                String str = (String) entry.getValue();
                try {
                    if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
                        BusFavouriteWithSubscription p = this.f.p(str);
                        arrayList.add(p);
                        t(str, p);
                    } else if (transitMode.equals(TransitMode.bus)) {
                        BusFavourite a2 = this.f.a(str);
                        arrayList.add(a2);
                        t(str, a2);
                    } else {
                        RailFavourite k = this.f.k(str);
                        arrayList.add(k);
                        t(str, k);
                    }
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
            }
        }
        return arrayList;
    }

    public final String k(City city, String str) {
        return hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, str);
    }

    public List<Favourite> l(List<Favourite> list) {
        Collections.sort(list, new a(this));
        return list;
    }

    public List<Favourite> m(List<Favourite> list) {
        Collections.sort(list, new b(this));
        return list;
    }

    public void n(Favourite favourite) {
        favourite.increaseAccessCount();
        a(favourite, favourite.getRouteStoreType());
    }

    public boolean o(Stop stop, Stop stop2, RouteStoreType routeStoreType) {
        return g(stop, stop2, routeStoreType) != null;
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        u(cityChangedEvent._city);
    }

    public boolean p(String str, RouteStoreType routeStoreType) {
        return h(str, routeStoreType) != null;
    }

    public void r(Favourite favourite, RouteStoreType routeStoreType) {
        String i = i(favourite);
        if (routeStoreType.equals(RouteStoreType.FAVORITE)) {
            String i2 = i(favourite);
            favourite.setTime(System.currentTimeMillis());
            favourite.setRouteStoreType(RouteStoreType.RECENT);
            if (favourite.getMode().equals(TransitMode.bus)) {
                try {
                    this.c.j(i2, this.f.c((BusFavourite) favourite).toString());
                    s(favourite.getMode());
                } catch (JSONException unused) {
                }
            } else {
                this.c.j(i2, this.f.e((RailFavourite) favourite).toString());
                s(favourite.getMode());
            }
            this.b.k(i);
            if (this.d.a(i)) {
                r(favourite, RouteStoreType.SUBSCRIBED);
            }
        } else if (routeStoreType.equals(RouteStoreType.SUBSCRIBED)) {
            this.d.k(i);
        } else {
            this.c.k(i);
        }
        jz5.b().g(new FavoriteChanged(favourite, false));
    }

    public final void s(TransitMode transitMode) {
        ArrayList arrayList = (ArrayList) j(transitMode, RouteStoreType.RECENT);
        int size = arrayList.size();
        String str = transitMode + " " + size;
        if (size > 3) {
            long time = ((Favourite) arrayList.get(0)).getTime();
            String id = ((Favourite) arrayList.get(0)).getId();
            for (int i = 1; i < size; i++) {
                if (time > ((Favourite) arrayList.get(i)).getTime()) {
                    time = ((Favourite) arrayList.get(i)).getTime();
                    id = ((Favourite) arrayList.get(i)).getId();
                }
            }
            this.c.k(transitMode.toString() + ProductDiscountsObject.KEY_DELIMITER + id);
            String str2 = transitMode + " " + ((ArrayList) j(transitMode, RouteStoreType.RECENT)).size();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(java.lang.String r5, app.zophop.models.Favourites.Favourite r6) throws org.json.JSONException {
        /*
            r4 = this;
            mv r0 = r4.f
            java.util.Objects.requireNonNull(r0)
            java.lang.String r1 = "_fromStop"
            java.lang.String r2 = "_toStop"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0032 }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x0032 }
            boolean r5 = r3.has(r2)     // Catch:{ JSONException -> 0x0032 }
            if (r5 == 0) goto L_0x001f
            java.lang.String r5 = r3.getString(r2)     // Catch:{ JSONException -> 0x0032 }
            boolean r5 = r0.r(r5)     // Catch:{ JSONException -> 0x0032 }
            if (r5 == 0) goto L_0x001f
            goto L_0x0032
        L_0x001f:
            boolean r5 = r3.has(r1)     // Catch:{ JSONException -> 0x0032 }
            if (r5 == 0) goto L_0x0030
            java.lang.String r5 = r3.getString(r1)     // Catch:{ JSONException -> 0x0032 }
            boolean r5 = r0.r(r5)     // Catch:{ JSONException -> 0x0032 }
            if (r5 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r5 = 0
            goto L_0x0033
        L_0x0032:
            r5 = 1
        L_0x0033:
            if (r5 == 0) goto L_0x003c
            app.zophop.models.Favourites.RouteStoreType r5 = r6.getRouteStoreType()
            r4.a(r6, r5)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c80.t(java.lang.String, app.zophop.models.Favourites.Favourite):void");
    }

    public void u(City city) {
        if (city != null) {
            this.b = new rf1(this.f532a, k(city, "fav"));
            this.c = new rf1(this.f532a, k(city, "route_recent_store"));
            this.d = new rf1(this.f532a, k(city, "route_subscribed_store"));
            this.e = new rf1(this.f532a, k(city, "route_subscription_info_store"));
        }
    }
}
