package server.zophop.GpsAnalytics;

import server.zophop.models.Point;
import server.zophop.models.Stop;

public class NearbyStopPoints {
    private long _arrivalTimeStamp;
    private double _distance;
    private double _distanceCovered;
    private Point _point;
    private Stop _stop;

    public NearbyStopPoints(Stop stop, Point point, long j, double d, double d2) {
        this._stop = stop;
        this._arrivalTimeStamp = j;
        this._distance = d;
        this._point = point;
        this._distanceCovered = d2;
    }

    public double getDistance() {
        return this._distance;
    }

    public double getDistanceCovered() {
        return this._distanceCovered;
    }

    public Point getPoint() {
        return this._point;
    }

    public Stop getStop() {
        return this._stop;
    }

    public long getTimestamp() {
        return this._arrivalTimeStamp;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0(" ");
        i0.append(this._stop.getName());
        i0.append(",");
        i0.append(this._stop.getId());
        i0.append(",");
        i0.append(this._point.getLatitude());
        i0.append(",");
        i0.append(this._point.getLongitude());
        i0.append(",");
        i0.append(this._arrivalTimeStamp);
        i0.append(",");
        i0.append(this._distance);
        return i0.toString();
    }
}
