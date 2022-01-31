package app.zophop.models;

import app.zophop.models.mTicketing.FareBreakupComponent;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProductDuration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProfileRejectionReason;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/* compiled from: CustomTypeConverters.kt */
public final class CustomTypeConverters {
    public final SuperPassTripReceipt fromDigitalTripReceiptString(String str) {
        if (str == null) {
            return null;
        }
        return (SuperPassTripReceipt) hj1.s(str, SuperPassTripReceipt.class);
    }

    public final List<FareBreakupComponent> fromFareBreakupComponentString(String str) {
        return (List) new Gson().fromJson(str, new CustomTypeConverters$fromFareBreakupComponentString$lListType$1().getType());
    }

    public PassApplicationActionRequired fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (PassApplicationActionRequired) hj1.s(str, PassApplicationActionRequired.class);
    }

    public final List<Long> fromLong(String str) {
        return (List) new Gson().fromJson(str, new CustomTypeConverters$fromLong$lListType$1().getType());
    }

    public final MTicketTripReceipt fromMTicketTripReceiptString(String str) {
        if (str == null) {
            return null;
        }
        return (MTicketTripReceipt) hj1.s(str, MTicketTripReceipt.class);
    }

    public final PassApplicationRejectionReasons fromPassApplicationRejectionReasonsString(String str) {
        if (str == null) {
            return null;
        }
        return (PassApplicationRejectionReasons) hj1.s(str, PassApplicationRejectionReasons.class);
    }

    public final ProductDuration fromProductDurationString(String str) {
        if (str == null) {
            return null;
        }
        return (ProductDuration) hj1.s(str, ProductDuration.class);
    }

    public final ProductFareMapping fromProductFareMappingString(String str) {
        if (str == null) {
            return null;
        }
        return (ProductFareMapping) hj1.s(str, ProductFareMapping.class);
    }

    public final List<ProfileRejectionReason> fromProfileRejectionReasonString(String str) {
        return (List) new Gson().fromJson(str, new CustomTypeConverters$fromProfileRejectionReasonString$lListType$1().getType());
    }

    public final List<ProofRejectionReason> fromProofRejectionReasonString(String str) {
        return (List) new Gson().fromJson(str, new CustomTypeConverters$fromProofRejectionReasonString$lListType$1().getType());
    }

    public final String fromProofsToString(Map<String, SuperPassProofProperties> map) {
        return new Gson().toJson(map);
    }

    public final List<String> fromString(String str) {
        return (List) new Gson().fromJson(str, new CustomTypeConverters$fromString$lListType$1().getType());
    }

    public final Map<String, SuperPassProofProperties> fromStringToProofs(String str) {
        return (Map) new Gson().fromJson(str, new CustomTypeConverters$fromStringToProofs$lMapType$1().getType());
    }

    public String toConverterString(PassApplicationActionRequired passApplicationActionRequired) {
        if (passApplicationActionRequired == null) {
            return null;
        }
        return new Gson().toJson(passApplicationActionRequired);
    }

    public final String toDigitalTripReceiptString(SuperPassTripReceipt superPassTripReceipt) {
        if (superPassTripReceipt == null) {
            return null;
        }
        return new Gson().toJson(superPassTripReceipt);
    }

    public final String toFareBreakupComponentString(List<FareBreakupComponent> list) {
        return new Gson().toJson(list);
    }

    public final String toLong(List<Long> list) {
        return new Gson().toJson(list);
    }

    public final String toMTicketTripReceiptString(MTicketTripReceipt mTicketTripReceipt) {
        if (mTicketTripReceipt == null) {
            return null;
        }
        return new Gson().toJson(mTicketTripReceipt);
    }

    public final String toPassApplicationRejectionReasonsString(PassApplicationRejectionReasons passApplicationRejectionReasons) {
        if (passApplicationRejectionReasons == null) {
            return null;
        }
        return new Gson().toJson(passApplicationRejectionReasons);
    }

    public final String toProductDurationString(ProductDuration productDuration) {
        if (productDuration == null) {
            return null;
        }
        return new Gson().toJson(productDuration);
    }

    public final String toProductFareMappingString(ProductFareMapping productFareMapping) {
        if (productFareMapping == null) {
            return null;
        }
        return new Gson().toJson(productFareMapping);
    }

    public final String toProfileRejectionReasonString(List<ProfileRejectionReason> list) {
        return new Gson().toJson(list);
    }

    public final String toProofRejectionReasonString(List<ProofRejectionReason> list) {
        return new Gson().toJson(list);
    }

    public final String toString(List<String> list) {
        return new Gson().toJson(list);
    }
}
