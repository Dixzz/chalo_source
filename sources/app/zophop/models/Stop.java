package app.zophop.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class Stop {
    private static final String KEY_FEED_ID = "feedId";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LON = "long";
    private static final String KEY_NAME = "stopName";
    private static final String KEY_STOP_ID = "stopId";
    private static final String KEY_TRANSIT_MODE = "transitMode";
    private FeedId _feedId;
    private final String _id;
    private final LatLng _latLong;
    private final TransitMode _mode;
    private final String _name;

    public Stop(String str, String str2, LatLng latLng, TransitMode transitMode) {
        this._id = str;
        this._name = vn.p0(str2);
        this._latLong = latLng;
        this._mode = transitMode;
    }

    public static Stop fromJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            double optDouble = jSONObject.optDouble(KEY_LAT, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble2 = jSONObject.optDouble(KEY_LON, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            String optString = jSONObject.optString(KEY_STOP_ID, null);
            String optString2 = jSONObject.optString(KEY_NAME, null);
            String optString3 = jSONObject.optString(KEY_TRANSIT_MODE, null);
            jSONObject.optString(KEY_FEED_ID, null);
            LatLng latLng = (optDouble == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || optDouble2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? null : new LatLng(optDouble, optDouble2);
            if (!(latLng == null || optString == null || optString2 == null || optString3 == null)) {
                return new Stop(optString, optString2, latLng, TransitMode.getTransitMode(optString3));
            }
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stop)) {
            return false;
        }
        Stop stop = (Stop) obj;
        String str = this._id;
        if (str == null ? stop._id != null : !str.equals(stop._id)) {
            return false;
        }
        if (this._mode == stop._mode) {
            return true;
        }
        return false;
    }

    public FeedId getFeed() {
        return this._feedId;
    }

    public String getId() {
        return this._id;
    }

    public LatLng getLatLong() {
        return this._latLong;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public String getName() {
        return this._name;
    }

    public int hashCode() {
        String str = this._id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this._name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        LatLng latLng = this._latLong;
        int hashCode3 = (hashCode2 + (latLng != null ? latLng.hashCode() : 0)) * 31;
        TransitMode transitMode = this._mode;
        int hashCode4 = (hashCode3 + (transitMode != null ? transitMode.hashCode() : 0)) * 31;
        FeedId feedId = this._feedId;
        if (feedId != null) {
            i = feedId.hashCode();
        }
        return hashCode4 + i;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            LatLng latLng = this._latLong;
            if (latLng != null) {
                jSONObject.put(KEY_LAT, latLng.latitude);
                jSONObject.put(KEY_LON, this._latLong.longitude);
            }
            jSONObject.put(KEY_STOP_ID, this._id);
            jSONObject.put(KEY_NAME, this._name);
            jSONObject.put(KEY_TRANSIT_MODE, this._mode.toString());
            FeedId feedId = this._feedId;
            if (feedId != null) {
                jSONObject.put(KEY_FEED_ID, feedId.getFeedId());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }
}
