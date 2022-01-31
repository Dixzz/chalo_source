package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;

/* compiled from: MTicketTripReceipt.kt */
public final class MTicketTripReceipt implements Parcelable {
    public static final Parcelable.Creator<MTicketTripReceipt> CREATOR = new Creator();
    private final long activationTimeStamp;
    private final String conductorId;
    private final long punchTimeStamp;
    private final String ticketId;
    private final String vehicleNo;

    /* compiled from: MTicketTripReceipt.kt */
    public static final class Creator implements Parcelable.Creator<MTicketTripReceipt> {
        @Override // android.os.Parcelable.Creator
        public final MTicketTripReceipt createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new MTicketTripReceipt(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MTicketTripReceipt[] newArray(int i) {
            return new MTicketTripReceipt[i];
        }
    }

    public MTicketTripReceipt(String str, long j, long j2, String str2, String str3) {
        n86.e(str, "ticketId");
        n86.e(str2, DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO);
        n86.e(str3, DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID);
        this.ticketId = str;
        this.activationTimeStamp = j;
        this.punchTimeStamp = j2;
        this.vehicleNo = str2;
        this.conductorId = str3;
    }

    public static /* synthetic */ MTicketTripReceipt copy$default(MTicketTripReceipt mTicketTripReceipt, String str, long j, long j2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTicketTripReceipt.ticketId;
        }
        if ((i & 2) != 0) {
            j = mTicketTripReceipt.activationTimeStamp;
        }
        if ((i & 4) != 0) {
            j2 = mTicketTripReceipt.punchTimeStamp;
        }
        if ((i & 8) != 0) {
            str2 = mTicketTripReceipt.vehicleNo;
        }
        if ((i & 16) != 0) {
            str3 = mTicketTripReceipt.conductorId;
        }
        return mTicketTripReceipt.copy(str, j, j2, str2, str3);
    }

    public final String component1() {
        return this.ticketId;
    }

    public final long component2() {
        return this.activationTimeStamp;
    }

    public final long component3() {
        return this.punchTimeStamp;
    }

    public final String component4() {
        return this.vehicleNo;
    }

    public final String component5() {
        return this.conductorId;
    }

    public final MTicketTripReceipt copy(String str, long j, long j2, String str2, String str3) {
        n86.e(str, "ticketId");
        n86.e(str2, DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO);
        n86.e(str3, DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID);
        return new MTicketTripReceipt(str, j, j2, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MTicketTripReceipt)) {
            return false;
        }
        MTicketTripReceipt mTicketTripReceipt = (MTicketTripReceipt) obj;
        return n86.a(this.ticketId, mTicketTripReceipt.ticketId) && this.activationTimeStamp == mTicketTripReceipt.activationTimeStamp && this.punchTimeStamp == mTicketTripReceipt.punchTimeStamp && n86.a(this.vehicleNo, mTicketTripReceipt.vehicleNo) && n86.a(this.conductorId, mTicketTripReceipt.conductorId);
    }

    public final long getActivationTimeStamp() {
        return this.activationTimeStamp;
    }

    public final String getConductorId() {
        return this.conductorId;
    }

    public final long getPunchTimeStamp() {
        return this.punchTimeStamp;
    }

    public final String getTicketId() {
        return this.ticketId;
    }

    public final String getVehicleNo() {
        return this.vehicleNo;
    }

    public int hashCode() {
        int a2 = d.a(this.activationTimeStamp);
        int a3 = d.a(this.punchTimeStamp);
        return this.conductorId.hashCode() + hj1.r0(this.vehicleNo, (a3 + ((a2 + (this.ticketId.hashCode() * 31)) * 31)) * 31, 31);
    }

    public final boolean isReceiptAvailable() {
        return this.punchTimeStamp != -1;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("MTicketTripReceipt(ticketId=");
        i0.append(this.ticketId);
        i0.append(", activationTimeStamp=");
        i0.append(this.activationTimeStamp);
        i0.append(", punchTimeStamp=");
        i0.append(this.punchTimeStamp);
        i0.append(", vehicleNo=");
        i0.append(this.vehicleNo);
        i0.append(", conductorId=");
        return hj1.Z(i0, this.conductorId, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.ticketId);
        parcel.writeLong(this.activationTimeStamp);
        parcel.writeLong(this.punchTimeStamp);
        parcel.writeString(this.vehicleNo);
        parcel.writeString(this.conductorId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MTicketTripReceipt(String str, long j, long j2, String str2, String str3, int i, j86 j86) {
        this(str, j, (i & 4) != 0 ? -1 : j2, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3);
    }
}
