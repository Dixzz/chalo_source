package defpackage;

import android.net.Uri;
import app.zophop.models.City;
import app.zophop.models.UniversalSearchItem;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: n50  reason: default package */
/* compiled from: UniversalSearchAutocompleteHelper */
public class n50 extends ld1<UniversalSearchItem> {
    public String b(String str) throws Exception {
        xt.t1 t1Var = xt.f3961a;
        City d = t1Var.k().d();
        LatLng h = t1Var.B().h();
        if (h == null || !d.containsLocation(h)) {
            h = d.getCenter();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lat", h.latitude);
        jSONObject.put("lon", h.longitude);
        Uri.Builder appendQueryParameter = new Uri.Builder().encodedPath(ut.d).appendPath(d.getName().toUpperCase()).appendPath("search").appendQueryParameter("str", str).appendQueryParameter("day", vn.I()).appendQueryParameter("station_type", "transit").appendQueryParameter(FirebaseAnalytics.Param.LOCATION, jSONObject.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("deviceId", t1Var.m0());
            jSONObject2.put("androidVersionCode", 764);
            if (t1Var.z() != null) {
                jSONObject2.put("language", t1Var.z().a());
            }
        } catch (JSONException unused) {
            jSONObject2 = null;
        }
        return appendQueryParameter.appendQueryParameter("meta", jSONObject2.toString()).build().toString();
    }

    public final List<UniversalSearchItem> c(UniversalSearchItem.UniversalSearchItemType universalSearchItemType, JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new UniversalSearchItem(universalSearchItemType, jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
