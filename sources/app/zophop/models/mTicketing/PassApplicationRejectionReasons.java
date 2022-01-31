package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PassApplicationRejectionReasons.kt */
public final class PassApplicationRejectionReasons implements Parcelable {
    public static final Parcelable.Creator<PassApplicationRejectionReasons> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final List<String> generalRejectionReasonsList;
    private final List<ProfileRejectionReason> profileRejectionReasonsList;
    private final List<ProofRejectionReason> proofRejectionReasonsList;

    /* compiled from: PassApplicationRejectionReasons.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final String convertPassApplicationRejectionReasonsToString(PassApplicationRejectionReasons passApplicationRejectionReasons) {
            n86.e(passApplicationRejectionReasons, "PassApplicationRejectionReasons");
            String json = new Gson().toJson(passApplicationRejectionReasons);
            n86.d(json, "lGson.toJson(PassApplicationRejectionReasons)");
            return json;
        }

        public final PassApplicationRejectionReasons getPassApplicationRejectionReasonsFromString(String str) {
            n86.e(str, "lPassApplicationRejectionReasonsString");
            Object fromJson = new Gson().fromJson(str, PassApplicationRejectionReasons.class);
            n86.d(fromJson, "lGson.fromJson(lPassAppl…ctionReasons::class.java)");
            return (PassApplicationRejectionReasons) fromJson;
        }
    }

    /* compiled from: PassApplicationRejectionReasons.kt */
    public static final class Creator implements Parcelable.Creator<PassApplicationRejectionReasons> {
        @Override // android.os.Parcelable.Creator
        public final PassApplicationRejectionReasons createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(ProofRejectionReason.CREATOR.createFromParcel(parcel));
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList2.add(ProfileRejectionReason.CREATOR.createFromParcel(parcel));
            }
            return new PassApplicationRejectionReasons(arrayList, arrayList2, parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final PassApplicationRejectionReasons[] newArray(int i) {
            return new PassApplicationRejectionReasons[i];
        }
    }

    public PassApplicationRejectionReasons() {
        this(null, null, null, 7, null);
    }

    public PassApplicationRejectionReasons(List<ProofRejectionReason> list, List<ProfileRejectionReason> list2, List<String> list3) {
        n86.e(list, "proofRejectionReasonsList");
        n86.e(list2, "profileRejectionReasonsList");
        n86.e(list3, "generalRejectionReasonsList");
        this.proofRejectionReasonsList = list;
        this.profileRejectionReasonsList = list2;
        this.generalRejectionReasonsList = list3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: app.zophop.models.mTicketing.PassApplicationRejectionReasons */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PassApplicationRejectionReasons copy$default(PassApplicationRejectionReasons passApplicationRejectionReasons, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = passApplicationRejectionReasons.proofRejectionReasonsList;
        }
        if ((i & 2) != 0) {
            list2 = passApplicationRejectionReasons.profileRejectionReasonsList;
        }
        if ((i & 4) != 0) {
            list3 = passApplicationRejectionReasons.generalRejectionReasonsList;
        }
        return passApplicationRejectionReasons.copy(list, list2, list3);
    }

    public final List<ProofRejectionReason> component1() {
        return this.proofRejectionReasonsList;
    }

    public final List<ProfileRejectionReason> component2() {
        return this.profileRejectionReasonsList;
    }

    public final List<String> component3() {
        return this.generalRejectionReasonsList;
    }

    public final PassApplicationRejectionReasons copy(List<ProofRejectionReason> list, List<ProfileRejectionReason> list2, List<String> list3) {
        n86.e(list, "proofRejectionReasonsList");
        n86.e(list2, "profileRejectionReasonsList");
        n86.e(list3, "generalRejectionReasonsList");
        return new PassApplicationRejectionReasons(list, list2, list3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassApplicationRejectionReasons)) {
            return false;
        }
        PassApplicationRejectionReasons passApplicationRejectionReasons = (PassApplicationRejectionReasons) obj;
        return n86.a(this.proofRejectionReasonsList, passApplicationRejectionReasons.proofRejectionReasonsList) && n86.a(this.profileRejectionReasonsList, passApplicationRejectionReasons.profileRejectionReasonsList) && n86.a(this.generalRejectionReasonsList, passApplicationRejectionReasons.generalRejectionReasonsList);
    }

    public final List<String> getGeneralRejectionReasonsList() {
        return this.generalRejectionReasonsList;
    }

    public final List<ProfileRejectionReason> getProfileRejectionReasonsList() {
        return this.profileRejectionReasonsList;
    }

    public final List<ProofRejectionReason> getProofRejectionReasonsList() {
        return this.proofRejectionReasonsList;
    }

    public int hashCode() {
        int hashCode = this.profileRejectionReasonsList.hashCode();
        return this.generalRejectionReasonsList.hashCode() + ((hashCode + (this.proofRejectionReasonsList.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("PassApplicationRejectionReasons(proofRejectionReasonsList=");
        i0.append(this.proofRejectionReasonsList);
        i0.append(", profileRejectionReasonsList=");
        i0.append(this.profileRejectionReasonsList);
        i0.append(", generalRejectionReasonsList=");
        i0.append(this.generalRejectionReasonsList);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        List<ProofRejectionReason> list = this.proofRejectionReasonsList;
        parcel.writeInt(list.size());
        for (ProofRejectionReason proofRejectionReason : list) {
            proofRejectionReason.writeToParcel(parcel, i);
        }
        List<ProfileRejectionReason> list2 = this.profileRejectionReasonsList;
        parcel.writeInt(list2.size());
        for (ProfileRejectionReason profileRejectionReason : list2) {
            profileRejectionReason.writeToParcel(parcel, i);
        }
        parcel.writeStringList(this.generalRejectionReasonsList);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PassApplicationRejectionReasons(List list, List list2, List list3, int i, j86 j86) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2, (i & 4) != 0 ? new ArrayList() : list3);
    }
}
