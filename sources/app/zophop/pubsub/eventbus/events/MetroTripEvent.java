package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Route;
import java.util.ArrayList;

public class MetroTripEvent extends RouteTripEvent {
    public MetroTripEvent(ArrayList<Route> arrayList) {
        super(arrayList);
    }

    @Override // app.zophop.pubsub.eventbus.events.RouteTripEvent
    public /* bridge */ /* synthetic */ ArrayList getRouteTripList() {
        return super.getRouteTripList();
    }
}
