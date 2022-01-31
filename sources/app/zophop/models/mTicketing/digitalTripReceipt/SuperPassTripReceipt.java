package app.zophop.models.mTicketing.digitalTripReceipt;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import server.zophop.Constants;

/* compiled from: SuperPassTripReceipt.kt */
public final class SuperPassTripReceipt implements Parcelable {
    public static final Parcelable.Creator<SuperPassTripReceipt> CREATOR = new Creator();
    private final long activationTimeStamp;
    private final String conductorId;
    private final String endStopName;
    private final String passId;
    private final String productSubType;
    private final String productType;
    private final long punchTimeStamp;
    private final String routeName;
    private final List<String> specialFeatureList;
    private final String startStopName;
    private final String vehicleNo;

    /* compiled from: SuperPassTripReceipt.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassTripReceipt> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassTripReceipt createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassTripReceipt(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassTripReceipt[] newArray(int i) {
            return new SuperPassTripReceipt[i];
        }
    }

    public SuperPassTripReceipt(String str, String str2, String str3, long j, long j2, String str4, String str5, String str6, String str7, String str8, List<String> list) {
        n86.e(str, "passId");
        n86.e(str2, "productType");
        n86.e(str3, "productSubType");
        n86.e(str4, DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO);
        n86.e(str5, DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID);
        n86.e(str6, Constants.START_STOP_NAME);
        n86.e(str7, Constants.END_STOP_STOP_NAME);
        n86.e(str8, "routeName");
        n86.e(list, "specialFeatureList");
        this.passId = str;
        this.productType = str2;
        this.productSubType = str3;
        this.activationTimeStamp = j;
        this.punchTimeStamp = j2;
        this.vehicleNo = str4;
        this.conductorId = str5;
        this.startStopName = str6;
        this.endStopName = str7;
        this.routeName = str8;
        this.specialFeatureList = list;
    }

    public static /* synthetic */ SuperPassTripReceipt copy$default(SuperPassTripReceipt superPassTripReceipt, String str, String str2, String str3, long j, long j2, String str4, String str5, String str6, String str7, String str8, List list, int i, Object obj) {
        return superPassTripReceipt.copy((i & 1) != 0 ? superPassTripReceipt.passId : str, (i & 2) != 0 ? superPassTripReceipt.productType : str2, (i & 4) != 0 ? superPassTripReceipt.productSubType : str3, (i & 8) != 0 ? superPassTripReceipt.activationTimeStamp : j, (i & 16) != 0 ? superPassTripReceipt.punchTimeStamp : j2, (i & 32) != 0 ? superPassTripReceipt.vehicleNo : str4, (i & 64) != 0 ? superPassTripReceipt.conductorId : str5, (i & 128) != 0 ? superPassTripReceipt.startStopName : str6, (i & 256) != 0 ? superPassTripReceipt.endStopName : str7, (i & 512) != 0 ? superPassTripReceipt.routeName : str8, (i & 1024) != 0 ? superPassTripReceipt.specialFeatureList : list);
    }

    public final String component1() {
        return this.passId;
    }

    public final String component10() {
        return this.routeName;
    }

    public final List<String> component11() {
        return this.specialFeatureList;
    }

    public final String component2() {
        return this.productType;
    }

    public final String component3() {
        return this.productSubType;
    }

    public final long component4() {
        return this.activationTimeStamp;
    }

    public final long component5() {
        return this.punchTimeStamp;
    }

    public final String component6() {
        return this.vehicleNo;
    }

    public final String component7() {
        return this.conductorId;
    }

    public final String component8() {
        return this.startStopName;
    }

    public final String component9() {
        return this.endStopName;
    }

    public final SuperPassTripReceipt copy(String str, String str2, String str3, long j, long j2, String str4, String str5, String str6, String str7, String str8, List<String> list) {
        n86.e(str, "passId");
        n86.e(str2, "productType");
        n86.e(str3, "productSubType");
        n86.e(str4, DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO);
        n86.e(str5, DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID);
        n86.e(str6, Constants.START_STOP_NAME);
        n86.e(str7, Constants.END_STOP_STOP_NAME);
        n86.e(str8, "routeName");
        n86.e(list, "specialFeatureList");
        return new SuperPassTripReceipt(str, str2, str3, j, j2, str4, str5, str6, str7, str8, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperPassTripReceipt)) {
            return false;
        }
        SuperPassTripReceipt superPassTripReceipt = (SuperPassTripReceipt) obj;
        return n86.a(this.passId, superPassTripReceipt.passId) && n86.a(this.productType, superPassTripReceipt.productType) && n86.a(this.productSubType, superPassTripReceipt.productSubType) && this.activationTimeStamp == superPassTripReceipt.activationTimeStamp && this.punchTimeStamp == superPassTripReceipt.punchTimeStamp && n86.a(this.vehicleNo, superPassTripReceipt.vehicleNo) && n86.a(this.conductorId, superPassTripReceipt.conductorId) && n86.a(this.startStopName, superPassTripReceipt.startStopName) && n86.a(this.endStopName, superPassTripReceipt.endStopName) && n86.a(this.routeName, superPassTripReceipt.routeName) && n86.a(this.specialFeatureList, superPassTripReceipt.specialFeatureList);
    }

    public final long getActivationTimeStamp() {
        return this.activationTimeStamp;
    }

    public final String getConductorId() {
        return this.conductorId;
    }

    public final String getEndStopName() {
        return this.endStopName;
    }

    public final String getPassId() {
        return this.passId;
    }

    public final String getProductSubType() {
        return this.productSubType;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final long getPunchTimeStamp() {
        return this.punchTimeStamp;
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final List<String> getSpecialFeatureList() {
        return this.specialFeatureList;
    }

    public final String getStartStopName() {
        return this.startStopName;
    }

    public final String getVehicleNo() {
        return this.vehicleNo;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.productSubType, hj1.r0(this.productType, this.passId.hashCode() * 31, 31), 31);
        int a2 = d.a(this.punchTimeStamp);
        return this.specialFeatureList.hashCode() + hj1.r0(this.routeName, hj1.r0(this.endStopName, hj1.r0(this.startStopName, hj1.r0(this.conductorId, hj1.r0(this.vehicleNo, (a2 + ((d.a(this.activationTimeStamp) + r0) * 31)) * 31, 31), 31), 31), 31), 31);
    }

    public final boolean isTripReceiptInfoAvailable() {
        return this.punchTimeStamp != -1;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("SuperPassTripReceipt(passId=");
        i0.append(this.passId);
        i0.append(", productType=");
        i0.append(this.productType);
        i0.append(", productSubType=");
        i0.append(this.productSubType);
        i0.append(", activationTimeStamp=");
        i0.append(this.activationTimeStamp);
        i0.append(", punchTimeStamp=");
        i0.append(this.punchTimeStamp);
        i0.append(", vehicleNo=");
        i0.append(this.vehicleNo);
        i0.append(", conductorId=");
        i0.append(this.conductorId);
        i0.append(", startStopName=");
        i0.append(this.startStopName);
        i0.append(", endStopName=");
        i0.append(this.endStopName);
        i0.append(", routeName=");
        i0.append(this.routeName);
        i0.append(", specialFeatureList=");
        i0.append(this.specialFeatureList);
        i0.append(')');
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.passId);
        parcel.writeString(this.productType);
        parcel.writeString(this.productSubType);
        parcel.writeLong(this.activationTimeStamp);
        parcel.writeLong(this.punchTimeStamp);
        parcel.writeString(this.vehicleNo);
        parcel.writeString(this.conductorId);
        parcel.writeString(this.startStopName);
        parcel.writeString(this.endStopName);
        parcel.writeString(this.routeName);
        parcel.writeStringList(this.specialFeatureList);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassTripReceipt(String str, String str2, String str3, long j, long j2, String str4, String str5, String str6, String str7, String str8, List list, int i, j86 j86) {
        this(str, str2, str3, j, (i & 16) != 0 ? -1 : j2, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, list);
    }
}
