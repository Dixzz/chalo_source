package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class NearbyStopEvent {
    private final TransitMode _mode;
    private final List<Stop> _nearbyStops;
    private final LatLng _queryLocation;
    private final String _requestId;
    private final ad1 _responseType;

    public NearbyStopEvent(String str, ad1 ad1, TransitMode transitMode, List<Stop> list, LatLng latLng) {
        this._requestId = str;
        this._responseType = ad1;
        this._mode = transitMode;
        this._nearbyStops = list;
        this._queryLocation = latLng;
    }

    public TransitMode getMode() {
        return this._mode;
    }

    public List<Stop> getNearbyStops() {
        return this._nearbyStops;
    }

    public LatLng getQueryLocation() {
        return this._queryLocation;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public ad1 getResponseType() {
        return this._responseType;
    }
}
