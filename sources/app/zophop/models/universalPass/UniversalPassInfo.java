package app.zophop.models.universalPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: UniversalPassInfo.kt */
public final class UniversalPassInfo implements Parcelable {
    public static final Parcelable.Creator<UniversalPassInfo> CREATOR = new Creator();
    private final String beneficiaryId;
    private final String name;
    private final String url;

    /* compiled from: UniversalPassInfo.kt */
    public static final class Creator implements Parcelable.Creator<UniversalPassInfo> {
        @Override // android.os.Parcelable.Creator
        public final UniversalPassInfo createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new UniversalPassInfo(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UniversalPassInfo[] newArray(int i) {
            return new UniversalPassInfo[i];
        }
    }

    public UniversalPassInfo(String str, String str2, String str3) {
        n86.e(str, "name");
        n86.e(str2, "url");
        n86.e(str3, "beneficiaryId");
        this.name = str;
        this.url = str2;
        this.beneficiaryId = str3;
    }

    public static /* synthetic */ UniversalPassInfo copy$default(UniversalPassInfo universalPassInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = universalPassInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = universalPassInfo.url;
        }
        if ((i & 4) != 0) {
            str3 = universalPassInfo.beneficiaryId;
        }
        return universalPassInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.beneficiaryId;
    }

    public final UniversalPassInfo copy(String str, String str2, String str3) {
        n86.e(str, "name");
        n86.e(str2, "url");
        n86.e(str3, "beneficiaryId");
        return new UniversalPassInfo(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UniversalPassInfo)) {
            return false;
        }
        UniversalPassInfo universalPassInfo = (UniversalPassInfo) obj;
        return n86.a(this.name, universalPassInfo.name) && n86.a(this.url, universalPassInfo.url) && n86.a(this.beneficiaryId, universalPassInfo.beneficiaryId);
    }

    public final String getBeneficiaryId() {
        return this.beneficiaryId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.beneficiaryId.hashCode() + hj1.r0(this.url, this.name.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("UniversalPassInfo(name=");
        i0.append(this.name);
        i0.append(", url=");
        i0.append(this.url);
        i0.append(", beneficiaryId=");
        return hj1.Z(i0, this.beneficiaryId, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.beneficiaryId);
    }
}
