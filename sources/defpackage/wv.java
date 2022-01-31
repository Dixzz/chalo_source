package defpackage;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: wv  reason: default package */
/* compiled from: TripResponseConverter */
public class wv {
    public Trip a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = jSONObject.getJSONObject("trip");
        String string = jSONObject2.getString("trip_id");
        TransitMode transitMode = TransitMode.getTransitMode(jSONObject2.getString("transport_type"));
        JSONArray jSONArray = jSONObject2.getJSONArray("special_features");
        ArrayList arrayList2 = new ArrayList();
        Gson gson = new Gson();
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList2.add((SPECIAL_FEATURE) gson.fromJson(jSONArray.getString(i2), SPECIAL_FEATURE.class));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("stop_sequence");
        while (i < jSONArray2.length()) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
            JSONObject jSONObject4 = jSONObject3.getJSONObject("stop");
            int i3 = jSONObject3.getInt("arrival_time");
            String optString = jSONObject3.optString("platform", null);
            TripLeg tripLeg = new TripLeg(new Stop(jSONObject4.getString("stop_id"), jSONObject4.getString("stop_name"), new LatLng(jSONObject4.getDouble("stop_lat"), jSONObject4.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject4.getString("station_type"))), i3);
            tripLeg.setPlatform(optString);
            arrayList.add(tripLeg);
            i++;
            jSONArray2 = jSONArray2;
            jSONObject2 = jSONObject2;
            string = string;
        }
        Trip trip = new Trip(string, transitMode, arrayList, arrayList2);
        trip.set_routeId(jSONObject2.getString("route_id"));
        return trip;
    }
}
