package app.zophop.models.mTicketing.cardRecharge;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CardRechargeInfo.kt */
public final class CardRechargeInfo implements Parcelable {
    public static final Parcelable.Creator<CardRechargeInfo> CREATOR = new Creator();
    private final CardRechargePaymentStatus paymentStatus;
    private final long rechargeAmount;
    private final CardRechargeStatus rechargeStatus;

    /* compiled from: CardRechargeInfo.kt */
    public static final class Creator implements Parcelable.Creator<CardRechargeInfo> {
        @Override // android.os.Parcelable.Creator
        public final CardRechargeInfo createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new CardRechargeInfo(CardRechargePaymentStatus.CREATOR.createFromParcel(parcel), CardRechargeStatus.CREATOR.createFromParcel(parcel), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final CardRechargeInfo[] newArray(int i) {
            return new CardRechargeInfo[i];
        }
    }

    public CardRechargeInfo(CardRechargePaymentStatus cardRechargePaymentStatus, CardRechargeStatus cardRechargeStatus, long j) {
        n86.e(cardRechargePaymentStatus, CardRechargeJsonKeys.PAYMENT_STATUS);
        n86.e(cardRechargeStatus, CardRechargeJsonKeys.RECHARGE_STATUS);
        this.paymentStatus = cardRechargePaymentStatus;
        this.rechargeStatus = cardRechargeStatus;
        this.rechargeAmount = j;
    }

    public static /* synthetic */ CardRechargeInfo copy$default(CardRechargeInfo cardRechargeInfo, CardRechargePaymentStatus cardRechargePaymentStatus, CardRechargeStatus cardRechargeStatus, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            cardRechargePaymentStatus = cardRechargeInfo.paymentStatus;
        }
        if ((i & 2) != 0) {
            cardRechargeStatus = cardRechargeInfo.rechargeStatus;
        }
        if ((i & 4) != 0) {
            j = cardRechargeInfo.rechargeAmount;
        }
        return cardRechargeInfo.copy(cardRechargePaymentStatus, cardRechargeStatus, j);
    }

    public final CardRechargePaymentStatus component1() {
        return this.paymentStatus;
    }

    public final CardRechargeStatus component2() {
        return this.rechargeStatus;
    }

    public final long component3() {
        return this.rechargeAmount;
    }

    public final CardRechargeInfo copy(CardRechargePaymentStatus cardRechargePaymentStatus, CardRechargeStatus cardRechargeStatus, long j) {
        n86.e(cardRechargePaymentStatus, CardRechargeJsonKeys.PAYMENT_STATUS);
        n86.e(cardRechargeStatus, CardRechargeJsonKeys.RECHARGE_STATUS);
        return new CardRechargeInfo(cardRechargePaymentStatus, cardRechargeStatus, j);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardRechargeInfo)) {
            return false;
        }
        CardRechargeInfo cardRechargeInfo = (CardRechargeInfo) obj;
        return this.paymentStatus == cardRechargeInfo.paymentStatus && this.rechargeStatus == cardRechargeInfo.rechargeStatus && this.rechargeAmount == cardRechargeInfo.rechargeAmount;
    }

    public final CardRechargePaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public final long getRechargeAmount() {
        return this.rechargeAmount;
    }

    public final CardRechargeStatus getRechargeStatus() {
        return this.rechargeStatus;
    }

    public int hashCode() {
        return ((this.rechargeStatus.hashCode() + (this.paymentStatus.hashCode() * 31)) * 31) + d.a(this.rechargeAmount);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargeInfo(paymentStatus=");
        i0.append(this.paymentStatus);
        i0.append(", rechargeStatus=");
        i0.append(this.rechargeStatus);
        i0.append(", rechargeAmount=");
        i0.append(this.rechargeAmount);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        this.paymentStatus.writeToParcel(parcel, i);
        this.rechargeStatus.writeToParcel(parcel, i);
        parcel.writeLong(this.rechargeAmount);
    }
}
