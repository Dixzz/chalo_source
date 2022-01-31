package app.zophop.models.mTicketing.superPass.pendingSuperPass;

import app.zophop.models.mTicketing.superPass.SuperPassPrimaryProperties;
import app.zophop.models.mTicketing.superPass.SuperPassStatus;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;

/* compiled from: PendingSuperPassProperties.kt */
public final class PendingSuperPassProperties extends SuperPassPrimaryProperties {
    private final SuperPassStatus status;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PendingSuperPassProperties(String str, String str2, SuperPassSubType superPassSubType, String str3, String str4, SuperPassStatus superPassStatus) {
        super(str, str2, superPassSubType, str3, str4);
        n86.e(str, "passId");
        n86.e(str2, "productType");
        n86.e(superPassSubType, "productSubType");
        n86.e(str3, "cityName");
        n86.e(str4, "agencyName");
        n86.e(superPassStatus, "status");
        this.status = superPassStatus;
    }

    public final SuperPassStatus getStatus() {
        return this.status;
    }
}
