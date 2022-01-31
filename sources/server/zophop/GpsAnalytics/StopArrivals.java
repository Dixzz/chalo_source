package server.zophop.GpsAnalytics;

import server.zophop.models.Route;
import server.zophop.models.Stop;

public class StopArrivals {
    private String _agency;
    private long _arrivalTime;
    private String _city;
    private long _createdAt;
    private long _departureTime;
    private String _deviceId;
    private String _mode;
    private Route _route;
    private Stop _stop;
    private int _stopSeqNum;
    private String _tripId;
    private String _vehicleNo;

    public StopArrivals(String str, String str2, String str3, String str4, Stop stop, Route route, String str5, String str6, long j, long j2, long j3, int i) {
        this._stopSeqNum = i;
        this._city = str;
        this._agency = str2;
        this._mode = str3;
        this._tripId = str4;
        this._stop = stop;
        this._route = route;
        this._vehicleNo = str5;
        this._deviceId = str6;
        this._createdAt = j;
        this._arrivalTime = j2;
        this._departureTime = j3;
    }

    public String get_agency() {
        return this._agency;
    }

    public long get_arrivalTime() {
        return this._arrivalTime;
    }

    public String get_city() {
        return this._city;
    }

    public long get_createdAt() {
        return this._createdAt;
    }

    public long get_departureTime() {
        return this._departureTime;
    }

    public String get_deviceId() {
        return this._deviceId;
    }

    public String get_mode() {
        return this._mode;
    }

    public Route get_route() {
        return this._route;
    }

    public Stop get_stop() {
        return this._stop;
    }

    public int get_stopSeqNum() {
        return this._stopSeqNum;
    }

    public String get_tripId() {
        return this._tripId;
    }

    public String get_vehicleNo() {
        return this._vehicleNo;
    }
}
