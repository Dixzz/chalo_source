package defpackage;

import app.zophop.models.Stop;
import app.zophop.models.StopGeofence;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: sv  reason: default package */
/* compiled from: StopsGeofenceConverter */
public class sv {
    public JSONObject a(StopGeofence stopGeofence) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stop", new Gson().toJson(stopGeofence.getStop()));
        jSONObject.put("expiryDuration", stopGeofence.getExpiryDuration());
        jSONObject.put("creationTime", stopGeofence.getCreationTimeInMillis());
        jSONObject.put("neverExpire", stopGeofence.isNeverExpire());
        return jSONObject;
    }

    public StopGeofence b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        StopGeofence stopGeofence = new StopGeofence();
        stopGeofence.setStop((Stop) new Gson().fromJson(jSONObject.getString("stop"), Stop.class));
        stopGeofence.setExpiryDuration(jSONObject.getLong("expiryDuration"));
        stopGeofence.setCreationTimeInMillis(jSONObject.getLong("creationTime"));
        stopGeofence.setNeverExpire(jSONObject.getBoolean("neverExpire"));
        return stopGeofence;
    }
}
