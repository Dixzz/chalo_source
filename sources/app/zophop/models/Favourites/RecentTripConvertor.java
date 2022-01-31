package app.zophop.models.Favourites;

import org.json.JSONException;
import org.json.JSONObject;

public class RecentTripConvertor {
    public static final String KEY_FROM_LOCATION = "fromLocation";
    public static final String KEY_TIMESTAMP = "timeStamp";
    public static final String KEY_TO_LOCATION = "toLocation";

    public static RecentTrips convertFromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new RecentTrips(mf1.a(jSONObject.getString(KEY_FROM_LOCATION)), mf1.a(jSONObject.getString(KEY_TO_LOCATION)), Long.valueOf(jSONObject.getLong("timeStamp")).longValue());
    }

    public JSONObject getJsonObject(RecentTrips recentTrips) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeStamp", recentTrips.getTimeStamp());
        jSONObject.put(KEY_FROM_LOCATION, recentTrips.getFromLocation().b());
        jSONObject.put(KEY_TO_LOCATION, recentTrips.getToLocation().b());
        return jSONObject;
    }
}
