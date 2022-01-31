package defpackage;

import android.util.Pair;
import app.zophop.models.Stop;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.http_response.SummaryResponse;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.SummaryResponseEvent;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.logging.LoggingConstants;
import zophop.models.SPECIAL_FEATURE;
import zophop.models.StatusMessage;

/* renamed from: uv  reason: default package */
/* compiled from: SummaryResponseConverter */
public class uv {
    public SummaryResponseEvent a(String str, JSONObject jSONObject) {
        SummaryResponseEvent.ResponseType responseType;
        ArrayList arrayList;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("payload");
            int ordinal = ((StatusMessage) new Gson().fromJson(jSONObject.getString("status"), StatusMessage.class)).ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    responseType = SummaryResponseEvent.ResponseType.NO_NEARBY_STOPS;
                } else if (ordinal == 2) {
                    responseType = SummaryResponseEvent.ResponseType.NO_TRIPS;
                } else if (ordinal != 3) {
                    responseType = SummaryResponseEvent.ResponseType.NO_TRIPS;
                } else {
                    responseType = SummaryResponseEvent.ResponseType.NO_TRIPS;
                }
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(c(optJSONArray.getJSONObject(i)));
                }
                responseType = SummaryResponseEvent.ResponseType.SUCCESS;
            }
            return new SummaryResponseEvent(str, null, responseType, arrayList);
        } catch (JSONException e) {
            e.toString();
            return new SummaryResponseEvent(str, null, SummaryResponseEvent.ResponseType.QUERY_FAILED, null);
        }
    }

    public List<TripSummary> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(d(jSONArray.getJSONObject(i)));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public final SummaryResponse c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("stop");
        double optDouble = jSONObject.optDouble(LoggingConstants.DISTANCE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("summary");
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(d(jSONArray.getJSONObject(i)));
        }
        return new SummaryResponse(new Stop(jSONObject2.getString("stop_id"), jSONObject2.getString("stop_name"), new LatLng(jSONObject2.getDouble("stop_lat"), jSONObject2.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject2.getString("station_type"))), optDouble, arrayList);
    }

    public TripSummary d(JSONObject jSONObject) throws JSONException {
        TripSummary tripSummary;
        tv tvVar = new tv();
        int i = jSONObject.getInt("arrival_time");
        String optString = jSONObject.optString("platform", null);
        JSONObject jSONObject2 = jSONObject.getJSONObject("trip");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("last_stop");
        String string = jSONObject2.getString("trip_id");
        String optString2 = jSONObject2.optString("agency_name", null);
        String optString3 = jSONObject2.optString("availabilityLevel", null);
        JSONObject jSONObject4 = jSONObject2.getJSONObject("direction_stop");
        JSONObject jSONObject5 = jSONObject2.getJSONObject("first_stop");
        String string2 = jSONObject2.getString("route_id");
        String optString4 = jSONObject2.optString("route_name", null);
        boolean optBoolean = jSONObject2.optBoolean("isFrequencyTrip", false);
        ArrayList arrayList = new ArrayList();
        int optInt = jSONObject2.optInt("ttStatus", 0);
        if (!x61.r(optInt)) {
            optInt = x61.o(optInt);
        }
        int optInt2 = jSONObject2.optInt("ttSid", 0);
        Gson gson = new Gson();
        int i2 = 0;
        for (JSONArray jSONArray = jSONObject2.getJSONArray("special_features"); i2 < jSONArray.length(); jSONArray = jSONArray) {
            arrayList.add((SPECIAL_FEATURE) gson.fromJson(jSONArray.getString(i2), SPECIAL_FEATURE.class));
            i2++;
        }
        if (optBoolean) {
            JSONArray jSONArray2 = jSONObject2.getJSONArray("frequency_data_array");
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < jSONArray2.length()) {
                JSONObject jSONObject6 = jSONArray2.getJSONObject(i3);
                Integer valueOf = Integer.valueOf(jSONObject6.getInt("start_time"));
                Integer valueOf2 = Integer.valueOf(jSONObject6.getInt("end_time"));
                arrayList2.add(new Pair(new TimeInterval(valueOf, valueOf2), Integer.valueOf(jSONObject6.getInt("frequency"))));
                i3++;
                jSONArray2 = jSONArray2;
                optString3 = optString3;
            }
            tripSummary = new TripSummary(string, i, tvVar.a(jSONObject5), tvVar.a(jSONObject3), tvVar.a(jSONObject4), string2, optString4, true, arrayList, optString3);
            tripSummary.setFrequencyList(arrayList2);
        } else {
            tripSummary = new TripSummary(string, i, tvVar.a(jSONObject5), tvVar.a(jSONObject3), tvVar.a(jSONObject4), string2, optString4, false, arrayList, optString3);
        }
        tripSummary.setPlatform(optString);
        tripSummary.setAgencyName(optString2);
        tripSummary.setTtStatus(optInt);
        tripSummary.setTtStatusId(optInt2);
        return tripSummary;
    }
}
