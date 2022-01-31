package app.zophop.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

public class ScanPayBookingDetails implements Parcelable {
    public static final Parcelable.Creator<ScanPayBookingDetails> CREATOR = new Parcelable.Creator<ScanPayBookingDetails>() {
        /* class app.zophop.models.ScanPayBookingDetails.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public ScanPayBookingDetails createFromParcel(Parcel parcel) {
            return new ScanPayBookingDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScanPayBookingDetails[] newArray(int i) {
            return new ScanPayBookingDetails[i];
        }
    };
    public final String _busInfo;

    public ScanPayBookingDetails(String str) {
        this._busInfo = str;
    }

    public static ScanPayBookingDetails fromString(String str) {
        if (str == null) {
            return null;
        }
        return (ScanPayBookingDetails) hj1.s(str, ScanPayBookingDetails.class);
    }

    public static String toString(ScanPayBookingDetails scanPayBookingDetails) {
        if (scanPayBookingDetails == null) {
            return null;
        }
        return new Gson().toJson(scanPayBookingDetails);
    }

    public int describeContents() {
        return 0;
    }

    public String getBusInfo() {
        return this._busInfo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._busInfo);
    }

    public ScanPayBookingDetails(Parcel parcel) {
        this._busInfo = parcel.readString();
    }
}
