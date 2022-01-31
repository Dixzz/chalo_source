package app.zophop.pubsub.eventbus.events;

import app.zophop.models.AutoCabResponse;
import com.google.android.gms.maps.model.LatLng;

public class NearByCabTripEvent extends CabTripInfoEvent {
    private final LatLng _cabQueryLocation;

    public NearByCabTripEvent(AutoCabResponse autoCabResponse, ad1 ad1, String str, LatLng latLng) {
        super(autoCabResponse, ad1, str);
        this._cabQueryLocation = latLng;
    }

    public LatLng getCabQueryLocation() {
        return this._cabQueryLocation;
    }
}
