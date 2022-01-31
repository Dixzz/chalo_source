package app.zophop.models.SuperSaver;

import android.os.Parcel;
import android.os.Parcelable;

public class RideInfo implements Parcelable {
    private long _activationTimeStamp;
    private String _rideId;

    public RideInfo(String str, long j) {
        this._rideId = str;
        this._activationTimeStamp = j;
    }

    public int describeContents() {
        return 0;
    }

    public long getActivationTimeStamp() {
        return this._activationTimeStamp;
    }

    public String get_rideId() {
        return this._rideId;
    }

    public void setActivationTimeStamp(long j) {
        this._activationTimeStamp = j;
    }

    public void set_rideId(String str) {
        this._rideId = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._rideId);
        parcel.writeLong(this._activationTimeStamp);
    }

    public RideInfo(Parcel parcel) {
        this._rideId = parcel.readString();
        this._activationTimeStamp = parcel.readLong();
    }
}
