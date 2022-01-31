package server.zophop.gpsIntegration.models;

public class VehicleDisapatchTypeInfo {
    private String _category;
    private String _endTime;
    private boolean _isActive;
    private String _rotueId;
    private String _startTime;
    private String _vehicleNo;

    public VehicleDisapatchTypeInfo(String str, String str2, boolean z, String str3, String str4, String str5) {
        this._category = str;
        this._endTime = str2;
        this._isActive = z;
        this._startTime = str3;
        this._vehicleNo = str4;
        this._rotueId = str5;
    }

    public String getCategory() {
        return this._category;
    }

    public String getEndTime() {
        return this._endTime;
    }

    public String getRotueId() {
        return this._rotueId;
    }

    public String getStartTime() {
        return this._startTime;
    }

    public String getVehicleNo() {
        return this._vehicleNo;
    }

    public boolean hasRouteId() {
        return this._rotueId != null;
    }

    public boolean isActive() {
        return this._isActive;
    }
}
