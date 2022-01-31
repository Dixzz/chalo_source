package defpackage;

import android.util.Pair;
import app.zophop.models.FrequencyRoute;
import app.zophop.models.FrequencyTripInfo;
import app.zophop.models.Route;
import app.zophop.models.RouteInfo;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.TripInfo;
import app.zophop.models.TripRoute;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: rv  reason: default package */
/* compiled from: RouteInfoConverter */
public class rv {
    public List<Pair<TimeInterval, Integer>> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(f(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public Route b(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        ArrayList arrayList;
        Route.RouteTiming routeTiming;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(DigitalTripReceiptJsonKeys.KEY_TRIPS);
        JSONObject jSONObject2 = jSONObject.getJSONObject("route");
        JSONArray jSONArray = jSONObject.getJSONArray("timeTable");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("special_features");
        JSONArray optJSONArray3 = jSONObject2.optJSONArray("spf");
        int i = 0;
        for (JSONArray jSONArray2 = jSONObject2.getJSONArray("stopSequenceWithDetails"); i < jSONArray2.length(); jSONArray2 = jSONArray2) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
            arrayList2.add(new Stop(jSONObject3.getString("stop_id"), jSONObject3.getString("stop_name"), new LatLng(jSONObject3.getDouble("stop_lat"), jSONObject3.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject3.getString("station_type"))));
            i++;
            optJSONArray = optJSONArray;
            jSONArray = jSONArray;
        }
        JSONArray jSONArray3 = jSONArray;
        int i2 = 0;
        while (optJSONArray2 != null && i2 < optJSONArray2.length()) {
            arrayList3.add(SPECIAL_FEATURE.getSpecialFeature(optJSONArray2.getString(i2)));
            i2++;
        }
        int i3 = 0;
        while (optJSONArray3 != null && i3 < optJSONArray3.length()) {
            arrayList4.add((String) optJSONArray3.get(i3));
            i3++;
        }
        JSONObject jSONObject4 = jSONObject2.getJSONObject("direction_stop");
        Stop stop = new Stop(jSONObject4.getString("stop_id"), jSONObject4.getString("stop_name"), new LatLng(jSONObject4.getDouble("stop_lat"), jSONObject4.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject4.getString("station_type")));
        String string = jSONObject2.getString("route_name");
        String string2 = jSONObject2.getString("route_id");
        String string3 = jSONObject2.getString("agency_name");
        TransitMode transitMode = TransitMode.getTransitMode(jSONObject2.getString("station_type"));
        boolean z3 = jSONObject2.getBoolean("hasFrequencyTrips");
        boolean z4 = jSONObject2.getBoolean("ticketingAllowed");
        String optString = jSONObject2.optString("polyline");
        boolean optBoolean = jSONObject2.optBoolean("mTicketEnabled", false);
        boolean optBoolean2 = jSONObject2.optBoolean("isFreeRide", false);
        long optLong = jSONObject2.optLong("availabilityLevel", 2);
        boolean optBoolean3 = jSONObject2.optBoolean("il", true);
        jSONObject2.optBoolean("isHalted", false);
        int optInt = jSONObject2.optInt("so", 0);
        boolean optBoolean4 = jSONObject2.optBoolean("d", false);
        boolean optBoolean5 = jSONObject2.optBoolean("routePassEnabled", false);
        int optInt2 = jSONObject2.optInt("ttStatus", 0);
        if (!x61.r(optInt2)) {
            optInt2 = x61.o(optInt2);
        }
        int optInt3 = jSONObject2.optInt("ttSid", 0);
        ArrayList arrayList5 = new ArrayList();
        HashMap hashMap = new HashMap();
        int i4 = 0;
        while (i4 < jSONArray3.length()) {
            JSONObject jSONObject5 = jSONArray3.getJSONObject(i4);
            if (jSONObject5.getBoolean("isFrequency")) {
                arrayList = arrayList3;
                routeTiming = new Route.RouteTiming(f(jSONObject5.getJSONObject("frequency_tuple")));
                z = optBoolean;
                z2 = optBoolean2;
            } else {
                arrayList = arrayList3;
                Integer valueOf = Integer.valueOf(jSONObject5.getInt("start_time"));
                z2 = optBoolean2;
                z = optBoolean;
                Route.RouteTiming routeTiming2 = new Route.RouteTiming(valueOf.intValue(), null);
                hashMap.put(valueOf, routeTiming2);
                routeTiming = routeTiming2;
            }
            arrayList5.add(routeTiming);
            i4++;
            arrayList4 = arrayList4;
            jSONArray3 = jSONArray3;
            arrayList3 = arrayList;
            optBoolean2 = z2;
            optBoolean = z;
        }
        if (z3) {
            FrequencyRoute frequencyRoute = new FrequencyRoute(string2, string, transitMode, arrayList2, stop, (FrequencyTripInfo) g(optJSONArray.getJSONObject(0)), arrayList5, string3, z4, optBoolean, optBoolean5, optBoolean2, optString, arrayList3, arrayList4);
            frequencyRoute.setAvailabilityStatus(optLong);
            frequencyRoute.setDisruption(optBoolean4);
            frequencyRoute.setLive(optBoolean3);
            frequencyRoute.setSeatAvailability(optInt);
            frequencyRoute.setTtStatus(optInt2);
            frequencyRoute.setTtStatusId(optInt3);
            return frequencyRoute;
        }
        long j = optLong;
        int i5 = 0;
        ArrayList arrayList6 = new ArrayList();
        while (i5 < optJSONArray.length()) {
            TripInfo g = g(optJSONArray.getJSONObject(i5));
            arrayList6.add(g);
            if (hashMap.containsKey(Integer.valueOf(g.getStartTime()))) {
                ((Route.RouteTiming) hashMap.get(Integer.valueOf(g.getStartTime()))).setTripId(g.getTripId());
            }
            i5++;
            j = j;
        }
        TripRoute tripRoute = new TripRoute(string2, string, transitMode, arrayList2, stop, arrayList6, arrayList5, string3, z4, optBoolean, optBoolean5, optBoolean2, optString, arrayList3, arrayList4);
        tripRoute.setAvailabilityStatus(j);
        tripRoute.setDisruption(optBoolean4);
        tripRoute.setLive(optBoolean3);
        tripRoute.setSeatAvailability(optInt);
        tripRoute.setTtStatus(optInt2);
        tripRoute.setTtStatusId(optInt3);
        return tripRoute;
    }

    public RouteInfo c(DataSnapshot dataSnapshot, String str, TransitMode transitMode) {
        boolean z;
        boolean z2;
        boolean z3;
        if (dataSnapshot.child("name").getValue() == null) {
            b00 b00 = b00.f358a;
            b00.a().b(new Throwable(hj1.S("Crashing for id ==> ", str)));
        }
        String E = hj1.E(dataSnapshot, "name");
        String E2 = hj1.E(dataSnapshot, "ag");
        String E3 = hj1.E(dataSnapshot, "f");
        String E4 = hj1.E(dataSnapshot, "l");
        boolean z4 = true;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        ArrayList arrayList3 = new ArrayList();
        if (dataSnapshot.hasChild("seq")) {
            Iterator q0 = hj1.q0(dataSnapshot, "seq");
            while (q0.hasNext()) {
                arrayList3.add(((DataSnapshot) q0.next()).getValue().toString());
            }
        }
        if (dataSnapshot.hasChild("sf")) {
            Iterator q02 = hj1.q0(dataSnapshot, "sf");
            while (q02.hasNext()) {
                arrayList.add(SPECIAL_FEATURE.valueOf(((DataSnapshot) q02.next()).getValue().toString()));
            }
        }
        if (dataSnapshot.hasChild("spf")) {
            Iterator q03 = hj1.q0(dataSnapshot, "spf");
            while (q03.hasNext()) {
                arrayList2.add(((DataSnapshot) q03.next()).getValue().toString());
            }
        }
        boolean z5 = dataSnapshot.hasChild("mobileTicketing") && ((Boolean) dataSnapshot.child("mobileTicketing").getValue()).booleanValue();
        if (dataSnapshot.hasChild("mTicketEnabled")) {
            z = dataSnapshot.child("mTicketEnabled").getValue() != null && Boolean.parseBoolean(dataSnapshot.child("mTicketEnabled").getValue().toString());
        } else {
            z = false;
        }
        if (dataSnapshot.hasChild("isFreeRide")) {
            z2 = dataSnapshot.child("isFreeRide").getValue() != null && Boolean.parseBoolean(dataSnapshot.child("isFreeRide").getValue().toString());
        } else {
            z2 = false;
        }
        String E5 = dataSnapshot.hasChild("poly") ? hj1.E(dataSnapshot, "poly") : "";
        if (dataSnapshot.hasChild("routePassEnabled")) {
            if (dataSnapshot.child("routePassEnabled").getValue() == null || !Boolean.parseBoolean(dataSnapshot.child("routePassEnabled").getValue().toString())) {
                z4 = false;
            }
            z3 = z4;
        } else {
            z3 = false;
        }
        return new RouteInfo(str, transitMode, E, E3, E4, E4, E2, arrayList, arrayList2, arrayList3, z5, z, z2, z3, E5);
    }

    public List<RouteInfo> d(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(h(jSONArray.getJSONObject(i)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public RouteInfo e(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString(LoggingConstants.FIRST_STOP);
            String string4 = jSONObject.getString(LoggingConstants.LAST_STOP);
            String string5 = jSONObject.getString("agency");
            boolean optBoolean = jSONObject.optBoolean("isAc", false);
            TransitMode transitMode = TransitMode.getTransitMode(jSONObject.getString("mode"));
            String optString = jSONObject.optString("polyline");
            JSONArray optJSONArray = jSONObject.optJSONArray("spf");
            ArrayList arrayList = new ArrayList(1);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(String.valueOf(optJSONArray.get(i)));
                }
            }
            ArrayList arrayList2 = new ArrayList(1);
            if (optBoolean) {
                arrayList2.add(SPECIAL_FEATURE.AC);
            }
            return new RouteInfo(string, transitMode, string2, string3, string4, string4, string5, arrayList2, arrayList, null, false, jSONObject.optBoolean("mTicketEnabled", false), jSONObject.optBoolean("isFreeRide", false), jSONObject.optBoolean("routePassEnabled", false), optString);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Pair<TimeInterval, Integer> f(JSONObject jSONObject) throws JSONException {
        Integer valueOf = Integer.valueOf(jSONObject.getInt("start_time"));
        Integer valueOf2 = Integer.valueOf(jSONObject.getInt("end_time"));
        return new Pair<>(new TimeInterval(valueOf, valueOf2), Integer.valueOf(jSONObject.getInt("frequency")));
    }

    public final TripInfo g(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("trip_id");
        int optInt = jSONObject.optInt("start_time");
        int optInt2 = jSONObject.optInt("end_time");
        int optInt3 = jSONObject.optInt("trip_duration");
        boolean z = jSONObject.getBoolean("isFrequencyTrip");
        if (z) {
            return new FrequencyTripInfo(string, z, a(jSONObject.getJSONArray("frequency_data_array")));
        }
        return new TripInfo(string, optInt, optInt2, optInt3, z);
    }

    public RouteInfo h(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("route_id");
        String string2 = jSONObject.getString("route_name");
        String string3 = jSONObject.getString("transport_type");
        String string4 = jSONObject.getString("first_stop_name");
        String string5 = jSONObject.getString("last_stop_name");
        String string6 = jSONObject.getString("direction_stop_name");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String string7 = jSONObject.getString("agency_name");
        JSONArray optJSONArray = jSONObject.optJSONArray("special_features");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("spf");
        if (optJSONArray != null) {
            Gson gson = new Gson();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add((SPECIAL_FEATURE) gson.fromJson(optJSONArray.getString(i), SPECIAL_FEATURE.class));
            }
        }
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                arrayList2.add((String) optJSONArray2.get(i2));
            }
        }
        return new RouteInfo(string, TransitMode.getTransitMode(string3), string2, string4, string5, string6, string7, arrayList, arrayList2, null, jSONObject.has("mobileTicketing") && jSONObject.getBoolean("mobileTicketing"), jSONObject.optBoolean("mTicketEnabled", false), jSONObject.optBoolean("isFreeRide", false), jSONObject.optBoolean("routePassEnabled", false), jSONObject.optString("poly", ""));
    }
}
