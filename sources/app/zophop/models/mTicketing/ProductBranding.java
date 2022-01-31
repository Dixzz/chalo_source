package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProductBranding.kt */
public final class ProductBranding implements Parcelable {
    public static final Parcelable.Creator<ProductBranding> CREATOR = new Creator();
    private final boolean isVisible;

    /* compiled from: ProductBranding.kt */
    public static final class Creator implements Parcelable.Creator<ProductBranding> {
        @Override // android.os.Parcelable.Creator
        public final ProductBranding createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProductBranding(parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final ProductBranding[] newArray(int i) {
            return new ProductBranding[i];
        }
    }

    public ProductBranding(boolean z) {
        this.isVisible = z;
    }

    public static /* synthetic */ ProductBranding copy$default(ProductBranding productBranding, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = productBranding.isVisible;
        }
        return productBranding.copy(z);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    public final ProductBranding copy(boolean z) {
        return new ProductBranding(z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductBranding) && this.isVisible == ((ProductBranding) obj).isVisible;
    }

    public int hashCode() {
        boolean z = this.isVisible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProductBranding(isVisible=");
        i0.append(this.isVisible);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeInt(this.isVisible ? 1 : 0);
    }
}
