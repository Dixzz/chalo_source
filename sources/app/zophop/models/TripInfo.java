package app.zophop.models;

public class TripInfo {
    private final int _endTime;
    private final boolean _isFrequencyTrip;
    private final int _startTime;
    private final int _tripDuration;
    private final String _tripId;

    public TripInfo(String str, int i, int i2, int i3, boolean z) {
        this._tripId = str;
        this._startTime = i;
        this._endTime = i2;
        this._tripDuration = i3;
        this._isFrequencyTrip = z;
    }

    public int getEndTime() {
        return this._endTime;
    }

    public int getStartTime() {
        return this._startTime;
    }

    public int getTripDuration() {
        return this._tripDuration;
    }

    public String getTripId() {
        return this._tripId;
    }

    public boolean isFrequencyTrip() {
        return this._isFrequencyTrip;
    }
}
