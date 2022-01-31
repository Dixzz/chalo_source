package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BookableSuperPassConfiguration.kt */
public final class BookableSuperPassConfiguration implements Parcelable {
    public static final Parcelable.Creator<BookableSuperPassConfiguration> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String configId;
    private final List<String> requiredProofsList;
    private final ProductCategory selectedProductCategory;
    private final ProductFareMapping selectedProductFareMapping;
    private final ProductSubCategory selectedSubCategory;
    private final SuperPassProductConfigurationProperties superPassProductConfigurationProperties;

    /* compiled from: BookableSuperPassConfiguration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final String convertBookableSuperPassConfigToString(BookableSuperPassConfiguration bookableSuperPassConfiguration) {
            n86.e(bookableSuperPassConfiguration, "lBookablePassConfig");
            String json = new Gson().toJson(bookableSuperPassConfiguration);
            n86.d(json, "lGson.toJson(lBookablePassConfig)");
            return json;
        }

        public final BookableSuperPassConfiguration getBookableSuperPassConfigFromString(String str) {
            n86.e(str, "lBookableConfigString");
            Object fromJson = new Gson().fromJson(str, BookableSuperPassConfiguration.class);
            n86.d(fromJson, "lGson.fromJson(lBookable…onfiguration::class.java)");
            return (BookableSuperPassConfiguration) fromJson;
        }
    }

    /* compiled from: BookableSuperPassConfiguration.kt */
    public static final class Creator implements Parcelable.Creator<BookableSuperPassConfiguration> {
        @Override // android.os.Parcelable.Creator
        public final BookableSuperPassConfiguration createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new BookableSuperPassConfiguration(parcel.readString(), SuperPassProductConfigurationProperties.CREATOR.createFromParcel(parcel), (ProductFareMapping) parcel.readParcelable(BookableSuperPassConfiguration.class.getClassLoader()), (ProductCategory) parcel.readParcelable(BookableSuperPassConfiguration.class.getClassLoader()), parcel.readInt() == 0 ? null : ProductSubCategory.CREATOR.createFromParcel(parcel), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final BookableSuperPassConfiguration[] newArray(int i) {
            return new BookableSuperPassConfiguration[i];
        }
    }

    public BookableSuperPassConfiguration(String str, SuperPassProductConfigurationProperties superPassProductConfigurationProperties2, ProductFareMapping productFareMapping, ProductCategory productCategory, ProductSubCategory productSubCategory, List<String> list) {
        n86.e(str, "configId");
        n86.e(superPassProductConfigurationProperties2, "superPassProductConfigurationProperties");
        n86.e(productFareMapping, "selectedProductFareMapping");
        n86.e(productCategory, "selectedProductCategory");
        n86.e(list, "requiredProofsList");
        this.configId = str;
        this.superPassProductConfigurationProperties = superPassProductConfigurationProperties2;
        this.selectedProductFareMapping = productFareMapping;
        this.selectedProductCategory = productCategory;
        this.selectedSubCategory = productSubCategory;
        this.requiredProofsList = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: app.zophop.models.mTicketing.BookableSuperPassConfiguration */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookableSuperPassConfiguration copy$default(BookableSuperPassConfiguration bookableSuperPassConfiguration, String str, SuperPassProductConfigurationProperties superPassProductConfigurationProperties2, ProductFareMapping productFareMapping, ProductCategory productCategory, ProductSubCategory productSubCategory, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bookableSuperPassConfiguration.configId;
        }
        if ((i & 2) != 0) {
            superPassProductConfigurationProperties2 = bookableSuperPassConfiguration.superPassProductConfigurationProperties;
        }
        if ((i & 4) != 0) {
            productFareMapping = bookableSuperPassConfiguration.selectedProductFareMapping;
        }
        if ((i & 8) != 0) {
            productCategory = bookableSuperPassConfiguration.selectedProductCategory;
        }
        if ((i & 16) != 0) {
            productSubCategory = bookableSuperPassConfiguration.selectedSubCategory;
        }
        if ((i & 32) != 0) {
            list = bookableSuperPassConfiguration.requiredProofsList;
        }
        return bookableSuperPassConfiguration.copy(str, superPassProductConfigurationProperties2, productFareMapping, productCategory, productSubCategory, list);
    }

    public final String component1() {
        return this.configId;
    }

    public final SuperPassProductConfigurationProperties component2() {
        return this.superPassProductConfigurationProperties;
    }

    public final ProductFareMapping component3() {
        return this.selectedProductFareMapping;
    }

    public final ProductCategory component4() {
        return this.selectedProductCategory;
    }

    public final ProductSubCategory component5() {
        return this.selectedSubCategory;
    }

    public final List<String> component6() {
        return this.requiredProofsList;
    }

    public final BookableSuperPassConfiguration copy(String str, SuperPassProductConfigurationProperties superPassProductConfigurationProperties2, ProductFareMapping productFareMapping, ProductCategory productCategory, ProductSubCategory productSubCategory, List<String> list) {
        n86.e(str, "configId");
        n86.e(superPassProductConfigurationProperties2, "superPassProductConfigurationProperties");
        n86.e(productFareMapping, "selectedProductFareMapping");
        n86.e(productCategory, "selectedProductCategory");
        n86.e(list, "requiredProofsList");
        return new BookableSuperPassConfiguration(str, superPassProductConfigurationProperties2, productFareMapping, productCategory, productSubCategory, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookableSuperPassConfiguration)) {
            return false;
        }
        BookableSuperPassConfiguration bookableSuperPassConfiguration = (BookableSuperPassConfiguration) obj;
        return n86.a(this.configId, bookableSuperPassConfiguration.configId) && n86.a(this.superPassProductConfigurationProperties, bookableSuperPassConfiguration.superPassProductConfigurationProperties) && n86.a(this.selectedProductFareMapping, bookableSuperPassConfiguration.selectedProductFareMapping) && n86.a(this.selectedProductCategory, bookableSuperPassConfiguration.selectedProductCategory) && n86.a(this.selectedSubCategory, bookableSuperPassConfiguration.selectedSubCategory) && n86.a(this.requiredProofsList, bookableSuperPassConfiguration.requiredProofsList);
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final String getInactiveReason() {
        boolean z = false;
        if (this.selectedProductFareMapping.getIsActive() != null) {
            String inactiveReason = this.selectedProductFareMapping.getInactiveReason();
            if (!(inactiveReason == null || inactiveReason.length() == 0)) {
                String inactiveReason2 = this.selectedProductFareMapping.getInactiveReason();
                n86.d(inactiveReason2, "selectedProductFareMapping.inactiveReason");
                return inactiveReason2;
            }
        }
        if (!this.selectedProductCategory.isCategoryActive()) {
            String inactiveReason3 = this.selectedProductCategory.getInactiveReason();
            if (inactiveReason3 == null || inactiveReason3.length() == 0) {
                z = true;
            }
            if (!z) {
                String inactiveReason4 = this.selectedProductCategory.getInactiveReason();
                n86.d(inactiveReason4, "selectedProductCategory.inactiveReason");
                return inactiveReason4;
            }
        }
        String inactiveReason5 = this.superPassProductConfigurationProperties.getInactiveReason();
        return inactiveReason5 == null ? new String() : inactiveReason5;
    }

    public final List<String> getRequiredProofsList() {
        return this.requiredProofsList;
    }

    public final ProductCategory getSelectedProductCategory() {
        return this.selectedProductCategory;
    }

    public final ProductFareMapping getSelectedProductFareMapping() {
        return this.selectedProductFareMapping;
    }

    public final ProductSubCategory getSelectedSubCategory() {
        return this.selectedSubCategory;
    }

    public final SuperPassProductConfigurationProperties getSuperPassProductConfigurationProperties() {
        return this.superPassProductConfigurationProperties;
    }

    public int hashCode() {
        int hashCode = this.superPassProductConfigurationProperties.hashCode();
        int hashCode2 = (this.selectedProductCategory.hashCode() + ((this.selectedProductFareMapping.hashCode() + ((hashCode + (this.configId.hashCode() * 31)) * 31)) * 31)) * 31;
        ProductSubCategory productSubCategory = this.selectedSubCategory;
        return this.requiredProofsList.hashCode() + ((hashCode2 + (productSubCategory == null ? 0 : productSubCategory.hashCode())) * 31);
    }

    public final boolean isBookablePassConfigActive() {
        if (!this.superPassProductConfigurationProperties.isActive()) {
            return false;
        }
        if (this.selectedProductFareMapping.getIsActive() != null) {
            Boolean isActive = this.selectedProductFareMapping.getIsActive();
            n86.d(isActive, "selectedProductFareMapping.isActive");
            return isActive.booleanValue();
        } else if (!this.selectedProductCategory.isCategoryActive()) {
            return false;
        } else {
            ProductSubCategory productSubCategory = this.selectedSubCategory;
            if (productSubCategory == null) {
                return true;
            }
            return productSubCategory.isActive();
        }
    }

    public final boolean isRenewable() {
        if (this.selectedProductFareMapping.isRenewable() == null) {
            return this.selectedProductCategory.isCategoryIsRenewable();
        }
        Boolean isRenewable = this.selectedProductFareMapping.isRenewable();
        n86.d(isRenewable, "selectedProductFareMapping.isRenewable");
        return isRenewable.booleanValue();
    }

    public final boolean isVerificationRequired() {
        if (this.selectedProductFareMapping.isVerificationRequired() == null) {
            return this.selectedProductCategory.isCategoryVerificationRequired();
        }
        Boolean isVerificationRequired = this.selectedProductFareMapping.isVerificationRequired();
        n86.d(isVerificationRequired, "selectedProductFareMapping.isVerificationRequired");
        return isVerificationRequired.booleanValue();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("BookableSuperPassConfiguration(configId=");
        i0.append(this.configId);
        i0.append(", superPassProductConfigurationProperties=");
        i0.append(this.superPassProductConfigurationProperties);
        i0.append(", selectedProductFareMapping=");
        i0.append(this.selectedProductFareMapping);
        i0.append(", selectedProductCategory=");
        i0.append(this.selectedProductCategory);
        i0.append(", selectedSubCategory=");
        i0.append(this.selectedSubCategory);
        i0.append(", requiredProofsList=");
        i0.append(this.requiredProofsList);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.configId);
        this.superPassProductConfigurationProperties.writeToParcel(parcel, i);
        parcel.writeParcelable(this.selectedProductFareMapping, i);
        parcel.writeParcelable(this.selectedProductCategory, i);
        ProductSubCategory productSubCategory = this.selectedSubCategory;
        if (productSubCategory == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            productSubCategory.writeToParcel(parcel, i);
        }
        parcel.writeStringList(this.requiredProofsList);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BookableSuperPassConfiguration(String str, SuperPassProductConfigurationProperties superPassProductConfigurationProperties2, ProductFareMapping productFareMapping, ProductCategory productCategory, ProductSubCategory productSubCategory, List list, int i, j86 j86) {
        this((i & 1) != 0 ? "" : str, superPassProductConfigurationProperties2, (i & 4) != 0 ? new ProductFareMapping() : productFareMapping, (i & 8) != 0 ? new ProductCategory() : productCategory, productSubCategory, (i & 32) != 0 ? new ArrayList() : list);
    }
}
