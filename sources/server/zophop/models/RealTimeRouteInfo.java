package server.zophop.models;

public class RealTimeRouteInfo {
    private String _agency;
    private String _fromName;
    private String _mode;
    private String _routeId;
    private String _routeName;
    private String _toName;
    private String _vehicleId;

    public RealTimeRouteInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this._routeId = str;
        this._routeName = str2;
        this._fromName = str3;
        this._toName = str4;
        this._mode = str5;
        this._agency = str6;
        this._vehicleId = str7;
    }

    public String getAgencyName() {
        return this._agency;
    }

    public String getFromName() {
        return this._fromName;
    }

    public String getMode() {
        return this._mode;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public String getToName() {
        return this._toName;
    }

    public String getVehicleId() {
        return this._vehicleId;
    }
}
