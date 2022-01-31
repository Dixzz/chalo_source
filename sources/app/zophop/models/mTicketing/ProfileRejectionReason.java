package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.List;

/* compiled from: ProfileRejectionReason.kt */
public final class ProfileRejectionReason implements Parcelable {
    public static final Parcelable.Creator<ProfileRejectionReason> CREATOR = new Creator();
    private final String proofId;
    private final List<String> reasonsList;
    private final RejectionStatus status;

    /* compiled from: ProfileRejectionReason.kt */
    public static final class Creator implements Parcelable.Creator<ProfileRejectionReason> {
        @Override // android.os.Parcelable.Creator
        public final ProfileRejectionReason createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProfileRejectionReason(RejectionStatus.valueOf(parcel.readString()), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileRejectionReason[] newArray(int i) {
            return new ProfileRejectionReason[i];
        }
    }

    public ProfileRejectionReason(RejectionStatus rejectionStatus, String str, List<String> list) {
        n86.e(rejectionStatus, "status");
        n86.e(str, "proofId");
        n86.e(list, "reasonsList");
        this.status = rejectionStatus;
        this.proofId = str;
        this.reasonsList = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: app.zophop.models.mTicketing.ProfileRejectionReason */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileRejectionReason copy$default(ProfileRejectionReason profileRejectionReason, RejectionStatus rejectionStatus, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            rejectionStatus = profileRejectionReason.status;
        }
        if ((i & 2) != 0) {
            str = profileRejectionReason.proofId;
        }
        if ((i & 4) != 0) {
            list = profileRejectionReason.reasonsList;
        }
        return profileRejectionReason.copy(rejectionStatus, str, list);
    }

    public final RejectionStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.proofId;
    }

    public final List<String> component3() {
        return this.reasonsList;
    }

    public final ProfileRejectionReason copy(RejectionStatus rejectionStatus, String str, List<String> list) {
        n86.e(rejectionStatus, "status");
        n86.e(str, "proofId");
        n86.e(list, "reasonsList");
        return new ProfileRejectionReason(rejectionStatus, str, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileRejectionReason)) {
            return false;
        }
        ProfileRejectionReason profileRejectionReason = (ProfileRejectionReason) obj;
        return this.status == profileRejectionReason.status && n86.a(this.proofId, profileRejectionReason.proofId) && n86.a(this.reasonsList, profileRejectionReason.reasonsList);
    }

    public final List<String> fromString(String str) {
        return (List) new Gson().fromJson(str, new ProfileRejectionReason$fromString$lListType$1().getType());
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

    public int hashCode() {
        return this.reasonsList.hashCode() + hj1.r0(this.proofId, this.status.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProfileRejectionReason(status=");
        i0.append(this.status);
        i0.append(", proofId=");
        i0.append(this.proofId);
        i0.append(", reasonsList=");
        i0.append(this.reasonsList);
        i0.append(')');
        return i0.toString();
    }

    public final String toString(List<String> list) {
        return new Gson().toJson(list);
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.status.name());
        parcel.writeString(this.proofId);
        parcel.writeStringList(this.reasonsList);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfileRejectionReason(RejectionStatus rejectionStatus, String str, List list, int i, j86 j86) {
        this((i & 1) != 0 ? RejectionStatus.VALID : rejectionStatus, str, list);
    }
}
