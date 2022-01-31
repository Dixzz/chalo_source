package server.zophop.models;

public class Point {
    private double _accuracy;
    private double _latitude;
    private double _longitude;
    private double _speed;
    private long _time;

    public Point(double d, double d2, long j, double d3, double d4) {
        this._latitude = d;
        this._longitude = d2;
        this._time = j;
        this._speed = d3;
        this._accuracy = d4;
    }

    public double getAccuracy() {
        return this._accuracy;
    }

    public double getLatitude() {
        return this._latitude;
    }

    public double getLongitude() {
        return this._longitude;
    }

    public double getSpeed() {
        return this._speed;
    }

    public long getTime() {
        return this._time;
    }
}
