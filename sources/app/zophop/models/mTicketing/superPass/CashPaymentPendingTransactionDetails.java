package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CashPaymentPendingTransactionDetails.kt */
public final class CashPaymentPendingTransactionDetails implements Parcelable {
    public static final Parcelable.Creator<CashPaymentPendingTransactionDetails> CREATOR = new Creator();
    private final double pendingFare;
    private final String referenceId;

    /* compiled from: CashPaymentPendingTransactionDetails.kt */
    public static final class Creator implements Parcelable.Creator<CashPaymentPendingTransactionDetails> {
        @Override // android.os.Parcelable.Creator
        public final CashPaymentPendingTransactionDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new CashPaymentPendingTransactionDetails(parcel.readDouble(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CashPaymentPendingTransactionDetails[] newArray(int i) {
            return new CashPaymentPendingTransactionDetails[i];
        }
    }

    public CashPaymentPendingTransactionDetails(double d, String str) {
        n86.e(str, SuperPassJsonKeys.REFERENCE_ID);
        this.pendingFare = d;
        this.referenceId = str;
    }

    public int describeContents() {
        return 0;
    }

    public final double getPendingFare() {
        return this.pendingFare;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeDouble(this.pendingFare);
        parcel.writeString(this.referenceId);
    }
}
