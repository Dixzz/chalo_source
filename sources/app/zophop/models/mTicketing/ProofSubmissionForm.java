package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProofSubmissionForm.kt */
public final class ProofSubmissionForm implements Parcelable {
    public static final Parcelable.Creator<ProofSubmissionForm> CREATOR = new Creator();
    private final String name;
    private final String url;

    /* compiled from: ProofSubmissionForm.kt */
    public static final class Creator implements Parcelable.Creator<ProofSubmissionForm> {
        @Override // android.os.Parcelable.Creator
        public final ProofSubmissionForm createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProofSubmissionForm(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProofSubmissionForm[] newArray(int i) {
            return new ProofSubmissionForm[i];
        }
    }

    public ProofSubmissionForm(String str, String str2) {
        n86.e(str, "name");
        n86.e(str2, "url");
        this.name = str;
        this.url = str2;
    }

    public static /* synthetic */ ProofSubmissionForm copy$default(ProofSubmissionForm proofSubmissionForm, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proofSubmissionForm.name;
        }
        if ((i & 2) != 0) {
            str2 = proofSubmissionForm.url;
        }
        return proofSubmissionForm.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final ProofSubmissionForm copy(String str, String str2) {
        n86.e(str, "name");
        n86.e(str2, "url");
        return new ProofSubmissionForm(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProofSubmissionForm)) {
            return false;
        }
        ProofSubmissionForm proofSubmissionForm = (ProofSubmissionForm) obj;
        return n86.a(this.name, proofSubmissionForm.name) && n86.a(this.url, proofSubmissionForm.url);
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProofSubmissionForm(name=");
        i0.append(this.name);
        i0.append(", url=");
        return hj1.Z(i0, this.url, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.url);
    }
}
