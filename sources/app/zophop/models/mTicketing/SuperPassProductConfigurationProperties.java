package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.ProductGroup;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.List;

/* compiled from: SuperPassProductConfigurationProperties.kt */
public final class SuperPassProductConfigurationProperties implements Parcelable {
    public static final Parcelable.Creator<SuperPassProductConfigurationProperties> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final ProductBranding branding;
    private final String inactiveReason;
    private final boolean isActive;
    private final boolean isVisible;
    private final int maxAppVer;
    private final int minAppVer;
    private final long productActivationDuration;
    private final String productAdditionalInfo;
    private final String productAgency;
    private final String productCity;
    private final String productDesc;
    private final String productId;
    private final String productLabel;
    private final String productLogo;
    private final String productName;
    private final int productPriority;
    private final String productSubType;
    private final List<String> productTermsAndConditions;
    private final String productType;
    private final boolean shouldHideSubCategorySelection;
    private final SubCategorySelectionDetails subCategorySelectionDetails;

    /* compiled from: SuperPassProductConfigurationProperties.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final SuperPassProductConfigurationProperties getSuperPassProductConfigPropertiesFromProductConfiguration(ProductConfiguration productConfiguration) {
            n86.e(productConfiguration, "lProductConfiguration");
            String productId = productConfiguration.getProductId();
            n86.d(productId, "productId");
            String productCity = productConfiguration.getProductCity();
            n86.d(productCity, "productCity");
            String productName = productConfiguration.getProductName();
            n86.d(productName, "productName");
            String productDesc = productConfiguration.getProductDesc();
            String productLogo = productConfiguration.getProductLogo();
            String productLabel = productConfiguration.getProductLabel();
            String productAdditionalInfo = productConfiguration.getProductAdditionalInfo();
            int productPriority = productConfiguration.getProductPriority();
            String productType = productConfiguration.getProductType();
            n86.d(productType, "productType");
            String productSubType = productConfiguration.getProductSubType();
            n86.d(productSubType, "productSubType");
            String productAgency = productConfiguration.getProductAgency();
            n86.d(productAgency, "productAgency");
            List<String> productTerms = productConfiguration.getProductTerms();
            long productActiveDuration = productConfiguration.getProductActiveDuration();
            boolean isActive = productConfiguration.getIsActive();
            String inactiveReason = productConfiguration.getInactiveReason();
            boolean isVisible = productConfiguration.getIsVisible();
            boolean shouldHideSubCategorySelection = productConfiguration.shouldHideSubCategorySelection();
            ProductBranding branding = productConfiguration.getBranding();
            n86.d(branding, "branding");
            return new SuperPassProductConfigurationProperties(productId, productCity, productName, productDesc, productLogo, productLabel, productAdditionalInfo, productPriority, productType, productSubType, productAgency, productTerms, productActiveDuration, isActive, inactiveReason, isVisible, shouldHideSubCategorySelection, branding, productConfiguration.getSubCategorySelectionDetails(), productConfiguration.getMinAppVer(), productConfiguration.getMaxAppVer());
        }
    }

    /* compiled from: SuperPassProductConfigurationProperties.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassProductConfigurationProperties> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassProductConfigurationProperties createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassProductConfigurationProperties(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readLong(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, ProductBranding.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SubCategorySelectionDetails.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassProductConfigurationProperties[] newArray(int i) {
            return new SuperPassProductConfigurationProperties[i];
        }
    }

    public SuperPassProductConfigurationProperties(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, List<String> list, long j, boolean z, String str11, boolean z2, boolean z3, ProductBranding productBranding, SubCategorySelectionDetails subCategorySelectionDetails2, int i2, int i3) {
        n86.e(str, "productId");
        n86.e(str2, "productCity");
        n86.e(str3, "productName");
        n86.e(str8, "productType");
        n86.e(str9, "productSubType");
        n86.e(str10, "productAgency");
        n86.e(productBranding, "branding");
        this.productId = str;
        this.productCity = str2;
        this.productName = str3;
        this.productDesc = str4;
        this.productLogo = str5;
        this.productLabel = str6;
        this.productAdditionalInfo = str7;
        this.productPriority = i;
        this.productType = str8;
        this.productSubType = str9;
        this.productAgency = str10;
        this.productTermsAndConditions = list;
        this.productActivationDuration = j;
        this.isActive = z;
        this.inactiveReason = str11;
        this.isVisible = z2;
        this.shouldHideSubCategorySelection = z3;
        this.branding = productBranding;
        this.subCategorySelectionDetails = subCategorySelectionDetails2;
        this.minAppVer = i2;
        this.maxAppVer = i3;
    }

    public static /* synthetic */ SuperPassProductConfigurationProperties copy$default(SuperPassProductConfigurationProperties superPassProductConfigurationProperties, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, List list, long j, boolean z, String str11, boolean z2, boolean z3, ProductBranding productBranding, SubCategorySelectionDetails subCategorySelectionDetails2, int i2, int i3, int i4, Object obj) {
        return superPassProductConfigurationProperties.copy((i4 & 1) != 0 ? superPassProductConfigurationProperties.productId : str, (i4 & 2) != 0 ? superPassProductConfigurationProperties.productCity : str2, (i4 & 4) != 0 ? superPassProductConfigurationProperties.productName : str3, (i4 & 8) != 0 ? superPassProductConfigurationProperties.productDesc : str4, (i4 & 16) != 0 ? superPassProductConfigurationProperties.productLogo : str5, (i4 & 32) != 0 ? superPassProductConfigurationProperties.productLabel : str6, (i4 & 64) != 0 ? superPassProductConfigurationProperties.productAdditionalInfo : str7, (i4 & 128) != 0 ? superPassProductConfigurationProperties.productPriority : i, (i4 & 256) != 0 ? superPassProductConfigurationProperties.productType : str8, (i4 & 512) != 0 ? superPassProductConfigurationProperties.productSubType : str9, (i4 & 1024) != 0 ? superPassProductConfigurationProperties.productAgency : str10, (i4 & 2048) != 0 ? superPassProductConfigurationProperties.productTermsAndConditions : list, (i4 & 4096) != 0 ? superPassProductConfigurationProperties.productActivationDuration : j, (i4 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0 ? superPassProductConfigurationProperties.isActive : z, (i4 & 16384) != 0 ? superPassProductConfigurationProperties.inactiveReason : str11, (i4 & 32768) != 0 ? superPassProductConfigurationProperties.isVisible : z2, (i4 & 65536) != 0 ? superPassProductConfigurationProperties.shouldHideSubCategorySelection : z3, (i4 & 131072) != 0 ? superPassProductConfigurationProperties.branding : productBranding, (i4 & 262144) != 0 ? superPassProductConfigurationProperties.subCategorySelectionDetails : subCategorySelectionDetails2, (i4 & 524288) != 0 ? superPassProductConfigurationProperties.minAppVer : i2, (i4 & CommonUtils.BYTES_IN_A_MEGABYTE) != 0 ? superPassProductConfigurationProperties.maxAppVer : i3);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component10() {
        return this.productSubType;
    }

    public final String component11() {
        return this.productAgency;
    }

    public final List<String> component12() {
        return this.productTermsAndConditions;
    }

    public final long component13() {
        return this.productActivationDuration;
    }

    public final boolean component14() {
        return this.isActive;
    }

    public final String component15() {
        return this.inactiveReason;
    }

    public final boolean component16() {
        return this.isVisible;
    }

    public final boolean component17() {
        return this.shouldHideSubCategorySelection;
    }

    public final ProductBranding component18() {
        return this.branding;
    }

    public final SubCategorySelectionDetails component19() {
        return this.subCategorySelectionDetails;
    }

    public final String component2() {
        return this.productCity;
    }

    public final int component20() {
        return this.minAppVer;
    }

    public final int component21() {
        return this.maxAppVer;
    }

    public final String component3() {
        return this.productName;
    }

    public final String component4() {
        return this.productDesc;
    }

    public final String component5() {
        return this.productLogo;
    }

    public final String component6() {
        return this.productLabel;
    }

    public final String component7() {
        return this.productAdditionalInfo;
    }

    public final int component8() {
        return this.productPriority;
    }

    public final String component9() {
        return this.productType;
    }

    public final SuperPassProductConfigurationProperties copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, List<String> list, long j, boolean z, String str11, boolean z2, boolean z3, ProductBranding productBranding, SubCategorySelectionDetails subCategorySelectionDetails2, int i2, int i3) {
        n86.e(str, "productId");
        n86.e(str2, "productCity");
        n86.e(str3, "productName");
        n86.e(str8, "productType");
        n86.e(str9, "productSubType");
        n86.e(str10, "productAgency");
        n86.e(productBranding, "branding");
        return new SuperPassProductConfigurationProperties(str, str2, str3, str4, str5, str6, str7, i, str8, str9, str10, list, j, z, str11, z2, z3, productBranding, subCategorySelectionDetails2, i2, i3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassProductConfigurationProperties)) {
            return false;
        }
        SuperPassProductConfigurationProperties superPassProductConfigurationProperties = (SuperPassProductConfigurationProperties) obj;
        return n86.a(this.productId, superPassProductConfigurationProperties.productId) && n86.a(this.productCity, superPassProductConfigurationProperties.productCity) && n86.a(this.productName, superPassProductConfigurationProperties.productName) && n86.a(this.productDesc, superPassProductConfigurationProperties.productDesc) && n86.a(this.productLogo, superPassProductConfigurationProperties.productLogo) && n86.a(this.productLabel, superPassProductConfigurationProperties.productLabel) && n86.a(this.productAdditionalInfo, superPassProductConfigurationProperties.productAdditionalInfo) && this.productPriority == superPassProductConfigurationProperties.productPriority && n86.a(this.productType, superPassProductConfigurationProperties.productType) && n86.a(this.productSubType, superPassProductConfigurationProperties.productSubType) && n86.a(this.productAgency, superPassProductConfigurationProperties.productAgency) && n86.a(this.productTermsAndConditions, superPassProductConfigurationProperties.productTermsAndConditions) && this.productActivationDuration == superPassProductConfigurationProperties.productActivationDuration && this.isActive == superPassProductConfigurationProperties.isActive && n86.a(this.inactiveReason, superPassProductConfigurationProperties.inactiveReason) && this.isVisible == superPassProductConfigurationProperties.isVisible && this.shouldHideSubCategorySelection == superPassProductConfigurationProperties.shouldHideSubCategorySelection && n86.a(this.branding, superPassProductConfigurationProperties.branding) && n86.a(this.subCategorySelectionDetails, superPassProductConfigurationProperties.subCategorySelectionDetails) && this.minAppVer == superPassProductConfigurationProperties.minAppVer && this.maxAppVer == superPassProductConfigurationProperties.maxAppVer;
    }

    public final ProductBranding getBranding() {
        return this.branding;
    }

    public final String getInactiveReason() {
        return this.inactiveReason;
    }

    public final int getMaxAppVer() {
        return this.maxAppVer;
    }

    public final int getMinAppVer() {
        return this.minAppVer;
    }

    public final long getProductActivationDuration() {
        return this.productActivationDuration;
    }

    public final String getProductAdditionalInfo() {
        return this.productAdditionalInfo;
    }

    public final String getProductAgency() {
        return this.productAgency;
    }

    public final String getProductCity() {
        return this.productCity;
    }

    public final String getProductDesc() {
        return this.productDesc;
    }

    public final ProductGroup getProductGroup() {
        if (ea6.f("singleJourneyTicket", this.productType, true)) {
            return ProductGroup.TICKET;
        }
        if (ea6.f("cardRecharge", this.productType, true)) {
            return ProductGroup.CARDRECHARGE;
        }
        return ProductGroup.LONGTERM;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductLabel() {
        return this.productLabel;
    }

    public final String getProductLogo() {
        return this.productLogo;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final int getProductPriority() {
        return this.productPriority;
    }

    public final String getProductSubType() {
        return this.productSubType;
    }

    public final List<String> getProductTermsAndConditions() {
        return this.productTermsAndConditions;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final boolean getShouldHideSubCategorySelection() {
        return this.shouldHideSubCategorySelection;
    }

    public final SubCategorySelectionDetails getSubCategorySelectionDetails() {
        return this.subCategorySelectionDetails;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.productName, hj1.r0(this.productCity, this.productId.hashCode() * 31, 31), 31);
        String str = this.productDesc;
        int i = 0;
        int hashCode = (r0 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.productLogo;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.productLabel;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.productAdditionalInfo;
        int r02 = hj1.r0(this.productAgency, hj1.r0(this.productSubType, hj1.r0(this.productType, (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.productPriority) * 31, 31), 31), 31);
        List<String> list = this.productTermsAndConditions;
        int a2 = (d.a(this.productActivationDuration) + ((r02 + (list == null ? 0 : list.hashCode())) * 31)) * 31;
        boolean z = this.isActive;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (a2 + i3) * 31;
        String str5 = this.inactiveReason;
        int hashCode4 = (i6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z2 = this.isVisible;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode4 + i7) * 31;
        boolean z3 = this.shouldHideSubCategorySelection;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        int hashCode5 = (this.branding.hashCode() + ((i10 + i2) * 31)) * 31;
        SubCategorySelectionDetails subCategorySelectionDetails2 = this.subCategorySelectionDetails;
        if (subCategorySelectionDetails2 != null) {
            i = subCategorySelectionDetails2.hashCode();
        }
        return ((((hashCode5 + i) * 31) + this.minAppVer) * 31) + this.maxAppVer;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassProductConfigurationProperties(productId=");
        i0.append(this.productId);
        i0.append(", productCity=");
        i0.append(this.productCity);
        i0.append(", productName=");
        i0.append(this.productName);
        i0.append(", productDesc=");
        i0.append((Object) this.productDesc);
        i0.append(", productLogo=");
        i0.append((Object) this.productLogo);
        i0.append(", productLabel=");
        i0.append((Object) this.productLabel);
        i0.append(", productAdditionalInfo=");
        i0.append((Object) this.productAdditionalInfo);
        i0.append(", productPriority=");
        i0.append(this.productPriority);
        i0.append(", productType=");
        i0.append(this.productType);
        i0.append(", productSubType=");
        i0.append(this.productSubType);
        i0.append(", productAgency=");
        i0.append(this.productAgency);
        i0.append(", productTermsAndConditions=");
        i0.append(this.productTermsAndConditions);
        i0.append(", productActivationDuration=");
        i0.append(this.productActivationDuration);
        i0.append(", isActive=");
        i0.append(this.isActive);
        i0.append(", inactiveReason=");
        i0.append((Object) this.inactiveReason);
        i0.append(", isVisible=");
        i0.append(this.isVisible);
        i0.append(", shouldHideSubCategorySelection=");
        i0.append(this.shouldHideSubCategorySelection);
        i0.append(", branding=");
        i0.append(this.branding);
        i0.append(", subCategorySelectionDetails=");
        i0.append(this.subCategorySelectionDetails);
        i0.append(", minAppVer=");
        i0.append(this.minAppVer);
        i0.append(", maxAppVer=");
        return hj1.W(i0, this.maxAppVer, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.productId);
        parcel.writeString(this.productCity);
        parcel.writeString(this.productName);
        parcel.writeString(this.productDesc);
        parcel.writeString(this.productLogo);
        parcel.writeString(this.productLabel);
        parcel.writeString(this.productAdditionalInfo);
        parcel.writeInt(this.productPriority);
        parcel.writeString(this.productType);
        parcel.writeString(this.productSubType);
        parcel.writeString(this.productAgency);
        parcel.writeStringList(this.productTermsAndConditions);
        parcel.writeLong(this.productActivationDuration);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeString(this.inactiveReason);
        parcel.writeInt(this.isVisible ? 1 : 0);
        parcel.writeInt(this.shouldHideSubCategorySelection ? 1 : 0);
        this.branding.writeToParcel(parcel, i);
        SubCategorySelectionDetails subCategorySelectionDetails2 = this.subCategorySelectionDetails;
        if (subCategorySelectionDetails2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subCategorySelectionDetails2.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.minAppVer);
        parcel.writeInt(this.maxAppVer);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassProductConfigurationProperties(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, List list, long j, boolean z, String str11, boolean z2, boolean z3, ProductBranding productBranding, SubCategorySelectionDetails subCategorySelectionDetails2, int i2, int i3, int i4, j86 j86) {
        this(str, str2, str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, (i4 & 32) != 0 ? null : str6, (i4 & 64) != 0 ? null : str7, (i4 & 128) != 0 ? 0 : i, str8, str9, str10, (i4 & 2048) != 0 ? null : list, (i4 & 4096) != 0 ? 0 : j, (i4 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0 ? false : z, (i4 & 16384) != 0 ? null : str11, (32768 & i4) != 0 ? false : z2, (65536 & i4) != 0 ? false : z3, productBranding, (262144 & i4) != 0 ? null : subCategorySelectionDetails2, (524288 & i4) != 0 ? -1 : i2, (i4 & CommonUtils.BYTES_IN_A_MEGABYTE) != 0 ? -1 : i3);
    }
}
