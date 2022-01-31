package defpackage;

import app.zophop.models.EtaUpdateInfo;
import app.zophop.models.LiveFeed;
import app.zophop.models.LocationUpdateInfo;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: nv  reason: default package */
/* compiled from: LiveFeedConvertor */
public class nv {
    public LiveFeed a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = jSONObject.getJSONObject("status");
        boolean z = jSONObject2.getBoolean("extrapolated");
        boolean z2 = jSONObject2.getBoolean("stopsEta");
        boolean z3 = jSONObject2.getBoolean("vehicle");
        if (z2) {
            JSONArray jSONArray = jSONObject.getJSONArray("stopsEta");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList2 = new ArrayList();
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JSONArray jSONArray2 = jSONObject3.getJSONArray("eta");
                String string = jSONObject3.getString("stopId");
                int i2 = 0;
                while (i2 < jSONArray2.length()) {
                    JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                    arrayList2.add(new EtaUpdateInfo(jSONObject4.getInt("eta"), jSONObject4.getLong("timestamp")));
                    i2++;
                    arrayList2 = arrayList2;
                }
                hashMap.put(string, arrayList2);
            }
        }
        if (z3) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("vehicle");
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                JSONObject jSONObject5 = jSONArray3.getJSONObject(i3);
                long j = jSONObject5.getLong("lastUpdated");
                JSONObject jSONObject6 = jSONObject5.getJSONObject(FirebaseAnalytics.Param.LOCATION);
                arrayList.add(new LocationUpdateInfo(new LatLng(jSONObject6.getDouble("lat"), jSONObject6.getDouble("lon")), j));
            }
        }
        return new LiveFeed(z, hashMap, arrayList);
    }
}
