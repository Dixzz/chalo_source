package app.zophop.models;

public class EtaModel {
    private final Integer _eta;
    private final boolean _isHalted;
    private final long _routeTimeStamp;
    private String _variableTime;
    private final String _vehicleNumber;

    public EtaModel(String str, Integer num, long j, boolean z) {
        this._vehicleNumber = str;
        this._eta = num;
        this._routeTimeStamp = j;
        this._isHalted = z;
    }

    public Integer get_eta() {
        return this._eta;
    }

    public long get_routeTimeStamp() {
        return this._routeTimeStamp;
    }

    public String get_variableTime() {
        return this._variableTime;
    }

    public String get_vehicleNumber() {
        return this._vehicleNumber;
    }

    public boolean is_isHalted() {
        return this._isHalted;
    }

    public void set_variableTime(String str) {
        this._variableTime = str;
    }
}
