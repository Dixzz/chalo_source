package app.zophop.models;

public class EtaInfo extends DataInfo {
    private int _maxEta;
    private int _minEta;
    private final long _timeStamp;

    public EtaInfo(String str, int i, String str2, long j) {
        this._streamId = str;
        this._eta = i;
        this._vehicleNo = str2;
        this._timeStamp = j;
    }

    public int get_eta() {
        return this._eta;
    }

    public int get_maxEta() {
        return this._maxEta;
    }

    public int get_minEta() {
        return this._minEta;
    }

    public String get_streamId() {
        return this._streamId;
    }

    public long get_timeStamp() {
        return this._timeStamp;
    }

    public String get_vehicleNo() {
        return this._vehicleNo;
    }

    public void set_maxEta(int i) {
        this._maxEta = i;
    }

    public void set_minEta(int i) {
        this._minEta = i;
    }
}
