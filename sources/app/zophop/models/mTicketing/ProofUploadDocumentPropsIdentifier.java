package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: ProofUploadDocumentPropsIdentifier.kt */
public final class ProofUploadDocumentPropsIdentifier implements Parcelable {
    public static final Parcelable.Creator<ProofUploadDocumentPropsIdentifier> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String agencyName;
    private final String cityName;
    private final String documentId;

    /* compiled from: ProofUploadDocumentPropsIdentifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final ProofUploadDocumentPropsIdentifier convertToObjectFromStoreString(String str) {
            n86.e(str, "lStringObject");
            List B = ea6.B(str, new String[]{ProductDiscountsObject.KEY_DELIMITER}, false, 0, 6);
            return new ProofUploadDocumentPropsIdentifier((String) B.get(0), (String) B.get(1), (String) B.get(2));
        }

        public final String convertToStringToStore(ProofUploadDocumentPropsIdentifier proofUploadDocumentPropsIdentifier) {
            n86.e(proofUploadDocumentPropsIdentifier, "lProofUploadDocumentPropsIdentifier");
            return proofUploadDocumentPropsIdentifier.getCityName() + ':' + proofUploadDocumentPropsIdentifier.getAgencyName() + ':' + proofUploadDocumentPropsIdentifier.getDocumentId();
        }
    }

    /* compiled from: ProofUploadDocumentPropsIdentifier.kt */
    public static final class Creator implements Parcelable.Creator<ProofUploadDocumentPropsIdentifier> {
        @Override // android.os.Parcelable.Creator
        public final ProofUploadDocumentPropsIdentifier createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProofUploadDocumentPropsIdentifier(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProofUploadDocumentPropsIdentifier[] newArray(int i) {
            return new ProofUploadDocumentPropsIdentifier[i];
        }
    }

    public ProofUploadDocumentPropsIdentifier(String str, String str2, String str3) {
        n86.e(str, "cityName");
        n86.e(str2, "agencyName");
        n86.e(str3, "documentId");
        this.cityName = str;
        this.agencyName = str2;
        this.documentId = str3;
    }

    public static final ProofUploadDocumentPropsIdentifier convertToObjectFromStoreString(String str) {
        return Companion.convertToObjectFromStoreString(str);
    }

    public static final String convertToStringToStore(ProofUploadDocumentPropsIdentifier proofUploadDocumentPropsIdentifier) {
        return Companion.convertToStringToStore(proofUploadDocumentPropsIdentifier);
    }

    public static /* synthetic */ ProofUploadDocumentPropsIdentifier copy$default(ProofUploadDocumentPropsIdentifier proofUploadDocumentPropsIdentifier, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proofUploadDocumentPropsIdentifier.cityName;
        }
        if ((i & 2) != 0) {
            str2 = proofUploadDocumentPropsIdentifier.agencyName;
        }
        if ((i & 4) != 0) {
            str3 = proofUploadDocumentPropsIdentifier.documentId;
        }
        return proofUploadDocumentPropsIdentifier.copy(str, str2, str3);
    }

    public final String component1() {
        return this.cityName;
    }

    public final String component2() {
        return this.agencyName;
    }

    public final String component3() {
        return this.documentId;
    }

    public final ProofUploadDocumentPropsIdentifier copy(String str, String str2, String str3) {
        n86.e(str, "cityName");
        n86.e(str2, "agencyName");
        n86.e(str3, "documentId");
        return new ProofUploadDocumentPropsIdentifier(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProofUploadDocumentPropsIdentifier)) {
            return false;
        }
        ProofUploadDocumentPropsIdentifier proofUploadDocumentPropsIdentifier = (ProofUploadDocumentPropsIdentifier) obj;
        return n86.a(this.cityName, proofUploadDocumentPropsIdentifier.cityName) && n86.a(this.agencyName, proofUploadDocumentPropsIdentifier.agencyName) && n86.a(this.documentId, proofUploadDocumentPropsIdentifier.documentId);
    }

    public final String getAgencyName() {
        return this.agencyName;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final String getDocumentId() {
        return this.documentId;
    }

    public int hashCode() {
        return this.documentId.hashCode() + hj1.r0(this.agencyName, this.cityName.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProofUploadDocumentPropsIdentifier(cityName=");
        i0.append(this.cityName);
        i0.append(", agencyName=");
        i0.append(this.agencyName);
        i0.append(", documentId=");
        return hj1.Z(i0, this.documentId, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.cityName);
        parcel.writeString(this.agencyName);
        parcel.writeString(this.documentId);
    }
}
