package defpackage;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: v50  reason: default package */
/* compiled from: UrlConstantsUpdater */
public class v50 {
    public static v50 b;

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f3600a;

    public v50(Context context) {
        this.f3600a = new rf1(context, "url_store");
    }

    public void a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("cab_base");
            String string2 = jSONObject.getString("firebase");
            String string3 = jSONObject.getString("firebase_app_id");
            String string4 = jSONObject.getString("mobileticketing");
            String string5 = jSONObject.getString("gcm_id");
            String string6 = jSONObject.getString("exchangeName");
            String string7 = jSONObject.getString("uber_booking");
            String string8 = jSONObject.getString("map_api_key");
            rf1 rf1 = this.f3600a;
            rf1.f3075a.putString("cab_base", string);
            rf1.f3075a.commit();
            rf1 rf12 = this.f3600a;
            rf12.f3075a.putString("firebase", string2);
            rf12.f3075a.commit();
            rf1 rf13 = this.f3600a;
            rf13.f3075a.putString("firebase_app_id", string3);
            rf13.f3075a.commit();
            rf1 rf14 = this.f3600a;
            rf14.f3075a.putString("mobileticketing", string4);
            rf14.f3075a.commit();
            rf1 rf15 = this.f3600a;
            rf15.f3075a.putString("gcm_id", string5);
            rf15.f3075a.commit();
            rf1 rf16 = this.f3600a;
            rf16.f3075a.putString("exchangeName", string6);
            rf16.f3075a.commit();
            rf1 rf17 = this.f3600a;
            rf17.f3075a.putString("uber_booking", string7);
            rf17.f3075a.commit();
            rf1 rf18 = this.f3600a;
            rf18.f3075a.putString("map_api_key", string8);
            rf18.f3075a.commit();
            rf1 rf19 = this.f3600a;
            rf19.f3075a.putBoolean("url_avl_key", true);
            rf19.f3075a.commit();
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            hj1.W0(e);
        }
    }
}
