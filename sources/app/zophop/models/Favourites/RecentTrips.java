package app.zophop.models.Favourites;

public class RecentTrips {
    private final mf1 _fromLocation;
    private long _timeStamp;
    private final mf1 _toLocation;

    public RecentTrips(mf1 mf1, mf1 mf12, long j) {
        this._fromLocation = mf1;
        this._toLocation = mf12;
        this._timeStamp = j;
    }

    public mf1 getFromLocation() {
        return this._fromLocation;
    }

    public long getTimeStamp() {
        return this._timeStamp;
    }

    public mf1 getToLocation() {
        return this._toLocation;
    }

    public void setTimeStamp(long j) {
        this._timeStamp = j;
    }
}
