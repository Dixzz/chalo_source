package app.zophop.models.mTicketing.superPass.pendingSuperPass;

import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUIProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import java.util.List;
import java.util.Map;

/* compiled from: PendingSuperPassUIProperties.kt */
public final class PendingSuperPassUIProperties extends SuperPassUIProperties {
    private final String fareMappingDescription;
    private final double maxPricePerTrip;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PendingSuperPassUIProperties(int i, List list, SuperPassUserDetails superPassUserDetails, Map map, long j, FareInfo fareInfo, String str, String str2, ProductBranding productBranding, String str3, double d, String str4, int i2, j86 j86) {
        this(i, list, superPassUserDetails, map, j, fareInfo, str, str2, productBranding, str3, (i2 & 1024) != 0 ? -1.0d : d, str4);
    }

    public final String getFareMappingDescription() {
        return this.fareMappingDescription;
    }

    public final double getMaxPricePerTrip() {
        return this.maxPricePerTrip;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PendingSuperPassUIProperties(int i, List<String> list, SuperPassUserDetails superPassUserDetails, Map<String, SuperPassProofProperties> map, long j, FareInfo fareInfo, String str, String str2, ProductBranding productBranding, String str3, double d, String str4) {
        super(i, list, superPassUserDetails, map, j, fareInfo, str, str2, productBranding, str3);
        n86.e(list, "specialFeatures");
        n86.e(superPassUserDetails, "superPassUserDetails");
        n86.e(map, SuperPassJsonKeys.PROOFS);
        n86.e(fareInfo, SuperPassJsonKeys.KEY_FARE_INFO);
        n86.e(str, "passName");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_NAME);
        n86.e(productBranding, "productBranding");
        n86.e(str3, "fareMappingDisplayName");
        this.maxPricePerTrip = d;
        this.fareMappingDescription = str4;
    }
}
