package app.zophop.models.mTicketing.cardRecharge;

import app.zophop.models.mTicketing.ProductBranding;

/* compiled from: CardRechargeUIProperties.kt */
public final class CardRechargeUIProperties {
    private final ProductBranding branding;
    private final String productName;
    private final String rechargeDelayCopy;

    public CardRechargeUIProperties(String str, ProductBranding productBranding, String str2) {
        n86.e(str, "productName");
        n86.e(productBranding, "branding");
        n86.e(str2, CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
        this.productName = str;
        this.branding = productBranding;
        this.rechargeDelayCopy = str2;
    }

    public static /* synthetic */ CardRechargeUIProperties copy$default(CardRechargeUIProperties cardRechargeUIProperties, String str, ProductBranding productBranding, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardRechargeUIProperties.productName;
        }
        if ((i & 2) != 0) {
            productBranding = cardRechargeUIProperties.branding;
        }
        if ((i & 4) != 0) {
            str2 = cardRechargeUIProperties.rechargeDelayCopy;
        }
        return cardRechargeUIProperties.copy(str, productBranding, str2);
    }

    public final String component1() {
        return this.productName;
    }

    public final ProductBranding component2() {
        return this.branding;
    }

    public final String component3() {
        return this.rechargeDelayCopy;
    }

    public final CardRechargeUIProperties copy(String str, ProductBranding productBranding, String str2) {
        n86.e(str, "productName");
        n86.e(productBranding, "branding");
        n86.e(str2, CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
        return new CardRechargeUIProperties(str, productBranding, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardRechargeUIProperties)) {
            return false;
        }
        CardRechargeUIProperties cardRechargeUIProperties = (CardRechargeUIProperties) obj;
        return n86.a(this.productName, cardRechargeUIProperties.productName) && n86.a(this.branding, cardRechargeUIProperties.branding) && n86.a(this.rechargeDelayCopy, cardRechargeUIProperties.rechargeDelayCopy);
    }

    public final ProductBranding getBranding() {
        return this.branding;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getRechargeDelayCopy() {
        return this.rechargeDelayCopy;
    }

    public int hashCode() {
        int hashCode = this.branding.hashCode();
        return this.rechargeDelayCopy.hashCode() + ((hashCode + (this.productName.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargeUIProperties(productName=");
        i0.append(this.productName);
        i0.append(", branding=");
        i0.append(this.branding);
        i0.append(", rechargeDelayCopy=");
        return hj1.Z(i0, this.rechargeDelayCopy, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardRechargeUIProperties(String str, ProductBranding productBranding, String str2, int i, j86 j86) {
        this(str, productBranding, (i & 4) != 0 ? new String() : str2);
    }
}
