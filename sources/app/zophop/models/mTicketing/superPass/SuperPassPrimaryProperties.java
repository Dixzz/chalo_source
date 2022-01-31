package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPassPrimaryProperties.kt */
public class SuperPassPrimaryProperties {
    private final String agencyName;
    private final String cityName;
    private final String passId;
    private final SuperPassSubType productSubType;
    private final String productType;

    public SuperPassPrimaryProperties(String str, String str2, SuperPassSubType superPassSubType, String str3, String str4) {
        n86.e(str, "passId");
        n86.e(str2, "productType");
        n86.e(superPassSubType, "productSubType");
        n86.e(str3, "cityName");
        n86.e(str4, "agencyName");
        this.passId = str;
        this.productType = str2;
        this.productSubType = superPassSubType;
        this.cityName = str3;
        this.agencyName = str4;
    }

    public final String getAgencyName() {
        return this.agencyName;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getPassId() {
        return this.passId;
    }

    public final SuperPassSubType getProductSubType() {
        return this.productSubType;
    }

    public final String getProductType() {
        return this.productType;
    }
}
