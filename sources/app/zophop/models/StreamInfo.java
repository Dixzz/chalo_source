package app.zophop.models;

import server.zophop.models.Point;

public class StreamInfo extends DataInfo {
    private boolean _isHalted;
    private final String _nextStopId;
    private final Point _point;
    private final long _timestamp;

    public StreamInfo(String str, int i, String str2, Point point, long j) {
        this._streamId = str;
        this._nextStopId = str2;
        this._eta = i;
        this._point = point;
        this._timestamp = j;
    }

    public String getNextStopId() {
        return this._nextStopId;
    }

    public int getOriginalEtaSec() {
        return this._eta;
    }

    public Point getPoint() {
        return this._point;
    }

    public String getStreamId() {
        return this._streamId;
    }

    public long getTimeStamp() {
        return this._timestamp;
    }

    public String getVehicleNumber() {
        return this._vehicleNo;
    }

    public boolean isHalted() {
        return this._isHalted;
    }

    public void setHaltedStatus(boolean z) {
        this._isHalted = z;
    }

    public void setVehicleNumber(String str) {
        this._vehicleNo = str;
    }
}
