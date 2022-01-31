package defpackage;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: mf1  reason: default package */
/* compiled from: DescriptiveLocation */
public class mf1 {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f2368a;
    public String b;
    public String c;
    public String d;

    public mf1(String str, String str2) {
        this.b = str;
        this.c = str;
        this.d = str2;
    }

    public static mf1 a(String str) {
        mf1 mf1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            double optDouble = jSONObject.optDouble("lat", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble2 = jSONObject.optDouble("long", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            String optString = jSONObject.optString("description", null);
            String optString2 = jSONObject.optString("placeId", null);
            String optString3 = jSONObject.optString(FirebaseAnalytics.Param.LOCATION, null);
            LatLng latLng = (optDouble == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || optDouble2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? null : new LatLng(optDouble, optDouble2);
            if (latLng == null) {
                mf1 = new mf1(optString3, optString2);
                if (optString != null) {
                    mf1.c = optString;
                }
            } else if (optString3 != null) {
                mf1 = new mf1(optString3, latLng);
                if (optString != null) {
                    mf1.c = optString;
                }
            } else {
                mf1 = optString != null ? new mf1(latLng, optString) : new mf1(latLng);
            }
        } catch (JSONException unused) {
            mf1 = null;
        }
        if (mf1 == null || (mf1.c == null && mf1.f2368a == null)) {
            return null;
        }
        return mf1;
    }

    public String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            LatLng latLng = this.f2368a;
            if (latLng != null) {
                jSONObject.put("lat", latLng.latitude);
                jSONObject.put("long", this.f2368a.longitude);
            }
            jSONObject.put(FirebaseAnalytics.Param.LOCATION, this.b);
            jSONObject.put("placeId", this.d);
            jSONObject.put("description", this.c);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || mf1.class != obj.getClass()) {
            return false;
        }
        mf1 mf1 = (mf1) obj;
        String str = this.b;
        if (str == null ? mf1.b != null : !str.equals(mf1.b)) {
            return false;
        }
        LatLng latLng = this.f2368a;
        LatLng latLng2 = mf1.f2368a;
        if (latLng != null) {
            return latLng.equals(latLng2);
        }
        if (latLng2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        LatLng latLng = this.f2368a;
        int i = 0;
        int hashCode = (latLng != null ? latLng.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public mf1(String str, LatLng latLng) {
        this.b = str;
        this.c = str;
        this.f2368a = latLng;
    }

    public mf1(LatLng latLng, String str) {
        this.f2368a = latLng;
        this.c = str;
    }

    public mf1(LatLng latLng) {
        this.f2368a = latLng;
    }
}
