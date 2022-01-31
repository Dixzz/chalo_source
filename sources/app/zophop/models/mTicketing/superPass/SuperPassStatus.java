package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SuperPassStatus.kt */
public enum SuperPassStatus implements Parcelable {
    PAYMENT_FAILED("payment_failed"),
    PAYMENT_PROCESSING("payment_processing"),
    UNUSED("unused"),
    USED("used"),
    INACTIVE("inactive"),
    EXPIRED("expired");
    
    public static final Parcelable.Creator<SuperPassStatus> CREATOR = new Creator();
    private final String s;

    /* compiled from: SuperPassStatus.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassStatus> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassStatus createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return SuperPassStatus.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassStatus[] newArray(int i) {
            return new SuperPassStatus[i];
        }
    }

    private SuperPassStatus(String str) {
        this.s = str;
    }

    public int describeContents() {
        return 0;
    }

    public final String getS() {
        return this.s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(name());
    }
}
