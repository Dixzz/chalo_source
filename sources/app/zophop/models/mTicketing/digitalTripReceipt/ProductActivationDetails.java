package app.zophop.models.mTicketing.digitalTripReceipt;

/* compiled from: ProductActivationDetails.kt */
public final class ProductActivationDetails {
    private final long activationTimeStamp;
    private final String agencyName;
    private final String bookingId;
    private final String city;
    private final long expiryTime;
    private final String productSubType;
    private final String productType;

    public ProductActivationDetails(long j, String str, long j2, String str2, String str3, String str4, String str5) {
        n86.e(str, "bookingId");
        n86.e(str2, "productType");
        n86.e(str3, "productSubType");
        n86.e(str4, "city");
        n86.e(str5, "agencyName");
        this.activationTimeStamp = j;
        this.bookingId = str;
        this.expiryTime = j2;
        this.productType = str2;
        this.productSubType = str3;
        this.city = str4;
        this.agencyName = str5;
    }

    public static /* synthetic */ ProductActivationDetails copy$default(ProductActivationDetails productActivationDetails, long j, String str, long j2, String str2, String str3, String str4, String str5, int i, Object obj) {
        return productActivationDetails.copy((i & 1) != 0 ? productActivationDetails.activationTimeStamp : j, (i & 2) != 0 ? productActivationDetails.bookingId : str, (i & 4) != 0 ? productActivationDetails.expiryTime : j2, (i & 8) != 0 ? productActivationDetails.productType : str2, (i & 16) != 0 ? productActivationDetails.productSubType : str3, (i & 32) != 0 ? productActivationDetails.city : str4, (i & 64) != 0 ? productActivationDetails.agencyName : str5);
    }

    public final long component1() {
        return this.activationTimeStamp;
    }

    public final String component2() {
        return this.bookingId;
    }

    public final long component3() {
        return this.expiryTime;
    }

    public final String component4() {
        return this.productType;
    }

    public final String component5() {
        return this.productSubType;
    }

    public final String component6() {
        return this.city;
    }

    public final String component7() {
        return this.agencyName;
    }

    public final ProductActivationDetails copy(long j, String str, long j2, String str2, String str3, String str4, String str5) {
        n86.e(str, "bookingId");
        n86.e(str2, "productType");
        n86.e(str3, "productSubType");
        n86.e(str4, "city");
        n86.e(str5, "agencyName");
        return new ProductActivationDetails(j, str, j2, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductActivationDetails)) {
            return false;
        }
        ProductActivationDetails productActivationDetails = (ProductActivationDetails) obj;
        return this.activationTimeStamp == productActivationDetails.activationTimeStamp && n86.a(this.bookingId, productActivationDetails.bookingId) && this.expiryTime == productActivationDetails.expiryTime && n86.a(this.productType, productActivationDetails.productType) && n86.a(this.productSubType, productActivationDetails.productSubType) && n86.a(this.city, productActivationDetails.city) && n86.a(this.agencyName, productActivationDetails.agencyName);
    }

    public final long getActivationTimeStamp() {
        return this.activationTimeStamp;
    }

    public final String getAgencyName() {
        return this.agencyName;
    }

    public final String getBookingId() {
        return this.bookingId;
    }

    public final String getCity() {
        return this.city;
    }

    public final long getExpiryTime() {
        return this.expiryTime;
    }

    public final String getProductSubType() {
        return this.productSubType;
    }

    public final String getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.bookingId, d.a(this.activationTimeStamp) * 31, 31);
        return this.agencyName.hashCode() + hj1.r0(this.city, hj1.r0(this.productSubType, hj1.r0(this.productType, (d.a(this.expiryTime) + r0) * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProductActivationDetails(activationTimeStamp=");
        i0.append(this.activationTimeStamp);
        i0.append(", bookingId=");
        i0.append(this.bookingId);
        i0.append(", expiryTime=");
        i0.append(this.expiryTime);
        i0.append(", productType=");
        i0.append(this.productType);
        i0.append(", productSubType=");
        i0.append(this.productSubType);
        i0.append(", city=");
        i0.append(this.city);
        i0.append(", agencyName=");
        return hj1.Z(i0, this.agencyName, ')');
    }
}
