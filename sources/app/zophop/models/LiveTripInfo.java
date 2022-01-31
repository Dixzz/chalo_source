package app.zophop.models;

import com.firebase.geofire.GeoLocation;
import server.zophop.models.GeoRealTimeInfo;

public class LiveTripInfo {
    private final GeoLocation _geoLocation;
    private final GeoRealTimeInfo _geoRealTimeInfo;
    private final String _id;
    private final String _routeId;
    private final String _streamId;

    public LiveTripInfo(String str, String str2, GeoLocation geoLocation, GeoRealTimeInfo geoRealTimeInfo, String str3) {
        this._streamId = str;
        this._routeId = str2;
        this._geoLocation = geoLocation;
        this._geoRealTimeInfo = geoRealTimeInfo;
        this._id = str3;
    }

    public GeoLocation getGeoLocation() {
        return this._geoLocation;
    }

    public GeoRealTimeInfo getGeoRealTimeInfo() {
        return this._geoRealTimeInfo;
    }

    public String getId() {
        return this._id;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getStreamId() {
        return this._streamId;
    }
}
