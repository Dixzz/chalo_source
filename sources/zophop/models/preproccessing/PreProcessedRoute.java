package zophop.models.preproccessing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PreProcessedRoute implements Serializable {
    private static final long serialVersionUID = 1;
    private HashSet<String> blocked_stops = null;
    public ArrayList<LegTuple> legs = new ArrayList<>(1);
    private HashSet<String> route_ids = null;
    private String start_stop = null;
    private HashSet<String> visited_stops = null;

    public PreProcessedRoute() {
    }

    public PreProcessedRoute add(LegTuple legTuple, double d) {
        HashSet<String> routeIds = getRouteIds();
        Iterator<String> it = legTuple.routes.iterator();
        while (it.hasNext()) {
            if (routeIds.contains(it.next())) {
                return null;
            }
        }
        HashSet<String> visitedStops = getVisitedStops();
        for (int i = 1; i < legTuple.visited_stops.size(); i++) {
            if (visitedStops.contains(legTuple.visited_stops.get(i))) {
                return null;
            }
        }
        if (getDistance() > d * 3.0d) {
            return null;
        }
        if (legTuple.isRoadConnection) {
            Iterator<LegTuple> it2 = this.legs.iterator();
            while (it2.hasNext()) {
                LegTuple next = it2.next();
                if (!next.isRoadConnection && next.distance < legTuple.distance) {
                    return null;
                }
            }
        }
        PreProcessedRoute preProcessedRoute = new PreProcessedRoute();
        Iterator<LegTuple> it3 = this.legs.iterator();
        while (it3.hasNext()) {
            preProcessedRoute.legs.add(it3.next());
        }
        preProcessedRoute.legs.add(legTuple);
        return preProcessedRoute;
    }

    public PreProcessedRoute cloneWithoutBlockedStops() {
        PreProcessedRoute preProcessedRoute = new PreProcessedRoute();
        Iterator<LegTuple> it = this.legs.iterator();
        while (it.hasNext()) {
            preProcessedRoute.legs.add(it.next().cloneWithoutBlockedStops());
        }
        return preProcessedRoute;
    }

    public boolean equals(PreProcessedRoute preProcessedRoute) {
        if (this.legs.size() != preProcessedRoute.legs.size()) {
            return false;
        }
        for (int i = 0; i < this.legs.size(); i++) {
            if (!this.legs.get(i).equals(preProcessedRoute.legs.get(i))) {
                return false;
            }
        }
        return true;
    }

    public HashSet<String> getBlockedStopIds() {
        HashSet<String> hashSet = this.blocked_stops;
        if (hashSet != null) {
            return hashSet;
        }
        this.blocked_stops = new HashSet<>(1);
        Iterator<LegTuple> it = this.legs.iterator();
        while (it.hasNext()) {
            this.blocked_stops.addAll(it.next().blocked_stops);
        }
        return this.blocked_stops;
    }

    public double getDistance() {
        Iterator<LegTuple> it = this.legs.iterator();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (it.hasNext()) {
            d += it.next().distance;
        }
        return d;
    }

    public String getFirstStopId() {
        if (this.legs.size() == 0) {
            return this.start_stop;
        }
        return this.legs.get(0).from_stop_id;
    }

    public String getLastStopId() {
        int size = this.legs.size();
        if (size == 0) {
            return this.start_stop;
        }
        return this.legs.get(size - 1).to_stop_id;
    }

    public HashSet<String> getRouteIds() {
        HashSet<String> hashSet = this.route_ids;
        if (hashSet != null) {
            return hashSet;
        }
        this.route_ids = new HashSet<>(1);
        Iterator<LegTuple> it = this.legs.iterator();
        while (it.hasNext()) {
            String str = it.next().route_id;
            if (str != null) {
                this.route_ids.add(str);
            }
        }
        return this.route_ids;
    }

    public HashSet<String> getVisitedStops() {
        HashSet<String> hashSet = this.visited_stops;
        if (hashSet != null) {
            return hashSet;
        }
        this.visited_stops = new HashSet<>(1);
        Iterator<LegTuple> it = this.legs.iterator();
        while (it.hasNext()) {
            this.visited_stops.addAll(it.next().visited_stops);
        }
        this.visited_stops.add(this.start_stop);
        return this.visited_stops;
    }

    public boolean hasRoadConnection() {
        Iterator<LegTuple> it = this.legs.iterator();
        while (it.hasNext()) {
            if (it.next().isRoadConnection) {
                return true;
            }
        }
        return false;
    }

    public String lastTripId() {
        return this.legs.get(this.legs.size() - 1).trip_id;
    }

    public PreProcessedRoute(String str) {
        this.start_stop = str;
    }
}
