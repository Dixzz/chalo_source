package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

public class MagicPassesProperties implements Parcelable {
    public static final Parcelable.Creator<MagicPassesProperties> CREATOR = new Parcelable.Creator<MagicPassesProperties>() {
        /* class app.zophop.models.mTicketing.MagicPassesProperties.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MagicPassesProperties createFromParcel(Parcel parcel) {
            return new MagicPassesProperties(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MagicPassesProperties[] newArray(int i) {
            return new MagicPassesProperties[i];
        }
    };
    private boolean _passesOnMultipleDevices;

    public MagicPassesProperties() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean hasPassesOnMultipleDevices() {
        return this._passesOnMultipleDevices;
    }

    public void setPassesOnMultipleDevices(boolean z) {
        this._passesOnMultipleDevices = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this._passesOnMultipleDevices ? (byte) 1 : 0);
    }

    public MagicPassesProperties(Parcel parcel) {
        this._passesOnMultipleDevices = parcel.readByte() != 0;
    }
}
