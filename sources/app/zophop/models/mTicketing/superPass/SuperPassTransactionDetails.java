package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SuperPassTransactionDetails.kt */
public final class SuperPassTransactionDetails implements Parcelable {
    public static final Parcelable.Creator<SuperPassTransactionDetails> CREATOR = new Creator();
    private final String paymentMode;
    private final String transactionId;

    /* compiled from: SuperPassTransactionDetails.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassTransactionDetails> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassTransactionDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassTransactionDetails(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassTransactionDetails[] newArray(int i) {
            return new SuperPassTransactionDetails[i];
        }
    }

    public SuperPassTransactionDetails(String str, String str2) {
        n86.e(str, "transactionId");
        n86.e(str2, "paymentMode");
        this.transactionId = str;
        this.paymentMode = str2;
    }

    public int describeContents() {
        return 0;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.transactionId);
        parcel.writeString(this.paymentMode);
    }
}
