package app.zophop.engagement.airship;

import android.content.Context;
import app.zophop.R;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import defpackage.kl5;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: AirshipAutoPilot.kt */
public final class AirshipAutoPilot extends Autopilot {
    public Context c;

    @Override // com.urbanairship.Autopilot, com.urbanairship.UAirship.c
    public void a(UAirship uAirship) {
        n86.e(uAirship, "airship");
        super.a(uAirship);
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
        vv5 vv5 = uAirship.i;
        vv5.k.f("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED").b(String.valueOf(true));
        vv5.v.s();
        vv5 vv52 = uAirship.i;
        vv52.r.add(wz.f3863a);
        uAirship.i.p = new yz(this);
        uAirship.f716a = new vz(this);
        kp5 kp5 = UAirship.l().j;
        kp5.j.add(new xz());
        vz vzVar = UAirship.l().f716a;
        n86.j("onAirshipReady: channelId = ", UAirship.l().j.l());
    }

    @Override // com.urbanairship.Autopilot
    public AirshipConfigOptions f(Context context) {
        n86.e(context, "lContext");
        this.c = context;
        AirshipConfigOptions.b bVar = new AirshipConfigOptions.b();
        bVar.e = "VwSMIVqfTziFP9Foe25S1w";
        bVar.f = "ihsGoE4nS06XTV91GYESUA";
        bVar.c = "q4QkN2UcQ4i4TncRWgXyxQ";
        bVar.d = "BMt6lLXCQvOZCcNKYOqouQ";
        bVar.s = Boolean.TRUE;
        bVar.B = R.drawable.logo_notification;
        bVar.D = q5.b(context, R.color.orange_primary);
        bVar.F = "myChannel";
        bVar.M = true;
        n86.d(bVar, "Builder()\n              …pressAllowListError(true)");
        AirshipConfigOptions b = bVar.b();
        n86.d(b, "lConfigOptionsBuilder.build()");
        return b;
    }

    public final void onEvent(zz zzVar) {
        n86.e(zzVar, "lAirshipAnalyticsEvent");
        if (UAirship.u) {
            kl5.b bVar = new kl5.b(zzVar.f4231a);
            for (Map.Entry<String, Object> entry : zzVar.b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    bVar.g.put(key, JsonValue.x((String) value));
                } else if (value instanceof Integer) {
                    bVar.g.put(key, JsonValue.x(Integer.valueOf(((Number) value).intValue())));
                } else if (value instanceof Double) {
                    double doubleValue = ((Number) value).doubleValue();
                    if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                        throw new NumberFormatException("Infinity or NaN: " + doubleValue);
                    }
                    bVar.g.put(key, JsonValue.q(doubleValue));
                } else {
                    continue;
                }
            }
            UAirship.l().f.i(new kl5(bVar, null));
        }
    }

    public final void onEvent(ve1 ve1) {
        n86.e(ve1, "lFcmMessageReceived");
        if (UAirship.u) {
            Map<String, String> data = ve1.f3640a.getData();
            n86.d(data, "lFcmMessageReceived.remoteMessage.data");
            LinkedHashMap linkedHashMap = new LinkedHashMap(hd3.f2(data.size()));
            for (T t : data.entrySet()) {
                linkedHashMap.put((String) t.getKey(), t.getValue());
            }
            n86.j("remoteMessageReceived map = ", linkedHashMap);
            if (new PushMessage(ve1.f3640a.getData()).l()) {
                Context context = this.c;
                if (context != null) {
                    hd3.x2(context, ve1.f3640a);
                    jz5.b().m(ve1);
                    return;
                }
                n86.l(AnalyticsConstants.CONTEXT);
                throw null;
            }
        }
    }

    public final void onEvent(xe1 xe1) {
        n86.e(xe1, "lFcmTokenEvent");
        if (UAirship.u) {
            n86.j("fcmTokenEvent src : ", xe1.b);
            n86.j("fcmTokenEvent : ", xe1.f3920a);
            Context context = this.c;
            if (context != null) {
                hd3.y2(context.getApplicationContext(), xe1.f3920a);
            } else {
                n86.l(AnalyticsConstants.CONTEXT);
                throw null;
            }
        }
    }
}
