package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.LastRideInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.pubsub.eventbus.events.CityChangedEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l10  reason: default package */
/* compiled from: FeedbackFeature */
public class l10 implements l20 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2149a;
    public rf1 b;

    public l10(Context context, City city) {
        this.f2149a = context;
        e(city);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.l20
    public void a(LastRideInfo lastRideInfo) {
        try {
            String c = c(lastRideInfo);
            if (c != null) {
                rf1 rf1 = this.b;
                rf1.f3075a.putString("lastRideInfo", c);
                rf1.f3075a.commit();
                int i = this.b.b.getInt("rideCount", 0);
                rf1 rf12 = this.b;
                rf12.f3075a.putInt("rideCount", i + 1);
                rf12.f3075a.commit();
            }
        } catch (Exception e) {
            e.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }

    @Override // defpackage.l20
    public LastRideInfo b() {
        String string;
        rf1 rf1 = this.b;
        if (!(rf1 == null || (string = rf1.b.getString("lastRideInfo", null)) == null)) {
            try {
                return d(string);
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        return null;
    }

    public final String c(LastRideInfo lastRideInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bookingId", lastRideInfo.getBookingId());
        jSONObject.put("productType", lastRideInfo.getProductType());
        jSONObject.put("activationTimeStamp", lastRideInfo.getActivationTimeStamp());
        jSONObject.put("activationDuration", lastRideInfo.getActivationDuration());
        return jSONObject.toString();
    }

    public final LastRideInfo d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        LastRideInfo lastRideInfo = new LastRideInfo();
        lastRideInfo.setBookingId(jSONObject.getString("bookingId"));
        lastRideInfo.setProductType(jSONObject.getString("productType"));
        lastRideInfo.setActivationTimeStamp(jSONObject.getLong("activationTimeStamp"));
        lastRideInfo.setActivationDuration(jSONObject.getLong("activationDuration"));
        return lastRideInfo;
    }

    public final void e(City city) {
        if (city != null) {
            this.b = new rf1(this.f2149a, hj1.T(city.getName().trim().toLowerCase(), ProductDiscountsObject.KEY_DELIMITER, "last_ride_store"));
        }
    }

    public void onEvent(CityChangedEvent cityChangedEvent) {
        e(cityChangedEvent._city);
    }
}
