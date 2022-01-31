package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: MPassVerificationTimingDetails.kt */
public final class MPassVerificationTimingDetails implements Parcelable {
    public static final Parcelable.Creator<MPassVerificationTimingDetails> CREATOR = new Creator();
    private final String verificationOfficeTimings;
    private final String verificationTimeRequired;

    /* compiled from: MPassVerificationTimingDetails.kt */
    public static final class Creator implements Parcelable.Creator<MPassVerificationTimingDetails> {
        @Override // android.os.Parcelable.Creator
        public final MPassVerificationTimingDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new MPassVerificationTimingDetails(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MPassVerificationTimingDetails[] newArray(int i) {
            return new MPassVerificationTimingDetails[i];
        }
    }

    public MPassVerificationTimingDetails() {
        this(null, null, 3, null);
    }

    public MPassVerificationTimingDetails(String str, String str2) {
        n86.e(str, "verificationTimeRequired");
        n86.e(str2, "verificationOfficeTimings");
        this.verificationTimeRequired = str;
        this.verificationOfficeTimings = str2;
    }

    public static /* synthetic */ MPassVerificationTimingDetails copy$default(MPassVerificationTimingDetails mPassVerificationTimingDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mPassVerificationTimingDetails.verificationTimeRequired;
        }
        if ((i & 2) != 0) {
            str2 = mPassVerificationTimingDetails.verificationOfficeTimings;
        }
        return mPassVerificationTimingDetails.copy(str, str2);
    }

    public final String component1() {
        return this.verificationTimeRequired;
    }

    public final String component2() {
        return this.verificationOfficeTimings;
    }

    public final MPassVerificationTimingDetails copy(String str, String str2) {
        n86.e(str, "verificationTimeRequired");
        n86.e(str2, "verificationOfficeTimings");
        return new MPassVerificationTimingDetails(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MPassVerificationTimingDetails)) {
            return false;
        }
        MPassVerificationTimingDetails mPassVerificationTimingDetails = (MPassVerificationTimingDetails) obj;
        return n86.a(this.verificationTimeRequired, mPassVerificationTimingDetails.verificationTimeRequired) && n86.a(this.verificationOfficeTimings, mPassVerificationTimingDetails.verificationOfficeTimings);
    }

    public final String getVerificationOfficeTimings() {
        return this.verificationOfficeTimings;
    }

    public final String getVerificationTimeRequired() {
        return this.verificationTimeRequired;
    }

    public int hashCode() {
        return this.verificationOfficeTimings.hashCode() + (this.verificationTimeRequired.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MPassVerificationTimingDetails(verificationTimeRequired=");
        i0.append(this.verificationTimeRequired);
        i0.append(", verificationOfficeTimings=");
        return hj1.Z(i0, this.verificationOfficeTimings, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.verificationTimeRequired);
        parcel.writeString(this.verificationOfficeTimings);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MPassVerificationTimingDetails(String str, String str2, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? new String() : str2);
    }
}
