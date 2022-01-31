package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import zophop.models.SPECIAL_FEATURE;

public class RouteStopsInfo implements Parcelable {
    public static final Parcelable.Creator<RouteStopsInfo> CREATOR = new Parcelable.Creator<RouteStopsInfo>() {
        /* class app.zophop.models.mTicketing.RouteStopsInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RouteStopsInfo createFromParcel(Parcel parcel) {
            return new RouteStopsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RouteStopsInfo[] newArray(int i) {
            return new RouteStopsInfo[i];
        }
    };
    private String _endStopId;
    private String _endStopName;
    private String _routeId;
    private String _routeName;
    private List<SPECIAL_FEATURE> _specialFeatures;
    private List<String> _spf;
    private String _startStopId;
    private String _startStopName;

    public RouteStopsInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this._routeId = str;
        this._routeName = str2;
        this._startStopId = str3;
        this._startStopName = str4;
        this._endStopId = str5;
        this._endStopName = str6;
    }

    public static RouteStopsInfo fromString(String str) {
        if (str == null) {
            return null;
        }
        return (RouteStopsInfo) hj1.s(str, RouteStopsInfo.class);
    }

    public static String toString(RouteStopsInfo routeStopsInfo) {
        if (routeStopsInfo == null) {
            return null;
        }
        return new Gson().toJson(routeStopsInfo);
    }

    public int describeContents() {
        return 0;
    }

    public String getEndStopId() {
        return this._endStopId;
    }

    public String getEndStopName() {
        return this._endStopName;
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

    public String getStartStopId() {
        return this._startStopId;
    }

    public String getStartStopName() {
        return this._startStopName;
    }

    public List<String> get_spf() {
        return this._spf;
    }

    public void setEndStopId(String str) {
        this._endStopId = str;
    }

    public void setEndStopName(String str) {
        this._endStopName = str;
    }

    public void setRouteId(String str) {
        this._routeId = str;
    }

    public void setRouteName(String str) {
        this._routeName = str;
    }

    public void setSpecialFeatures(List<SPECIAL_FEATURE> list) {
        this._specialFeatures = list;
    }

    public void setStartStopId(String str) {
        this._startStopId = str;
    }

    public void setStartStopName(String str) {
        this._startStopName = str;
    }

    public void set_spf(List<String> list) {
        this._spf = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._routeId);
        parcel.writeString(this._routeName);
        parcel.writeString(this._startStopId);
        parcel.writeString(this._startStopName);
        parcel.writeString(this._endStopId);
        parcel.writeString(this._endStopName);
        if (this._specialFeatures == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._specialFeatures);
        }
        if (this._spf == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeList(this._spf);
    }

    public RouteStopsInfo(Parcel parcel) {
        this._routeId = parcel.readString();
        this._routeName = parcel.readString();
        this._startStopId = parcel.readString();
        this._startStopName = parcel.readString();
        this._endStopId = parcel.readString();
        this._endStopName = parcel.readString();
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._specialFeatures = arrayList;
            parcel.readList(arrayList, SPECIAL_FEATURE.class.getClassLoader());
        } else {
            this._specialFeatures = null;
        }
        if (parcel.readByte() == 1) {
            ArrayList arrayList2 = new ArrayList();
            this._spf = arrayList2;
            parcel.readList(arrayList2, String.class.getClassLoader());
            return;
        }
        this._spf = null;
    }
}
