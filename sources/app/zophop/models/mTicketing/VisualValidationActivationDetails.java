package app.zophop.models.mTicketing;

/* compiled from: VisualValidationActivationDetails.kt */
public final class VisualValidationActivationDetails {
    private final long activationTimeStamp;
    private final String agencyName;
    private final String bookingId;
    private final String city;
    private final long expiryTime;
    private final String productType;

    public VisualValidationActivationDetails(long j, String str, long j2, String str2, String str3, String str4) {
        n86.e(str, "bookingId");
        n86.e(str2, "productType");
        n86.e(str3, "city");
        n86.e(str4, "agencyName");
        this.activationTimeStamp = j;
        this.bookingId = str;
        this.expiryTime = j2;
        this.productType = str2;
        this.city = str3;
        this.agencyName = str4;
    }

    public static /* synthetic */ VisualValidationActivationDetails copy$default(VisualValidationActivationDetails visualValidationActivationDetails, long j, String str, long j2, String str2, String str3, String str4, int i, Object obj) {
        return visualValidationActivationDetails.copy((i & 1) != 0 ? visualValidationActivationDetails.activationTimeStamp : j, (i & 2) != 0 ? visualValidationActivationDetails.bookingId : str, (i & 4) != 0 ? visualValidationActivationDetails.expiryTime : j2, (i & 8) != 0 ? visualValidationActivationDetails.productType : str2, (i & 16) != 0 ? visualValidationActivationDetails.city : str3, (i & 32) != 0 ? visualValidationActivationDetails.agencyName : str4);
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
        return this.city;
    }

    public final String component6() {
        return this.agencyName;
    }

    public final VisualValidationActivationDetails copy(long j, String str, long j2, String str2, String str3, String str4) {
        n86.e(str, "bookingId");
        n86.e(str2, "productType");
        n86.e(str3, "city");
        n86.e(str4, "agencyName");
        return new VisualValidationActivationDetails(j, str, j2, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisualValidationActivationDetails)) {
            return false;
        }
        VisualValidationActivationDetails visualValidationActivationDetails = (VisualValidationActivationDetails) obj;
        return this.activationTimeStamp == visualValidationActivationDetails.activationTimeStamp && n86.a(this.bookingId, visualValidationActivationDetails.bookingId) && this.expiryTime == visualValidationActivationDetails.expiryTime && n86.a(this.productType, visualValidationActivationDetails.productType) && n86.a(this.city, visualValidationActivationDetails.city) && n86.a(this.agencyName, visualValidationActivationDetails.agencyName);
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

    public final String getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.bookingId, d.a(this.activationTimeStamp) * 31, 31);
        return this.agencyName.hashCode() + hj1.r0(this.city, hj1.r0(this.productType, (d.a(this.expiryTime) + r0) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("VisualValidationActivationDetails(activationTimeStamp=");
        i0.append(this.activationTimeStamp);
        i0.append(", bookingId=");
        i0.append(this.bookingId);
        i0.append(", expiryTime=");
        i0.append(this.expiryTime);
        i0.append(", productType=");
        i0.append(this.productType);
        i0.append(", city=");
        i0.append(this.city);
        i0.append(", agencyName=");
        return hj1.Z(i0, this.agencyName, ')');
    }
}
