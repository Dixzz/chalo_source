package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SuperPassProofProperties.kt */
public final class SuperPassProofProperties implements Parcelable {
    public static final Parcelable.Creator<SuperPassProofProperties> CREATOR = new Creator();
    private final String proofName;
    private final String proofUrl;

    /* compiled from: SuperPassProofProperties.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassProofProperties> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassProofProperties createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassProofProperties(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassProofProperties[] newArray(int i) {
            return new SuperPassProofProperties[i];
        }
    }

    public SuperPassProofProperties(String str, String str2) {
        n86.e(str, SuperPassJsonKeys.PROOF_NAME);
        n86.e(str2, SuperPassJsonKeys.PROOF_URL);
        this.proofName = str;
        this.proofUrl = str2;
    }

    public static /* synthetic */ SuperPassProofProperties copy$default(SuperPassProofProperties superPassProofProperties, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = superPassProofProperties.proofName;
        }
        if ((i & 2) != 0) {
            str2 = superPassProofProperties.proofUrl;
        }
        return superPassProofProperties.copy(str, str2);
    }

    public final String component1() {
        return this.proofName;
    }

    public final String component2() {
        return this.proofUrl;
    }

    public final SuperPassProofProperties copy(String str, String str2) {
        n86.e(str, SuperPassJsonKeys.PROOF_NAME);
        n86.e(str2, SuperPassJsonKeys.PROOF_URL);
        return new SuperPassProofProperties(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassProofProperties)) {
            return false;
        }
        SuperPassProofProperties superPassProofProperties = (SuperPassProofProperties) obj;
        return n86.a(this.proofName, superPassProofProperties.proofName) && n86.a(this.proofUrl, superPassProofProperties.proofUrl);
    }

    public final String getProofName() {
        return this.proofName;
    }

    public final String getProofUrl() {
        return this.proofUrl;
    }

    public int hashCode() {
        return this.proofUrl.hashCode() + (this.proofName.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassProofProperties(proofName=");
        i0.append(this.proofName);
        i0.append(", proofUrl=");
        return hj1.Z(i0, this.proofUrl, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.proofName);
        parcel.writeString(this.proofUrl);
    }
}
