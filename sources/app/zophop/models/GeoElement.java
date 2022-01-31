package app.zophop.models;

import com.firebase.geofire.GeoLocation;
import server.zophop.models.GeoRealTimeInfo;

public class GeoElement {
    private final GeoLocation _geoLocation;
    private final GeoRealTimeInfo _geoRealTimeInfo;
    private final String _key;
    private final String _streamId;

    public GeoElement(String str, String str2, GeoRealTimeInfo geoRealTimeInfo, GeoLocation geoLocation) {
        this._key = str;
        this._streamId = str2;
        this._geoRealTimeInfo = geoRealTimeInfo;
        this._geoLocation = geoLocation;
    }

    public GeoLocation getGeoLocation() {
        return this._geoLocation;
    }

    public GeoRealTimeInfo getGeoRealTimeInfo() {
        return this._geoRealTimeInfo;
    }

    public String getKey() {
        return this._key;
    }

    public String getStreamId() {
        return this._streamId;
    }
}
