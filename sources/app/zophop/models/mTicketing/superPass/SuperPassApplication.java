package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProofDocumentProps;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SuperPassApplication.kt */
public final class SuperPassApplication implements Parcelable {
    public static final Parcelable.Creator<SuperPassApplication> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String agencyName;
    private final CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails;
    private final String categoryId;
    private final String cityName;
    private final String configId;
    private final String fareMappingDisplayName;
    private final int fareMappingId;
    private final PassApplicationActionRequired passApplicationActionRequired;
    private final PassApplicationRejectionReasons passApplicationRejectionReasons;
    private final String passName;
    private final long passStartDate;
    private final Map<String, SuperPassProofProperties> proofs;
    private final SuperPassApplicationStatus superPassApplicationStatus;
    private final SuperPassUserDetails superPassUserDetails;
    private final long verificationExpiryTime;

    /* compiled from: SuperPassApplication.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public static /* synthetic */ SuperPassApplication convertBookableConfigToSuperPassApplication$default(Companion companion, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, long j2, String str, SuperPassUserDetails superPassUserDetails, SuperPassApplicationStatus superPassApplicationStatus, Map map, List list, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails, int i, Object obj) {
            return companion.convertBookableConfigToSuperPassApplication(bookableSuperPassConfiguration, j, j2, str, superPassUserDetails, superPassApplicationStatus, map, list, (i & 256) != 0 ? null : cashPaymentPendingTransactionDetails);
        }

        private final String getProofName(String str, List<ProofDocumentProps> list) {
            for (ProofDocumentProps proofDocumentProps : list) {
                if (n86.a(str, proofDocumentProps.getProofId())) {
                    return proofDocumentProps.getProofName();
                }
            }
            return new String();
        }

        private final Map<String, SuperPassProofProperties> getProofsMap(Map<String, String> map, List<ProofDocumentProps> list) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (ProofDocumentProps proofDocumentProps : list) {
                hashMap.put(proofDocumentProps.getProofId(), proofDocumentProps);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                hashMap2.put(key, new SuperPassProofProperties(getProofName(key, list), entry.getValue()));
            }
            return hashMap2;
        }

        public final SuperPassApplication convertBookableConfigToSuperPassApplication(BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, long j2, String str, SuperPassUserDetails superPassUserDetails, SuperPassApplicationStatus superPassApplicationStatus, Map<String, String> map, List<ProofDocumentProps> list, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails) {
            n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
            n86.e(str, "lAgencyName");
            n86.e(superPassUserDetails, "lSuperPassUserDetails");
            n86.e(superPassApplicationStatus, "lSuperPassApplicationStatus");
            n86.e(map, "lUploadedProofsMap");
            n86.e(list, "lProofDocumentPropsList");
            City d = xt.f3961a.k().d();
            n86.c(d);
            String name = d.getName();
            n86.c(name);
            String lowerCase = name.toLowerCase();
            n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            Map<String, SuperPassProofProperties> proofsMap = getProofsMap(map, list);
            String configId = bookableSuperPassConfiguration.getConfigId();
            String categoryId = bookableSuperPassConfiguration.getSelectedProductCategory().getCategoryId();
            n86.d(categoryId, "lBookableSuperPassConfig…roductCategory.categoryId");
            int fareMappingId = bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareMappingId();
            String durationDisplayName = bookableSuperPassConfiguration.getSelectedProductFareMapping().getDurationDisplayName();
            n86.d(durationDisplayName, "lBookableSuperPassConfig…pping.durationDisplayName");
            return new SuperPassApplication(lowerCase, str, configId, categoryId, fareMappingId, durationDisplayName, bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductName(), j, j2, superPassUserDetails, superPassApplicationStatus, proofsMap, cashPaymentPendingTransactionDetails, null, null);
        }
    }

    /* compiled from: SuperPassApplication.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassApplication> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassApplication createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            SuperPassUserDetails createFromParcel = SuperPassUserDetails.CREATOR.createFromParcel(parcel);
            SuperPassApplicationStatus valueOf = SuperPassApplicationStatus.valueOf(parcel.readString());
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            int i = 0;
            while (i != readInt2) {
                linkedHashMap.put(parcel.readString(), SuperPassProofProperties.CREATOR.createFromParcel(parcel));
                i++;
                readInt2 = readInt2;
                createFromParcel = createFromParcel;
            }
            PassApplicationActionRequired passApplicationActionRequired = null;
            CashPaymentPendingTransactionDetails createFromParcel2 = parcel.readInt() == 0 ? null : CashPaymentPendingTransactionDetails.CREATOR.createFromParcel(parcel);
            PassApplicationRejectionReasons createFromParcel3 = parcel.readInt() == 0 ? null : PassApplicationRejectionReasons.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                passApplicationActionRequired = PassApplicationActionRequired.CREATOR.createFromParcel(parcel);
            }
            return new SuperPassApplication(readString, readString2, readString3, readString4, readInt, readString5, readString6, readLong, readLong2, createFromParcel, valueOf, linkedHashMap, createFromParcel2, createFromParcel3, passApplicationActionRequired);
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassApplication[] newArray(int i) {
            return new SuperPassApplication[i];
        }
    }

    public SuperPassApplication(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, long j2, SuperPassUserDetails superPassUserDetails2, SuperPassApplicationStatus superPassApplicationStatus2, Map<String, SuperPassProofProperties> map, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2, PassApplicationRejectionReasons passApplicationRejectionReasons2, PassApplicationActionRequired passApplicationActionRequired2) {
        n86.e(str, "cityName");
        n86.e(str2, "agencyName");
        n86.e(str3, "configId");
        n86.e(str4, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str5, "fareMappingDisplayName");
        n86.e(str6, "passName");
        n86.e(superPassUserDetails2, "superPassUserDetails");
        n86.e(superPassApplicationStatus2, "superPassApplicationStatus");
        n86.e(map, SuperPassJsonKeys.PROOFS);
        this.cityName = str;
        this.agencyName = str2;
        this.configId = str3;
        this.categoryId = str4;
        this.fareMappingId = i;
        this.fareMappingDisplayName = str5;
        this.passName = str6;
        this.passStartDate = j;
        this.verificationExpiryTime = j2;
        this.superPassUserDetails = superPassUserDetails2;
        this.superPassApplicationStatus = superPassApplicationStatus2;
        this.proofs = map;
        this.cashPaymentPendingTransactionDetails = cashPaymentPendingTransactionDetails2;
        this.passApplicationRejectionReasons = passApplicationRejectionReasons2;
        this.passApplicationActionRequired = passApplicationActionRequired2;
    }

    public static /* synthetic */ SuperPassApplication copy$default(SuperPassApplication superPassApplication, String str, String str2, String str3, String str4, int i, String str5, String str6, long j, long j2, SuperPassUserDetails superPassUserDetails2, SuperPassApplicationStatus superPassApplicationStatus2, Map map, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2, PassApplicationRejectionReasons passApplicationRejectionReasons2, PassApplicationActionRequired passApplicationActionRequired2, int i2, Object obj) {
        return superPassApplication.copy((i2 & 1) != 0 ? superPassApplication.cityName : str, (i2 & 2) != 0 ? superPassApplication.agencyName : str2, (i2 & 4) != 0 ? superPassApplication.configId : str3, (i2 & 8) != 0 ? superPassApplication.categoryId : str4, (i2 & 16) != 0 ? superPassApplication.fareMappingId : i, (i2 & 32) != 0 ? superPassApplication.fareMappingDisplayName : str5, (i2 & 64) != 0 ? superPassApplication.passName : str6, (i2 & 128) != 0 ? superPassApplication.passStartDate : j, (i2 & 256) != 0 ? superPassApplication.verificationExpiryTime : j2, (i2 & 512) != 0 ? superPassApplication.superPassUserDetails : superPassUserDetails2, (i2 & 1024) != 0 ? superPassApplication.superPassApplicationStatus : superPassApplicationStatus2, (i2 & 2048) != 0 ? superPassApplication.proofs : map, (i2 & 4096) != 0 ? superPassApplication.cashPaymentPendingTransactionDetails : cashPaymentPendingTransactionDetails2, (i2 & RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST) != 0 ? superPassApplication.passApplicationRejectionReasons : passApplicationRejectionReasons2, (i2 & 16384) != 0 ? superPassApplication.passApplicationActionRequired : passApplicationActionRequired2);
    }

    public final String component1() {
        return this.cityName;
    }

    public final SuperPassUserDetails component10() {
        return this.superPassUserDetails;
    }

    public final SuperPassApplicationStatus component11() {
        return this.superPassApplicationStatus;
    }

    public final Map<String, SuperPassProofProperties> component12() {
        return this.proofs;
    }

    public final CashPaymentPendingTransactionDetails component13() {
        return this.cashPaymentPendingTransactionDetails;
    }

    public final PassApplicationRejectionReasons component14() {
        return this.passApplicationRejectionReasons;
    }

    public final PassApplicationActionRequired component15() {
        return this.passApplicationActionRequired;
    }

    public final String component2() {
        return this.agencyName;
    }

    public final String component3() {
        return this.configId;
    }

    public final String component4() {
        return this.categoryId;
    }

    public final int component5() {
        return this.fareMappingId;
    }

    public final String component6() {
        return this.fareMappingDisplayName;
    }

    public final String component7() {
        return this.passName;
    }

    public final long component8() {
        return this.passStartDate;
    }

    public final long component9() {
        return this.verificationExpiryTime;
    }

    public final SuperPassApplication copy(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, long j2, SuperPassUserDetails superPassUserDetails2, SuperPassApplicationStatus superPassApplicationStatus2, Map<String, SuperPassProofProperties> map, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2, PassApplicationRejectionReasons passApplicationRejectionReasons2, PassApplicationActionRequired passApplicationActionRequired2) {
        n86.e(str, "cityName");
        n86.e(str2, "agencyName");
        n86.e(str3, "configId");
        n86.e(str4, SuperPassJsonKeys.CATEGORY_ID);
        n86.e(str5, "fareMappingDisplayName");
        n86.e(str6, "passName");
        n86.e(superPassUserDetails2, "superPassUserDetails");
        n86.e(superPassApplicationStatus2, "superPassApplicationStatus");
        n86.e(map, SuperPassJsonKeys.PROOFS);
        return new SuperPassApplication(str, str2, str3, str4, i, str5, str6, j, j2, superPassUserDetails2, superPassApplicationStatus2, map, cashPaymentPendingTransactionDetails2, passApplicationRejectionReasons2, passApplicationActionRequired2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassApplication)) {
            return false;
        }
        SuperPassApplication superPassApplication = (SuperPassApplication) obj;
        return n86.a(this.cityName, superPassApplication.cityName) && n86.a(this.agencyName, superPassApplication.agencyName) && n86.a(this.configId, superPassApplication.configId) && n86.a(this.categoryId, superPassApplication.categoryId) && this.fareMappingId == superPassApplication.fareMappingId && n86.a(this.fareMappingDisplayName, superPassApplication.fareMappingDisplayName) && n86.a(this.passName, superPassApplication.passName) && this.passStartDate == superPassApplication.passStartDate && this.verificationExpiryTime == superPassApplication.verificationExpiryTime && n86.a(this.superPassUserDetails, superPassApplication.superPassUserDetails) && this.superPassApplicationStatus == superPassApplication.superPassApplicationStatus && n86.a(this.proofs, superPassApplication.proofs) && n86.a(this.cashPaymentPendingTransactionDetails, superPassApplication.cashPaymentPendingTransactionDetails) && n86.a(this.passApplicationRejectionReasons, superPassApplication.passApplicationRejectionReasons) && this.passApplicationActionRequired == superPassApplication.passApplicationActionRequired;
    }

    public final String getAgencyName() {
        return this.agencyName;
    }

    public final CashPaymentPendingTransactionDetails getCashPaymentPendingTransactionDetails() {
        return this.cashPaymentPendingTransactionDetails;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getConfigId() {
        return this.configId;
    }

    public final String getFareMappingDisplayName() {
        return this.fareMappingDisplayName;
    }

    public final int getFareMappingId() {
        return this.fareMappingId;
    }

    public final PassApplicationActionRequired getPassApplicationActionRequired() {
        return this.passApplicationActionRequired;
    }

    public final PassApplicationRejectionReasons getPassApplicationRejectionReasons() {
        return this.passApplicationRejectionReasons;
    }

    public final String getPassName() {
        return this.passName;
    }

    public final long getPassStartDate() {
        return this.passStartDate;
    }

    public final String getProfilePhotoUrl() {
        return this.superPassUserDetails.getProfilePhoto();
    }

    public final Map<String, SuperPassProofProperties> getProofs() {
        return this.proofs;
    }

    public final SuperPassApplicationStatus getSuperPassApplicationStatus() {
        return this.superPassApplicationStatus;
    }

    public final SuperPassUserDetails getSuperPassUserDetails() {
        return this.superPassUserDetails;
    }

    public final long getVerificationExpiryTime() {
        return this.verificationExpiryTime;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.passName, hj1.r0(this.fareMappingDisplayName, (hj1.r0(this.categoryId, hj1.r0(this.configId, hj1.r0(this.agencyName, this.cityName.hashCode() * 31, 31), 31), 31) + this.fareMappingId) * 31, 31), 31);
        int a2 = d.a(this.verificationExpiryTime);
        int hashCode = (this.proofs.hashCode() + ((this.superPassApplicationStatus.hashCode() + ((this.superPassUserDetails.hashCode() + ((a2 + ((d.a(this.passStartDate) + r0) * 31)) * 31)) * 31)) * 31)) * 31;
        CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2 = this.cashPaymentPendingTransactionDetails;
        int i = 0;
        int hashCode2 = (hashCode + (cashPaymentPendingTransactionDetails2 == null ? 0 : cashPaymentPendingTransactionDetails2.hashCode())) * 31;
        PassApplicationRejectionReasons passApplicationRejectionReasons2 = this.passApplicationRejectionReasons;
        int hashCode3 = (hashCode2 + (passApplicationRejectionReasons2 == null ? 0 : passApplicationRejectionReasons2.hashCode())) * 31;
        PassApplicationActionRequired passApplicationActionRequired2 = this.passApplicationActionRequired;
        if (passApplicationActionRequired2 != null) {
            i = passApplicationActionRequired2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassApplication(cityName=");
        i0.append(this.cityName);
        i0.append(", agencyName=");
        i0.append(this.agencyName);
        i0.append(", configId=");
        i0.append(this.configId);
        i0.append(", categoryId=");
        i0.append(this.categoryId);
        i0.append(", fareMappingId=");
        i0.append(this.fareMappingId);
        i0.append(", fareMappingDisplayName=");
        i0.append(this.fareMappingDisplayName);
        i0.append(", passName=");
        i0.append(this.passName);
        i0.append(", passStartDate=");
        i0.append(this.passStartDate);
        i0.append(", verificationExpiryTime=");
        i0.append(this.verificationExpiryTime);
        i0.append(", superPassUserDetails=");
        i0.append(this.superPassUserDetails);
        i0.append(", superPassApplicationStatus=");
        i0.append(this.superPassApplicationStatus);
        i0.append(", proofs=");
        i0.append(this.proofs);
        i0.append(", cashPaymentPendingTransactionDetails=");
        i0.append(this.cashPaymentPendingTransactionDetails);
        i0.append(", passApplicationRejectionReasons=");
        i0.append(this.passApplicationRejectionReasons);
        i0.append(", passApplicationActionRequired=");
        i0.append(this.passApplicationActionRequired);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.cityName);
        parcel.writeString(this.agencyName);
        parcel.writeString(this.configId);
        parcel.writeString(this.categoryId);
        parcel.writeInt(this.fareMappingId);
        parcel.writeString(this.fareMappingDisplayName);
        parcel.writeString(this.passName);
        parcel.writeLong(this.passStartDate);
        parcel.writeLong(this.verificationExpiryTime);
        this.superPassUserDetails.writeToParcel(parcel, i);
        parcel.writeString(this.superPassApplicationStatus.name());
        Map<String, SuperPassProofProperties> map = this.proofs;
        parcel.writeInt(map.size());
        for (Map.Entry<String, SuperPassProofProperties> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            entry.getValue().writeToParcel(parcel, i);
        }
        CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2 = this.cashPaymentPendingTransactionDetails;
        if (cashPaymentPendingTransactionDetails2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            cashPaymentPendingTransactionDetails2.writeToParcel(parcel, i);
        }
        PassApplicationRejectionReasons passApplicationRejectionReasons2 = this.passApplicationRejectionReasons;
        if (passApplicationRejectionReasons2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            passApplicationRejectionReasons2.writeToParcel(parcel, i);
        }
        PassApplicationActionRequired passApplicationActionRequired2 = this.passApplicationActionRequired;
        if (passApplicationActionRequired2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        passApplicationActionRequired2.writeToParcel(parcel, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassApplication(String str, String str2, String str3, String str4, int i, String str5, String str6, long j, long j2, SuperPassUserDetails superPassUserDetails2, SuperPassApplicationStatus superPassApplicationStatus2, Map map, CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails2, PassApplicationRejectionReasons passApplicationRejectionReasons2, PassApplicationActionRequired passApplicationActionRequired2, int i2, j86 j86) {
        this(str, str2, str3, (i2 & 8) != 0 ? new String() : str4, (i2 & 16) != 0 ? -1 : i, str5, str6, j, j2, superPassUserDetails2, superPassApplicationStatus2, map, cashPaymentPendingTransactionDetails2, passApplicationRejectionReasons2, passApplicationActionRequired2);
    }
}
