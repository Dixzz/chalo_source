package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class RouteInfo implements Parcelable {
    public static final Parcelable.Creator<RouteInfo> CREATOR = new Parcelable.Creator<RouteInfo>() {
        /* class app.zophop.models.RouteInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RouteInfo createFromParcel(Parcel parcel) {
            return new RouteInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteInfo[] newArray(int i) {
            return new RouteInfo[i];
        }
    };
    private final String _agencyName;
    private long _availabilityLevel;
    private final String _directionStopName;
    private final String _firstStopName;
    private final boolean _isFreeRide;
    private boolean _isRouteDisrupted;
    private final String _lastStopName;
    private boolean _mTicketEnabled;
    private final boolean _mobileTicketing;
    private final String _polyline;
    private final String _routeId;
    private final String _routeName;
    private final boolean _routePassEnabled;
    private int _seatOccupancy;
    private final List<SPECIAL_FEATURE> _specialFeatures;
    private final List<String> _stopSeq;
    private final TransitMode _transitMode;
    private final List<String> _updateSpecialFeaturesList;

    public RouteInfo(String str, TransitMode transitMode, String str2, String str3, String str4, String str5, String str6, List<SPECIAL_FEATURE> list, List<String> list2, List<String> list3, boolean z, boolean z2, boolean z3, boolean z4, String str7) {
        this._routeId = str;
        this._transitMode = transitMode;
        this._routeName = str2;
        this._firstStopName = vn.p0(str3);
        this._lastStopName = vn.p0(str4);
        this._directionStopName = str5;
        this._agencyName = str6;
        this._specialFeatures = list;
        this._updateSpecialFeaturesList = list2;
        this._mobileTicketing = z;
        this._stopSeq = list3;
        this._mTicketEnabled = z2;
        this._isFreeRide = z3;
        this._polyline = str7;
        this._routePassEnabled = z4;
        this._availabilityLevel = 2;
        this._isRouteDisrupted = false;
        this._seatOccupancy = 0;
    }

    public int describeContents() {
        return 0;
    }

    public String getAgencyName() {
        return this._agencyName;
    }

    public String getDirectionStopName() {
        return this._directionStopName;
    }

    public String getFirstStopName() {
        return this._firstStopName;
    }

    public String getLastStopName() {
        return this._lastStopName;
    }

    public String getPolyline() {
        return this._polyline;
    }

    public String getRouteId() {
        return this._routeId;
    }

    public String getRouteName() {
        return this._routeName;
    }

    public List<SPECIAL_FEATURE> getSpecialFeatures() {
        return this._specialFeatures;
    }

    public List<String> getStopSeq() {
        return this._stopSeq;
    }

    public TransitMode getTransitMode() {
        return this._transitMode;
    }

    public long get_availabilityLevel() {
        return this._availabilityLevel;
    }

    public int get_seatOccupancy() {
        return this._seatOccupancy;
    }

    public List<String> get_updateSpecialFeaturesList() {
        return this._updateSpecialFeaturesList;
    }

    public boolean isFreeRide() {
        return this._isFreeRide;
    }

    public boolean isMTicketEnabled() {
        return this._mTicketEnabled;
    }

    public boolean isMobileTicketing() {
        return this._mobileTicketing;
    }

    public boolean isRoutePassEnabled() {
        return this._routePassEnabled;
    }

    public boolean is_isRouteDisrupted() {
        return this._isRouteDisrupted;
    }

    public void setMTicketEnabled(boolean z) {
        this._mTicketEnabled = z;
    }

    public void set_availabilityLevel(long j) {
        this._availabilityLevel = j;
    }

    public void set_isRouteDisrupted(boolean z) {
        this._isRouteDisrupted = z;
    }

    public void set_seatOccupancy(int i) {
        this._seatOccupancy = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._routeId);
        parcel.writeValue(this._transitMode);
        parcel.writeString(this._routeName);
        parcel.writeString(this._firstStopName);
        parcel.writeString(this._lastStopName);
        parcel.writeString(this._directionStopName);
        parcel.writeString(this._agencyName);
        if (this._specialFeatures == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._specialFeatures);
        }
        if (this._updateSpecialFeaturesList == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._updateSpecialFeaturesList);
        }
        if (this._stopSeq == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._stopSeq);
        }
        parcel.writeByte(this._mobileTicketing ? (byte) 1 : 0);
        parcel.writeByte(this._mTicketEnabled ? (byte) 1 : 0);
        parcel.writeByte(this._routePassEnabled ? (byte) 1 : 0);
        parcel.writeByte(this._isFreeRide ? (byte) 1 : 0);
        parcel.writeString(this._polyline);
        parcel.writeLong(this._availabilityLevel);
        parcel.writeByte(this._isRouteDisrupted ? (byte) 1 : 0);
        parcel.writeInt(this._seatOccupancy);
    }

    public RouteInfo(Parcel parcel) {
        this._routeId = parcel.readString();
        this._transitMode = (TransitMode) parcel.readValue(TransitMode.class.getClassLoader());
        this._routeName = parcel.readString();
        this._firstStopName = parcel.readString();
        this._lastStopName = parcel.readString();
        this._directionStopName = parcel.readString();
        this._agencyName = parcel.readString();
        boolean z = true;
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._specialFeatures = arrayList;
            parcel.readList(arrayList, SPECIAL_FEATURE.class.getClassLoader());
        } else {
            this._specialFeatures = null;
        }
        if (parcel.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this._updateSpecialFeaturesList = arrayList2;
            parcel.readList(arrayList2, String.class.getClassLoader());
        } else {
            this._updateSpecialFeaturesList = null;
        }
        if (parcel.readByte() == 1) {
            ArrayList arrayList3 = new ArrayList();
            this._stopSeq = arrayList3;
            parcel.readList(arrayList3, String.class.getClassLoader());
        } else {
            this._stopSeq = null;
        }
        this._mobileTicketing = parcel.readByte() != 0;
        this._mTicketEnabled = parcel.readByte() != 0;
        this._routePassEnabled = parcel.readByte() != 0;
        this._isFreeRide = parcel.readByte() != 0;
        this._polyline = parcel.readString();
        this._availabilityLevel = parcel.readLong();
        this._isRouteDisrupted = parcel.readByte() == 0 ? false : z;
        this._seatOccupancy = parcel.readInt();
    }
}
