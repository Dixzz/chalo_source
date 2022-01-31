package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SuperPassProductConfigDetails.kt */
public final class SuperPassProductConfigDetails implements Parcelable {
    public static final Parcelable.Creator<SuperPassProductConfigDetails> CREATOR = new Creator();
    private final String agencyId;
    private final String categoryId;
    private final String configId;
    private final int fareMappingId;
    private final String subCategoryId;

    /* compiled from: SuperPassProductConfigDetails.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassProductConfigDetails> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassProductConfigDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassProductConfigDetails(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassProductConfigDetails[] newArray(int i) {
            return new SuperPassProductConfigDetails[i];
        }
    }

    public SuperPassProductConfigDetails(String str, String str2, String str3, String str4, int i) {
        n86.e(str, "agencyId");
        n86.e(str2, "configId");
        n86.e(str3, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str4, "subCategoryId");
        this.agencyId = str;
        this.configId = str2;
        this.categoryId = str3;
        this.subCategoryId = str4;
        this.fareMappingId = i;
    }

    public static /* synthetic */ SuperPassProductConfigDetails copy$default(SuperPassProductConfigDetails superPassProductConfigDetails, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = superPassProductConfigDetails.agencyId;
        }
        if ((i2 & 2) != 0) {
            str2 = superPassProductConfigDetails.configId;
        }
        if ((i2 & 4) != 0) {
            str3 = superPassProductConfigDetails.categoryId;
        }
        if ((i2 & 8) != 0) {
            str4 = superPassProductConfigDetails.subCategoryId;
        }
        if ((i2 & 16) != 0) {
            i = superPassProductConfigDetails.fareMappingId;
        }
        return superPassProductConfigDetails.copy(str, str2, str3, str4, i);
    }

    public final String component1() {
        return this.agencyId;
    }

    public final String component2() {
        return this.configId;
    }

    public final String component3() {
        return this.categoryId;
    }

    public final String component4() {
        return this.subCategoryId;
    }

    public final int component5() {
        return this.fareMappingId;
    }

    public final SuperPassProductConfigDetails copy(String str, String str2, String str3, String str4, int i) {
        n86.e(str, "agencyId");
        n86.e(str2, "configId");
        n86.e(str3, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str4, "subCategoryId");
        return new SuperPassProductConfigDetails(str, str2, str3, str4, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassProductConfigDetails)) {
            return false;
        }
        SuperPassProductConfigDetails superPassProductConfigDetails = (SuperPassProductConfigDetails) obj;
        return n86.a(this.agencyId, superPassProductConfigDetails.agencyId) && n86.a(this.configId, superPassProductConfigDetails.configId) && n86.a(this.categoryId, superPassProductConfigDetails.categoryId) && n86.a(this.subCategoryId, superPassProductConfigDetails.subCategoryId) && this.fareMappingId == superPassProductConfigDetails.fareMappingId;
    }

    public final String getAgencyId() {
        return this.agencyId;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final int getFareMappingId() {
        return this.fareMappingId;
    }

    public final String getSubCategoryId() {
        return this.subCategoryId;
    }

    public int hashCode() {
        return hj1.r0(this.subCategoryId, hj1.r0(this.categoryId, hj1.r0(this.configId, this.agencyId.hashCode() * 31, 31), 31), 31) + this.fareMappingId;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassProductConfigDetails(agencyId=");
        i0.append(this.agencyId);
        i0.append(", configId=");
        i0.append(this.configId);
        i0.append(", categoryId=");
        i0.append(this.categoryId);
        i0.append(", subCategoryId=");
        i0.append(this.subCategoryId);
        i0.append(", fareMappingId=");
        return hj1.W(i0, this.fareMappingId, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.agencyId);
        parcel.writeString(this.configId);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.subCategoryId);
        parcel.writeInt(this.fareMappingId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassProductConfigDetails(String str, String str2, String str3, String str4, int i, int i2, j86 j86) {
        this(str, str2, str3, (i2 & 8) != 0 ? new String() : str4, i);
    }
}
