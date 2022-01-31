package app.zophop.models;

public class StopGeofence {
    private long _creationTimeInMillis;
    private long _expiryDuration;
    private boolean _neverExpire;
    private Stop _stop;

    public long getCreationTimeInMillis() {
        return this._creationTimeInMillis;
    }

    public long getExpiryDuration() {
        return this._expiryDuration;
    }

    public Stop getStop() {
        return this._stop;
    }

    public boolean isNeverExpire() {
        return this._neverExpire;
    }

    public void setCreationTimeInMillis(long j) {
        this._creationTimeInMillis = j;
    }

    public void setExpiryDuration(long j) {
        this._expiryDuration = j;
    }

    public void setNeverExpire(boolean z) {
        this._neverExpire = z;
    }

    public void setStop(Stop stop) {
        this._stop = stop;
    }
}
