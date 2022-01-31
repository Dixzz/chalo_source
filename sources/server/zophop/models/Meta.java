package server.zophop.models;

public class Meta {
    private int _destinationEta;
    private String _nextStopId;
    private String _previousStopId;
    private double _speed;

    public Meta(String str, String str2, double d, int i) {
        this._nextStopId = str;
        this._previousStopId = str2;
        this._speed = d;
        this._destinationEta = i;
    }

    public int getDestinationEta() {
        return this._destinationEta;
    }

    public String getNextStopId() {
        return this._nextStopId;
    }

    public String getPreviousStopId() {
        return this._previousStopId;
    }

    public double getSpeed() {
        return this._speed;
    }
}
