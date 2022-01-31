package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CardRechargeConfiguration.kt */
public final class CardRechargeConfiguration implements Parcelable {
    public static final Parcelable.Creator<CardRechargeConfiguration> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public static final int REQUIRED_CARD_NO_LENGTH = 16;
    private final String agency;
    private final ProductBranding branding;
    private final String city;
    private final String configId;
    private final CardRechargeFareInfo fareInfo;
    private final boolean isActive;
    private final boolean isVisible;
    private final int maxAppVer;
    private final int minAppVer;
    private final String name;
    private final String productSubType;
    private final String productType;
    private final String rechargeDelayCopy;
    private final List<String> terms;

    /* compiled from: CardRechargeConfiguration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final CardRechargeConfiguration convertProductConfigToCardRechargeConfig(ProductConfiguration productConfiguration) {
            if (productConfiguration == null || !isValidCardRechargeConfig(productConfiguration)) {
                return null;
            }
            String productId = productConfiguration.getProductId();
            n86.d(productId, "productId");
            String productCity = productConfiguration.getProductCity();
            n86.d(productCity, "productCity");
            String productName = productConfiguration.getProductName();
            n86.d(productName, "productName");
            String productAgency = productConfiguration.getProductAgency();
            n86.d(productAgency, "productAgency");
            String productType = productConfiguration.getProductType();
            n86.d(productType, "productType");
            String productSubType = productConfiguration.getProductSubType();
            n86.d(productSubType, "productSubType");
            CardRechargeFareInfo cardRechargeFareInfo = productConfiguration.getCardRechargeFareInfo();
            n86.d(cardRechargeFareInfo, "cardRechargeFareInfo");
            ProductBranding branding = productConfiguration.getBranding();
            n86.d(branding, "branding");
            List<String> productTerms = productConfiguration.getProductTerms();
            n86.d(productTerms, "productTerms");
            String rechargeDelayCopy = productConfiguration.getRechargeDelayCopy();
            n86.d(rechargeDelayCopy, CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
            return new CardRechargeConfiguration(productId, productCity, productName, productAgency, productType, productSubType, cardRechargeFareInfo, branding, productTerms, rechargeDelayCopy, productConfiguration.getIsActive(), productConfiguration.getIsVisible(), productConfiguration.getMinAppVer(), productConfiguration.getMaxAppVer());
        }

        public final boolean isValidCardRechargeConfig(ProductConfiguration productConfiguration) {
            if (productConfiguration != null && n86.a(productConfiguration.getProductType(), "cardRecharge") && n86.a(productConfiguration.getProductSubType(), "cardRecharge") && productConfiguration.isProductConfigSupportedOnCurrentAppVersion()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: CardRechargeConfiguration.kt */
    public static final class Creator implements Parcelable.Creator<CardRechargeConfiguration> {
        @Override // android.os.Parcelable.Creator
        public final CardRechargeConfiguration createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            CardRechargeFareInfo createFromParcel = CardRechargeFareInfo.CREATOR.createFromParcel(parcel);
            ProductBranding createFromParcel2 = ProductBranding.CREATOR.createFromParcel(parcel);
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString7 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new CardRechargeConfiguration(readString, readString2, readString3, readString4, readString5, readString6, createFromParcel, createFromParcel2, createStringArrayList, readString7, z2, z, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CardRechargeConfiguration[] newArray(int i) {
            return new CardRechargeConfiguration[i];
        }
    }

    public CardRechargeConfiguration(String str, String str2, String str3, String str4, String str5, String str6, CardRechargeFareInfo cardRechargeFareInfo, ProductBranding productBranding, List<String> list, String str7, boolean z, boolean z2, int i, int i2) {
        n86.e(str, "configId");
        n86.e(str2, "city");
        n86.e(str3, "name");
        n86.e(str4, "agency");
        n86.e(str5, "productType");
        n86.e(str6, "productSubType");
        n86.e(cardRechargeFareInfo, SuperPassJsonKeys.KEY_FARE_INFO);
        n86.e(productBranding, "branding");
        n86.e(list, "terms");
        n86.e(str7, CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
        this.configId = str;
        this.city = str2;
        this.name = str3;
        this.agency = str4;
        this.productType = str5;
        this.productSubType = str6;
        this.fareInfo = cardRechargeFareInfo;
        this.branding = productBranding;
        this.terms = list;
        this.rechargeDelayCopy = str7;
        this.isActive = z;
        this.isVisible = z2;
        this.minAppVer = i;
        this.maxAppVer = i2;
    }

    public static /* synthetic */ CardRechargeConfiguration copy$default(CardRechargeConfiguration cardRechargeConfiguration, String str, String str2, String str3, String str4, String str5, String str6, CardRechargeFareInfo cardRechargeFareInfo, ProductBranding productBranding, List list, String str7, boolean z, boolean z2, int i, int i2, int i3, Object obj) {
        return cardRechargeConfiguration.copy((i3 & 1) != 0 ? cardRechargeConfiguration.configId : str, (i3 & 2) != 0 ? cardRechargeConfiguration.city : str2, (i3 & 4) != 0 ? cardRechargeConfiguration.name : str3, (i3 & 8) != 0 ? cardRechargeConfiguration.agency : str4, (i3 & 16) != 0 ? cardRechargeConfiguration.productType : str5, (i3 & 32) != 0 ? cardRechargeConfiguration.productSubType : str6, (i3 & 64) != 0 ? cardRechargeConfiguration.fareInfo : cardRechargeFareInfo, (i3 & 128) != 0 ? cardRechargeConfiguration.branding : productBranding, (i3 & 256) != 0 ? cardRechargeConfiguration.terms : list, (i3 & 512) != 0 ? cardRechargeConfiguration.rechargeDelayCopy : str7, (i3 & 1024) != 0 ? cardRechargeConfiguration.isActive : z, (i3 & 2048) != 0 ? cardRechargeConfiguration.isVisible : z2, (i3 & 4096) != 0 ? cardRechargeConfiguration.minAppVer : i, (i3 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0 ? cardRechargeConfiguration.maxAppVer : i2);
    }

    public final String component1() {
        return this.configId;
    }

    public final String component10() {
        return this.rechargeDelayCopy;
    }

    public final boolean component11() {
        return this.isActive;
    }

    public final boolean component12() {
        return this.isVisible;
    }

    public final int component13() {
        return this.minAppVer;
    }

    public final int component14() {
        return this.maxAppVer;
    }

    public final String component2() {
        return this.city;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.agency;
    }

    public final String component5() {
        return this.productType;
    }

    public final String component6() {
        return this.productSubType;
    }

    public final CardRechargeFareInfo component7() {
        return this.fareInfo;
    }

    public final ProductBranding component8() {
        return this.branding;
    }

    public final List<String> component9() {
        return this.terms;
    }

    public final CardRechargeConfiguration copy(String str, String str2, String str3, String str4, String str5, String str6, CardRechargeFareInfo cardRechargeFareInfo, ProductBranding productBranding, List<String> list, String str7, boolean z, boolean z2, int i, int i2) {
        n86.e(str, "configId");
        n86.e(str2, "city");
        n86.e(str3, "name");
        n86.e(str4, "agency");
        n86.e(str5, "productType");
        n86.e(str6, "productSubType");
        n86.e(cardRechargeFareInfo, SuperPassJsonKeys.KEY_FARE_INFO);
        n86.e(productBranding, "branding");
        n86.e(list, "terms");
        n86.e(str7, CardRechargeJsonKeys.RECHARGE_DELAY_COPY);
        return new CardRechargeConfiguration(str, str2, str3, str4, str5, str6, cardRechargeFareInfo, productBranding, list, str7, z, z2, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardRechargeConfiguration)) {
            return false;
        }
        CardRechargeConfiguration cardRechargeConfiguration = (CardRechargeConfiguration) obj;
        return n86.a(this.configId, cardRechargeConfiguration.configId) && n86.a(this.city, cardRechargeConfiguration.city) && n86.a(this.name, cardRechargeConfiguration.name) && n86.a(this.agency, cardRechargeConfiguration.agency) && n86.a(this.productType, cardRechargeConfiguration.productType) && n86.a(this.productSubType, cardRechargeConfiguration.productSubType) && n86.a(this.fareInfo, cardRechargeConfiguration.fareInfo) && n86.a(this.branding, cardRechargeConfiguration.branding) && n86.a(this.terms, cardRechargeConfiguration.terms) && n86.a(this.rechargeDelayCopy, cardRechargeConfiguration.rechargeDelayCopy) && this.isActive == cardRechargeConfiguration.isActive && this.isVisible == cardRechargeConfiguration.isVisible && this.minAppVer == cardRechargeConfiguration.minAppVer && this.maxAppVer == cardRechargeConfiguration.maxAppVer;
    }

    public final String getAgency() {
        return this.agency;
    }

    public final ProductBranding getBranding() {
        return this.branding;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final CardRechargeFareInfo getFareInfo() {
        return this.fareInfo;
    }

    public final int getMaxAppVer() {
        return this.maxAppVer;
    }

    public final int getMinAppVer() {
        return this.minAppVer;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductSubType() {
        return this.productSubType;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getRechargeDelayCopy() {
        return this.rechargeDelayCopy;
    }

    public final List<String> getTerms() {
        return this.terms;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.productSubType, hj1.r0(this.productType, hj1.r0(this.agency, hj1.r0(this.name, hj1.r0(this.city, this.configId.hashCode() * 31, 31), 31), 31), 31), 31);
        int hashCode = this.branding.hashCode();
        int hashCode2 = this.terms.hashCode();
        int r02 = hj1.r0(this.rechargeDelayCopy, (hashCode2 + ((hashCode + ((this.fareInfo.hashCode() + r0) * 31)) * 31)) * 31, 31);
        boolean z = this.isActive;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (r02 + i2) * 31;
        boolean z2 = this.isVisible;
        if (!z2) {
            i = z2 ? 1 : 0;
        }
        return ((((i5 + i) * 31) + this.minAppVer) * 31) + this.maxAppVer;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("CardRechargeConfiguration(configId=");
        i0.append(this.configId);
        i0.append(", city=");
        i0.append(this.city);
        i0.append(", name=");
        i0.append(this.name);
        i0.append(", agency=");
        i0.append(this.agency);
        i0.append(", productType=");
        i0.append(this.productType);
        i0.append(", productSubType=");
        i0.append(this.productSubType);
        i0.append(", fareInfo=");
        i0.append(this.fareInfo);
        i0.append(", branding=");
        i0.append(this.branding);
        i0.append(", terms=");
        i0.append(this.terms);
        i0.append(", rechargeDelayCopy=");
        i0.append(this.rechargeDelayCopy);
        i0.append(", isActive=");
        i0.append(this.isActive);
        i0.append(", isVisible=");
        i0.append(this.isVisible);
        i0.append(", minAppVer=");
        i0.append(this.minAppVer);
        i0.append(", maxAppVer=");
        return hj1.W(i0, this.maxAppVer, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.configId);
        parcel.writeString(this.city);
        parcel.writeString(this.name);
        parcel.writeString(this.agency);
        parcel.writeString(this.productType);
        parcel.writeString(this.productSubType);
        this.fareInfo.writeToParcel(parcel, i);
        this.branding.writeToParcel(parcel, i);
        parcel.writeStringList(this.terms);
        parcel.writeString(this.rechargeDelayCopy);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeInt(this.isVisible ? 1 : 0);
        parcel.writeInt(this.minAppVer);
        parcel.writeInt(this.maxAppVer);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardRechargeConfiguration(String str, String str2, String str3, String str4, String str5, String str6, CardRechargeFareInfo cardRechargeFareInfo, ProductBranding productBranding, List list, String str7, boolean z, boolean z2, int i, int i2, int i3, j86 j86) {
        this(str, str2, str3, str4, str5, str6, cardRechargeFareInfo, productBranding, list, (i3 & 512) != 0 ? new String() : str7, (i3 & 1024) != 0 ? true : z, (i3 & 2048) != 0 ? true : z2, (i3 & 4096) != 0 ? -1 : i, (i3 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0 ? -1 : i2);
    }
}
