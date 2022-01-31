package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

public class UserAgencyInfo implements Parcelable {
    public static final Parcelable.Creator<UserAgencyInfo> CREATOR = new Parcelable.Creator<UserAgencyInfo>() {
        /* class app.zophop.models.mTicketing.UserAgencyInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public UserAgencyInfo[] newArray(int i) {
            return new UserAgencyInfo[0];
        }

        @Override // android.os.Parcelable.Creator
        public UserAgencyInfo createFromParcel(Parcel parcel) {
            return new UserAgencyInfo(parcel);
        }
    };
    private final String _agency;
    private final Map<String, String> _agencyFields;
    private final String _city;
    private final String _passengerType;
    private final Map<String, String> _proofs;
    private final STATUS _status;

    public enum STATUS {
        VERIFIED,
        UNVERIFIED,
        BLOCKED,
        BANNED,
        REJECTED,
        PAYMENT_PENDING,
        FAILED,
        TRANSACTION_PENDING,
        PENDING,
        SUCCESS
    }

    public UserAgencyInfo(Parcel parcel) {
        this._agencyFields = parcel.readHashMap(getClass().getClassLoader());
        this._proofs = parcel.readHashMap(getClass().getClassLoader());
        this._status = STATUS.valueOf(parcel.readString());
        this._agency = parcel.readString();
        this._city = parcel.readString();
        this._passengerType = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getAgency() {
        return this._agency;
    }

    public Map<String, String> getAgencyFields() {
        return this._agencyFields;
    }

    public String getCity() {
        return this._city;
    }

    public String getPassengerType() {
        return this._passengerType;
    }

    public Map<String, String> getProofs() {
        return this._proofs;
    }

    public STATUS getStatus() {
        return this._status;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this._agencyFields);
        parcel.writeMap(this._proofs);
        parcel.writeString(this._status.name());
        parcel.writeString(this._agency);
        parcel.writeString(this._city);
        parcel.writeString(this._passengerType);
    }

    public UserAgencyInfo(Map<String, String> map, Map<String, String> map2, STATUS status, String str, String str2, String str3) {
        this._agencyFields = map;
        this._proofs = map2;
        this._status = status;
        this._agency = str;
        this._city = str2;
        this._passengerType = str3;
    }
}
