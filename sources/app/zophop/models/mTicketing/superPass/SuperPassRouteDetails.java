package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;
import server.zophop.Constants;
import server.zophop.logging.LoggingConstants;

/* compiled from: SuperPassRouteDetails.kt */
public final class SuperPassRouteDetails implements Parcelable {
    public static final Parcelable.Creator<SuperPassRouteDetails> CREATOR = new Creator();
    private final String endStopId;
    private final String endStopName;
    private final String routeId;
    private final String routeName;
    private final String startStopId;
    private final String startStopName;

    /* compiled from: SuperPassRouteDetails.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassRouteDetails> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassRouteDetails createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new SuperPassRouteDetails(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassRouteDetails[] newArray(int i) {
            return new SuperPassRouteDetails[i];
        }
    }

    public SuperPassRouteDetails() {
        this(null, null, null, null, null, null, 63, null);
    }

    public SuperPassRouteDetails(String str, String str2, String str3, String str4, String str5, String str6) {
        n86.e(str, LoggingConstants.ROUTE_ID);
        n86.e(str2, "startStopId");
        n86.e(str3, "endStopId");
        n86.e(str4, "routeName");
        n86.e(str5, Constants.START_STOP_NAME);
        n86.e(str6, Constants.END_STOP_STOP_NAME);
        this.routeId = str;
        this.startStopId = str2;
        this.endStopId = str3;
        this.routeName = str4;
        this.startStopName = str5;
        this.endStopName = str6;
    }

    public int describeContents() {
        return 0;
    }

    public final String getEndStopId() {
        return this.endStopId;
    }

    public final String getEndStopName() {
        return this.endStopName;
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final String getStartStopId() {
        return this.startStopId;
    }

    public final String getStartStopName() {
        return this.startStopName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.routeId);
        parcel.writeString(this.startStopId);
        parcel.writeString(this.endStopId);
        parcel.writeString(this.routeName);
        parcel.writeString(this.startStopName);
        parcel.writeString(this.endStopName);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperPassRouteDetails(String str, String str2, String str3, String str4, String str5, String str6, int i, j86 j86) {
        this((i & 1) != 0 ? new String() : str, (i & 2) != 0 ? new String() : str2, (i & 4) != 0 ? new String() : str3, (i & 8) != 0 ? new String() : str4, (i & 16) != 0 ? new String() : str5, (i & 32) != 0 ? new String() : str6);
    }
}
