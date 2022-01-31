package app.zophop.pubsub.eventbus.events;

import app.zophop.models.AutoCabResponse;

public class TripPlannerCabTripEvent extends CabTripInfoEvent {
    public TripPlannerCabTripEvent(AutoCabResponse autoCabResponse, ad1 ad1, String str) {
        super(autoCabResponse, ad1, str);
    }
}
