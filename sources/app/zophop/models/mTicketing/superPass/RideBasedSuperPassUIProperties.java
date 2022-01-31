package app.zophop.models.mTicketing.superPass;

import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductBranding;
import java.util.List;
import java.util.Map;

/* compiled from: RideBasedSuperPassUIProperties.kt */
public final class RideBasedSuperPassUIProperties extends SuperPassUIProperties {
    private final String fareMappingDescription;
    private final double maxPricePerTrip;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RideBasedSuperPassUIProperties(int i, List<String> list, SuperPassUserDetails superPassUserDetails, Map<String, SuperPassProofProperties> map, long j, FareInfo fareInfo, double d, String str, String str2, ProductBranding productBranding, String str3, String str4) {
        super(i, list, superPassUserDetails, map, j, fareInfo, str, str2, productBranding, str3);
        n86.e(list, "specialFeatures");
        n86.e(superPassUserDetails, "superPassUserDetails");
        n86.e(map, SuperPassJsonKeys.PROOFS);
        n86.e(fareInfo, SuperPassJsonKeys.KEY_FARE_INFO);
        n86.e(str, "passName");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_NAME);
        n86.e(productBranding, "productBranding");
        n86.e(str3, "fareMappingDisplayName");
        n86.e(str4, "fareMappingDescription");
        this.maxPricePerTrip = d;
        this.fareMappingDescription = str4;
    }

    public final String getFareMappingDescription() {
        return this.fareMappingDescription;
    }

    public final double getMaxPricePerTrip() {
        return this.maxPricePerTrip;
    }
}
