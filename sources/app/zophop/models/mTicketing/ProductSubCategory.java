package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProductSubCategory.kt */
public final class ProductSubCategory implements Parcelable {
    public static final Parcelable.Creator<ProductSubCategory> CREATOR = new Creator();
    private final String additionalInfo;
    private final String announcement;
    private final String id;
    private final String inActiveReason;
    private final String infoNote;
    private final boolean isActive;
    private final boolean isVisible;
    private final String name;
    private final String plansTitle;
    private final boolean shouldHideSpecialFeatureTags;

    /* compiled from: ProductSubCategory.kt */
    public static final class Creator implements Parcelable.Creator<ProductSubCategory> {
        @Override // android.os.Parcelable.Creator
        public final ProductSubCategory createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProductSubCategory(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProductSubCategory[] newArray(int i) {
            return new ProductSubCategory[i];
        }
    }

    public ProductSubCategory(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7) {
        n86.e(str, "id");
        n86.e(str2, "name");
        n86.e(str3, "plansTitle");
        n86.e(str4, "infoNote");
        n86.e(str5, "announcement");
        n86.e(str6, "additionalInfo");
        n86.e(str7, "inActiveReason");
        this.id = str;
        this.name = str2;
        this.plansTitle = str3;
        this.infoNote = str4;
        this.announcement = str5;
        this.additionalInfo = str6;
        this.shouldHideSpecialFeatureTags = z;
        this.isVisible = z2;
        this.isActive = z3;
        this.inActiveReason = str7;
    }

    public static /* synthetic */ ProductSubCategory copy$default(ProductSubCategory productSubCategory, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, int i, Object obj) {
        return productSubCategory.copy((i & 1) != 0 ? productSubCategory.id : str, (i & 2) != 0 ? productSubCategory.name : str2, (i & 4) != 0 ? productSubCategory.plansTitle : str3, (i & 8) != 0 ? productSubCategory.infoNote : str4, (i & 16) != 0 ? productSubCategory.announcement : str5, (i & 32) != 0 ? productSubCategory.additionalInfo : str6, (i & 64) != 0 ? productSubCategory.shouldHideSpecialFeatureTags : z, (i & 128) != 0 ? productSubCategory.isVisible : z2, (i & 256) != 0 ? productSubCategory.isActive : z3, (i & 512) != 0 ? productSubCategory.inActiveReason : str7);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.inActiveReason;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.plansTitle;
    }

    public final String component4() {
        return this.infoNote;
    }

    public final String component5() {
        return this.announcement;
    }

    public final String component6() {
        return this.additionalInfo;
    }

    public final boolean component7() {
        return this.shouldHideSpecialFeatureTags;
    }

    public final boolean component8() {
        return this.isVisible;
    }

    public final boolean component9() {
        return this.isActive;
    }

    public final ProductSubCategory copy(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7) {
        n86.e(str, "id");
        n86.e(str2, "name");
        n86.e(str3, "plansTitle");
        n86.e(str4, "infoNote");
        n86.e(str5, "announcement");
        n86.e(str6, "additionalInfo");
        n86.e(str7, "inActiveReason");
        return new ProductSubCategory(str, str2, str3, str4, str5, str6, z, z2, z3, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductSubCategory)) {
            return false;
        }
        ProductSubCategory productSubCategory = (ProductSubCategory) obj;
        return n86.a(this.id, productSubCategory.id) && n86.a(this.name, productSubCategory.name) && n86.a(this.plansTitle, productSubCategory.plansTitle) && n86.a(this.infoNote, productSubCategory.infoNote) && n86.a(this.announcement, productSubCategory.announcement) && n86.a(this.additionalInfo, productSubCategory.additionalInfo) && this.shouldHideSpecialFeatureTags == productSubCategory.shouldHideSpecialFeatureTags && this.isVisible == productSubCategory.isVisible && this.isActive == productSubCategory.isActive && n86.a(this.inActiveReason, productSubCategory.inActiveReason);
    }

    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final String getAnnouncement() {
        return this.announcement;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInActiveReason() {
        return this.inActiveReason;
    }

    public final String getInfoNote() {
        return this.infoNote;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlansTitle() {
        return this.plansTitle;
    }

    public final boolean getShouldHideSpecialFeatureTags() {
        return this.shouldHideSpecialFeatureTags;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.additionalInfo, hj1.r0(this.announcement, hj1.r0(this.infoNote, hj1.r0(this.plansTitle, hj1.r0(this.name, this.id.hashCode() * 31, 31), 31), 31), 31), 31);
        boolean z = this.shouldHideSpecialFeatureTags;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (r0 + i2) * 31;
        boolean z2 = this.isVisible;
        if (z2) {
            z2 = true;
        }
        int i6 = z2 ? 1 : 0;
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = (i5 + i6) * 31;
        boolean z3 = this.isActive;
        if (!z3) {
            i = z3 ? 1 : 0;
        }
        return this.inActiveReason.hashCode() + ((i9 + i) * 31);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProductSubCategory(id=");
        i0.append(this.id);
        i0.append(", name=");
        i0.append(this.name);
        i0.append(", plansTitle=");
        i0.append(this.plansTitle);
        i0.append(", infoNote=");
        i0.append(this.infoNote);
        i0.append(", announcement=");
        i0.append(this.announcement);
        i0.append(", additionalInfo=");
        i0.append(this.additionalInfo);
        i0.append(", shouldHideSpecialFeatureTags=");
        i0.append(this.shouldHideSpecialFeatureTags);
        i0.append(", isVisible=");
        i0.append(this.isVisible);
        i0.append(", isActive=");
        i0.append(this.isActive);
        i0.append(", inActiveReason=");
        return hj1.Z(i0, this.inActiveReason, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.plansTitle);
        parcel.writeString(this.infoNote);
        parcel.writeString(this.announcement);
        parcel.writeString(this.additionalInfo);
        parcel.writeInt(this.shouldHideSpecialFeatureTags ? 1 : 0);
        parcel.writeInt(this.isVisible ? 1 : 0);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeString(this.inActiveReason);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductSubCategory(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, int i, j86 j86) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? false : z, z2, z3, str7);
    }
}
