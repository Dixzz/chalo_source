package app.zophop.models.mTicketing.superPass;

import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductBranding;
import java.util.List;
import java.util.Map;

/* compiled from: SuperPassUIProperties.kt */
public class SuperPassUIProperties {
    private final long bookingTime;
    private final String categoryName;
    private final FareInfo fareInfo;
    private final String fareMappingDisplayName;
    private final int numOfDays;
    private final String passName;
    private final ProductBranding productBranding;
    private final Map<String, SuperPassProofProperties> proofs;
    private final List<String> specialFeatures;
    private final SuperPassUserDetails superPassUserDetails;

    public SuperPassUIProperties(int i, List<String> list, SuperPassUserDetails superPassUserDetails2, Map<String, SuperPassProofProperties> map, long j, FareInfo fareInfo2, String str, String str2, ProductBranding productBranding2, String str3) {
        n86.e(list, "specialFeatures");
        n86.e(superPassUserDetails2, "superPassUserDetails");
        n86.e(map, SuperPassJsonKeys.PROOFS);
        n86.e(fareInfo2, SuperPassJsonKeys.KEY_FARE_INFO);
        n86.e(str, "passName");
        n86.e(str2, SuperPassJsonKeys.CATEGORY_NAME);
        n86.e(productBranding2, "productBranding");
        n86.e(str3, "fareMappingDisplayName");
        this.numOfDays = i;
        this.specialFeatures = list;
        this.superPassUserDetails = superPassUserDetails2;
        this.proofs = map;
        this.bookingTime = j;
        this.fareInfo = fareInfo2;
        this.passName = str;
        this.categoryName = str2;
        this.productBranding = productBranding2;
        this.fareMappingDisplayName = str3;
    }

    public final long getBookingTime() {
        return this.bookingTime;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final FareInfo getFareInfo() {
        return this.fareInfo;
    }

    public final String getFareMappingDisplayName() {
        return this.fareMappingDisplayName;
    }

    public final int getNumOfDays() {
        return this.numOfDays;
    }

    public final String getPassName() {
        return this.passName;
    }

    public final ProductBranding getProductBranding() {
        return this.productBranding;
    }

    public final Map<String, SuperPassProofProperties> getProofs() {
        return this.proofs;
    }

    public final List<String> getSpecialFeatures() {
        return this.specialFeatures;
    }

    public final SuperPassUserDetails getSuperPassUserDetails() {
        return this.superPassUserDetails;
    }
}
