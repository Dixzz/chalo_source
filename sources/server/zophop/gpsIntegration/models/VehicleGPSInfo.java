package server.zophop.gpsIntegration.models;

import com.google.maps.model.LatLng;
import server.zophop.models.HaltState;
import server.zophop.models.Point;

public class VehicleGPSInfo {
    private String _agency;
    private String _alias;
    private String _city;
    private int _deviationCount;
    private String _deviceId;
    private HaltState _haltState;
    private Point _lastPoint;
    private double _lastSpeed;
    private LatLng _lastVisitedPolylinePoint;
    private String _lastVisitedStopId;
    private String _lastVisitedStopName;
    private String _mode;
    private int _reversalCount;
    private String _vehicleId;

    public VehicleGPSInfo(String str, String str2, String str3, String str4, String str5, String str6, Point point, double d, String str7, String str8, int i, int i2, LatLng latLng, HaltState haltState) {
        this._mode = str;
        this._city = str2;
        this._agency = str3;
        this._vehicleId = str4;
        this._deviceId = str5;
        this._alias = str6;
        this._lastPoint = point;
        this._lastSpeed = d;
        this._lastVisitedStopId = str7;
        this._lastVisitedStopName = str8;
        this._deviationCount = i;
        this._reversalCount = i2;
        this._lastVisitedPolylinePoint = latLng;
        this._haltState = haltState;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getAlias() {
        return this._alias;
    }

    public String getCity() {
        return this._city;
    }

    public int getDeviationCount() {
        return this._deviationCount;
    }

    public String getDeviceId() {
        return this._deviceId;
    }

    public HaltState getHaltState() {
        return this._haltState;
    }

    public Point getLastPoint() {
        return this._lastPoint;
    }

    public double getLastSpeed() {
        return this._lastSpeed;
    }

    public long getLastUpdated() {
        return this._lastPoint.getTime();
    }

    public LatLng getLastVisitedPolylinePoint() {
        return this._lastVisitedPolylinePoint;
    }

    public String getLastVisitedStopId() {
        return this._lastVisitedStopId;
    }

    public String getLastVisitedStopName() {
        return this._lastVisitedStopName;
    }

    public String getMode() {
        return this._mode;
    }

    public int getReversalCount() {
        return this._reversalCount;
    }

    public String getVehicleId() {
        return this._vehicleId;
    }

    public void setDeviationCount(int i) {
        this._deviationCount = i;
    }

    public void setHaltState(HaltState haltState) {
        this._haltState = haltState;
    }

    public void setLastPoint(Point point) {
        this._lastPoint = point;
    }

    public void setLastSpeed(double d) {
        this._lastSpeed = d;
    }

    public void setLastVisitedPolylineId(LatLng latLng) {
        this._lastVisitedPolylinePoint = latLng;
    }

    public void setLastVisitedStopId(String str) {
        this._lastVisitedStopId = str;
    }

    public void setLastVisitedStopName(String str) {
        this._lastVisitedStopName = str;
    }

    public void setReversalCount(int i) {
        this._reversalCount = i;
    }
}
