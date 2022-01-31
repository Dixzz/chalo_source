package defpackage;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: tv  reason: default package */
/* compiled from: StopsResponseConverter */
public class tv {
    public Stop a(JSONObject jSONObject) throws JSONException {
        return new Stop(jSONObject.getString("stop_id"), jSONObject.getString("stop_name"), new LatLng(jSONObject.getDouble("stop_lat"), jSONObject.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject.getString("station_type")));
    }
}
