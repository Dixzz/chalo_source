package app.zophop.models.mTicketing.cardRecharge;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CardRechargeStatus.kt */
public enum CardRechargeStatus implements Parcelable {
    PENDING("pending"),
    SUCCESS("success"),
    FAILED("failed");
    
    public static final Parcelable.Creator<CardRechargeStatus> CREATOR = new Creator();
    private final String s;

    /* compiled from: CardRechargeStatus.kt */
    public static final class Creator implements Parcelable.Creator<CardRechargeStatus> {
        @Override // android.os.Parcelable.Creator
        public final CardRechargeStatus createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return CardRechargeStatus.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CardRechargeStatus[] newArray(int i) {
            return new CardRechargeStatus[i];
        }
    }

    private CardRechargeStatus(String str) {
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
