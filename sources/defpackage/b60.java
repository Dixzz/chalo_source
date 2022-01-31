package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;

/* renamed from: b60  reason: default package */
/* compiled from: ZophopSavedDestinationFeature */
public class b60 extends ee1 {
    public rf1 e;
    public rf1 f;
    public rf1 g;

    public b60(Context context, City city, je1 je1) {
        this.f964a = context.getApplicationContext();
        this.b = je1;
        p(city);
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
    }

    @Override // defpackage.ee1
    public rf1 f() {
        return this.e;
    }

    @Override // defpackage.ee1
    public rf1 g() {
        return this.f;
    }

    @Override // defpackage.ee1
    public rf1 i() {
        return this.g;
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        p(cityChangedEvent._city);
    }

    public void p(City city) {
        if (city != null) {
            this.e = new rf1(this.f964a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "fav_locations"));
            this.f = new rf1(this.f964a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "homework"));
            this.g = new rf1(this.f964a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "recent_store"));
        }
    }
}
