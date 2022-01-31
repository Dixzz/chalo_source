package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SubCategorySelectionDetails.kt */
public final class SubCategorySelectionDetails implements Parcelable {
    public static final Parcelable.Creator<SubCategorySelectionDetails> CREATOR = new Creator();
    private final String _description;
    private final String _title;

    /* compiled from: SubCategorySelectionDetails.kt */
    public static final class Creator implements Parcelable.Creator<SubCategorySelectionDetails> {
        @Override // android.os.Parcelable.Creator
        public final SubCategorySelectionDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SubCategorySelectionDetails(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SubCategorySelectionDetails[] newArray(int i) {
            return new SubCategorySelectionDetails[i];
        }
    }

    public SubCategorySelectionDetails(String str, String str2) {
        n86.e(str, "_title");
        n86.e(str2, "_description");
        this._title = str;
        this._description = str2;
    }

    public static /* synthetic */ SubCategorySelectionDetails copy$default(SubCategorySelectionDetails subCategorySelectionDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subCategorySelectionDetails._title;
        }
        if ((i & 2) != 0) {
            str2 = subCategorySelectionDetails._description;
        }
        return subCategorySelectionDetails.copy(str, str2);
    }

    public final String component1() {
        return this._title;
    }

    public final String component2() {
        return this._description;
    }

    public final SubCategorySelectionDetails copy(String str, String str2) {
        n86.e(str, "_title");
        n86.e(str2, "_description");
        return new SubCategorySelectionDetails(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubCategorySelectionDetails)) {
            return false;
        }
        SubCategorySelectionDetails subCategorySelectionDetails = (SubCategorySelectionDetails) obj;
        return n86.a(this._title, subCategorySelectionDetails._title) && n86.a(this._description, subCategorySelectionDetails._description);
    }

    public final String get_description() {
        return this._description;
    }

    public final String get_title() {
        return this._title;
    }

    public int hashCode() {
        return this._description.hashCode() + (this._title.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SubCategorySelectionDetails(_title=");
        i0.append(this._title);
        i0.append(", _description=");
        return hj1.Z(i0, this._description, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this._title);
        parcel.writeString(this._description);
    }
}
