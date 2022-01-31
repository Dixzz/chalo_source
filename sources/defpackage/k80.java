package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.Favourites.RecentTripConvertor;
import app.zophop.models.Favourites.RecentTrips;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* renamed from: k80  reason: default package */
/* compiled from: SaveTripFeature */
public class k80 implements g80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2034a;
    public rf1 b;

    public k80(Context context, City city) {
        this.f2034a = context;
        e(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
    }

    @Override // defpackage.g80
    public void a(mf1 mf1, mf1 mf12) {
        try {
            RecentTrips recentTrips = new RecentTrips(mf1, mf12, System.currentTimeMillis());
            this.b.j(d(recentTrips), new RecentTripConvertor().getJsonObject(recentTrips).toString());
        } catch (JSONException unused) {
        }
    }

    @Override // defpackage.g80
    public List<RecentTrips> b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.b.b().entrySet()) {
            try {
                String f = this.b.f(entry.getKey(), null);
                new RecentTripConvertor();
                arrayList.add(RecentTripConvertor.convertFromJson(f));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    @Override // defpackage.g80
    public void c(RecentTrips recentTrips) {
        String d = d(recentTrips);
        recentTrips.setTimeStamp(System.currentTimeMillis());
        try {
            this.b.j(d, new RecentTripConvertor().getJsonObject(recentTrips).toString());
        } catch (JSONException unused) {
        }
    }

    public final String d(RecentTrips recentTrips) {
        return recentTrips.getFromLocation().c + "" + recentTrips.getToLocation().c;
    }

    public final void e(City city) {
        if (city != null) {
            this.b = new rf1(this.f2034a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "fav_trips_search"));
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        e(cityChangedEvent._city);
    }
}
