package app.zophop.models.mTicketing.cardRecharge;

/* compiled from: OnlineCardRecharge.kt */
public final class OnlineCardRecharge {
    private final CardProperties cardProperties;
    private final CardRechargePaymentProperties cardRechargePaymentProperties;
    private final CardRechargeUIProperties cardRechargeUIProperties;

    public OnlineCardRecharge(CardRechargePaymentProperties cardRechargePaymentProperties2, CardRechargeUIProperties cardRechargeUIProperties2, CardProperties cardProperties2) {
        n86.e(cardRechargePaymentProperties2, "cardRechargePaymentProperties");
        n86.e(cardRechargeUIProperties2, "cardRechargeUIProperties");
        n86.e(cardProperties2, "cardProperties");
        this.cardRechargePaymentProperties = cardRechargePaymentProperties2;
        this.cardRechargeUIProperties = cardRechargeUIProperties2;
        this.cardProperties = cardProperties2;
    }

    public static /* synthetic */ OnlineCardRecharge copy$default(OnlineCardRecharge onlineCardRecharge, CardRechargePaymentProperties cardRechargePaymentProperties2, CardRechargeUIProperties cardRechargeUIProperties2, CardProperties cardProperties2, int i, Object obj) {
        if ((i & 1) != 0) {
            cardRechargePaymentProperties2 = onlineCardRecharge.cardRechargePaymentProperties;
        }
        if ((i & 2) != 0) {
            cardRechargeUIProperties2 = onlineCardRecharge.cardRechargeUIProperties;
        }
        if ((i & 4) != 0) {
            cardProperties2 = onlineCardRecharge.cardProperties;
        }
        return onlineCardRecharge.copy(cardRechargePaymentProperties2, cardRechargeUIProperties2, cardProperties2);
    }

    public final CardRechargePaymentProperties component1() {
        return this.cardRechargePaymentProperties;
    }

    public final CardRechargeUIProperties component2() {
        return this.cardRechargeUIProperties;
    }

    public final CardProperties component3() {
        return this.cardProperties;
    }

    public final OnlineCardRecharge copy(CardRechargePaymentProperties cardRechargePaymentProperties2, CardRechargeUIProperties cardRechargeUIProperties2, CardProperties cardProperties2) {
        n86.e(cardRechargePaymentProperties2, "cardRechargePaymentProperties");
        n86.e(cardRechargeUIProperties2, "cardRechargeUIProperties");
        n86.e(cardProperties2, "cardProperties");
        return new OnlineCardRecharge(cardRechargePaymentProperties2, cardRechargeUIProperties2, cardProperties2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnlineCardRecharge)) {
            return false;
        }
        OnlineCardRecharge onlineCardRecharge = (OnlineCardRecharge) obj;
        return n86.a(this.cardRechargePaymentProperties, onlineCardRecharge.cardRechargePaymentProperties) && n86.a(this.cardRechargeUIProperties, onlineCardRecharge.cardRechargeUIProperties) && n86.a(this.cardProperties, onlineCardRecharge.cardProperties);
    }

    public final CardProperties getCardProperties() {
        return this.cardProperties;
    }

    public final CardRechargePaymentProperties getCardRechargePaymentProperties() {
        return this.cardRechargePaymentProperties;
    }

    public final CardRechargeUIProperties getCardRechargeUIProperties() {
        return this.cardRechargeUIProperties;
    }

    public int hashCode() {
        int hashCode = this.cardRechargeUIProperties.hashCode();
        return this.cardProperties.hashCode() + ((hashCode + (this.cardRechargePaymentProperties.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("OnlineCardRecharge(cardRechargePaymentProperties=");
        i0.append(this.cardRechargePaymentProperties);
        i0.append(", cardRechargeUIProperties=");
        i0.append(this.cardRechargeUIProperties);
        i0.append(", cardProperties=");
        i0.append(this.cardProperties);
        i0.append(')');
        return i0.toString();
    }
}
