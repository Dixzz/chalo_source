package zophop.models.preproccessing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class LegTuple implements Serializable {
    private static final long serialVersionUID = 1;
    public HashSet<String> blocked_stops = new HashSet<>(1);
    public double distance;
    public int end_time;
    public int frequency;
    public double from_lat;
    public double from_lon;
    public String from_stop_id;
    public boolean isRoadConnection = false;
    public String polyline;
    public String route_id;
    public ArrayList<String> routes = new ArrayList<>(1);
    public int start_time;
    public double to_lat;
    public double to_lon;
    public String to_stop_id;
    public String trip_id;
    public ArrayList<String> visited_stops = new ArrayList<>();

    public LegTuple cloneWithoutBlockedStops() {
        LegTuple legTuple = new LegTuple();
        legTuple.distance = this.distance;
        legTuple.polyline = this.polyline;
        legTuple.isRoadConnection = this.isRoadConnection;
        legTuple.routes = this.routes;
        legTuple.from_stop_id = this.from_stop_id;
        legTuple.to_stop_id = this.to_stop_id;
        return legTuple;
    }

    public boolean equals(LegTuple legTuple) {
        if (!this.from_stop_id.equals(legTuple.from_stop_id) || !this.to_stop_id.equals(legTuple.to_stop_id) || this.visited_stops.size() != legTuple.visited_stops.size()) {
            return false;
        }
        for (int i = 0; i < this.visited_stops.size(); i++) {
            if (!this.visited_stops.get(i).equals(legTuple.visited_stops.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.from_stop_id;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.to_stop_id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<String> arrayList = this.visited_stops;
        if (arrayList != null) {
            i = arrayList.size();
        }
        return hashCode2 + i;
    }

    public void mergeRoutes(LegTuple legTuple) {
        Iterator<String> it = legTuple.routes.iterator();
        while (it.hasNext()) {
            this.routes.add(it.next());
        }
    }

    public String toString() {
        if (this.isRoadConnection) {
            StringBuilder i0 = hj1.i0("(");
            i0.append(this.from_stop_id);
            i0.append(",");
            return hj1.a0(i0, this.to_stop_id, ",road)");
        }
        StringBuilder i02 = hj1.i0("(");
        i02.append(this.from_stop_id);
        i02.append(",");
        i02.append(this.to_stop_id);
        i02.append(",");
        return hj1.a0(i02, this.trip_id, ")");
    }
}
