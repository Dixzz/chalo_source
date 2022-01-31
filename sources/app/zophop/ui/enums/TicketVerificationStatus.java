package app.zophop.ui.enums;

import android.os.Parcel;
import android.os.Parcelable;
import com.razorpay.AnalyticsConstants;

/* compiled from: TicketVerificationStatus.kt */
public enum TicketVerificationStatus implements Parcelable {
    SUCCESS("success"),
    FAILURE(AnalyticsConstants.FAILURE);
    
    public static final Parcelable.Creator<TicketVerificationStatus> CREATOR = new a();
    private final String s;

    /* compiled from: TicketVerificationStatus.kt */
    public static final class a implements Parcelable.Creator<TicketVerificationStatus> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public TicketVerificationStatus createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return TicketVerificationStatus.valueOf(parcel.readString());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public TicketVerificationStatus[] newArray(int i) {
            return new TicketVerificationStatus[i];
        }
    }

    private TicketVerificationStatus(String str) {
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
