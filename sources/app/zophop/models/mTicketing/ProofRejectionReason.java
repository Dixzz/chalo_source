package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.List;

/* compiled from: ProofRejectionReason.kt */
public final class ProofRejectionReason implements Parcelable {
    public static final Parcelable.Creator<ProofRejectionReason> CREATOR = new Creator();
    private final String lProofUrl;
    private final String proofId;
    private final List<String> reasonsList;
    private final RejectionStatus status;

    /* compiled from: ProofRejectionReason.kt */
    public static final class Creator implements Parcelable.Creator<ProofRejectionReason> {
        @Override // android.os.Parcelable.Creator
        public final ProofRejectionReason createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProofRejectionReason(RejectionStatus.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final ProofRejectionReason[] newArray(int i) {
            return new ProofRejectionReason[i];
        }
    }

    public ProofRejectionReason(RejectionStatus rejectionStatus, String str, String str2, List<String> list) {
        n86.e(rejectionStatus, "status");
        n86.e(str, "proofId");
        n86.e(str2, "lProofUrl");
        n86.e(list, "reasonsList");
        this.status = rejectionStatus;
        this.proofId = str;
        this.lProofUrl = str2;
        this.reasonsList = list;
    }

    public int describeContents() {
        return 0;
    }

    public final List<String> fromString(String str) {
        return (List) new Gson().fromJson(str, new ProofRejectionReason$fromString$lListType$1().getType());
    }

    public final String getLProofUrl() {
        return this.lProofUrl;
    }

    public final String getProofId() {
        return this.proofId;
    }

    public final List<String> getReasonsList() {
        return this.reasonsList;
    }

    public final RejectionStatus getStatus() {
        return this.status;
    }

    public final String toString(List<String> list) {
        return new Gson().toJson(list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.status.name());
        parcel.writeString(this.proofId);
        parcel.writeString(this.lProofUrl);
        parcel.writeStringList(this.reasonsList);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProofRejectionReason(RejectionStatus rejectionStatus, String str, String str2, List list, int i, j86 j86) {
        this((i & 1) != 0 ? RejectionStatus.VALID : rejectionStatus, str, str2, list);
    }
}
