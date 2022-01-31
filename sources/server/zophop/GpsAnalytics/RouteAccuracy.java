package server.zophop.GpsAnalytics;

import server.zophop.models.Route;

public class RouteAccuracy implements Comparable {
    private int _accuracy;
    private Route _route;

    public RouteAccuracy(Route route, int i) {
        this._route = route;
        this._accuracy = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        int i = this._accuracy;
        int i2 = ((RouteAccuracy) obj)._accuracy;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public int getAccuracy() {
        return this._accuracy;
    }

    public Route getRoute() {
        return this._route;
    }

    public void setAccuracy(int i) {
        this._accuracy = i;
    }

    public String toString() {
        return this._route.getId() + "  " + this._route.getName() + "  " + this._accuracy;
    }
}
