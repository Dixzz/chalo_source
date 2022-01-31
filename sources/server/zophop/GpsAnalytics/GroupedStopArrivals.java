package server.zophop.GpsAnalytics;

import java.util.ArrayList;
import java.util.List;
import server.zophop.models.Stop;

public class GroupedStopArrivals implements Comparable {
    private long _arrivalTimeStamp;
    private double _distanceCovered;
    private List<NearbyStopPoints> _filterPoints;
    private List<NearbyStopPoints> _points;
    private Stop _stop;

    public GroupedStopArrivals(Stop stop, List<NearbyStopPoints> list, long j) {
        this._stop = stop;
        this._distanceCovered = list.get(0).getDistanceCovered();
        this._points = list;
        List<NearbyStopPoints> capturesClosedPoints = capturesClosedPoints();
        this._filterPoints = capturesClosedPoints;
        this._arrivalTimeStamp = capturesClosedPoints.get(0).getTimestamp();
    }

    private List<NearbyStopPoints> capturesClosedPoints() {
        ArrayList arrayList = new ArrayList();
        double d = 999999.0d;
        int i = 0;
        for (int i2 = 0; i2 < this._points.size(); i2++) {
            NearbyStopPoints nearbyStopPoints = this._points.get(i2);
            if (nearbyStopPoints.getDistance() < d) {
                d = nearbyStopPoints.getDistance();
                i = i2;
            }
        }
        while (i < this._points.size()) {
            if (Math.abs(this._points.get(i).getDistance() - d) < 20.0d) {
                arrayList.add(this._points.get(i));
            }
            i++;
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        GroupedStopArrivals groupedStopArrivals = (GroupedStopArrivals) obj;
        if (getTimestamp() > groupedStopArrivals.getTimestamp()) {
            return 1;
        }
        return getTimestamp() < groupedStopArrivals.getTimestamp() ? -1 : 0;
    }

    public double getDistance() {
        return this._distanceCovered;
    }

    public List<NearbyStopPoints> getPoints() {
        return this._points;
    }

    public Stop getStop() {
        return this._stop;
    }

    public long getTimestamp() {
        return this._arrivalTimeStamp;
    }

    public String toString() {
        return this._stop.getId();
    }
}
