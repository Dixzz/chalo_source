package server.zophop.models;

public class StreamMeta {
    private boolean _halted;
    private String _prevStopId;
    private double _speed;
    private String _stopId;

    public StreamMeta(String str, String str2, double d, boolean z) {
        this._halted = z;
        this._stopId = str;
        this._speed = d;
        this._prevStopId = str2;
    }

    public String getPrevStopId() {
        return this._prevStopId;
    }

    public double getSpeed() {
        return this._speed;
    }

    public String getStopId() {
        return this._stopId;
    }

    public boolean isHalted() {
        return this._halted;
    }

    public void setPrevStopId(String str) {
        this._prevStopId = str;
    }

    public void setStopId(String str) {
        this._stopId = str;
    }
}
