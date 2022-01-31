package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

public class MagicPassPunchInfo implements Comparable, Parcelable {
    public static final Parcelable.Creator<MagicPassPunchInfo> CREATOR = new Parcelable.Creator<MagicPassPunchInfo>() {
        /* class app.zophop.models.mTicketing.MagicPassPunchInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public MagicPassPunchInfo createFromParcel(Parcel parcel) {
            return new MagicPassPunchInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public MagicPassPunchInfo[] newArray(int i) {
            return new MagicPassPunchInfo[i];
        }
    };
    private long _punchingTime;

    public MagicPassPunchInfo(Parcel parcel) {
    }

    public static MagicPassPunchInfo fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (MagicPassPunchInfo) hj1.s(str, MagicPassPunchInfo.class);
    }

    public static String toConverterString(MagicPassPunchInfo magicPassPunchInfo) {
        if (magicPassPunchInfo == null) {
            return null;
        }
        return new Gson().toJson(magicPassPunchInfo);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof PunchInfo)) {
            return -1;
        }
        MagicPassPunchInfo magicPassPunchInfo = (MagicPassPunchInfo) obj;
        if (getPunchingTime() < magicPassPunchInfo.getPunchingTime()) {
            return -1;
        }
        return getPunchingTime() == magicPassPunchInfo.getPunchingTime() ? 0 : 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this._punchingTime == ((MagicPassPunchInfo) obj)._punchingTime) {
            return true;
        }
        return false;
    }

    public long getPunchingTime() {
        return this._punchingTime;
    }

    public int hashCode() {
        long j = this._punchingTime;
        return (int) (j ^ (j >>> 32));
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public MagicPassPunchInfo(long j) {
        this._punchingTime = j;
    }
}
