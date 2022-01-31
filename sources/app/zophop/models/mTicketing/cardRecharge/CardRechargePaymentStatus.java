package app.zophop.models.mTicketing.cardRecharge;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CardRechargePaymentStatus.kt */
public enum CardRechargePaymentStatus implements Parcelable {
    INITIATED("initiated"),
    SUCCESS("success"),
    FAILED("failed");
    
    public static final Parcelable.Creator<CardRechargePaymentStatus> CREATOR = new Creator();
    private final String s;

    /* compiled from: CardRechargePaymentStatus.kt */
    public static final class Creator implements Parcelable.Creator<CardRechargePaymentStatus> {
        @Override // android.os.Parcelable.Creator
        public final CardRechargePaymentStatus createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return CardRechargePaymentStatus.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CardRechargePaymentStatus[] newArray(int i) {
            return new CardRechargePaymentStatus[i];
        }
    }

    private CardRechargePaymentStatus(String str) {
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
