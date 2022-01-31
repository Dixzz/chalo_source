package app.zophop.pubsub.eventbus.events;

import com.google.android.gms.maps.model.LatLng;

public class LocationUpdateEvent {
    private final LatLng _latLng;

    public LocationUpdateEvent(LatLng latLng) {
        this._latLng = latLng;
    }

    public LatLng getLatLng() {
        return this._latLng;
    }
}
