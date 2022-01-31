package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

public class MTicketConfiguration implements Parcelable {
    public static final Parcelable.Creator<MTicketConfiguration> CREATOR = new Parcelable.Creator<MTicketConfiguration>() {
        /* class app.zophop.models.mTicketing.MTicketConfiguration.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MTicketConfiguration createFromParcel(Parcel parcel) {
            return new MTicketConfiguration(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MTicketConfiguration[] newArray(int i) {
            return new MTicketConfiguration[i];
        }
    };
    private String _id;

    public MTicketConfiguration(String str) {
        this._id = str;
    }

    public static MTicketConfiguration fromString(String str) {
        if (str == null) {
            return null;
        }
        return (MTicketConfiguration) hj1.s(str, MTicketConfiguration.class);
    }

    public static String toString(MTicketConfiguration mTicketConfiguration) {
        if (mTicketConfiguration == null) {
            return null;
        }
        return new Gson().toJson(mTicketConfiguration);
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String str) {
        this._id = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._id);
    }

    public MTicketConfiguration(Parcel parcel) {
        this._id = parcel.readString();
    }
}
