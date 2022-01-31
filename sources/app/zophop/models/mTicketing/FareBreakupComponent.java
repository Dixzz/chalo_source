package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;

/* compiled from: FareBreakupComponent.kt */
public final class FareBreakupComponent implements Parcelable {
    public static final Parcelable.Creator<FareBreakupComponent> CREATOR = new Creator();
    private final String amountName;
    private final String displayName;

    /* compiled from: FareBreakupComponent.kt */
    public static final class Creator implements Parcelable.Creator<FareBreakupComponent> {
        @Override // android.os.Parcelable.Creator
        public final FareBreakupComponent createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new FareBreakupComponent(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final FareBreakupComponent[] newArray(int i) {
            return new FareBreakupComponent[i];
        }
    }

    public FareBreakupComponent(String str, String str2) {
        n86.e(str, SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        n86.e(str2, "amountName");
        this.displayName = str;
        this.amountName = str2;
    }

    public static /* synthetic */ FareBreakupComponent copy$default(FareBreakupComponent fareBreakupComponent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fareBreakupComponent.displayName;
        }
        if ((i & 2) != 0) {
            str2 = fareBreakupComponent.amountName;
        }
        return fareBreakupComponent.copy(str, str2);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.amountName;
    }

    public final FareBreakupComponent copy(String str, String str2) {
        n86.e(str, SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
        n86.e(str2, "amountName");
        return new FareBreakupComponent(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FareBreakupComponent)) {
            return false;
        }
        FareBreakupComponent fareBreakupComponent = (FareBreakupComponent) obj;
        return n86.a(this.displayName, fareBreakupComponent.displayName) && n86.a(this.amountName, fareBreakupComponent.amountName);
    }

    public final String getAmountName() {
        return this.amountName;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public int hashCode() {
        return this.amountName.hashCode() + (this.displayName.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("FareBreakupComponent(displayName=");
        i0.append(this.displayName);
        i0.append(", amountName=");
        return hj1.Z(i0, this.amountName, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.displayName);
        parcel.writeString(this.amountName);
    }
}
