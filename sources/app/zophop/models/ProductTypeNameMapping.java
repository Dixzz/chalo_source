package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductTypeNameMapping implements Parcelable {
    public static final Parcelable.Creator<ProductTypeNameMapping> CREATOR = new Parcelable.Creator<ProductTypeNameMapping>() {
        /* class app.zophop.models.ProductTypeNameMapping.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ProductTypeNameMapping createFromParcel(Parcel parcel) {
            return new ProductTypeNameMapping(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProductTypeNameMapping[] newArray(int i) {
            return new ProductTypeNameMapping[i];
        }
    };
    public final String productId;
    public final String productName;

    public ProductTypeNameMapping(Parcel parcel) {
        this.productId = parcel.readString();
        this.productName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.productId);
        parcel.writeString(this.productName);
    }

    public ProductTypeNameMapping(String str, String str2) {
        this.productId = str;
        this.productName = str2;
    }
}
