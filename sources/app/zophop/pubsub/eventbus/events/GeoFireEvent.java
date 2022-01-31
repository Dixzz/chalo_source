package app.zophop.pubsub.eventbus.events;

import app.zophop.models.LiveTripInfo;
import com.google.android.gms.maps.model.LatLng;

public class GeoFireEvent {
    private final LiveTripInfo _cardInfo;
    private final LatLng _queryCenter;
    private final String _requestId;
    private final Type _type;

    public enum Type {
        ENTERED,
        MOVED,
        EXITED
    }

    public GeoFireEvent(String str, Type type, LiveTripInfo liveTripInfo, LatLng latLng) {
        this._cardInfo = liveTripInfo;
        this._type = type;
        this._requestId = str;
        this._queryCenter = latLng;
    }

    public LiveTripInfo getCardInfo() {
        return this._cardInfo;
    }

    public LatLng getQueryCenter() {
        return this._queryCenter;
    }

    public String getRequestId() {
        return this._requestId;
    }

    public Type getType() {
        return this._type;
    }
}
