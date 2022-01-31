package app.zophop.models;

import android.util.Pair;
import com.google.android.gms.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

public class UniversalSearchItem {
    private Object _data;
    private final UniversalSearchItemType _type;

    public enum UniversalSearchItemType {
        LOCATION,
        STOP,
        ROUTE,
        TRIPS_STOPS,
        TRIPS_LOCATIONS
    }

    public UniversalSearchItem(UniversalSearchItemType universalSearchItemType, JSONObject jSONObject) {
        JSONException e;
        this._type = universalSearchItemType;
        if (universalSearchItemType.equals(UniversalSearchItemType.STOP)) {
            try {
                this._data = new Stop(jSONObject.getString("stop_id"), jSONObject.getString("stop_name"), new LatLng(jSONObject.getDouble("stop_lat"), jSONObject.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject.getString("station_type")));
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.W0(e2);
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.ROUTE)) {
            try {
                this._data = new rv().h(jSONObject);
            } catch (JSONException e3) {
                b00 b002 = b00.f358a;
                hj1.W0(e3);
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.TRIPS_LOCATIONS)) {
            try {
                this._data = new Pair(vn.h0(jSONObject.getJSONObject("start_point")), vn.h0(jSONObject.getJSONObject("end_point")));
            } catch (JSONException e4) {
                b00 b003 = b00.f358a;
                hj1.W0(e4);
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.TRIPS_STOPS)) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("start_point");
                try {
                    Stop stop = new Stop(jSONObject2.getString("stop_id"), jSONObject2.getString("stop_name"), new LatLng(jSONObject2.getDouble("stop_lat"), jSONObject2.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject2.getString("station_type")));
                    JSONObject jSONObject3 = jSONObject.getJSONObject("end_point");
                    this._data = new Pair(stop, new Stop(jSONObject3.getString("stop_id"), jSONObject3.getString("stop_name"), new LatLng(jSONObject3.getDouble("stop_lat"), jSONObject3.getDouble("stop_lon")), TransitMode.getTransitMode(jSONObject3.getString("station_type"))));
                } catch (JSONException e5) {
                    e = e5;
                    b00 b004 = b00.f358a;
                    hj1.W0(e);
                }
            } catch (JSONException e6) {
                e = e6;
                b00 b0042 = b00.f358a;
                hj1.W0(e);
            }
        } else {
            try {
                this._data = vn.h0(jSONObject);
            } catch (JSONException e7) {
                b00 b005 = b00.f358a;
                hj1.W0(e7);
            }
        }
    }

    public Object getData() {
        return this._data;
    }

    public UniversalSearchItemType getType() {
        return this._type;
    }

    public UniversalSearchItem(UniversalSearchItemType universalSearchItemType, Object obj) {
        this._type = universalSearchItemType;
        this._data = obj;
        if (universalSearchItemType.equals(UniversalSearchItemType.STOP)) {
            if (!(obj instanceof Stop)) {
                throw new RuntimeException("Stop expected here");
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.ROUTE)) {
            if (!(obj instanceof RouteInfo)) {
                throw new RuntimeException("Route expected here");
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.TRIPS_LOCATIONS)) {
            boolean z = obj instanceof Pair;
            if (!z) {
                throw new RuntimeException("Stop trips expected here");
            } else if (z) {
                Pair pair = (Pair) obj;
                if (!(pair.first instanceof md1) || !(pair.second instanceof md1)) {
                    throw new RuntimeException("Stop trips expected here");
                }
            }
        } else if (universalSearchItemType.equals(UniversalSearchItemType.TRIPS_STOPS)) {
            Pair pair2 = (Pair) obj;
            if (!(obj instanceof Pair)) {
                throw new RuntimeException("Stop trips expected here");
            } else if (!(obj instanceof server.zophop.models.Pair)) {
            } else {
                if (!(pair2.first instanceof md1) || !(pair2.second instanceof md1)) {
                    throw new RuntimeException("Stop trips expected here");
                }
            }
        } else if (!(obj instanceof md1)) {
            throw new RuntimeException("PlacesAutoComplete expected here");
        }
    }
}
