package app.zophop.models;

import com.google.android.gms.maps.model.LatLng;

public class LocationUpdateInfo {
    private final LatLng _latLng;
    private final long _latLngUpdateTimeInMillis;

    public LocationUpdateInfo(LatLng latLng, long j) {
        this._latLng = latLng;
        this._latLngUpdateTimeInMillis = j;
    }

    public long getEtaUpdateTimeInMillis() {
        return this._latLngUpdateTimeInMillis;
    }

    public LatLng getLatLng() {
        return this._latLng;
    }
}
