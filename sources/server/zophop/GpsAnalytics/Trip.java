package server.zophop.GpsAnalytics;

import java.util.List;
import server.zophop.models.Route;

public class Trip {
    private int _accuracy;
    private String _agency;
    private String _city;
    private long _distanceCovered;
    private Route _route;
    private List<StopArrivals> _stopSeq;
    private long _tripEndTime;
    private String _tripId;
    private long _tripStartTime;
    private TripType _tripType;
    private String _vehicleNo;
    private String mode;

    public Trip(String str, String str2, String str3, String str4, String str5, List<StopArrivals> list, Route route, long j, long j2, TripType tripType) {
        this._agency = str2;
        this._city = str;
        this.mode = str3;
        this._vehicleNo = str4;
        this._tripId = str5;
        this._stopSeq = list;
        this._route = route;
        this._tripStartTime = j;
        this._tripEndTime = j2;
        this._accuracy = (list.size() * 100) / route.getStopSequence().size();
        this._tripType = tripType;
    }

    private TripType setStatus(int i) {
        if (i > 70) {
            return TripType.complete;
        }
        if (i <= 30 || i >= 70) {
            return TripType.dead;
        }
        return TripType.partial;
    }

    public TripType getTripType() {
        return this._tripType;
    }

    public int get_accuracy() {
        return this._accuracy;
    }

    public String get_agency() {
        return this._agency;
    }

    public String get_city() {
        return this._city;
    }

    public Route get_route() {
        return this._route;
    }

    public List<StopArrivals> get_stopSeq() {
        return this._stopSeq;
    }

    public long get_tripEndTime() {
        return this._tripEndTime;
    }

    public String get_tripId() {
        return this._tripId;
    }

    public long get_tripStartTime() {
        return this._tripStartTime;
    }

    public String get_vehicleNo() {
        return this._vehicleNo;
    }

    public Trip(String str, String str2, String str3, String str4, String str5, List<StopArrivals> list, Route route, long j, long j2) {
        this._agency = str2;
        this._city = str;
        this.mode = str3;
        this._vehicleNo = str4;
        this._tripId = str5;
        this._stopSeq = list;
        this._route = route;
        this._tripStartTime = j;
        this._tripEndTime = j2;
        int size = (list.size() * 100) / route.getStopSequence().size();
        this._accuracy = size;
        this._tripType = setStatus(size);
    }
}
