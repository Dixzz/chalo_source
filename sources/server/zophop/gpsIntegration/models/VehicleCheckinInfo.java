package server.zophop.gpsIntegration.models;

public class VehicleCheckinInfo {
    private String _agency;
    private String _alias;
    private String _city;
    private String _deviceId;
    private String _mode;
    private String _routeId;
    private String _source;
    private String _status;
    private String _streamId;
    private String _vehicleId;

    public VehicleCheckinInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this._vehicleId = str;
        this._deviceId = str2;
        this._alias = str3;
        this._routeId = str4;
        this._mode = str5;
        this._city = str6;
        this._agency = str7;
        this._streamId = str8;
        this._source = str9;
    }

    public void checkIn(String str) {
        this._routeId = str;
    }

    public void checkOut() {
        this._streamId = null;
        this._routeId = null;
    }

    public void checkOutSession() {
        this._streamId = null;
    }

    public String getAgency() {
        return this._agency;
    }

    public String getCity() {
        return this._city;
    }

    public String getDeviceId() {
        return this._deviceId;
    }

    public String getMode() {
        return this._mode;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getSource() {
        return this._source;
    }

    public String getStatus() {
        return this._status;
    }

    public String getStreamId() {
        return this._streamId;
    }

    public String getVehicleId() {
        return this._vehicleId;
    }

    public boolean isCheckedIn() {
        return this._streamId != null;
    }

    public boolean routeExists() {
        return this._routeId != null;
    }

    public void setRouteId(String str) {
        this._routeId = str;
    }

    public void setStatus(String str) {
        this._status = str;
    }

    public void setStreamId(String str) {
        this._streamId = str;
    }
}
