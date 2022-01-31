package app.zophop.pubsub.eventbus.events;

import android.util.Pair;
import app.zophop.models.Stop;
import app.zophop.models.http_response.TripSummary;
import app.zophop.pubsub.eventbus.events.TripPlannerEvent;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class NearbyStopTripEvent {
    private final LatLng _latLng;
    private final List<Pair<TripSummary, i10>> _liveTimings;
    private final String _reqId;
    private final TripPlannerEvent.ResponseType _responseType;
    private final List<TripSummary> _scheduledTimings;
    private final Stop _stop;

    public NearbyStopTripEvent(String str, TripPlannerEvent.ResponseType responseType, Stop stop, List<Pair<TripSummary, i10>> list, List<TripSummary> list2, LatLng latLng) {
        this._reqId = str;
        this._responseType = responseType;
        this._stop = stop;
        this._liveTimings = list;
        this._scheduledTimings = list2;
        this._latLng = latLng;
    }

    public LatLng getLatLng() {
        return this._latLng;
    }

    public List<Pair<TripSummary, i10>> getLiveTimings() {
        return this._liveTimings;
    }

    public String getReqId() {
        return this._reqId;
    }

    public TripPlannerEvent.ResponseType getResponseType() {
        return this._responseType;
    }

    public List<TripSummary> getScheduledTimings() {
        return this._scheduledTimings;
    }

    public Stop getStop() {
        return this._stop;
    }
}
