package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.models.SuperSaver.RideInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class RideDetails implements Parcelable {
    public static final Parcelable.Creator<RideDetails> CREATOR = new Parcelable.Creator<RideDetails>() {
        /* class app.zophop.models.mTicketing.RideDetails.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public RideDetails createFromParcel(Parcel parcel) {
            return new RideDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public RideDetails[] newArray(int i) {
            return new RideDetails[i];
        }
    };
    private String _dailyRidesCount;
    private String _passId;
    private List<RideInfo> _rideInfoList;
    private String _totalRideCount;

    public RideDetails(String str, List<RideInfo> list) {
        this._passId = str;
        this._rideInfoList = list;
    }

    public static List<RideInfo> fromString(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<RideInfo>>() {
            /* class app.zophop.models.mTicketing.RideDetails.AnonymousClass2 */
        }.getType());
    }

    public static String toString(List<RideInfo> list) {
        return new Gson().toJson(list);
    }

    public int describeContents() {
        return 0;
    }

    public String get_dailyRidesCount() {
        return this._dailyRidesCount;
    }

    public String get_passId() {
        return this._passId;
    }

    public List<RideInfo> get_rideInfoList() {
        return this._rideInfoList;
    }

    public String get_totalRideCount() {
        return this._totalRideCount;
    }

    public void set_dailyRidesCount(String str) {
        this._dailyRidesCount = str;
    }

    public void set_passId(String str) {
        this._passId = str;
    }

    public void set_rideInfoList(List<RideInfo> list) {
        this._rideInfoList = list;
    }

    public void set_totalRideCount(String str) {
        this._totalRideCount = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._passId);
        if (this._rideInfoList == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this._rideInfoList);
        }
        parcel.writeString(this._dailyRidesCount);
        parcel.writeString(this._totalRideCount);
    }

    public RideDetails() {
    }

    public RideDetails(Parcel parcel) {
        this._passId = parcel.readString();
        if (parcel.readByte() == 1) {
            ArrayList arrayList = new ArrayList();
            this._rideInfoList = arrayList;
            parcel.readList(arrayList, RideInfo.class.getClassLoader());
        } else {
            this._rideInfoList = null;
        }
        this._dailyRidesCount = parcel.readString();
        this._totalRideCount = parcel.readString();
    }
}
