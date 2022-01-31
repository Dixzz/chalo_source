package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import java.util.List;

/* compiled from: ProofDocumentProps.kt */
public final class ProofDocumentProps implements Parcelable {
    public static final Parcelable.Creator<ProofDocumentProps> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String formUrl;
    private final String longDescription;
    private final String placeHolderImageUrl;
    private final String proofId;
    private final String proofName;
    private final String shortDescription;
    private final String tutorialUrl;

    /* compiled from: ProofDocumentProps.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final ProofDocumentProps convertToObjectFromStoreString(String str) {
            n86.e(str, "lStringObject");
            List B = ea6.B(str, new String[]{"~~~"}, false, 0, 6);
            return new ProofDocumentProps((String) B.get(0), (String) B.get(1), (String) B.get(2), (String) B.get(3), (String) B.get(4), (String) B.get(5), (String) B.get(6));
        }

        public final String convertToStringToStore(ProofDocumentProps proofDocumentProps) {
            n86.e(proofDocumentProps, "lProofDocumentProps");
            return proofDocumentProps.getProofId() + "~~~" + proofDocumentProps.getProofName() + "~~~" + proofDocumentProps.getShortDescription() + "~~~" + proofDocumentProps.getLongDescription() + "~~~" + proofDocumentProps.getPlaceHolderImageUrl() + "~~~" + proofDocumentProps.getFormUrl() + "~~~" + proofDocumentProps.getTutorialUrl();
        }
    }

    /* compiled from: ProofDocumentProps.kt */
    public static final class Creator implements Parcelable.Creator<ProofDocumentProps> {
        @Override // android.os.Parcelable.Creator
        public final ProofDocumentProps createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new ProofDocumentProps(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProofDocumentProps[] newArray(int i) {
            return new ProofDocumentProps[i];
        }
    }

    public ProofDocumentProps(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        n86.e(str, "proofId");
        n86.e(str2, SuperPassJsonKeys.PROOF_NAME);
        n86.e(str3, "shortDescription");
        n86.e(str4, "longDescription");
        n86.e(str5, "placeHolderImageUrl");
        n86.e(str6, "formUrl");
        n86.e(str7, "tutorialUrl");
        this.proofId = str;
        this.proofName = str2;
        this.shortDescription = str3;
        this.longDescription = str4;
        this.placeHolderImageUrl = str5;
        this.formUrl = str6;
        this.tutorialUrl = str7;
    }

    public static final ProofDocumentProps convertToObjectFromStoreString(String str) {
        return Companion.convertToObjectFromStoreString(str);
    }

    public static final String convertToStringToStore(ProofDocumentProps proofDocumentProps) {
        return Companion.convertToStringToStore(proofDocumentProps);
    }

    public static /* synthetic */ ProofDocumentProps copy$default(ProofDocumentProps proofDocumentProps, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proofDocumentProps.proofId;
        }
        if ((i & 2) != 0) {
            str2 = proofDocumentProps.proofName;
        }
        if ((i & 4) != 0) {
            str3 = proofDocumentProps.shortDescription;
        }
        if ((i & 8) != 0) {
            str4 = proofDocumentProps.longDescription;
        }
        if ((i & 16) != 0) {
            str5 = proofDocumentProps.placeHolderImageUrl;
        }
        if ((i & 32) != 0) {
            str6 = proofDocumentProps.formUrl;
        }
        if ((i & 64) != 0) {
            str7 = proofDocumentProps.tutorialUrl;
        }
        return proofDocumentProps.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.proofId;
    }

    public final String component2() {
        return this.proofName;
    }

    public final String component3() {
        return this.shortDescription;
    }

    public final String component4() {
        return this.longDescription;
    }

    public final String component5() {
        return this.placeHolderImageUrl;
    }

    public final String component6() {
        return this.formUrl;
    }

    public final String component7() {
        return this.tutorialUrl;
    }

    public final ProofDocumentProps copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        n86.e(str, "proofId");
        n86.e(str2, SuperPassJsonKeys.PROOF_NAME);
        n86.e(str3, "shortDescription");
        n86.e(str4, "longDescription");
        n86.e(str5, "placeHolderImageUrl");
        n86.e(str6, "formUrl");
        n86.e(str7, "tutorialUrl");
        return new ProofDocumentProps(str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProofDocumentProps)) {
            return false;
        }
        ProofDocumentProps proofDocumentProps = (ProofDocumentProps) obj;
        return n86.a(this.proofId, proofDocumentProps.proofId) && n86.a(this.proofName, proofDocumentProps.proofName) && n86.a(this.shortDescription, proofDocumentProps.shortDescription) && n86.a(this.longDescription, proofDocumentProps.longDescription) && n86.a(this.placeHolderImageUrl, proofDocumentProps.placeHolderImageUrl) && n86.a(this.formUrl, proofDocumentProps.formUrl) && n86.a(this.tutorialUrl, proofDocumentProps.tutorialUrl);
    }

    public final String getFormUrl() {
        return this.formUrl;
    }

    public final String getLongDescription() {
        return this.longDescription;
    }

    public final String getPlaceHolderImageUrl() {
        return this.placeHolderImageUrl;
    }

    public final String getProofId() {
        return this.proofId;
    }

    public final String getProofName() {
        return this.proofName;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final String getTutorialUrl() {
        return this.tutorialUrl;
    }

    public int hashCode() {
        return this.tutorialUrl.hashCode() + hj1.r0(this.formUrl, hj1.r0(this.placeHolderImageUrl, hj1.r0(this.longDescription, hj1.r0(this.shortDescription, hj1.r0(this.proofName, this.proofId.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ProofDocumentProps(proofId=");
        i0.append(this.proofId);
        i0.append(", proofName=");
        i0.append(this.proofName);
        i0.append(", shortDescription=");
        i0.append(this.shortDescription);
        i0.append(", longDescription=");
        i0.append(this.longDescription);
        i0.append(", placeHolderImageUrl=");
        i0.append(this.placeHolderImageUrl);
        i0.append(", formUrl=");
        i0.append(this.formUrl);
        i0.append(", tutorialUrl=");
        return hj1.Z(i0, this.tutorialUrl, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.proofId);
        parcel.writeString(this.proofName);
        parcel.writeString(this.shortDescription);
        parcel.writeString(this.longDescription);
        parcel.writeString(this.placeHolderImageUrl);
        parcel.writeString(this.formUrl);
        parcel.writeString(this.tutorialUrl);
    }
}
