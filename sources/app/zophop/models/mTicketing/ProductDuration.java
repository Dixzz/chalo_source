package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductDuration implements Parcelable {
    public static final Parcelable.Creator<ProductDuration> CREATOR = new Parcelable.Creator<ProductDuration>() {
        /* class app.zophop.models.mTicketing.ProductDuration.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProductDuration createFromParcel(Parcel parcel) {
            return new ProductDuration(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProductDuration[] newArray(int i) {
            return new ProductDuration[i];
        }
    };
    private String _inactiveReason;
    private boolean _isActive;
    private boolean _isVisible;
    private final long validity;
    private final String validityName;

    public ProductDuration(long j, String str) {
        this.validity = j;
        this.validityName = str;
    }

    public ProductDuration deepCopyProductDuration(ProductDuration productDuration) {
        ProductDuration productDuration2 = new ProductDuration(productDuration.getValidity(), productDuration.getValidityName());
        productDuration2.setInactiveReason(productDuration.getInactiveReason());
        productDuration2.setIsActive(productDuration.getIsActive());
        productDuration2.setIsVisible(productDuration.isVisible());
        return productDuration2;
    }

    public int describeContents() {
        return 0;
    }

    public String getInactiveReason() {
        return this._inactiveReason;
    }

    public boolean getIsActive() {
        return this._isActive;
    }

    public long getValidity() {
        return this.validity;
    }

    public String getValidityName() {
        return this.validityName;
    }

    public boolean isVisible() {
        return this._isVisible;
    }

    public void setInactiveReason(String str) {
        this._inactiveReason = str;
    }

    public void setIsActive(boolean z) {
        this._isActive = z;
    }

    public void setIsVisible(boolean z) {
        this._isVisible = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.validity);
        parcel.writeString(this.validityName);
        parcel.writeByte(this._isActive ? (byte) 1 : 0);
        parcel.writeString(this._inactiveReason);
        parcel.writeByte(this._isVisible ? (byte) 1 : 0);
    }

    public ProductDuration(Parcel parcel) {
        this.validity = parcel.readLong();
        this.validityName = parcel.readString();
        boolean z = true;
        this._isActive = parcel.readByte() != 0;
        this._inactiveReason = parcel.readString();
        this._isVisible = parcel.readByte() == 0 ? false : z;
    }
}
