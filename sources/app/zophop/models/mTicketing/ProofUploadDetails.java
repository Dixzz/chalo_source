package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProofUploadDetails.kt */
public final class ProofUploadDetails implements Parcelable {
    public static final Parcelable.Creator<ProofUploadDetails> CREATOR = new Creator();
    private final boolean isFreshUpload;
    private String proofImageLocalUri;
    private ProofUploadStatus proofUploadStatus;
    private String uploadRequestId;
    private String uploadedProofUrl;

    /* compiled from: ProofUploadDetails.kt */
    public static final class Creator implements Parcelable.Creator<ProofUploadDetails> {
        @Override // android.os.Parcelable.Creator
        public final ProofUploadDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProofUploadDetails(parcel.readString(), parcel.readString(), parcel.readString(), ProofUploadStatus.valueOf(parcel.readString()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final ProofUploadDetails[] newArray(int i) {
            return new ProofUploadDetails[i];
        }
    }

    public ProofUploadDetails() {
        this(null, null, null, null, false, 31, null);
    }

    public ProofUploadDetails(String str, String str2, String str3, ProofUploadStatus proofUploadStatus2, boolean z) {
        n86.e(str, "uploadedProofUrl");
        n86.e(str2, "proofImageLocalUri");
        n86.e(str3, "uploadRequestId");
        n86.e(proofUploadStatus2, "proofUploadStatus");
        this.uploadedProofUrl = str;
        this.proofImageLocalUri = str2;
        this.uploadRequestId = str3;
        this.proofUploadStatus = proofUploadStatus2;
        this.isFreshUpload = z;
    }

    public static /* synthetic */ ProofUploadDetails copy$default(ProofUploadDetails proofUploadDetails, String str, String str2, String str3, ProofUploadStatus proofUploadStatus2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proofUploadDetails.uploadedProofUrl;
        }
        if ((i & 2) != 0) {
            str2 = proofUploadDetails.proofImageLocalUri;
        }
        if ((i & 4) != 0) {
            str3 = proofUploadDetails.uploadRequestId;
        }
        if ((i & 8) != 0) {
            proofUploadStatus2 = proofUploadDetails.proofUploadStatus;
        }
        if ((i & 16) != 0) {
            z = proofUploadDetails.isFreshUpload;
        }
        return proofUploadDetails.copy(str, str2, str3, proofUploadStatus2, z);
    }

    public final String component1() {
        return this.uploadedProofUrl;
    }

    public final String component2() {
        return this.proofImageLocalUri;
    }

    public final String component3() {
        return this.uploadRequestId;
    }

    public final ProofUploadStatus component4() {
        return this.proofUploadStatus;
    }

    public final boolean component5() {
        return this.isFreshUpload;
    }

    public final ProofUploadDetails copy(String str, String str2, String str3, ProofUploadStatus proofUploadStatus2, boolean z) {
        n86.e(str, "uploadedProofUrl");
        n86.e(str2, "proofImageLocalUri");
        n86.e(str3, "uploadRequestId");
        n86.e(proofUploadStatus2, "proofUploadStatus");
        return new ProofUploadDetails(str, str2, str3, proofUploadStatus2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProofUploadDetails)) {
            return false;
        }
        ProofUploadDetails proofUploadDetails = (ProofUploadDetails) obj;
        return n86.a(this.uploadedProofUrl, proofUploadDetails.uploadedProofUrl) && n86.a(this.proofImageLocalUri, proofUploadDetails.proofImageLocalUri) && n86.a(this.uploadRequestId, proofUploadDetails.uploadRequestId) && this.proofUploadStatus == proofUploadDetails.proofUploadStatus && this.isFreshUpload == proofUploadDetails.isFreshUpload;
    }

    public final String getProofImageLocalUri() {
        return this.proofImageLocalUri;
    }

    public final ProofUploadStatus getProofUploadStatus() {
        return this.proofUploadStatus;
    }

    public final String getUploadRequestId() {
        return this.uploadRequestId;
    }

    public final String getUploadedProofUrl() {
        return this.uploadedProofUrl;
    }

    public int hashCode() {
        int hashCode = (this.proofUploadStatus.hashCode() + hj1.r0(this.uploadRequestId, hj1.r0(this.proofImageLocalUri, this.uploadedProofUrl.hashCode() * 31, 31), 31)) * 31;
        boolean z = this.isFreshUpload;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public final boolean isFreshUpload() {
        return this.isFreshUpload;
    }

    public final void setProofImageLocalUri(String str) {
        n86.e(str, "<set-?>");
        this.proofImageLocalUri = str;
    }

    public final void setProofUploadStatus(ProofUploadStatus proofUploadStatus2) {
        n86.e(proofUploadStatus2, "<set-?>");
        this.proofUploadStatus = proofUploadStatus2;
    }

    public final void setUploadRequestId(String str) {
        n86.e(str, "<set-?>");
        this.uploadRequestId = str;
    }

    public final void setUploadedProofUrl(String str) {
        n86.e(str, "<set-?>");
        this.uploadedProofUrl = str;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProofUploadDetails(uploadedProofUrl=");
        i0.append(this.uploadedProofUrl);
        i0.append(", proofImageLocalUri=");
        i0.append(this.proofImageLocalUri);
        i0.append(", uploadRequestId=");
        i0.append(this.uploadRequestId);
        i0.append(", proofUploadStatus=");
        i0.append(this.proofUploadStatus);
        i0.append(", isFreshUpload=");
        i0.append(this.isFreshUpload);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.uploadedProofUrl);
        parcel.writeString(this.proofImageLocalUri);
        parcel.writeString(this.uploadRequestId);
        parcel.writeString(this.proofUploadStatus.name());
        parcel.writeInt(this.isFreshUpload ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProofUploadDetails(String str, String str2, String str3, ProofUploadStatus proofUploadStatus2, boolean z, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? new String() : str2, (i & 4) != 0 ? new String() : str3, (i & 8) != 0 ? ProofUploadStatus.NOT_UPLOADED : proofUploadStatus2, (i & 16) != 0 ? true : z);
    }
}
