package app.zophop.models.mTicketing.superPass.pendingSuperPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: PendingSuperPassTransactionDetails.kt */
public final class PendingSuperPassTransactionDetails implements Parcelable {
    public static final Parcelable.Creator<PendingSuperPassTransactionDetails> CREATOR = new Creator();
    private final String orderId;
    private final String paymentMode;
    private final String transactionId;

    /* compiled from: PendingSuperPassTransactionDetails.kt */
    public static final class Creator implements Parcelable.Creator<PendingSuperPassTransactionDetails> {
        @Override // android.os.Parcelable.Creator
        public final PendingSuperPassTransactionDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new PendingSuperPassTransactionDetails(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PendingSuperPassTransactionDetails[] newArray(int i) {
            return new PendingSuperPassTransactionDetails[i];
        }
    }

    public PendingSuperPassTransactionDetails(String str, String str2, String str3) {
        n86.e(str, "paymentMode");
        n86.e(str2, "transactionId");
        this.paymentMode = str;
        this.transactionId = str2;
        this.orderId = str3;
    }

    public int describeContents() {
        return 0;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.paymentMode);
        parcel.writeString(this.transactionId);
        parcel.writeString(this.orderId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PendingSuperPassTransactionDetails(String str, String str2, String str3, int i, j86 j86) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }
}
