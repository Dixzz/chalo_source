package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopFavourite;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

/* renamed from: l80  reason: default package */
/* compiled from: StopRecentStore */
public class l80 implements h80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2184a;
    public rf1 b;
    public final mv c = new mv();

    public l80(Context context, City city) {
        this.f2184a = context;
        i(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.h80
    public void a(Stop stop) {
        if (stop != null) {
            Iterator it = ((ArrayList) g(stop.getMode())).iterator();
            while (it.hasNext()) {
                StopFavourite stopFavourite = (StopFavourite) ((Favourite) it.next());
                if (stopFavourite.match(stop.getId())) {
                    this.b.k(f(stopFavourite));
                }
            }
        }
    }

    @Override // defpackage.h80
    public void b(Favourite favourite) {
        favourite.increaseAccessCount();
        favourite.setTime(System.currentTimeMillis());
        String f = f(favourite);
        try {
            this.b.j(f, this.c.f((StopFavourite) favourite).toString());
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    @Override // defpackage.h80
    public List<StopFavourite> c(RouteStoreType routeStoreType) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.b.b().entrySet()) {
            try {
                arrayList.add(this.c.n((String) entry.getValue()));
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        return arrayList;
    }

    @Override // defpackage.h80
    public void d(Stop stop) {
        int i;
        boolean z;
        StopFavourite stopFavourite;
        String id = stop.getId();
        Iterator it = ((ArrayList) c(RouteStoreType.RECENT)).iterator();
        while (true) {
            i = 0;
            if (it.hasNext()) {
                if (((StopFavourite) it.next()).getStop().getId().equals(id)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            try {
                h(stop.getMode());
                StopFavourite stopFavourite2 = new StopFavourite(stop, UUID.randomUUID().toString(), System.currentTimeMillis(), RouteStoreType.RECENT);
                String jSONObject = this.c.f(stopFavourite2).toString();
                this.b.j(f(stopFavourite2), jSONObject);
            } catch (JSONException e) {
                stop.getName();
                stop.getId();
                stop.getMode().toString();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        } else {
            String id2 = stop.getId();
            ArrayList arrayList = (ArrayList) c(RouteStoreType.RECENT);
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    stopFavourite = null;
                    break;
                }
                stopFavourite = (StopFavourite) arrayList.get(i);
                if (stopFavourite.match(id2)) {
                    break;
                }
                i++;
            }
            b(stopFavourite);
        }
    }

    @Override // defpackage.h80
    public void e(Favourite favourite) {
        this.b.k(f(favourite));
    }

    public final String f(Favourite favourite) {
        return hj1.T(favourite.getMode().toString(), ProductDiscountsObject.KEY_DELIMITER, favourite.getId());
    }

    public final List<Favourite> g(TransitMode transitMode) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.b.b().entrySet()) {
            if (entry.getKey().contains(transitMode.toString())) {
                try {
                    arrayList.add(this.c.n((String) entry.getValue()));
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
            }
        }
        return arrayList;
    }

    public final void h(TransitMode transitMode) {
        ArrayList arrayList = (ArrayList) g(transitMode);
        int size = arrayList.size();
        if (size > 3) {
            long time = ((Favourite) arrayList.get(0)).getTime();
            String id = ((Favourite) arrayList.get(0)).getId();
            for (int i = 1; i < size; i++) {
                if (time > ((Favourite) arrayList.get(i)).getTime()) {
                    long time2 = ((Favourite) arrayList.get(i)).getTime();
                    id = ((Favourite) arrayList.get(i)).getId();
                    time = time2;
                }
            }
            rf1 rf1 = this.b;
            String transitMode2 = transitMode.toString();
            rf1.k(transitMode2 + ProductDiscountsObject.KEY_DELIMITER + id);
        }
    }

    public void i(City city) {
        if (city != null) {
            this.b = new rf1(this.f2184a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "stop_recent_store"));
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        i(cityChangedEvent._city);
    }
}
