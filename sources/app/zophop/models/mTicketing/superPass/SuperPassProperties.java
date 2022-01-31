package app.zophop.models.mTicketing.superPass;

/* compiled from: SuperPassProperties.kt */
public final class SuperPassProperties extends SuperPassPrimaryProperties {
    private final String qrCode;
    private final String tone;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperPassProperties(String str, String str2, SuperPassSubType superPassSubType, String str3, String str4, String str5, String str6) {
        super(str, str2, superPassSubType, str3, str4);
        n86.e(str, "passId");
        n86.e(str2, "productType");
        n86.e(superPassSubType, "productSubType");
        n86.e(str3, "cityName");
        n86.e(str4, "agencyName");
        n86.e(str5, SuperPassJsonKeys.QR_CODE);
        this.qrCode = str5;
        this.tone = str6;
    }

    public final String getQrCode() {
        return this.qrCode;
    }

    public final String getTone() {
        return this.tone;
    }
}
