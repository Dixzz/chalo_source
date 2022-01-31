package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FareInfo.kt */
public final class FareInfo implements Parcelable {
    public static final Parcelable.Creator<FareInfo> CREATOR = new Creator();
    private final double actualFare;
    private final double discountedFare;
    private final List<FareBreakupComponent> fareBreakupComponentList;
    private final boolean isDiscountApplicable;
    private final double payableAmount;

    /* compiled from: FareInfo.kt */
    public static final class Creator implements Parcelable.Creator<FareInfo> {
        @Override // android.os.Parcelable.Creator
        public final FareInfo createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            double readDouble = parcel.readDouble();
            double readDouble2 = parcel.readDouble();
            boolean z = parcel.readInt() != 0;
            double readDouble3 = parcel.readDouble();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(FareBreakupComponent.CREATOR.createFromParcel(parcel));
            }
            return new FareInfo(readDouble, readDouble2, z, readDouble3, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final FareInfo[] newArray(int i) {
            return new FareInfo[i];
        }
    }

    public FareInfo(double d, double d2, boolean z, double d3, List<FareBreakupComponent> list) {
        n86.e(list, "fareBreakupComponentList");
        this.payableAmount = d;
        this.actualFare = d2;
        this.isDiscountApplicable = z;
        this.discountedFare = d3;
        this.fareBreakupComponentList = list;
    }

    public static /* synthetic */ FareInfo copy$default(FareInfo fareInfo, double d, double d2, boolean z, double d3, List list, int i, Object obj) {
        return fareInfo.copy((i & 1) != 0 ? fareInfo.payableAmount : d, (i & 2) != 0 ? fareInfo.actualFare : d2, (i & 4) != 0 ? fareInfo.isDiscountApplicable : z, (i & 8) != 0 ? fareInfo.discountedFare : d3, (i & 16) != 0 ? fareInfo.fareBreakupComponentList : list);
    }

    public final double component1() {
        return this.payableAmount;
    }

    public final double component2() {
        return this.actualFare;
    }

    public final boolean component3() {
        return this.isDiscountApplicable;
    }

    public final double component4() {
        return this.discountedFare;
    }

    public final List<FareBreakupComponent> component5() {
        return this.fareBreakupComponentList;
    }

    public final FareInfo copy(double d, double d2, boolean z, double d3, List<FareBreakupComponent> list) {
        n86.e(list, "fareBreakupComponentList");
        return new FareInfo(d, d2, z, d3, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FareInfo)) {
            return false;
        }
        FareInfo fareInfo = (FareInfo) obj;
        return n86.a(Double.valueOf(this.payableAmount), Double.valueOf(fareInfo.payableAmount)) && n86.a(Double.valueOf(this.actualFare), Double.valueOf(fareInfo.actualFare)) && this.isDiscountApplicable == fareInfo.isDiscountApplicable && n86.a(Double.valueOf(this.discountedFare), Double.valueOf(fareInfo.discountedFare)) && n86.a(this.fareBreakupComponentList, fareInfo.fareBreakupComponentList);
    }

    public final double getActualFare() {
        return this.actualFare;
    }

    public final String getActualFareString() {
        double d = this.actualFare;
        int i = (int) d;
        if (d - ((double) i) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }

    public final String getDiscountAmountString() {
        double d = this.actualFare - this.discountedFare;
        int i = (int) d;
        if (d - ((double) i) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }

    public final double getDiscountedFare() {
        return this.discountedFare;
    }

    public final String getDiscountedFareString() {
        double d = this.discountedFare;
        int i = (int) d;
        if (d - ((double) i) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }

    public final List<FareBreakupComponent> getFareBreakupComponentList() {
        return this.fareBreakupComponentList;
    }

    public final double getPayableAmount() {
        return this.payableAmount;
    }

    public final String getPayableAmountString() {
        double d = this.payableAmount;
        int i = (int) d;
        if (d - ((double) i) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return String.valueOf(i);
        }
        return String.valueOf(d);
    }

    public int hashCode() {
        int doubleToLongBits = ((Double.doubleToLongBits(this.payableAmount) * 31) + Double.doubleToLongBits(this.actualFare)) * 31;
        boolean z = this.isDiscountApplicable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return this.fareBreakupComponentList.hashCode() + ((((doubleToLongBits + i) * 31) + Double.doubleToLongBits(this.discountedFare)) * 31);
    }

    public final boolean isDiscountApplicable() {
        return this.isDiscountApplicable;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("FareInfo(payableAmount=");
        i0.append(this.payableAmount);
        i0.append(", actualFare=");
        i0.append(this.actualFare);
        i0.append(", isDiscountApplicable=");
        i0.append(this.isDiscountApplicable);
        i0.append(", discountedFare=");
        i0.append(this.discountedFare);
        i0.append(", fareBreakupComponentList=");
        i0.append(this.fareBreakupComponentList);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeDouble(this.payableAmount);
        parcel.writeDouble(this.actualFare);
        parcel.writeInt(this.isDiscountApplicable ? 1 : 0);
        parcel.writeDouble(this.discountedFare);
        List<FareBreakupComponent> list = this.fareBreakupComponentList;
        parcel.writeInt(list.size());
        for (FareBreakupComponent fareBreakupComponent : list) {
            fareBreakupComponent.writeToParcel(parcel, i);
        }
    }
}
