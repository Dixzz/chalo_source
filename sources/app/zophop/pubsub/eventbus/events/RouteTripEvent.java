package app.zophop.pubsub.eventbus.events;

import app.zophop.models.Route;
import java.util.ArrayList;

public class RouteTripEvent {
    public final ArrayList<Route> _routeTripList;

    public RouteTripEvent(ArrayList<Route> arrayList) {
        this._routeTripList = arrayList;
    }

    public ArrayList<Route> getRouteTripList() {
        return this._routeTripList;
    }
}
