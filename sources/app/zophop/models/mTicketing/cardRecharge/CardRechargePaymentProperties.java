package app.zophop.models.mTicketing.cardRecharge;

/* compiled from: CardRechargePaymentProperties.kt */
public final class CardRechargePaymentProperties {
    private final CardRechargeInfo cardRechargeInfo;
    private final String paymentMode;
    private final long paymentTime;
    private final String transactionId;

    public CardRechargePaymentProperties(String str, String str2, long j, CardRechargeInfo cardRechargeInfo2) {
        n86.e(str, "transactionId");
        n86.e(str2, "paymentMode");
        n86.e(cardRechargeInfo2, "cardRechargeInfo");
        this.transactionId = str;
        this.paymentMode = str2;
        this.paymentTime = j;
        this.cardRechargeInfo = cardRechargeInfo2;
    }

    public static /* synthetic */ CardRechargePaymentProperties copy$default(CardRechargePaymentProperties cardRechargePaymentProperties, String str, String str2, long j, CardRechargeInfo cardRechargeInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardRechargePaymentProperties.transactionId;
        }
        if ((i & 2) != 0) {
            str2 = cardRechargePaymentProperties.paymentMode;
        }
        if ((i & 4) != 0) {
            j = cardRechargePaymentProperties.paymentTime;
        }
        if ((i & 8) != 0) {
            cardRechargeInfo2 = cardRechargePaymentProperties.cardRechargeInfo;
        }
        return cardRechargePaymentProperties.copy(str, str2, j, cardRechargeInfo2);
    }

    public final String component1() {
        return this.transactionId;
    }

    public final String component2() {
        return this.paymentMode;
    }

    public final long component3() {
        return this.paymentTime;
    }

    public final CardRechargeInfo component4() {
        return this.cardRechargeInfo;
    }

    public final CardRechargePaymentProperties copy(String str, String str2, long j, CardRechargeInfo cardRechargeInfo2) {
        n86.e(str, "transactionId");
        n86.e(str2, "paymentMode");
        n86.e(cardRechargeInfo2, "cardRechargeInfo");
        return new CardRechargePaymentProperties(str, str2, j, cardRechargeInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardRechargePaymentProperties)) {
            return false;
        }
        CardRechargePaymentProperties cardRechargePaymentProperties = (CardRechargePaymentProperties) obj;
        return n86.a(this.transactionId, cardRechargePaymentProperties.transactionId) && n86.a(this.paymentMode, cardRechargePaymentProperties.paymentMode) && this.paymentTime == cardRechargePaymentProperties.paymentTime && n86.a(this.cardRechargeInfo, cardRechargePaymentProperties.cardRechargeInfo);
    }

    public final CardRechargeInfo getCardRechargeInfo() {
        return this.cardRechargeInfo;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final long getPaymentTime() {
        return this.paymentTime;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.paymentMode, this.transactionId.hashCode() * 31, 31);
        return this.cardRechargeInfo.hashCode() + ((d.a(this.paymentTime) + r0) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargePaymentProperties(transactionId=");
        i0.append(this.transactionId);
        i0.append(", paymentMode=");
        i0.append(this.paymentMode);
        i0.append(", paymentTime=");
        i0.append(this.paymentTime);
        i0.append(", cardRechargeInfo=");
        i0.append(this.cardRechargeInfo);
        i0.append(')');
        return i0.toString();
    }
}
